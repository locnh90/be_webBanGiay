package com.example.webSiteBanGiay.dto.sanPham.thuongHieu;

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
public class ResponseThuongHieu {
    Integer id;
    String tenThuongHieu;
    LocalDate ngayThem;
    LocalDate ngayUpdate;
}
