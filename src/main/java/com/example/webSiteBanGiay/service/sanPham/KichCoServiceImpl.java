package com.example.webSiteBanGiay.service.sanPham;

import com.example.webSiteBanGiay.common.GenericMapper;
import com.example.webSiteBanGiay.common.GenericRepository;
import com.example.webSiteBanGiay.common.GenericServiceImpl;
import com.example.webSiteBanGiay.dto.PageResponse;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.CreateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.ResponseKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.UpdateKichCo;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.KichCo;
import com.example.webSiteBanGiay.mapper.sanPham.KichCoMapper;
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
    private final KichCoMapper mapper;

    protected KichCoServiceImpl(GenericMapper<KichCo, CreateKichCo, UpdateKichCo, ResponseKichCo> mapper,
                                GenericRepository<KichCo, Integer, CreateKichCo, UpdateKichCo, ResponseKichCo> repository,
                                EntityManager entityManager, KichCoResponsitory kichCoResponsitory, KichCoMapper mapper1) {
        super(mapper, repository, entityManager);
        this.kichCoResponsitory = kichCoResponsitory;
        this.mapper = mapper1;
    }

    @Override
    public List<ResponseKichCo> getByName(String tenKichCo) {
        KichCo kichCo = kichCoResponsitory.findByTenKichCo(tenKichCo);
        if(kichCo!= null){
            return List.of(mapper.toResponse(kichCo));
        }
        return null;
    }


}
