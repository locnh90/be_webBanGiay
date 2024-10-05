package com.example.webSiteBanGiay.service.sanPham;

import com.example.webSiteBanGiay.common.GenericMapper;
import com.example.webSiteBanGiay.common.GenericRepository;
import com.example.webSiteBanGiay.common.GenericServiceImpl;
import com.example.webSiteBanGiay.dto.sanPham.CreateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.ResponseKichCo;
import com.example.webSiteBanGiay.dto.sanPham.UpdateKichCo;
import com.example.webSiteBanGiay.entity.product.attributes.KichCo;
import com.example.webSiteBanGiay.repository.sanPham.KichCoResponsitory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;



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

}
