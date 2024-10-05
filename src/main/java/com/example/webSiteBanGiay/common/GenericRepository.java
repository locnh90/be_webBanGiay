package com.example.webSiteBanGiay.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T,ID,C,U,R> extends JpaRepository<T, ID> {
}
