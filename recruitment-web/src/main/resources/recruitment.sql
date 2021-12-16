/*
 Navicat Premium Data Transfer

 Source Server         : 本机环境库
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : localhost:3306
 Source Schema         : recruitment

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 16/12/2021 12:23:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for company_m
-- ----------------------------
DROP TABLE IF EXISTS `company_m`;
CREATE TABLE `company_m` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `company_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司名称',
  `img_url` varchar(255) DEFAULT NULL COMMENT '公司图标',
  `company_type` varchar(255) DEFAULT NULL COMMENT '公司类型',
  `company_status` varchar(255) DEFAULT NULL COMMENT '公司状态',
  `recruit_number` int DEFAULT NULL COMMENT '招聘数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for file_m
-- ----------------------------
DROP TABLE IF EXISTS `file_m`;
CREATE TABLE `file_m` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `file_name` varchar(255) NOT NULL COMMENT '文件名',
  `file_type` varchar(255) DEFAULT NULL COMMENT '文件类型',
  `file_size` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件大小',
  `file_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件地址',
  `publish_user` bigint NOT NULL COMMENT '发布人',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for interview_experience_m
-- ----------------------------
DROP TABLE IF EXISTS `interview_experience_m`;
CREATE TABLE `interview_experience_m` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内容',
  `company_name` varchar(255) DEFAULT NULL COMMENT '公司',
  `position` varchar(255) DEFAULT NULL COMMENT '职位',
  `publish_user` bigint DEFAULT NULL COMMENT '发布用户',
  `hot` int DEFAULT NULL COMMENT '热度',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for recruit_d
-- ----------------------------
DROP TABLE IF EXISTS `recruit_d`;
CREATE TABLE `recruit_d` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `content` varchar(700) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '招聘信息内容',
  `email` varchar(255) DEFAULT NULL COMMENT '联系方式 邮箱',
  `p_id` bigint DEFAULT NULL COMMENT '父级id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1455103255295946754 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for recruit_m
-- ----------------------------
DROP TABLE IF EXISTS `recruit_m`;
CREATE TABLE `recruit_m` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职位',
  `wages` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工资',
  `work_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工作地点',
  `education` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学历',
  `recruit_type` int NOT NULL DEFAULT '0' COMMENT '招聘类型(0实习，1校招)',
  `company_id` bigint NOT NULL DEFAULT '-1' COMMENT '公司id',
  `industry` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职位所属行业',
  `user_id` bigint NOT NULL COMMENT '所属用户',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for sys_user_m
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_m`;
CREATE TABLE `sys_user_m` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `username` varchar(255) NOT NULL COMMENT '账号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `user_type` int NOT NULL COMMENT '账户类型(0普通1招聘2管理)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for user_info_d
-- ----------------------------
DROP TABLE IF EXISTS `user_info_d`;
CREATE TABLE `user_info_d` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `birthday` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '出生日期',
  `sex` int DEFAULT NULL COMMENT '性别',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `grade` varchar(255) DEFAULT NULL COMMENT '年级',
  `college` varchar(255) DEFAULT NULL COMMENT '学院',
  `class` varchar(255) DEFAULT NULL COMMENT '班级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3;

SET FOREIGN_KEY_CHECKS = 1;
