package com.example.webSiteBanGiay.service.taikhoan;

import com.example.webSiteBanGiay.common.GenericService;
import com.example.webSiteBanGiay.dto.taiKhoan.nguoiDung.CreateNguoiDung;
import com.example.webSiteBanGiay.dto.taiKhoan.nguoiDung.ResponseNguoiDung;
import com.example.webSiteBanGiay.dto.taiKhoan.nguoiDung.UpdateNguoiDung;
import com.example.webSiteBanGiay.entity.taiKhoan.NguoiDung;

public interface NguoiDungService extends GenericService<NguoiDung,Integer, CreateNguoiDung,
        UpdateNguoiDung, ResponseNguoiDung> {
}
