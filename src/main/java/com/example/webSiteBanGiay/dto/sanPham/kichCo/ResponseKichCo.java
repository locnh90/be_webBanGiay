package com.example.webSiteBanGiay.dto.sanPham.kichCo;


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
public class ResponseKichCo {
    Integer id;
    String tenKichCo;
    LocalDate ngayThem;
    LocalDate ngayUpdate;
}
