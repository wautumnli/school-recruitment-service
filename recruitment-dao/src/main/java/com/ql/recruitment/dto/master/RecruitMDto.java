package com.ql.recruitment.dto.master;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: wautumnli
 * @date: 2021-05-13 16:47
 **/
@Data
@Accessors(chain = true)
public class RecruitMDto {
    private Long id;
    /**
     * 招聘类型 0实习，1校招
     */
    private Integer recruitType;
    /**
     * 职位所属行业
     */
    private String industry;
    /**
     * 公司名字
     */
    private String companyName;
    /**
     * 招聘名称
     */
    private String position;
    /**
     * 页数
     */
    private Integer pageNum;
    /**
     * 内容
     */
    private Integer pageSize;
    private Long userId;
    private Long companyId;
    private String wages;
    private String workPlace;
    private String education;
    private String email;
    private String content;
    private String userName;
}
