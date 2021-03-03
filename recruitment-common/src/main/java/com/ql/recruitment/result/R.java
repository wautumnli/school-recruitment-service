package com.ql.recruitment.result;

import com.google.common.collect.Maps;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * Author： wanqiuli
 * DateTime: 2021/2/22 15:10
 */
@Data
@Accessors(chain = true)
public class R {

    private Integer code;
    private String message;
    private Map<String, Object> data = Maps.newHashMap();

    public R() {}

    public static R ok() {
        R r = new R();
        r.setCode(ResultEnum.SUCCESS.getCode())
                .setMessage(ResultEnum.SUCCESS.getMessage());
        return r;
    }

    public static R error() {
        R r = new R();
        r.setCode(ResultEnum.ERROR.getCode());
        r.setMessage(ResultEnum.ERROR.getMessage());
        return r;
    }

    public static R unAuthorized() {
        R r = new R();
        r.setCode(ResultEnum.UNAUTHORIZED.getCode());
        r.setMessage(ResultEnum.UNAUTHORIZED.getMessage());
        return r;
    }

    public static R forbidden() {
        R r = new R();
        r.setCode(ResultEnum.FORBIDDEN.getCode());
        r.setMessage(ResultEnum.FORBIDDEN.getMessage());
        return r;
    }

    public R data(Map<String,Object> map) {
        this.setData(map);
        return this;
    }

    public R data(String key,Object value) {
        this.data.put(key, value);
        return this;
    }

    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    public R code(Integer code) {
        this.setCode(code);
        return this;
    }
}
