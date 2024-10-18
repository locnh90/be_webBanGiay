package com.example.webSiteBanGiay.service.sanPham.thuongHieu;

import com.example.webSiteBanGiay.common.GenericMapper;
import com.example.webSiteBanGiay.common.GenericRepository;
import com.example.webSiteBanGiay.common.GenericServiceImpl;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.CreateThuongHieu;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.ResponseThuongHieu;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.UpdateThuongHieu;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.ThuongHieu;
import com.example.webSiteBanGiay.mapper.sanPham.ThuongHieuMapper;
import com.example.webSiteBanGiay.repository.sanPham.ThuongHieuRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class ThuongHieuServiceImpl
extends GenericServiceImpl<ThuongHieu, Integer, CreateThuongHieu, UpdateThuongHieu, ResponseThuongHieu>
implements ThuongHieuService{

    private final ThuongHieuRepository thuongHieuRepository;
    private final ThuongHieuMapper thuongHieuMapper;

    protected ThuongHieuServiceImpl(GenericMapper<ThuongHieu, CreateThuongHieu, UpdateThuongHieu, ResponseThuongHieu> mapper, GenericRepository<ThuongHieu, Integer, CreateThuongHieu, UpdateThuongHieu, ResponseThuongHieu> repository, EntityManager entityManager, ThuongHieuRepository thuongHieuRepository, ThuongHieuMapper thuongHieuMapper) {
        super(mapper, repository, entityManager);
        this.thuongHieuRepository = thuongHieuRepository;
        this.thuongHieuMapper = thuongHieuMapper;
    }
}
