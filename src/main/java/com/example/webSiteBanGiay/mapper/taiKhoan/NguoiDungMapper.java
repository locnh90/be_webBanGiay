package com.example.webSiteBanGiay.mapper.taiKhoan;

import com.example.webSiteBanGiay.common.GenericMapper;
import com.example.webSiteBanGiay.dto.taiKhoan.nguoiDung.CreateNguoiDung;
import com.example.webSiteBanGiay.dto.taiKhoan.nguoiDung.ResponseNguoiDung;
import com.example.webSiteBanGiay.dto.taiKhoan.nguoiDung.UpdateNguoiDung;
import com.example.webSiteBanGiay.entity.taiKhoan.NguoiDung;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NguoiDungMapper extends GenericMapper<NguoiDung, CreateNguoiDung, UpdateNguoiDung, ResponseNguoiDung> {
    @Mapping(target = "id",ignore = true)
    @Override
    NguoiDung toCreateEntity(CreateNguoiDung request);

    @Override
    ResponseNguoiDung toResponse(NguoiDung entity);

    @Override
    List<ResponseNguoiDung> toListResponse(List<NguoiDung> listEntity);

    @Override
    void toUpdateEntity(@MappingTarget  NguoiDung entity, UpdateNguoiDung request);
}
