package com.example.webSiteBanGiay.dto.taiKhoan.nguoiDung;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseNguoiDung {
    Integer id;
    String hoTen;
    LocalDate ngaySinh;
    String gioiTinh;
    String sdt;
    String email;
    String avatar;
    String diaChi;
    String userName;
    String password;
    String trangThai;
}
