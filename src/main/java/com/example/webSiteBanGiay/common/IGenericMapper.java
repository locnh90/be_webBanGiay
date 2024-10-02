package com.example.webSiteBanGiay.common;

import java.util.List;

public interface IGenericMapper <E,C,U,R>{
    R toEntityDto (E entity);
    List<R> toEntityDtoList(List<E> entityList);
    E createToEntity(C request);
    void updateToEntity(E entity, U request);
    List<E> createToEntityList(List<C> dtoCreateList );
    List<E> updateToEntityList(List<U> dtoCreateList );

}
