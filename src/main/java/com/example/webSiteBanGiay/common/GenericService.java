package com.example.webSiteBanGiay.common;

import com.example.webSiteBanGiay.dto.PageResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenericService<T,ID, C,U,R> {
    R createEntity(C request);
    R updateEntity(ID id, U request);
    T getById(ID id);
    PageResponse<?> getAll(Pageable pageable);
    List<R> getAll();
}
