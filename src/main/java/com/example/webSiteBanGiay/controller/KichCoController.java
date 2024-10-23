package com.example.webSiteBanGiay.controller;

import com.example.webSiteBanGiay.dto.ApiResponse;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.CreateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.UpdateKichCo;
import com.example.webSiteBanGiay.exception.AppException;
import com.example.webSiteBanGiay.exception.ErrorCode;
import com.example.webSiteBanGiay.repository.sanPham.KichCoResponsitory;
import com.example.webSiteBanGiay.service.sanPham.KichCoService;
import com.example.webSiteBanGiay.service.sanPham.KichCoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin/kichCo")
public class KichCoController {

    private final KichCoService kichCoService;
    private final KichCoResponsitory kichCoResponsitory;

    public KichCoController(KichCoService kichCoService, KichCoResponsitory kichCoResponsitory) {
        this.kichCoService = kichCoService;
        this.kichCoResponsitory = kichCoResponsitory;
    }

    @GetMapping()
    public ApiResponse<?> getAll(Pageable pageable){
        return new ApiResponse<>(HttpStatus.OK.value(), "Successfully",kichCoService.getAll(pageable));
    }
    @PostMapping()
    public ApiResponse<?> createKichCo(@Valid @RequestBody CreateKichCo request){
        if(kichCoResponsitory.findByTenKichCo(request.getTenKichCo()) != null){
            throw new AppException(ErrorCode.EXISTED);
        }
        return new ApiResponse<>(HttpStatus.CREATED.value(),
                "Add thanh cong",kichCoService.createEntity(request));
    }
    @PutMapping("/{id}")
    public ApiResponse<?> updateKichCo(@Valid @PathVariable ("id") Integer id,@RequestBody UpdateKichCo request){
        return new ApiResponse<>(HttpStatus.CREATED.value(), "thanh cong",kichCoService.updateEntity(id, request));
    }
    @GetMapping("/{id}")
    public ApiResponse<?> detailKichCo(@PathVariable("id") Integer id){
        return new ApiResponse<>(HttpStatus.OK.value(), "thanh cong",kichCoService.getById(id));
    }
    @GetMapping("/")
    public ApiResponse<?> getByName(@RequestParam ("tenKichCo") String tenKichCo){
        return new ApiResponse<>(HttpStatus.OK.value(), "thanh cong",kichCoService.getByName(tenKichCo));
    }
}
