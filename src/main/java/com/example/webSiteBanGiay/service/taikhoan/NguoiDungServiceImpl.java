package com.example.webSiteBanGiay.service.taikhoan;

import com.example.webSiteBanGiay.common.GenericMapper;
import com.example.webSiteBanGiay.common.GenericRepository;
import com.example.webSiteBanGiay.common.GenericServiceImpl;
import com.example.webSiteBanGiay.dto.taiKhoan.nguoiDung.CreateNguoiDung;
import com.example.webSiteBanGiay.dto.taiKhoan.nguoiDung.ResponseNguoiDung;
import com.example.webSiteBanGiay.dto.taiKhoan.nguoiDung.UpdateNguoiDung;
import com.example.webSiteBanGiay.entity.taiKhoan.NguoiDung;
import com.example.webSiteBanGiay.repository.taiKhoan.NguoiDungResponsitory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class NguoiDungServiceImpl
        extends GenericServiceImpl<NguoiDung,Integer, CreateNguoiDung, UpdateNguoiDung, ResponseNguoiDung>
        implements NguoiDungService{

    private final NguoiDungResponsitory nguoiDungRepository;

    protected NguoiDungServiceImpl(GenericMapper<NguoiDung, CreateNguoiDung, UpdateNguoiDung, ResponseNguoiDung> mapper,
                                   GenericRepository<NguoiDung, Integer, CreateNguoiDung, UpdateNguoiDung, ResponseNguoiDung> repository, EntityManager entityManager,
                                   NguoiDungResponsitory nguoiDungRepository, NguoiDungResponsitory nguoiDungRepository1) {
        super(mapper, repository, entityManager);
        this.nguoiDungRepository = nguoiDungRepository1;
    }
}
