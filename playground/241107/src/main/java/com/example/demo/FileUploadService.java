package com.example.demo;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class FileUploadService {

    private final S3Client s3Client;
    private final String bucketName;
    private final String cdnUrl;

    public FileUploadService(S3Client s3Client,
                             @Value("${spring.aws.s3.bucket-name}") String bucketName,
                             @Value("${spring.aws.cdn.url}") String cdnUrl) {
        this.s3Client = s3Client;
        this.bucketName = bucketName;
        this.cdnUrl = cdnUrl;
    }

    public PdfFile upload(MultipartFile file) throws IOException {
        String originalFileName = file.getOriginalFilename();
        String fileName = URLDecoder.decode(originalFileName, StandardCharsets.UTF_8.toString());
        String encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString()).replaceAll("\\+", "%20");
        String objectKey = "uploads/" + encodedFileName;

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
            .bucket(bucketName)
            .key(objectKey)
            .contentType(file.getContentType())
            .build();

        // https://{bucket-name}.s3.{region}.amazonaws.com/{object-key}
        s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));

        String fileUrl = cdnUrl + "/" + objectKey;
        String id = UUID.randomUUID().toString();
        return new PdfFile(id, fileName, fileUrl);
    }
}
