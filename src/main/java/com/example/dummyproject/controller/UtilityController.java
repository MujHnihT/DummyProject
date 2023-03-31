package com.example.dummyproject.controller;

import com.example.dummyproject.model.request.QrContentRequest;
import com.example.dummyproject.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/utility")
public class UtilityController {

    @Autowired
    UtilityService utilityService;


    @PostMapping(value="/qrcode/create")
    public ResponseEntity<Object> saveContent(@RequestBody QrContentRequest request,@RequestHeader (name="Authorization") String token) throws Exception {
        return utilityService.saveContent(request,token);
    }

    @PostMapping(value="/qrcode/getContentByUser")
    public ResponseEntity<Object> getContentByUser(@RequestBody Map<String, Object> request) throws Exception {
        return utilityService.getContentByUser(request);
    }


    @PostMapping(value="/qrcode/getContentById")
    public ResponseEntity<Object> getContentById(@RequestBody Map<String, Object> request) throws Exception {
        return utilityService.getContentById(request);
    }

}
