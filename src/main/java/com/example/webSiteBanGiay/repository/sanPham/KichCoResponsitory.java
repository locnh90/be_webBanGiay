package com.example.webSiteBanGiay.repository.sanPham;

import com.example.webSiteBanGiay.common.GenericRepository;
import com.example.webSiteBanGiay.dto.sanPham.CreateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.ResponseKichCo;
import com.example.webSiteBanGiay.dto.sanPham.UpdateKichCo;
import com.example.webSiteBanGiay.entity.product.attributes.KichCo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KichCoResponsitory extends GenericRepository<KichCo,Integer, CreateKichCo, UpdateKichCo, ResponseKichCo> {
        @Query("""
        select k 
        from KichCo k where k.tenKichCo = :name
""")
    KichCo findByTenKichCo(@Param("name") String name);
}
