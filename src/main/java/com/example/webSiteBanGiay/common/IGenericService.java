package com.example.webSiteBanGiay.common;

import com.example.webSiteBanGiay.dto.ApiResponse;
import com.example.webSiteBanGiay.dto.PageResponse;
import org.springframework.data.domain.Pageable;

public interface IGenericService<E, ID, C, U, R> {
    PageResponse<?> getAll(Pageable pageable);
    R create(C request);
    R update(ID id, U request);
    void delete(ID id);
    R getDtoById(ID id);
    E getById(ID id);
}
