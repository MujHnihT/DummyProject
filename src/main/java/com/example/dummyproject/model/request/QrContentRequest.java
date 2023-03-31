package com.example.dummyproject.model.request;

import lombok.Data;

@Data
public class QrContentRequest {
    private Integer id;
    private Integer userId;
    private String description;
    private String facebookLink;
    private String twitterLink;
    private String phone;
    private String instagramLink;
}
