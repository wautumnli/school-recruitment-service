package com.ql.recruitment.entity.authority;

import lombok.Builder;
import lombok.Data;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/1 15:44
 */
@Data
@Builder
public class SysPermission {

    private Long id;
    private Long pid;
    private String name;
}
