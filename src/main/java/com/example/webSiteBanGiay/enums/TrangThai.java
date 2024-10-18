package com.example.webSiteBanGiay.enums;

import jakarta.annotation.Nullable;

public enum TrangThai {
    ACTIVE(0),
    INACTIVE(1)
    ;

    private final int value;

    TrangThai(int value) {
        this.value = value;
    }
    public static TrangThai valueOf(int value){
        TrangThai trangThai = resolve(value);
        if(trangThai==null){
            throw new IllegalArgumentException("khong dung dinh dang ["+value+"]");
        }
        return trangThai;
    }

    @Nullable
    public static TrangThai resolve(int value){
        for (TrangThai trangThai: TrangThai.values()){
            if(trangThai.value == value){
                return trangThai;
            }
        }
        return null;
    }
}
