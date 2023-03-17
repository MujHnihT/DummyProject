package com.example.dummyproject.controller;

import com.example.dummyproject.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping(value = "/utility")
public class UtilityController {

    @Autowired
    UtilityService utilityService;
    @GetMapping(value="/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> generateQRCode(HttpServletRequest httpServlet) throws Exception {
        return utilityService.generateQR(httpServlet);
    }
}
