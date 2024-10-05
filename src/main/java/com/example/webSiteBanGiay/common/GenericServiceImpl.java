package com.example.webSiteBanGiay.common;

import com.example.webSiteBanGiay.exception.AppException;
import com.example.webSiteBanGiay.exception.ErrorCode;
import jakarta.persistence.EntityManager;

import java.util.List;


public abstract class GenericServiceImpl<T,ID,C,U,R> implements GenericService<T, ID, C,U,R> {

    private final GenericMapper<T,C,U,R> mapper;
    private final GenericRepository <T,ID,C,U,R> repository;
    private final EntityManager entityManager;

    protected GenericServiceImpl(GenericMapper<T, C, U, R> mapper, GenericRepository<T, ID, C, U, R> repository, EntityManager entityManager) {
        this.mapper = mapper;
        this.repository = repository;
        this.entityManager = entityManager;
    }

    @Override
    public List<R> getAll() {
        List<T> listEntity = repository.findAll();
        return mapper.toListResponse(listEntity);
    }

    @Override
    public R createEntity(C request) {
        T entity = mapper.toCreateEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public R updateEntity(ID id, U request) {
        T entity = this.getById(id);
        if(entity == null){
            throw new AppException(ErrorCode.NOT_FOUND);
        }
        mapper.toUpdateEntity(entity,request);
        return mapper.toResponse(entity);
    }

    @Override
    public T getById(ID id) {
        return repository.findById(id).orElseThrow(()-> new AppException(ErrorCode.NOT_FOUND));
    }
}
