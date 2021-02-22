package com.ql.recruitment.result;

import lombok.Getter;

/**
 *
 * @author wanqiuli
 * @date 2021-02-22 14:56
 */
@Getter
public enum ResultEnum {

    SUCCESS(200, "操作成功"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403,"拒绝访问"),
    ERROR(404, "操作失败");


    private Integer code;
    private String message;

    private ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
