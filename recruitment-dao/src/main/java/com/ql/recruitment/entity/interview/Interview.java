package com.ql.recruitment.entity.interview;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author: wautumnli
 * @date: 2021-05-18 17:24
 **/
@Data
@TableName("interview_experience_m")
@Accessors(chain = true)
public class Interview {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("title")
    private String title;
    @TableField("content")
    private String content;
    @TableField("company_name")
    private String companyName;
    @TableField("position")
    private String position;
    @TableField("publish_user")
    private Long publishUser;
    @TableField("hot")
    private Integer hot;
    @TableField("create_time")

    private Date createTime;
    @TableField(exist = false)
    private String userName;
}
