package com.example.webSiteBanGiay.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<E> implements Serializable {

    private final int code;
    private final String message;
    private E data;

    public ApiResponse(int code, String message, E data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }


}
