package com.ql.recruitment.service.minio;

import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author: wautumnli
 * @date: 2021-05-19 02:56
 **/
@Component
public class MinioService {

    @Resource
    private MinioClient minioClient;

    private static final Long PART_SIZE = 1000 * 1024 * 1024L;

    public String upload(MultipartFile file) throws Exception {
        InputStream is = file.getInputStream();
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket("file")
                .object(file.getOriginalFilename())
                .contentType(file.getContentType())
                .stream(is, -1, PART_SIZE)
                .build();
        ObjectWriteResponse objectWriteResponse = minioClient.putObject(putObjectArgs);
        GetPresignedObjectUrlArgs build = GetPresignedObjectUrlArgs.builder()
                .bucket("file")
                .object(file.getOriginalFilename())
                .method(Method.GET)
                .build();
        return minioClient.getPresignedObjectUrl(build);
    }

    public void deleteFile(String fileName) throws Exception {
        RemoveObjectArgs removeObjectArgs = RemoveObjectArgs.builder()
                .bucket("file")
                .object(fileName)
                .build();
        minioClient.removeObject(removeObjectArgs);
    }
}
