package com.ql.recruitment.dto.interview;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author: wautumnli
 * @date: 2021-05-18 17:30
 **/
@Data
@Accessors(chain = true)
public class InterviewDto {
    private Long id;
    private String title;
    private String position;
    private String companyName;
    private Integer pageNum;
    private Integer pageSize;
    private Long userId;
    private String content;
    private String userName;
    private Integer hot;
}
