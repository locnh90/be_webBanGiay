package com.example.webSiteBanGiay.service.sanPham.thuongHieu;

import com.example.webSiteBanGiay.common.GenericService;
import com.example.webSiteBanGiay.dto.PageResponse;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.CreateThuongHieu;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.ResponseThuongHieu;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.UpdateThuongHieu;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.ThuongHieu;
import org.springframework.data.domain.Pageable;

public interface ThuongHieuService extends GenericService<ThuongHieu,Integer, CreateThuongHieu, UpdateThuongHieu, ResponseThuongHieu> {
    PageResponse<?> getByName(Pageable pageable, String tenThuongHieu);
    Boolean getByName(String tenThuongHieu);
}
