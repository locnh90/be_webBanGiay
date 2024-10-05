package com.example.webSiteBanGiay.common;

import java.util.List;

public interface GenericService<T,ID, C,U,R> {
    R createEntity(C request);
    R updateEntity(ID id, U request);
    T getById(ID id);
    List<R> getAll();
}
