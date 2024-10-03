package com.example.webSiteBanGiay.service.sanPham;


import com.example.webSiteBanGiay.common.IGenericService;
import com.example.webSiteBanGiay.dto.PageResponse;
import com.example.webSiteBanGiay.dto.sanPham.CreateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.ResponseKichCo;
import com.example.webSiteBanGiay.dto.sanPham.UpdateKichCo;
import com.example.webSiteBanGiay.entity.product.attributes.KichCo;
import org.springframework.data.domain.Pageable;

public interface IKichCoService
    extends IGenericService<KichCo, Integer,CreateKichCo, UpdateKichCo, ResponseKichCo> {
    PageResponse<?> getAll (Pageable pageable);
}
