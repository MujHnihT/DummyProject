package com.example.dummyproject.service.impl;

import com.example.dummyproject.service.UtilityService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;

@Service
public class UtilityServiceImpl implements UtilityService {

    @Override
    public ResponseEntity<BufferedImage> generateQR(HttpServletRequest httpServlet) {
        try {
            String a = httpServlet.getParameter("barcode");
            BufferedImage qrCode = generateEAN13BarcodeImage(a);
            return ResponseEntity.status(200).body(qrCode);
        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.status(500).body(null);
    }

    public static BufferedImage generateEAN13BarcodeImage(String barcodeText) throws Exception {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =
                barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
