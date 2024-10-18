package com.example.webSiteBanGiay.dto.sanPham.thuongHieu;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateThuongHieu {

    @NotBlank(message = "khong duoc de trong")
    String tenThuongHieu;
}
