package com.example.webSiteBanGiay.common;

import com.example.webSiteBanGiay.dto.PageResponse;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public abstract class GenericServiceAbstract<E,ID,C,U,R> implements IGenericService<E,ID,C,U,R> {

    protected final IGenericRepository<E, ID> entityRepository;
    protected final IGenericMapper<E, C,U,R> mapper;
    protected final EntityManager entityManager;


    public PageResponse<?> getAll(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by(Sort.Direction.DESC, "ngayThem","id"));

        Page<E> entityPage = entityRepository.findAll(pageRequest);
        List<R> result = mapper.toEntityDtoList(entityPage.getContent());

        return PageResponse.builder()
                .pageNo(pageable.getPageNumber()+1)
                .pageSize(pageable.getPageSize())
                .totalElements(entityPage.getTotalElements())
                .totalPages(entityPage.getTotalPages())
                .items(result)
                .build();
    }

    @Transactional
    @Override
    public R create(C request) {
        this.beforeCreate(request);
        E entity = mapper.createToEntity(request);
        this.afterConvertCreateRequest(request,entity);
        return mapper.toEntityDto(entityRepository.save(entity));
    }

    @Override
    public R update(ID id, U request) {
        return null;
    }

    @Override
    public void delete(ID id) {

    }

    @Override
    public R getDtoById(ID id) {
        return null;
    }

    @Override
    public E getById(ID id) {
        return null;
    }


    protected abstract List<C> beforeCreateEntities(List<C> requests);
    protected abstract List<U> beforeUpdateEntities(List<U> requests);
    protected abstract void beforeCreate(C request);
    protected abstract void beforeUpdate(U request);
    protected abstract void afterConvertCreateRequest(C request, E entity);
    protected abstract void afterConvertUpdateRequest(U request, E entity);
    protected abstract String getEntityName();
}
