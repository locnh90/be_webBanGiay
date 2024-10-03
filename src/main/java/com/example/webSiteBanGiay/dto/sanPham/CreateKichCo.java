package com.example.webSiteBanGiay.dto.sanPham;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateKichCo {
    @NotBlank(message = "khong được để trống")
    String tenKichCo;
}
