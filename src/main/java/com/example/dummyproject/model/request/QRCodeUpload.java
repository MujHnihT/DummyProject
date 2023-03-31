package com.example.dummyproject.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class QRCodeUpload {
    @JsonIgnore
    private MultipartFile file;
}
