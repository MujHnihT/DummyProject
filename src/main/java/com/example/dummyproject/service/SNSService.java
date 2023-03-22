package com.example.dummyproject.service;

import com.example.dummyproject.model.request.AddCommentRequest;
import com.example.dummyproject.model.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;

@Service
public interface SNSService {
    ResponseEntity<BaseResponse> sendComment(AddCommentRequest req);
    ResponseEntity<BaseResponse> getComment();
}
