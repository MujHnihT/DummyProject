package com.example.dummyproject.common;

public enum CommonResponseEnum {
    SUCCESS(200,"Success"),
    INTERNAL_ERROR(500,"Internal server error");

    public final int responseCode;
    public final String message;
    CommonResponseEnum(int responseCode, String message){
        this.responseCode =responseCode;
        this.message = message;

    }
}
