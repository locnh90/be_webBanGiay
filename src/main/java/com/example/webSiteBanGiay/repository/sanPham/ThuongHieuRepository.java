package com.example.webSiteBanGiay.repository.sanPham;

import com.example.webSiteBanGiay.common.GenericRepository;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.CreateThuongHieu;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.ResponseThuongHieu;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.UpdateThuongHieu;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.KichCo;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.ThuongHieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ThuongHieuRepository extends GenericRepository<ThuongHieu, Integer, CreateThuongHieu
        , UpdateThuongHieu, ResponseThuongHieu> {

    @Query("""
            select t from ThuongHieu t 
            where 
                (:name is null or t.tenThuongHieu like concat('%', :name, '%'))
            """)
    Page<ThuongHieu> findByTenThuongHieu(Pageable pageable,
                                 @Param("name") String name);

    @Query("""
            select t from ThuongHieu t 
            where 
                (:name is null or t.tenThuongHieu like concat('%', :name, '%'))
            """)
    ThuongHieu findByTenThuongHieu(
                                         @Param("name") String name);

}
