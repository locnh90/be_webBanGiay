package com.example.webSiteBanGiay.mapper.sanPham;

import com.example.webSiteBanGiay.common.GenericMapper;
import com.example.webSiteBanGiay.dto.sanPham.chatLieu.CreateChatLieu;
import com.example.webSiteBanGiay.dto.sanPham.chatLieu.ResponseChatLieu;
import com.example.webSiteBanGiay.dto.sanPham.chatLieu.UpdateChatLieu;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.CreateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.ResponseKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.UpdateKichCo;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.ChatLieu;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.KichCo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatLieuMapper extends GenericMapper<ChatLieu, CreateChatLieu, UpdateChatLieu, ResponseChatLieu> {
    @Mapping(target = "id",ignore = true)
    @Override
    ChatLieu toCreateEntity(CreateChatLieu request);

    @Override
    ResponseChatLieu toResponse(ChatLieu entity);

    @Override
    List<ResponseChatLieu> toListResponse(List<ChatLieu> listEntity);

    @Override
    void toUpdateEntity(@MappingTarget ChatLieu entity, UpdateChatLieu request);
}
