package com.example.webSiteBanGiay.common;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenericRepository <E, ID> extends JpaRepository<E,ID> {
}
