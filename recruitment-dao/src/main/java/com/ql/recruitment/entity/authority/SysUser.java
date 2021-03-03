package com.ql.recruitment.entity.authority;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * Author： wanqiuli
 * DateTime: 2021/3/1 15:44
 */
@Data
@Builder
@TableName("sys_user")
public class SysUser {

    /**
     * 用户唯一id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户电话
     */
    @TableField("phone")
    private String phone;
    /**
     * 用户密码
     */
    @TableField("password")
    private String password;
    /**
     * 用户昵称
     */
    @TableField("nick_name")
    private String nickName;
}
