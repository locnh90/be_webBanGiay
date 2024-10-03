package com.example.webSiteBanGiay.mapper.sanPham;

import com.example.webSiteBanGiay.common.IGenericMapper;
import com.example.webSiteBanGiay.dto.sanPham.CreateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.ResponseKichCo;
import com.example.webSiteBanGiay.dto.sanPham.UpdateKichCo;
import com.example.webSiteBanGiay.entity.product.attributes.KichCo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KichCoMapper extends IGenericMapper<KichCo, CreateKichCo, UpdateKichCo, ResponseKichCo> {

    @Override
    ResponseKichCo toEntityDto(KichCo entity);


    @Mapping(target = "ngayThem", ignore = true)
    @Mapping(target = "ngayUpdate",ignore = true)
    @Mapping(target = "id",ignore = true)
    @Override
    KichCo createToEntity(CreateKichCo request);

    @Mapping(target = "ngayThem", ignore = true)
    @Mapping(target = "ngayUpdate",ignore = true)
    @Mapping(target = "id",ignore = true)
    @Override
    void updateToEntity(@MappingTarget KichCo entity, UpdateKichCo request);
}
