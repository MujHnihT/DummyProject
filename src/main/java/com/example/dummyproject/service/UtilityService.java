package com.example.dummyproject.service;

import com.example.dummyproject.model.request.QrContentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.util.Map;

@Service
public interface UtilityService {
    ResponseEntity<BufferedImage> generateQR(HttpServletRequest httpServlet);

    ResponseEntity<Object> saveContent(QrContentRequest request,String token);

    ResponseEntity<Object> getContentByUser(Map<String, Object> request);
    ResponseEntity<Object> getContentById(Map<String, Object> request);
}
