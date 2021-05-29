package com.ql.recruitment.dto.master;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ql.recruitment.dto.authority.SysUserDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author: wautumnli
 * @date: 2021-05-19 05:21
 **/
@Data
@Accessors(chain = true)
public class UserInfoDto {
    private Long id;
    private Date birthday;
    private Integer sex;
    private Long userId;
    private String grade;
    private String college;
    private String className;
    private String userPassword;
    private String userNickName;
    private String username;
    private Integer pageNum;
    private Integer pageSize;
    private Integer userType;
}
