package com.example.webSiteBanGiay.service.sanPham.chatLieu;

import com.example.webSiteBanGiay.common.GenericService;
import com.example.webSiteBanGiay.dto.PageResponse;
import com.example.webSiteBanGiay.dto.sanPham.chatLieu.CreateChatLieu;
import com.example.webSiteBanGiay.dto.sanPham.chatLieu.ResponseChatLieu;
import com.example.webSiteBanGiay.dto.sanPham.chatLieu.UpdateChatLieu;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.CreateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.ResponseKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.UpdateKichCo;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.ChatLieu;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.KichCo;
import org.springframework.data.domain.Pageable;


public interface ChatLieuService extends GenericService<ChatLieu,Integer, CreateChatLieu, UpdateChatLieu, ResponseChatLieu> {
    PageResponse<?> getAllByName(Pageable pageable, String name);
    Boolean getByName(String tenChatLieu);
}
