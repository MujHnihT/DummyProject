package com.example.dummyproject.controller;

import com.example.dummyproject.model.request.AddCommentRequest;
import com.example.dummyproject.model.response.BaseResponse;
import com.example.dummyproject.service.SNSService;
import com.example.dummyproject.service.impl.SNSServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping(value = "/sns")
public class SNSController {

    @Autowired
    SNSService snsService;

    @PostMapping(value="/sendComment")
    public ResponseEntity<BaseResponse> sendComment(@RequestBody @Valid AddCommentRequest addCommentRequest){
        return snsService.sendComment(addCommentRequest);
    }

    @GetMapping(value="/getComment")
    public ResponseEntity<BaseResponse> getComment(){
        return snsService.getComment();
    }
}
