package com.example.dummyproject.service.impl;

import com.example.dummyproject.common.CommonResponseEnum;
import com.example.dummyproject.model.entity.QrContent;
import com.example.dummyproject.model.request.QrContentRequest;
import com.example.dummyproject.model.response.QrContentResponse;
import com.example.dummyproject.repo.QrContentRepository;
import com.example.dummyproject.service.UtilityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class UtilityServiceImpl implements UtilityService {

    @Autowired
    QrContentRepository qrContentRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public ResponseEntity<BufferedImage> generateQR(HttpServletRequest httpServlet) {
        try {
            String url = httpServlet.getParameter("url");
            BufferedImage qrCode = generateEAN13BarcodeImage(url);
            return ResponseEntity.status(CommonResponseEnum.SUCCESS.responseCode).body(qrCode);
        } catch (Exception e) {
            return ResponseEntity.status(CommonResponseEnum.INTERNAL_ERROR.responseCode).body(null);

        }
    }

    public static BufferedImage generateEAN13BarcodeImage(String barcodeText) throws Exception {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =
                barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }


    public static String readQRCode(MultipartFile filePath, Map<DecodeHintType, String> hintMap)
            throws Exception {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(
                        ImageIO.read(filePath.getInputStream()))));
        Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap, hintMap);
        System.out.println(qrCodeResult.getText());
        return qrCodeResult.getText();
    }

    @Override
    public ResponseEntity<Object> saveContent(QrContentRequest request, String token) {
        try {
            QrContent qrContent = new QrContent();
            qrContent.setDescription(request.getDescription());
            qrContent.setFacebookLink(request.getFacebookLink());
            qrContent.setTwitterLink(request.getTwitterLink());
            qrContent.setInstagramLink(request.getInstagramLink());
            qrContent.setPhone(request.getPhone());
            LocalDateTime currentTime = LocalDateTime.now();
            qrContent.setUpdateDate(Timestamp.valueOf(currentTime));
//            //todo validate later
//            qrContent.setUserId(request.getUserId());
            if (request.getUserId() != null) {
                qrContent.setUserId(request.getUserId());
            } else {
                qrContent.setExpiredDate(Timestamp.valueOf(currentTime.toLocalDate().atTime(23, 59, 59)));
            }
            qrContent = qrContentRepository.save(qrContent);
            request.setId(qrContent.getId());
            return ResponseEntity.status(CommonResponseEnum.SUCCESS.responseCode).body(qrContent);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.status(CommonResponseEnum.INTERNAL_ERROR.responseCode).body(CommonResponseEnum.INTERNAL_ERROR.message);

        }

    }

    @Override
    public ResponseEntity<Object> getContentByUser(Map<String, Object> request) {
        try {
            List<QrContentResponse> contentResponses = new ArrayList<>();

            if (request.containsKey("userId") && Objects.nonNull(request.get("userId"))) {
                int userId = (Integer) request.get("userId");
                List<QrContent> qrContents = qrContentRepository.findByUserId(userId);

                for (QrContent qrContent : qrContents) {
                    contentResponses.add(mapDetailResponseWithData(qrContent));
                }

            }

            return ResponseEntity.status(CommonResponseEnum.SUCCESS.responseCode).body(contentResponses);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.status(CommonResponseEnum.INTERNAL_ERROR.responseCode).body(CommonResponseEnum.INTERNAL_ERROR.message);


        }

    }

    @Override
    public ResponseEntity<Object> getContentById(Map<String, Object> request) {
        try {
            QrContentResponse contentResponses = new QrContentResponse();

            if (request.containsKey("id") && Objects.nonNull(request.get("id"))) {
                int userId = (Integer) request.get("id");
                Optional<QrContent> qrContents = qrContentRepository.findById(userId);

                if(qrContents.isPresent()){
                    contentResponses = mapDetailResponseWithData(qrContents.get());
                }
            }

            return ResponseEntity.status(CommonResponseEnum.SUCCESS.responseCode).body(contentResponses);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.status(CommonResponseEnum.INTERNAL_ERROR.responseCode).body(CommonResponseEnum.INTERNAL_ERROR.message);


        }
    }

    public QrContentResponse mapDetailResponseWithData(QrContent qrContent) {
        QrContentResponse response = new QrContentResponse();
        response.setId(qrContent.getId());
        response.setDescription(qrContent.getDescription());
        response.setPhone(qrContent.getPhone());
        response.setTwitterLink(qrContent.getTwitterLink());
        response.setFacebookLink(qrContent.getFacebookLink());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        LocalDateTime localDateTime = qrContent.getUpdateDate().toLocalDateTime();
        response.setLastUpdateTime(localDateTime.format(formatter));
        return response;
    }


}
