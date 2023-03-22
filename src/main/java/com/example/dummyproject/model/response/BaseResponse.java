package com.example.dummyproject.model.response;

import lombok.Data;

@Data
public class BaseResponse {
    private int responseCode;
    private String message;
    private Object data;
}
