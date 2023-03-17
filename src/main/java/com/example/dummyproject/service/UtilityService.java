package com.example.dummyproject.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;

@Service
public interface UtilityService {
    ResponseEntity<BufferedImage> generateQR(HttpServletRequest httpServlet);
}
