package com.example.webSiteBanGiay.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    EXISTED (HttpStatus.CONFLICT.value(), "Da ton tai"),
    NOT_FOUND(HttpStatus.NOT_FOUND.value(), "Khong tim thay"),
    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
