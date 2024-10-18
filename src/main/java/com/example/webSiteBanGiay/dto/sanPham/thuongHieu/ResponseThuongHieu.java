package com.example.webSiteBanGiay.dto.sanPham.thuongHieu;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseThuongHieu {
    Integer id;
    String tenThuongHieu;
}
