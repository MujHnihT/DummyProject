package com.example.dummyproject.model.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QrContentResponse {
    private Integer id;
    private Integer userId;
    private String description;
    private String facebookLink;
    private String twitterLink;
    private String phone;
    private String instagramLink;
    private String lastUpdateTime;
}
