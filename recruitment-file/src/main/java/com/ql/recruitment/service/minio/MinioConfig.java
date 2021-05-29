package com.ql.recruitment.service.minio;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: wautumnli
 * @date: 2021-05-19 01:43
 **/
@Component
public class MinioConfig {

    @Value("${minio.url}")
    private String url;
    @Value("${minio.port}")
    private int port;
    @Value("${minio.username}")
    private String username;
    @Value("${minio.password}")
    private String password;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(url,port,false)
                .credentials(username, password)
                .build();
    }
}
