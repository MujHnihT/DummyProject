package com.example.dummyproject.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "qr_content")
@Data
public class QrContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "description")
    private String description;
    @Column(name = "facebook_link")
    private String facebookLink;
    @Column(name = "twitter_link")
    private String twitterLink;
    @Column(name = "phone")
    private String phone;
    @Column(name = "instagram_link")
    private String instagramLink;
    @Column(name = "update_date")
    private Timestamp updateDate;
    @Column(name = "expired_date")
    private Timestamp expiredDate;
}

