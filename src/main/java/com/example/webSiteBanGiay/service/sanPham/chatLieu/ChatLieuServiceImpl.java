package com.example.webSiteBanGiay.service.sanPham.chatLieu;

import com.example.webSiteBanGiay.common.GenericMapper;
import com.example.webSiteBanGiay.common.GenericRepository;
import com.example.webSiteBanGiay.common.GenericServiceImpl;
import com.example.webSiteBanGiay.dto.PageResponse;
import com.example.webSiteBanGiay.dto.sanPham.chatLieu.CreateChatLieu;
import com.example.webSiteBanGiay.dto.sanPham.chatLieu.ResponseChatLieu;
import com.example.webSiteBanGiay.dto.sanPham.chatLieu.UpdateChatLieu;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.ResponseKichCo;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.ChatLieu;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.KichCo;
import com.example.webSiteBanGiay.repository.sanPham.ChatLieuResponsitory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChatLieuServiceImpl
        extends GenericServiceImpl<ChatLieu,Integer, CreateChatLieu, UpdateChatLieu, ResponseChatLieu>
        implements ChatLieuService {

    private final ChatLieuResponsitory chatLieuResponsitory;

    protected ChatLieuServiceImpl(GenericMapper<ChatLieu, CreateChatLieu, UpdateChatLieu, ResponseChatLieu> mapper
            , GenericRepository<ChatLieu, Integer, CreateChatLieu, UpdateChatLieu, ResponseChatLieu> repository
            , EntityManager entityManager, ChatLieuResponsitory chatLieuResponsitory) {
        super(mapper, repository, entityManager);
        this.chatLieuResponsitory = chatLieuResponsitory;
    }


    @Override
    public PageResponse<?> getAllByName(Pageable pageable, String tenChatLieu) {
        int page = 0;
        if (pageable.getPageNumber() > 0) page = pageable.getPageNumber() - 1;

        PageRequest pageRequest = PageRequest.of(page, pageable.getPageSize(),
                Sort.by(Sort.Direction.DESC, "ngayThem", "id"));

        Page<ChatLieu> entityPage = chatLieuResponsitory.findByTenKChatLieu(pageRequest,tenChatLieu);
        List<ResponseChatLieu> result = mapper.toListResponse(entityPage.getContent());
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
        ChatLieu chatLieu = chatLieuResponsitory.findByTenChatLieu(tenKichCo);
        if(chatLieu!=null){
            return true;
        }
        return false;
    }


}
