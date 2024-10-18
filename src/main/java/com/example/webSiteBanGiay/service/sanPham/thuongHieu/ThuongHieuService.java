package com.example.webSiteBanGiay.service.sanPham.thuongHieu;

import com.example.webSiteBanGiay.common.GenericService;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.CreateThuongHieu;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.ResponseThuongHieu;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.UpdateThuongHieu;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.ThuongHieu;

public interface ThuongHieuService extends GenericService<ThuongHieu,Integer, CreateThuongHieu, UpdateThuongHieu, ResponseThuongHieu> {
}
