package com.ql.recruitment.entity.master;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ql.recruitment.entity.authority.SysUser;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author: wautumnli
 * @date: 2021-05-19 05:12
 **/
@Data
@Accessors(chain = true)
@TableName("user_info_d")
public class UserInfo {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("birthday")
    private Date birthday;
    @TableField("sex")
    private Integer sex;
    @TableField("user_id")
    private Long userId;
    @TableField("grade")
    private String grade;
    @TableField("college")
    private String college;
    @TableField("class")
    private String className;
    @TableField(exist = false)
    private SysUser sysUser;
}
