package com.example.webSiteBanGiay.dto.taiKhoan.nguoiDung;

import com.example.webSiteBanGiay.enums.GioiTinh;
import com.example.webSiteBanGiay.enums.TrangThai;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateNguoiDung {
    String hoTen;
    LocalDate ngaySinh;
    GioiTinh gioiTinh;
    String sdt;
    String email;
    String avatar;
    String diaChi;
    @NotBlank(message = "khong dc de trong")
    String userName;
    String password;
    TrangThai trangThai;
}
