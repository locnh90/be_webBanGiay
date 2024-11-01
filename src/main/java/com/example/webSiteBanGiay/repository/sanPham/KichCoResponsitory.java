package com.example.webSiteBanGiay.repository.sanPham;

import com.example.webSiteBanGiay.common.GenericRepository;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.CreateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.ResponseKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.UpdateKichCo;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.KichCo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KichCoResponsitory extends GenericRepository<KichCo,Integer, CreateKichCo, UpdateKichCo, ResponseKichCo> {
        @Query("""
        select k 
        from KichCo k where k.tenKichCo = :name
""")
    KichCo findByTenKichCo(@Param("name") String name);

    @Query("""
            select k from KichCo k 
            where 
                (:name is null or k.tenKichCo like concat('%', :name, '%'))
            """)
    Page<KichCo> findByTenKichCo(Pageable pageable,
                                              @Param("name") String name);
}
