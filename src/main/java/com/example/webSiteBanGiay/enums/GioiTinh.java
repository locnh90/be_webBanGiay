package com.example.webSiteBanGiay.enums;

import jakarta.annotation.Nullable;

public enum GioiTinh {
    NAM(0),
    NU(1),
    KHAC(2)
    ;
    private final int value;


    GioiTinh(int value) {
        this.value = value;
    }

    public static GioiTinh valueOf(int value){
        GioiTinh gioiTinh = resolve(value);
        if(gioiTinh == null){
            throw new IllegalArgumentException("Khong dung dinh danh ["+ value+ "]");
        }
        return gioiTinh;
    }

    @Nullable
    public static GioiTinh resolve(int value){
        for(GioiTinh gioiTinh : GioiTinh.values()){
            if(gioiTinh.value == value){
                return gioiTinh;
            }
        }
        return null;
    }
}
