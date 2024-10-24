package com.example.webSiteBanGiay.service.sanPham.thuongHieu;

import com.example.webSiteBanGiay.common.GenericMapper;
import com.example.webSiteBanGiay.common.GenericRepository;
import com.example.webSiteBanGiay.common.GenericServiceImpl;
import com.example.webSiteBanGiay.dto.PageResponse;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.CreateThuongHieu;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.ResponseThuongHieu;
import com.example.webSiteBanGiay.dto.sanPham.thuongHieu.UpdateThuongHieu;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.ThuongHieu;
import com.example.webSiteBanGiay.mapper.sanPham.ThuongHieuMapper;
import com.example.webSiteBanGiay.repository.sanPham.ThuongHieuRepository;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PageResponse<?> getByName(Pageable pageable, String tenThuongHieu) {
        int page = 0;
        if (pageable.getPageNumber() > 0) page = pageable.getPageNumber() - 1;

        PageRequest pageRequest = PageRequest.of(page, pageable.getPageSize(),
                Sort.by(Sort.Direction.DESC, "ngayThem", "id"));

        Page<ThuongHieu> entityPage = thuongHieuRepository.findByTenThuongHieu(pageRequest,tenThuongHieu);
        List<ResponseThuongHieu> result = mapper.toListResponse(entityPage.getContent());
        return PageResponse.builder()
                .pageNo(pageRequest.getPageNumber() + 1)
                .pageSize(pageable.getPageSize())
                .totalElements(entityPage.getTotalElements())
                .totalPages(entityPage.getTotalPages())
                .items(result)
                .build();
    }

    @Override
    public Boolean getByName(String tenThuongHieu) {
        ThuongHieu thuongHieu = thuongHieuRepository.findByTenThuongHieu(tenThuongHieu);
        if(thuongHieu!=null){
            return true;
        }
        return false;
    }
}
