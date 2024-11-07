package com.example.demo;

import lombok.Data;

@Data
public class PdfFile {

    private final String id;
    private final String fileName;
    private final String fileUrl;

    public PdfFile(String id, String fileName, String fileUrl) {
        this.id = id;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }
}
