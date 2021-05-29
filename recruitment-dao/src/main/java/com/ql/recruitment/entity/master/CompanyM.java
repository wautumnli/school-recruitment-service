package com.ql.recruitment.entity.master;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 公司实体
 * @author: wautumnli
 * @date: 2021-05-13 17:20
 **/
@Data
@TableName("company_m")
public class CompanyM {
    /**
     * 唯一主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 公司名称
     */
    @TableField("company_name")
    private String companyName;
    /**
     * 图片地址
     */
    @TableField("img_url")
    private String imgUrl;
    /**
     * 公司类型
     */
    @TableField("company_type")
    private String companyType;
    /**
     * 公司状态
     */
    @TableField("company_status")
    private String companyStatus;
    /**
     * 招聘数量
     */
    @TableField("recruit_number")
    private Integer recruitNumber;
}
