package com.example.webSiteBanGiay.exception;

public class AppException extends RuntimeException{


    public AppException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    public AppException(ErrorCode errorCode,String message) {
        super(errorCode.getMessage()+" "+message);
        this.errorCode = errorCode;
    }

    private ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}