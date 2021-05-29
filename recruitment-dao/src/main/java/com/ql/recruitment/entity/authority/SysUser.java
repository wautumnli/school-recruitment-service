package com.ql.recruitment.entity.authority;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户主档信息
 * Author： wanqiuli
 * DateTime: 2021/3/1 15:44
 */
@Data
@Accessors(chain = true)
@TableName("sys_user_m")
public class SysUser {

    /**
     * 用户唯一id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 账号
     */
    @TableField("username")
    private String username;
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
    /**
     * 账户类型(0普通，1招聘，2管理)
     */
    @TableField("user_type")
    private Integer userType;
}
