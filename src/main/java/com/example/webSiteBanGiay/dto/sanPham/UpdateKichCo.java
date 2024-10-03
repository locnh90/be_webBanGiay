package com.example.webSiteBanGiay.dto.sanPham;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateKichCo {
    @NotBlank(message = "khong được để trống")
    String tenKichCo;
}
