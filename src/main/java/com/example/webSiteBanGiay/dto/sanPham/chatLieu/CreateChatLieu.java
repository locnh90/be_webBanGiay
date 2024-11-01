package com.example.webSiteBanGiay.dto.sanPham.chatLieu;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateChatLieu {
    @NotBlank(message = "khong được để trống")
    String tenChatLieu;
}
