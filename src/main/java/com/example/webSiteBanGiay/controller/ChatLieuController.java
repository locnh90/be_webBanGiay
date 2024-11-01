package com.example.webSiteBanGiay.controller;

import com.example.webSiteBanGiay.dto.ApiResponse;
import com.example.webSiteBanGiay.dto.sanPham.chatLieu.CreateChatLieu;
import com.example.webSiteBanGiay.dto.sanPham.chatLieu.UpdateChatLieu;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.CreateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.UpdateKichCo;
import com.example.webSiteBanGiay.exception.AppException;
import com.example.webSiteBanGiay.exception.ErrorCode;
import com.example.webSiteBanGiay.service.sanPham.chatLieu.ChatLieuService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin/chatLieu")
public class ChatLieuController {

    private final ChatLieuService chatLieuService;

    public ChatLieuController(ChatLieuService chatLieuService) {
        this.chatLieuService = chatLieuService;
    }


    @GetMapping()
    public ApiResponse<?> getAll(Pageable pageable,@RequestParam(required = false)String name){
        return new ApiResponse<>(HttpStatus.OK.value(), "Successfully",chatLieuService.getAllByName(pageable,name));
    }
    @PostMapping()
    public ApiResponse<?> createChatLieu(@Valid @RequestBody CreateChatLieu request){
        if(chatLieuService.getByName(request.getTenChatLieu())){
            throw new AppException(ErrorCode.EXISTED,"chất liệu");
        }
        return new ApiResponse<>(HttpStatus.CREATED.value(),
                "Thêm thành công kích cỡ",chatLieuService.createEntity(request));
    }
    @PutMapping("/{id}")
    public ApiResponse<?> updateChatLieu(@Valid @PathVariable ("id") Integer id,@RequestBody UpdateChatLieu request){
        if(chatLieuService.getByName(request.getTenChatLieu())){
            throw new AppException(ErrorCode.EXISTED,"chất liệu");
        }
        return new ApiResponse<>(HttpStatus.CREATED.value(), "Cập nhật thành công chất liệu",chatLieuService.updateEntity(id, request));
    }
    @GetMapping("/{id}")
    public ApiResponse<?> detailChatLieu(@PathVariable("id") Integer id){
        return new ApiResponse<>(HttpStatus.OK.value(), "thanh cong",chatLieuService.getById(id));
    }

}
