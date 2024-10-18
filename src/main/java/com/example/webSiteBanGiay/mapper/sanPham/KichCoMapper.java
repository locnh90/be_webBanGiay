package com.example.webSiteBanGiay.mapper.sanPham;

import com.example.webSiteBanGiay.common.GenericMapper;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.CreateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.ResponseKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.UpdateKichCo;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.KichCo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KichCoMapper extends GenericMapper<KichCo, CreateKichCo, UpdateKichCo, ResponseKichCo> {
    @Mapping(target = "id",ignore = true)
    @Override
    KichCo toCreateEntity(CreateKichCo request);

    @Override
    ResponseKichCo toResponse(KichCo entity);

    @Override
    List<ResponseKichCo> toListResponse(List<KichCo> listEntity);

    @Override
    void toUpdateEntity(@MappingTarget KichCo entity, UpdateKichCo request);
}
