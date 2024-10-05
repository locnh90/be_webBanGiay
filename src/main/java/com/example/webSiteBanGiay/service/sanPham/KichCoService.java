package com.example.webSiteBanGiay.service.sanPham;

import com.example.webSiteBanGiay.common.GenericService;
import com.example.webSiteBanGiay.dto.sanPham.CreateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.ResponseKichCo;
import com.example.webSiteBanGiay.dto.sanPham.UpdateKichCo;
import com.example.webSiteBanGiay.entity.product.attributes.KichCo;


public interface KichCoService extends GenericService<KichCo,Integer, CreateKichCo, UpdateKichCo, ResponseKichCo> {
}
