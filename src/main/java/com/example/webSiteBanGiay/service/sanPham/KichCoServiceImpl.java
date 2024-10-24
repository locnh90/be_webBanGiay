package com.example.webSiteBanGiay.service.sanPham;

import com.example.webSiteBanGiay.common.GenericMapper;
import com.example.webSiteBanGiay.common.GenericRepository;
import com.example.webSiteBanGiay.common.GenericServiceImpl;
import com.example.webSiteBanGiay.dto.PageResponse;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.CreateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.ResponseKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.UpdateKichCo;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.KichCo;

import com.example.webSiteBanGiay.repository.sanPham.KichCoResponsitory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class KichCoServiceImpl
        extends GenericServiceImpl<KichCo,Integer, CreateKichCo, UpdateKichCo, ResponseKichCo>
        implements KichCoService {

    private final KichCoResponsitory kichCoResponsitory;

    protected KichCoServiceImpl(GenericMapper<KichCo, CreateKichCo, UpdateKichCo, ResponseKichCo> mapper,
                                GenericRepository<KichCo, Integer, CreateKichCo, UpdateKichCo, ResponseKichCo> repository,
                                EntityManager entityManager, KichCoResponsitory kichCoResponsitory) {
        super(mapper, repository, entityManager);
        this.kichCoResponsitory = kichCoResponsitory;
    }


    @Override
    public PageResponse<?> getByName(Pageable pageable, String tenKichCo) {
        int page = 0;
        if (pageable.getPageNumber() > 0) page = pageable.getPageNumber() - 1;

        PageRequest pageRequest = PageRequest.of(page, pageable.getPageSize(),
                Sort.by(Sort.Direction.DESC, "ngayThem", "id"));

        Page<KichCo> entityPage = kichCoResponsitory.findByTenKichCo(pageRequest,tenKichCo);
        List<ResponseKichCo> result = mapper.toListResponse(entityPage.getContent());
        return PageResponse.builder()
                .pageNo(pageRequest.getPageNumber() + 1)
                .pageSize(pageable.getPageSize())
                .totalElements(entityPage.getTotalElements())
                .totalPages(entityPage.getTotalPages())
                .items(result)
                .build();
    }

    @Override
    public Boolean getByName(String tenKichCo) {
        KichCo kichCo = kichCoResponsitory.findByTenKichCo(tenKichCo);
        if(kichCo!=null){
            return true;
        }
        return false;
    }


}
