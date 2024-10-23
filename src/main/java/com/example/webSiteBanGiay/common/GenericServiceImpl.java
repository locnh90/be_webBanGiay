package com.example.webSiteBanGiay.common;

import com.example.webSiteBanGiay.dto.PageResponse;
import com.example.webSiteBanGiay.exception.AppException;
import com.example.webSiteBanGiay.exception.ErrorCode;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


public abstract class GenericServiceImpl<T,ID,C,U,R> implements GenericService<T, ID, C,U,R> {

    protected final GenericMapper<T,C,U,R> mapper;
    private final GenericRepository <T,ID,C,U,R> repository;
    private final EntityManager entityManager;

    protected GenericServiceImpl(GenericMapper<T, C, U, R> mapper, GenericRepository<T, ID, C, U, R> repository, EntityManager entityManager) {
        this.mapper = mapper;
        this.repository = repository;
        this.entityManager = entityManager;
    }

    @Override
    public PageResponse<?> getAll(Pageable pageable) {
        int page = 0;
        if (pageable.getPageNumber() > 0) page = pageable.getPageNumber() - 1;

        PageRequest pageRequest = PageRequest.of(page, pageable.getPageSize(),
                Sort.by(Sort.Direction.DESC, "ngayThem", "id"));

        Page<T> entityPage = repository.findAll(pageRequest);
        List<R> result = mapper.toListResponse(entityPage.getContent());
        return PageResponse.builder()
                .pageNo(pageRequest.getPageNumber() + 1)
                .pageSize(pageable.getPageSize())
                .totalElements(entityPage.getTotalElements())
                .totalPages(entityPage.getTotalPages())
                .items(result)
                .build();
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
        repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public T getById(ID id) {
        return repository.findById(id).orElseThrow(()-> new AppException(ErrorCode.NOT_FOUND));
    }
}
