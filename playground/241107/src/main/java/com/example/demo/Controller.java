package com.example.demo;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final FileUploadService fileUploadService;

    @PostMapping
    public ResponseEntity<PdfFile> upload(@RequestParam("file") MultipartFile file) throws IOException {
        PdfFile pdfFile = fileUploadService.upload(file);
        return ResponseEntity.ok(pdfFile);
    }
}
