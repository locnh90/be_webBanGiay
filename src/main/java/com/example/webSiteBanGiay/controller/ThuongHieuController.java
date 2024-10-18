package com.example.webSiteBanGiay.controller;

import com.example.webSiteBanGiay.dto.ApiResponse;
import com.example.webSiteBanGiay.repository.sanPham.KichCoResponsitory;
import com.example.webSiteBanGiay.repository.sanPham.ThuongHieuRepository;
import com.example.webSiteBanGiay.service.sanPham.KichCoServiceImpl;
import com.example.webSiteBanGiay.service.sanPham.thuongHieu.ThuongHieuServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin/thuongHieu")
public class ThuongHieuController {

    private final ThuongHieuServiceImpl thuongHieuService;
    private final ThuongHieuRepository thuongHieuRepository;

    public ThuongHieuController(ThuongHieuServiceImpl thuongHieuService, ThuongHieuRepository thuongHieuRepository) {

        this.thuongHieuService = thuongHieuService;
        this.thuongHieuRepository = thuongHieuRepository;
    }

    @GetMapping("")
    public ApiResponse<?> getAll(){
        return new ApiResponse<>(HttpStatus.OK.value(), "thanh cong",thuongHieuService.getAll());
    }
}
