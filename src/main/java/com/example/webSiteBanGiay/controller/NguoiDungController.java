package com.example.webSiteBanGiay.controller;

import com.example.webSiteBanGiay.dto.ApiResponse;
import com.example.webSiteBanGiay.dto.taiKhoan.nguoiDung.CreateNguoiDung;
import com.example.webSiteBanGiay.dto.taiKhoan.nguoiDung.UpdateNguoiDung;
import com.example.webSiteBanGiay.exception.AppException;
import com.example.webSiteBanGiay.exception.ErrorCode;
import com.example.webSiteBanGiay.repository.taiKhoan.NguoiDungResponsitory;
import com.example.webSiteBanGiay.service.taikhoan.NguoiDungServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/nguoiDung")
public class NguoiDungController {
    private final NguoiDungServiceImpl nguoiDungService;
    private final NguoiDungResponsitory nguoiDungResponsitory;

    public NguoiDungController(NguoiDungServiceImpl nguoiDungService, NguoiDungResponsitory nguoiDungResponsitory) {
        this.nguoiDungService = nguoiDungService;
        this.nguoiDungResponsitory = nguoiDungResponsitory;
    }
    @GetMapping()
    public ApiResponse<?> getAll(){
        return new ApiResponse<>(HttpStatus.OK.value(), "Successfully",nguoiDungService.getAll());
    }
    @PostMapping()
    public ApiResponse<?> createNguoiDung(@Valid @RequestBody CreateNguoiDung request){
        return new ApiResponse<>(HttpStatus.CREATED.value(),
                "Add thanh cong",nguoiDungService.createEntity(request));
    }
    @PutMapping("/{id}")
    public ApiResponse<?> updateNguoiDung(@Valid @PathVariable ("id") Integer id, UpdateNguoiDung request){
        return new ApiResponse<>(HttpStatus.OK.value(), "thanh cong",nguoiDungService.updateEntity(id, request));
    }
    @GetMapping("/{id}")
    public ApiResponse<?> detailNguoiDung(@PathVariable("id") Integer id){
        return new ApiResponse<>(HttpStatus.OK.value(), "thanh cong",nguoiDungService.getById(id));
    }
}
