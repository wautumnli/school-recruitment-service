package com.ql.recruitment.dto.file;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: wautumnli
 * @date: 2021-05-18 18:24
 **/
@Data
@Accessors(chain = true)
public class FileMDto {

    private Long publishUser;
    private String userName;
    private String fileName;
    private Integer pageNum;
    private Integer pageSize;
    private Long userId;
    private Long id;
}
