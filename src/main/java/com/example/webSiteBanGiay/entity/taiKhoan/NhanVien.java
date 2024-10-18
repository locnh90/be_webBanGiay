package com.example.webSiteBanGiay.entity.taiKhoan;

import com.example.webSiteBanGiay.entity.BaseEntity;
import com.example.webSiteBanGiay.enums.GioiTinh;
import com.example.webSiteBanGiay.enums.TrangThai;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "nhan_vien")
@Getter
@Setter
@AllArgsConstructor
public class NhanVien extends BaseEntity<Integer> {
    String hoTen;
    LocalDate ngaySinh;
    GioiTinh gioiTinh;
    String sdt;
    String email;
    String avatar;
    String diaChi;
    String userName;
    String password;
    TrangThai trangThai;
}
