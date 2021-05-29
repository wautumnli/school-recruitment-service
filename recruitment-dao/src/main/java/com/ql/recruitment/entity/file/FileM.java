package com.ql.recruitment.entity.file;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author: wautumnli
 * @date: 2021-05-18 18:22
 **/
@Data
@TableName("file_m")
@Accessors(chain = true)
public class FileM {

    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("file_name")
    private String fileName;
    @TableField("file_size")
    private String fileSize;
    @TableField("file_type")
    private String fileType;
    @TableField("file_url")
    private String fileUrl;
    @TableField("publish_user")
    private Long publishUser;
    @TableField("create_time")
    private Date createTime;
    @TableField(exist = false)
    private String userName;
}
