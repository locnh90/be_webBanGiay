package com.example.webSiteBanGiay.service.sanPham;

import com.example.webSiteBanGiay.common.GenericService;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.CreateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.ResponseKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.UpdateKichCo;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.KichCo;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface KichCoService extends GenericService<KichCo,Integer, CreateKichCo, UpdateKichCo, ResponseKichCo> {
    List<ResponseKichCo> getByName(String tenKichCo);

}
