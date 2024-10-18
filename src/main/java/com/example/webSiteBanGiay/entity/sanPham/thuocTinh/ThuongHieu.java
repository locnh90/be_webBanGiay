package com.example.webSiteBanGiay.entity.sanPham.thuocTinh;

import com.example.webSiteBanGiay.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "thuong_hieu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ThuongHieu extends BaseEntity<Integer> {
    @Column(name = "ten_thuong_hieu")
    String tenThuongHieu;
}
