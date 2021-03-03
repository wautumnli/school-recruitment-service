package com.ql.recruitment.web.exception;

import com.ql.recruitment.exception.AuthorityException;
import com.ql.recruitment.exception.CommonException;
import com.ql.recruitment.result.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/3 14:33
 */
@RestControllerAdvice
public class WebExceptionHandle {

    @ExceptionHandler(AuthorityException.class)
    public R authorityException(AuthorityException e) {
        return R.error().message(e.getMessage());
    }

    @ExceptionHandler(CommonException.class)
    public R commonException(CommonException e) {
        return R.error().message(e.getMessage());
    }
}
