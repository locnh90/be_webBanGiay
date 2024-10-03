package com.example.webSiteBanGiay.common;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IGenericMapper <E,C,U,R>{
    R toEntityDto (E entity);
    List<R> toEntityDtoList(List<E> entityList);
    E createToEntity(C request);
    void updateToEntity(E entity, U request);
    List<E> createToEntityList(List<C> dtoCreateList );
    List<E> updateToEntityList(List<U> dtoCreateList );

}
