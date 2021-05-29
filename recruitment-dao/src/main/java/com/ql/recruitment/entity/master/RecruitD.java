package com.ql.recruitment.entity.master;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: wautumnli
 * @date: 2021-05-19 00:19
 **/
@Data
@TableName("recruit_d")
@Accessors(chain = true)
public class RecruitD {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("content")
    private String content;
    @TableField("email")
    private String email;
    @TableField("p_id")
    private Long pId;
}
