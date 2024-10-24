package com.example.webSiteBanGiay.controller;

import com.example.webSiteBanGiay.dto.ApiResponse;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.CreateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.UpdateKichCo;
import com.example.webSiteBanGiay.exception.AppException;
import com.example.webSiteBanGiay.exception.ErrorCode;
import com.example.webSiteBanGiay.repository.sanPham.KichCoResponsitory;
import com.example.webSiteBanGiay.service.sanPham.KichCoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin/kichCo")
public class KichCoController {

    private final KichCoService kichCoService;

    public KichCoController(KichCoService kichCoService, KichCoResponsitory kichCoResponsitory) {
        this.kichCoService = kichCoService;
    }

    @GetMapping()
    public ApiResponse<?> getAll(Pageable pageable,@RequestParam(required = false)String name){
        return new ApiResponse<>(HttpStatus.OK.value(), "Successfully",kichCoService.getByName(pageable,name));
    }
    @PostMapping()
    public ApiResponse<?> createKichCo(@Valid @RequestBody CreateKichCo request){
        if(kichCoService.getByName(request.getTenKichCo())){
            throw new AppException(ErrorCode.EXISTED,"size");
        }
        return new ApiResponse<>(HttpStatus.CREATED.value(),
                "Thêm thành công kích cỡ",kichCoService.createEntity(request));
    }
    @PutMapping("/{id}")
    public ApiResponse<?> updateKichCo(@Valid @PathVariable ("id") Integer id,@RequestBody UpdateKichCo request){
        if(kichCoService.getByName(request.getTenKichCo())){
            throw new AppException(ErrorCode.EXISTED,"size");
        }
        return new ApiResponse<>(HttpStatus.CREATED.value(), "Cập nhật thành công kích cỡ",kichCoService.updateEntity(id, request));
    }
    @GetMapping("/{id}")
    public ApiResponse<?> detailKichCo(@PathVariable("id") Integer id){
        return new ApiResponse<>(HttpStatus.OK.value(), "thanh cong",kichCoService.getById(id));
    }

}
