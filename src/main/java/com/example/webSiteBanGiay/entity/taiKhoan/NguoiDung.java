package com.example.webSiteBanGiay.entity.taiKhoan;

import com.example.webSiteBanGiay.entity.BaseEntity;
import com.example.webSiteBanGiay.enums.GioiTinh;
import com.example.webSiteBanGiay.enums.TrangThai;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "nguoi_dung")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NguoiDung extends BaseEntity<Integer> {

    String hoTen;
    LocalDate ngaySinh;
    @Enumerated(EnumType.STRING)
    GioiTinh gioiTinh;
    String sdt;
    String email;
    String avatar;
    String diaChi;
    String userName;
    String password;

    @Enumerated(EnumType.STRING)
    TrangThai trangThai;

}
