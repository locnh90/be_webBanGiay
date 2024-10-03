package com.example.webSiteBanGiay.service.sanPham;

import com.example.webSiteBanGiay.common.GenericServiceAbstract;
import com.example.webSiteBanGiay.common.IGenericMapper;
import com.example.webSiteBanGiay.common.IGenericRepository;
import com.example.webSiteBanGiay.dto.PageResponse;
import com.example.webSiteBanGiay.dto.sanPham.CreateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.ResponseKichCo;
import com.example.webSiteBanGiay.dto.sanPham.UpdateKichCo;
import com.example.webSiteBanGiay.entity.product.attributes.KichCo;
import com.example.webSiteBanGiay.repository.sanPham.KichCoRepository;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class KichCoService
    extends GenericServiceAbstract<KichCo, Integer, CreateKichCo, UpdateKichCo, ResponseKichCo>
    implements IKichCoService {

    private final KichCoRepository kichCoRepository;

    public KichCoService(IGenericRepository<KichCo, Integer> entityRepository,
                         @Qualifier("kichCoMapperImpl") IGenericMapper<KichCo, CreateKichCo, UpdateKichCo, ResponseKichCo> mapper,
                         EntityManager entityManager, KichCoRepository kichCoRepository) {
        super(entityRepository, mapper, entityManager);
        this.kichCoRepository = kichCoRepository;
    }

    @Override
    public PageResponse<?> getAll(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(),
                pageable.getPageSize(), Sort.by(Sort.Direction.DESC,"ngayThem","id"));
        Page<KichCo> kichCoPage = kichCoRepository.findAll(pageable);
        List<ResponseKichCo> kichCoResponseList = mapper.toEntityDtoList(kichCoPage.getContent());

        return PageResponse.builder()
                .pageNo(pageable.getPageNumber())
                .pageSize(pageable.getPageSize())
                .totalPages(kichCoPage.getTotalPages())
                .totalElements(kichCoPage.getTotalElements())
                .items(kichCoResponseList)
                .build();
    }

    @Override
    protected List<CreateKichCo> beforeCreateEntities(List<CreateKichCo> requests) {
        return null;
    }

    @Override
    protected List<UpdateKichCo> beforeUpdateEntities(List<UpdateKichCo> requests) {
        return null;
    }

    @Override
    protected void beforeCreate(CreateKichCo request) {

    }

    @Override
    protected void beforeUpdate(UpdateKichCo request) {

    }

    @Override
    protected void afterConvertCreateRequest(CreateKichCo request, KichCo entity) {

    }

    @Override
    protected void afterConvertUpdateRequest(UpdateKichCo request, KichCo entity) {

    }

    @Override
    protected String getEntityName() {
        return null;
    }
}


