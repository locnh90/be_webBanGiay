package com.example.webSiteBanGiay.entity.taiKhoan;

import com.example.webSiteBanGiay.entity.BaseEntity;
import com.example.webSiteBanGiay.enums.GioiTinh;
import com.example.webSiteBanGiay.enums.TrangThai;
import jakarta.persistence.*;
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
//    @OneToMany(mappedBy = "khach_", cascade = ALL, fetch = FetchType.LAZY)
//    Set<hang> addresses = new HashSet<>();
//
//    public void addAddress(Address address) {
//        if (address != null) {
//            if (addresses == null) {
//                addresses = new HashSet<>();
//            }
//            addresses.add(address);
//            address.setCustomer(this); // save customer id
//        }
//    }
    String userName;
    String password;

    @Enumerated(EnumType.STRING)
    TrangThai trangThai;

}
