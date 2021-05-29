package com.ql.recruitment.entity.master;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 招聘信息主表
 * @author: wautumnli
 * @date: 2021-05-13 16:11
 **/
@Data
@TableName("recruit_m")
@Accessors(chain = true)
public class RecruitM {
    /**
     * 唯一Id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 招聘职位名称
     */
    @TableField("position")
    private String position;
    /**
     * 工资
     */
    @TableField("wages")
    private String wages;
    /**
     * 工作地点
     */
    @TableField("work_place")
    private String workPlace;
    /**
     * 学历
     */
    @TableField("education")
    private String education;
    /**
     * 招聘类型 0实习，1校招
     */
    @TableField("recruit_type")
    private Integer recruitType;
    /**
     * 职位所属行业
     */
    @TableField("industry")
    private String industry;
    /**
     * 公司id
     */
    @TableField("company_id")
    private Long companyId;
    /**
     * 招聘信息发布者id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 公司实体
     */
    @TableField(exist = false)
    private CompanyM companyM;
    @TableField(exist = false)
    private String userName;
    @TableField("create_time")
    private Date createTime;
    @TableField(exist = false)
    private RecruitD recruitD;
}
