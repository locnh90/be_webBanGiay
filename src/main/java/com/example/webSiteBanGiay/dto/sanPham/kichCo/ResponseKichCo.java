package com.example.webSiteBanGiay.dto.sanPham.kichCo;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseKichCo {
    Integer id;
    String tenKichCo;
}
