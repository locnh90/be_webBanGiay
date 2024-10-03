package com.example.webSiteBanGiay.controller;

import com.example.webSiteBanGiay.dto.ApiResponse;
import com.example.webSiteBanGiay.dto.sanPham.CreateKichCo;
import com.example.webSiteBanGiay.service.sanPham.IKichCoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/admin/kichCo")
@Tag(name = "Kich co controller")
public class KichCoController {
    private final IKichCoService kichCoService;


    public KichCoController(IKichCoService kichCoService) {
        this.kichCoService = kichCoService;
    }

    @GetMapping()
    public ApiResponse<?> getKichCo(Pageable pageable){
        return new ApiResponse<>(HttpStatus.OK.value(), "Kich co",kichCoService.getAll(pageable));
    }
    @PostMapping("/create")
    public ApiResponse<?> create(@RequestBody CreateKichCo request){
        return new ApiResponse<>(HttpStatus.CREATED.value(), "Them thanh cong",kichCoService.create(request));
    }
}
