package com.example.webSiteBanGiay.dto.sanPham.chatLieu;


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
public class ResponseChatLieu {
    Integer id;
    String tenChatLieu;
    LocalDate ngayThem;
    LocalDate ngayUpdate;
}
