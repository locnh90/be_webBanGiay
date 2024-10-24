package com.example.webSiteBanGiay.controller;

import com.example.webSiteBanGiay.dto.ApiResponse;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.UpdateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.CreateThuongHieu;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.UpdateThuongHieu;
import com.example.webSiteBanGiay.exception.AppException;
import com.example.webSiteBanGiay.exception.ErrorCode;
import com.example.webSiteBanGiay.repository.sanPham.ThuongHieuRepository;
import com.example.webSiteBanGiay.service.sanPham.thuongHieu.ThuongHieuService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin/thuongHieu")
public class ThuongHieuController {

    private final ThuongHieuService thuongHieuService;

    public ThuongHieuController(ThuongHieuService thuongHieuService, ThuongHieuRepository thuongHieuRepository) {

        this.thuongHieuService = thuongHieuService;
    }

    @GetMapping("")
    public ApiResponse<?> getAll(Pageable pageable,
                                 @RequestParam(required = false) String name){
        return new ApiResponse<>(HttpStatus.OK.value(), "thanh cong",thuongHieuService.getByName(pageable,name));
    }
    @PostMapping()
    public ApiResponse<?> createThuongHieu(@Valid @RequestBody CreateThuongHieu request){
        if (thuongHieuService.getByName(request.getTenThuongHieu())) {
            // Ném ngoại lệ với thông điệp tùy chỉnh và mã lỗi
            throw new AppException(ErrorCode.EXISTED,"tên thương hiệu");
        }
        return new ApiResponse<>(HttpStatus.CREATED.value(),
                "Thêm mới thanh cong",thuongHieuService.createEntity(request));
    }
    @PutMapping("/{id}")
    public ApiResponse<?> updateKichCo(@Valid @PathVariable ("id") Integer id,@RequestBody UpdateThuongHieu request){
        if(thuongHieuService.getByName(request.getTenThuongHieu())){
            throw new AppException(ErrorCode.EXISTED,"thương hiệu");
        }
        return new ApiResponse<>(HttpStatus.CREATED.value(), "Cập nhật thành công thương hiệu",thuongHieuService.updateEntity(id, request));
    }
    @GetMapping("/{id}")
    public ApiResponse<?> detailKichCo(@PathVariable("id") Integer id){
        return new ApiResponse<>(HttpStatus.OK.value(), "thanh cong",thuongHieuService.getById(id));
    }
}
