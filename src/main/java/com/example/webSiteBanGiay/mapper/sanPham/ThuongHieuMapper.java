package com.example.webSiteBanGiay.mapper.sanPham;

import com.example.webSiteBanGiay.common.GenericMapper;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.CreateThuongHieu;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.ResponseThuongHieu;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.UpdateThuongHieu;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.ThuongHieu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThuongHieuMapper extends GenericMapper<ThuongHieu, CreateThuongHieu, UpdateThuongHieu, ResponseThuongHieu> {
    @Mapping(target = "id",ignore = true)
    @Override
    ThuongHieu toCreateEntity(CreateThuongHieu request);

    @Override
    ResponseThuongHieu toResponse(ThuongHieu entity);

    @Override
    List<ResponseThuongHieu> toListResponse(List<ThuongHieu> listEntity);

    @Override
    void toUpdateEntity(@MappingTarget ThuongHieu entity, UpdateThuongHieu request);
}
