package com.ql.recruitment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author： wanqiuli
 * DateTime: 2021/2/26 9:33
 */
@SpringBootApplication
@MapperScan("com.ql.recruitment.mapper.*")
public class RecruitmentWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitmentWebApplication.class, args);
    }
}
