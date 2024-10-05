package com.example.webSiteBanGiay.common;



import java.util.List;


public interface GenericMapper<T,C,U,R>{
    T toCreateEntity(C request);
    R toResponse(T entity);
    List<R> toListResponse(List<T> listEntity);
    void toUpdateEntity( T entity, U request);
}
