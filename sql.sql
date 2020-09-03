/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50712
 Source Host           : localhost:3306
 Source Schema         : appogg

 Target Server Type    : MySQL
 Target Server Version : 50712
 File Encoding         : 65001

 Date: 03/09/2020 16:21:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ogg_article
-- ----------------------------
DROP TABLE IF EXISTS `ogg_article`;
CREATE TABLE `ogg_article`  (
  `id` int(11) NOT NULL,
  `create_date_time` datetime(0) NULL DEFAULT NULL,
  `modify_date_time` datetime(0) NULL DEFAULT NULL,
  `article_title_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `article_auth_id` int(11) NULL DEFAULT NULL,
  `article_classify_group` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `article_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_user_id` int(11) NULL DEFAULT NULL,
  `create_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modify_user_id` int(11) NULL DEFAULT NULL,
  `modify_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT NULL,
  `read_num` int(11) NULL DEFAULT NULL,
  `comment_num` int(11) NULL DEFAULT NULL,
  `is_sticky` tinyint(1) NULL DEFAULT NULL,
  `is_fine` tinyint(1) NULL DEFAULT NULL,
  `helpful_num` int(11) NULL DEFAULT NULL,
  `unhelpful_num` int(11) NULL DEFAULT NULL,
  `is_edit` tinyint(1) NULL DEFAULT NULL,
  `article_title_icon` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `article_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ogg_article_comment
-- ----------------------------
DROP TABLE IF EXISTS `ogg_article_comment`;
CREATE TABLE `ogg_article_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date_time` datetime(0) NULL DEFAULT NULL,
  `modify_date_time` datetime(0) NULL DEFAULT NULL,
  `create_user_id` int(11) NULL DEFAULT NULL,
  `create_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modify_user_id` int(11) NULL DEFAULT NULL,
  `modify_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT NULL,
  `is_sticky` tinyint(1) NULL DEFAULT NULL,
  `helpful_num` int(11) NULL DEFAULT NULL,
  `unhelpful_num` int(11) NULL DEFAULT NULL,
  `comment_article_id` int(11) NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `back_to_user_id` int(11) NULL DEFAULT NULL,
  `back_to_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ogg_auth
-- ----------------------------
DROP TABLE IF EXISTS `ogg_auth`;
CREATE TABLE `ogg_auth`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auth_id` int(11) NULL DEFAULT NULL,
  `auth_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `auth_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date_time` datetime(0) NULL DEFAULT NULL,
  `modify_date_time` datetime(0) NULL DEFAULT NULL,
  `auth_price` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ogg_auth_grade
-- ----------------------------
DROP TABLE IF EXISTS `ogg_auth_grade`;
CREATE TABLE `ogg_auth_grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auth_grade_id` int(11) NULL DEFAULT NULL,
  `auth_operate_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date_time` datetime(0) NULL DEFAULT NULL,
  `modify_date_time` datetime(0) NULL DEFAULT NULL,
  `auth_operate_intr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ogg_classify
-- ----------------------------
DROP TABLE IF EXISTS `ogg_classify`;
CREATE TABLE `ogg_classify`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date_time` datetime(0) NULL DEFAULT NULL,
  `modirfy_date_time` datetime(0) NULL DEFAULT NULL,
  `classify_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `classify_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `classify_create_user_id` int(11) NULL DEFAULT NULL,
  `classify_create_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_enable` tinyint(1) NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ogg_follow
-- ----------------------------
DROP TABLE IF EXISTS `ogg_follow`;
CREATE TABLE `ogg_follow`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `follow_user_id` int(11) NULL DEFAULT NULL,
  `follow_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `follow_to_user_id` int(11) NULL DEFAULT NULL,
  `follow_to_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date_time` datetime(0) NULL DEFAULT NULL,
  `modify_date_time` datetime(0) NULL DEFAULT NULL,
  `is_enable` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ogg_menu
-- ----------------------------
DROP TABLE IF EXISTS `ogg_menu`;
CREATE TABLE `ogg_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date_time` datetime(0) NULL DEFAULT NULL,
  `modify_date_time` datetime(0) NULL DEFAULT NULL,
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_user_id` int(11) NULL DEFAULT NULL,
  `menu_name_english` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ogg_need
-- ----------------------------
DROP TABLE IF EXISTS `ogg_need`;
CREATE TABLE `ogg_need`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date_time` datetime(0) NULL DEFAULT NULL,
  `modify_date_time` datetime(0) NULL DEFAULT NULL,
  `need_title_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_user_id` int(11) NULL DEFAULT NULL,
  `create_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modify_user_id` int(11) NULL DEFAULT NULL,
  `modify_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `answer_num` int(11) NULL DEFAULT NULL,
  `is_solved` tinyint(1) NULL DEFAULT NULL,
  `read_num` int(11) NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT NULL,
  `is_fine` tinyint(1) NULL DEFAULT NULL,
  `is_sticky` tinyint(1) NULL DEFAULT NULL,
  `helpful_num` int(11) NULL DEFAULT NULL,
  `unhelpful_num` int(11) NULL DEFAULT NULL,
  `need_classify_group` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `need_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ogg_need_answer
-- ----------------------------
DROP TABLE IF EXISTS `ogg_need_answer`;
CREATE TABLE `ogg_need_answer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date_time` datetime(0) NULL DEFAULT NULL,
  `modify_date_time` datetime(0) NULL DEFAULT NULL,
  `create_user_id` int(11) NULL DEFAULT NULL,
  `create_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modify_user_id` int(11) NULL DEFAULT NULL,
  `modify_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT NULL,
  `is_sticky` tinyint(1) NULL DEFAULT NULL,
  `helpful_num` int(11) NULL DEFAULT NULL,
  `unhelpful_num` int(11) NULL DEFAULT NULL,
  `answer_need_id` int(11) NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `back_to_user_id` int(11) NULL DEFAULT NULL,
  `back_to_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_adopt` tinyint(1) NULL DEFAULT NULL,
  `is_enable` tinyint(1) NULL DEFAULT NULL,
  `answer_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ogg_notice
-- ----------------------------
DROP TABLE IF EXISTS `ogg_notice`;
CREATE TABLE `ogg_notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date_time` datetime(0) NULL DEFAULT NULL,
  `modify_date_time` datetime(0) NULL DEFAULT NULL,
  `action_from_user_id` int(11) NULL DEFAULT NULL,
  `action_from_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `read_status` tinyint(1) NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT NULL,
  `notice_to_user_id` int(11) NULL DEFAULT NULL,
  `notice_to_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notice_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `action_accepter` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notice_module` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notice_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ogg_soft
-- ----------------------------
DROP TABLE IF EXISTS `ogg_soft`;
CREATE TABLE `ogg_soft`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `soft_title_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `soft_title_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date_time` datetime(0) NULL DEFAULT NULL,
  `modify_date_time` datetime(0) NULL DEFAULT NULL,
  `create_user_id` int(11) NULL DEFAULT NULL,
  `create_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modify_user_id` int(11) NULL DEFAULT NULL,
  `modify_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `soft_auth_id` int(11) NULL DEFAULT NULL,
  `soft_classify_group` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT NULL,
  `read_num` int(11) NULL DEFAULT NULL,
  `comment_num` int(11) NULL DEFAULT NULL,
  `is_sticky` tinyint(1) NULL DEFAULT NULL,
  `is_fine` tinyint(1) NULL DEFAULT NULL,
  `helpful_num` int(11) NULL DEFAULT NULL,
  `unhelpful_num` int(11) NULL DEFAULT NULL,
  `soft_system_platform` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `soft_download_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `soft_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ogg_soft_comment
-- ----------------------------
DROP TABLE IF EXISTS `ogg_soft_comment`;
CREATE TABLE `ogg_soft_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date_time` datetime(0) NULL DEFAULT NULL,
  `modify_date_time` datetime(0) NULL DEFAULT NULL,
  `create_user_id` int(11) NULL DEFAULT NULL,
  `create_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modify_user_id` int(11) NULL DEFAULT NULL,
  `modify_user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT NULL,
  `is_sticky` tinyint(1) NULL DEFAULT NULL,
  `helpful_num` int(11) NULL DEFAULT NULL,
  `unhelpful_num` int(11) NULL DEFAULT NULL,
  `comment_soft_id` int(11) NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `back_to_user_id` int(11) NULL DEFAULT NULL,
  `back_to_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ogg_user
-- ----------------------------
DROP TABLE IF EXISTS `ogg_user`;
CREATE TABLE `ogg_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `member_level_id` int(11) NULL DEFAULT NULL,
  `member_level_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_destroy` tinyint(1) NULL DEFAULT NULL,
  `create_date_time` datetime(0) NULL DEFAULT NULL,
  `article_num` int(11) NULL DEFAULT NULL,
  `article_read_num` int(11) NULL DEFAULT NULL,
  `user_nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_head_icon` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `user_page_icon` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
