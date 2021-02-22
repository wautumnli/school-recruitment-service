package com.ql.recruitment.exception;

import com.ql.recruitment.result.ResultEnum;
import lombok.Data;

/**
 * Author： wanqiuli
 * DateTime: 2021/2/22 15:35
 */
@Data
public class CommonException extends RuntimeException {

    private Integer code;

    public CommonException() {
        super();
    }

    public CommonException(String message) {
        super(message);
    }

    public CommonException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
