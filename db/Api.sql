CREATE DATABASE `db_blog`;

USE `db_blog`;

-- ----------------------------
-- Table structure for tb_blog
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog`;

CREATE TABLE `tb_blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `type_id` int(11) NOT NULL COMMENT '分类id',
  `first_picture` int(11) DEFAULT NULL COMMENT '博客首图',
  `title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标题',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内容',
  `flag` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标记',
  `views` int(11) NOT NULL DEFAULT 0 COMMENT '浏览次数',
  `recommend` tinyint(1) DEFAULT 0 COMMENT '是否推荐(0-不推荐 1-推荐)',
  `status` tinyint(1) DEFAULT 0 COMMENT '状态(0-保存 1-发布)',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='博客表';


-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;

CREATE TABLE `tb_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `blog_id` int(11) NOT NULL COMMENT '博客id',
  `pid` int(11) NOT NULL DEFAULT -1 COMMENT '父id',
  `avatar` VARCHAR(255) COMMENT '头像url',
  `nick_name` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '昵称',
  `email` VARCHAR(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内容',
  `is_blogger` tinyint(1) DEFAULT 0 COMMENT '是否是博主(0-否 1-是)',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=INNODB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='评论表';


-- ----------------------------
-- Table structure for tb_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_type`;

CREATE TABLE `tb_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分类名称',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=INNODB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='分类表';


-- ----------------------------
-- Table structure for tb_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;

CREATE TABLE `tb_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `pid` int(11) NOT NULL DEFAULT -1 COMMENT '父id',
  `avatar` VARCHAR(255) COMMENT '头像url',
  `nick_name` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '昵称',
  `email` VARCHAR(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内容',
  `is_blogger` tinyint(1) DEFAULT 0 COMMENT '是否是博主(0-否 1-是)',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=INNODB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='留言表';


-- ----------------------------
-- Table structure for tb_friend_chain
-- ----------------------------
DROP TABLE IF EXISTS `tb_friend_chain`;

CREATE TABLE `tb_friend_chain` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `blog_avatar` int(11) NOT NULL COMMENT '博客头像',
  `blog_title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '博客标题',
  `blog_link` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '博客链接',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '简介',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=INNODB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='友链表';


-- ----------------------------
-- Table structure for tb_picture
-- ----------------------------
DROP TABLE IF EXISTS `tb_picture`;

CREATE TABLE `tb_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `picture` int(11) NOT NULL COMMENT '照片',
  `title` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标题',
  `address` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `description` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=INNODB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='照片表';


-- ----------------------------
-- Table structure for tb_res
-- ----------------------------
DROP TABLE IF EXISTS `tb_res`;

CREATE TABLE `tb_res` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `type_code` varchar(64) NOT NULL COMMENT '类型code',
  `path` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '存储路径',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=INNODB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='资源表';


-- ----------------------------
-- Table structure for tb_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_log`;

CREATE TABLE `tb_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'IP地址',
  `content` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '访问内容',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统日志表';


-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `avatar` int(11) DEFAULT NULL COMMENT '头像',
  `account` VARCHAR(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '账号（支持中文、英文、数字）',
  `password` VARCHAR(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户密码',
  `name` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称',
  `mobile` VARCHAR(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  `email` VARCHAR(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=INNODB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统用户表';