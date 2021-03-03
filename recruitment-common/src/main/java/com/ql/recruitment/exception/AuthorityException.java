package com.ql.recruitment.exception;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/3 14:34
 */

public class AuthorityException extends RuntimeException {

    private Integer code;

    public AuthorityException() {
        super();
    }

    public AuthorityException(String message) {
        super(message);
    }

    public AuthorityException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
