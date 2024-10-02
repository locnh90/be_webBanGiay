package com.example.webSiteBanGiay.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder

public class PageResponse<E> implements Serializable {
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private E items;

}
