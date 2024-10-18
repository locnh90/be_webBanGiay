package com.example.webSiteBanGiay.repository.sanPham;

import com.example.webSiteBanGiay.common.GenericRepository;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.CreateThuongHieu;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.ResponseThuongHieu;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.UpdateThuongHieu;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.ThuongHieu;

public interface ThuongHieuRepository extends GenericRepository<ThuongHieu, Integer, CreateThuongHieu
        , UpdateThuongHieu, ResponseThuongHieu> {
}
