package com.example.webSiteBanGiay.repository.taiKhoan;

import com.example.webSiteBanGiay.common.GenericRepository;
import com.example.webSiteBanGiay.dto.taiKhoan.nguoiDung.CreateNguoiDung;
import com.example.webSiteBanGiay.dto.taiKhoan.nguoiDung.ResponseNguoiDung;
import com.example.webSiteBanGiay.dto.taiKhoan.nguoiDung.UpdateNguoiDung;
import com.example.webSiteBanGiay.entity.taiKhoan.NguoiDung;

public interface NguoiDungResponsitory extends GenericRepository<NguoiDung,Integer, CreateNguoiDung, UpdateNguoiDung, ResponseNguoiDung> {
}
