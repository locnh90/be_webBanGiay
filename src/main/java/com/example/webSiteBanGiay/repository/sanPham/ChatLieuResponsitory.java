package com.example.webSiteBanGiay.repository.sanPham;

import com.example.webSiteBanGiay.common.GenericRepository;
import com.example.webSiteBanGiay.dto.sanPham.chatLieu.CreateChatLieu;
import com.example.webSiteBanGiay.dto.sanPham.chatLieu.ResponseChatLieu;
import com.example.webSiteBanGiay.dto.sanPham.chatLieu.UpdateChatLieu;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.CreateKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.ResponseKichCo;
import com.example.webSiteBanGiay.dto.sanPham.kichCo.UpdateKichCo;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.ChatLieu;
import com.example.webSiteBanGiay.entity.sanPham.thuocTinh.KichCo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChatLieuResponsitory extends GenericRepository<ChatLieu,Integer, CreateChatLieu, UpdateChatLieu, ResponseChatLieu> {
        @Query("""
        select c 
        from ChatLieu c where c.tenChatLieu = :name
""")
    ChatLieu findByTenChatLieu(@Param("name") String name);

    @Query("""
            select c from ChatLieu c 
            where 
                (:name is null or c.tenChatLieu like concat('%', :name, '%'))
            """)
    Page<ChatLieu> findByTenKChatLieu(Pageable pageable,
                                      @Param("name") String name);
}
