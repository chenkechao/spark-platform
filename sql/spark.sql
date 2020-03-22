/*
 Navicat MySQL Data Transfer

 Source Server         : 百度云
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 106.13.179.172
106.13.179.172
106.13.179.172
106.13.179.172
 Source Database       : spark

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : utf-8

 Date: 03/22/2020 14:48:03 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `sys_dept`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `pid` bigint(11) DEFAULT NULL COMMENT '父部门id',
  `pids` varchar(255) DEFAULT NULL COMMENT '父级ids',
  `simple_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简称',
  `full_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '全称',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `dept_type` int(11) DEFAULT NULL COMMENT '部门类型(0 公司1部门)',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '创建人',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  `modifier` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `del_flag` bit(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `sys_dept`
-- ----------------------------
BEGIN;
INSERT INTO `sys_dept` VALUES ('1', '0', null, 'spark', 'spark开源公司', null, '0', '10', '2020-03-21 10:07:50', 'admin', '2020-03-21 10:07:50', 'admin', null, b'0'), ('2', '1', null, '技术部', '信息技术部', null, '1', '10', '2020-03-21 10:11:50', 'admin', '2020-03-21 10:11:50', 'admin', null, b'0'), ('3', '7', null, '研发一部', '研发一部门', null, '1', '10', '2020-03-21 10:12:31', 'admin', '2020-03-21 13:04:32', 'admin', null, b'0'), ('4', '1', null, 'A事业部', 'A产品事业部', null, '1', '10', '2020-03-21 10:13:17', 'admin', '2020-03-21 10:13:17', 'admin', null, b'0'), ('5', '4', null, 'A产品一部', 'A产品一部', null, '1', '10', '2020-03-21 10:13:56', 'admin', '2020-03-21 10:13:56', 'admin', null, b'0'), ('6', '2', null, '测试部', '测试部', null, '1', '10', '2020-03-21 13:03:00', 'admin', '2020-03-21 13:03:00', 'admin', null, b'0'), ('7', '2', null, '研发部', '研发部', null, '0', '10', '2020-03-21 13:04:01', 'admin', '2020-03-21 13:04:01', 'admin', null, b'0'), ('8', '6', null, '测试一部', '测试一部门', null, '0', '10', '2020-03-21 13:05:09', 'admin', '2020-03-21 13:05:09', 'admin', null, b'0');
COMMIT;

-- ----------------------------
--  Table structure for `sys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `value` int(11) DEFAULT NULL COMMENT '字典值',
  `pid` bigint(11) DEFAULT NULL COMMENT '上级ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字典名称',
  `type` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字典类型',
  `description` varchar(128) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '创建人',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  `modifier` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `del_flag` bit(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `pid` bigint(20) NOT NULL COMMENT '上级菜单ID',
  `type` char(1) DEFAULT NULL COMMENT '类型',
  `i_frame` bit(1) DEFAULT NULL COMMENT '是否外链',
  `path` varchar(255) DEFAULT NULL COMMENT '路径',
  `component` varchar(128) DEFAULT NULL COMMENT '组件路径',
  `permission` varchar(128) DEFAULT NULL COMMENT '权限',
  `hidden` bit(1) DEFAULT NULL COMMENT '是否隐藏',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `sort` bigint(20) NOT NULL COMMENT '排序',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(32) DEFAULT NULL COMMENT '创建人',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  `modifier` varchar(32) DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` bit(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `sys_menu`
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES ('1', '系统设置', '0', '0', b'0', 'example', 'Layout', '', b'0', 'example', '1', '2020-04-02 15:37:06', 'admin', '2020-03-20 18:13:12', 'admin', null, b'0'), ('2', '用户管理', '1', '1', b'0', '/user', 'sys/user', '', b'0', 'user', '1', '2020-03-16 15:38:27', 'admin', '2020-03-16 15:38:32', 'admin', null, b'0'), ('3', '新增', '2', '2', b'0', null, null, 'user:add', b'0', null, '2', '2020-03-16 15:41:23', 'admin', '2020-03-21 21:29:53', 'admin', null, b'0'), ('4', '编辑', '2', '2', b'0', null, null, 'user:edit', b'0', null, '3', '2020-03-16 15:42:22', 'admin', '2020-03-21 21:32:02', 'admin', null, b'0'), ('5', '删除', '2', '2', b'0', null, null, 'user:delete', b'0', null, '4', '2020-03-16 15:43:05', 'admin', '2020-03-21 21:32:14', 'admin', null, b'0'), ('6', '角色管理', '1', '1', b'0', '/role', 'sys/role', null, b'0', 'tree', '5', '2020-03-16 15:44:21', 'admin', '2020-03-16 15:44:28', 'admin', null, b'0'), ('7', '新增', '6', '2', b'0', null, null, 'role:add', b'0', null, '6', '2020-03-18 15:05:22', 'admin', '2020-03-21 21:32:38', 'admin', null, b'0'), ('8', '编辑', '6', '2', b'0', null, null, 'role:edit', b'0', null, '7', '2020-03-18 15:06:05', 'admin', '2020-03-21 21:32:26', 'admin', null, b'0'), ('9', '删除', '6', '2', b'0', null, null, 'role:delete', b'0', null, '8', '2020-03-18 15:06:46', 'admin', '2020-03-21 21:32:47', 'admin', null, b'0'), ('10', '菜单管理', '1', '1', b'0', '/menu', 'sys/menu', null, b'0', 'table', '10', '2020-03-18 15:07:57', 'admin', '2020-03-18 15:08:04', 'admin', null, b'0'), ('11', '新增', '10', '2', b'0', '', '', 'menu:add', b'0', '', '100', '2020-03-20 13:45:34', 'admin', '2020-03-21 21:32:58', 'admin', null, b'0'), ('12', '编辑', '10', '2', b'0', '', '', 'menu:edit', b'0', '', '110', '2020-03-21 09:35:26', 'admin', '2020-03-21 21:33:09', 'admin', null, b'0'), ('13', '删除', '10', '2', b'0', '', '', 'menu:delete', b'0', '', '120', '2020-03-21 09:36:04', 'admin', '2020-03-21 21:33:18', 'admin', null, b'0'), ('14', '部门管理', '1', '1', b'0', '/dept', 'sys/dept', '', b'0', 'dept', '20', '2020-03-21 09:38:25', 'admin', '2020-03-21 09:38:25', 'admin', null, b'0'), ('15', '新增', '14', '2', b'0', '', '', 'dept:add', b'0', '', '210', '2020-03-21 09:39:01', 'admin', '2020-03-21 09:39:01', 'admin', null, b'0'), ('16', '编辑', '14', '2', b'0', '', '', 'dept:edit', b'0', '', '220', '2020-03-21 09:39:22', 'admin', '2020-03-21 09:39:22', 'admin', null, b'0'), ('17', '删除', '14', '2', b'0', '', '', 'dept:delete', b'0', '', '230', '2020-03-21 09:39:42', 'admin', '2020-03-21 09:39:42', 'admin', null, b'0'), ('18', '字典管理', '1', '1', b'0', '/dict', 'sys/dict', '', b'1', 'dictionary', '300', '2020-03-21 14:49:56', 'admin', '2020-03-22 10:58:11', 'admin', null, b'0'), ('19', '新增', '18', '2', b'0', '', '', 'dict:add', b'0', '', '10', '2020-03-21 14:50:31', 'admin', '2020-03-21 14:50:31', 'admin', null, b'0'), ('20', '编辑', '18', '2', b'0', '', '', 'dict:edit', b'0', '', '10', '2020-03-21 14:50:48', 'admin', '2020-03-21 14:50:48', 'admin', null, b'0'), ('21', '删除', '18', '2', b'0', '', '', 'dict:delete', b'0', '', '10', '2020-03-21 14:51:03', 'admin', '2020-03-21 14:51:03', 'admin', null, b'0'), ('22', '客户端管理', '1', '1', b'0', '/oauth', 'sys/oauth', '', b'0', 'oauthClient', '10', '2020-03-21 15:39:23', 'admin', '2020-03-21 15:39:23', 'admin', null, b'0'), ('23', '系统监控', '0', '0', b'0', 'Layout', 'Layout', '', b'0', 'sparkler', '10', '2020-03-21 21:37:44', 'admin', '2020-03-21 21:37:44', 'admin', null, b'0'), ('24', '接口文档', '23', '1', b'1', 'http://106.13.179.172:8002/swagger-ui.html', null, '', b'0', '', '10', '2020-03-21 21:39:27', 'admin', '2020-03-21 21:39:27', 'admin', null, b'0'), ('25', '注册中心', '23', '1', b'1', 'http://106.13.179.172:8761/', null, '', b'0', '', '10', '2020-03-21 21:58:22', 'admin', '2020-03-21 21:58:22', 'admin', null, b'0'), ('26', 'Admin监控', '23', '1', b'1', 'http://106.13.179.172:8980/wallboard', null, '', b'0', '', '10', '2020-03-22 14:12:05', 'admin', '2020-03-22 14:42:04', 'admin', null, b'0');
COMMIT;

-- ----------------------------
--  Table structure for `sys_oauth_client_details`
-- ----------------------------
DROP TABLE IF EXISTS `sys_oauth_client_details`;
CREATE TABLE `sys_oauth_client_details` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `client_id` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  `resource_ids` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `client_secret` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `scope` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `authorized_grant_types` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `authorities` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `autoapprove` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Records of `sys_oauth_client_details`
-- ----------------------------
BEGIN;
INSERT INTO `sys_oauth_client_details` VALUES ('1', 'spark-admin', null, 'spark-admin-secret', 'all,read,write', 'password,refresh_token,authorization_code,client_credentials', null, null, '21600', '28800', 'true');
COMMIT;

-- ----------------------------
--  Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(30) DEFAULT NULL COMMENT '角色编号',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门id',
  `dept_name` varchar(64) DEFAULT NULL COMMENT '部门简称',
  `status` int(1) DEFAULT NULL COMMENT '状态 0无效 1有效',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `creator` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '创建人',
  `modify_date` datetime NOT NULL COMMENT '修改时间',
  `modifier` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '修改人',
  `remarks` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `del_flag` int(1) NOT NULL COMMENT '是否删除 (0 是  1否)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `sys_role`
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES ('1', '超级管理员', 'admin', '超级管理员', '7', '研发部', null, '2020-03-19 22:54:10', 'admin', '2020-03-22 10:57:32', 'admin', null, '0'), ('2', '系统管理员', 'system', '我是', '7', '研发部', null, '2020-03-19 22:55:31', 'admin', '2020-03-22 14:01:50', 'admin', null, '0'), ('3', '测试角色', 'role_test', '', '2', null, null, '2020-03-19 22:56:06', 'admin', '2020-03-19 22:56:06', 'admin', null, '1'), ('4', '测试角色1', 'role_test1', '', '2', null, null, '2020-03-19 23:01:32', 'admin', '2020-03-19 23:01:32', 'admin', null, '1');
COMMIT;

-- ----------------------------
--  Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(11) DEFAULT NULL COMMENT '角色id',
  `menu_id` bigint(11) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=170 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `sys_role_menu`
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_menu` VALUES ('74', '2', '1'), ('75', '2', '2'), ('76', '2', '3'), ('77', '2', '4'), ('78', '2', '5'), ('79', '2', '6'), ('80', '2', '7'), ('81', '2', '10'), ('144', '1', '1'), ('145', '1', '2'), ('146', '1', '3'), ('147', '1', '4'), ('148', '1', '5'), ('149', '1', '6'), ('150', '1', '7'), ('151', '1', '8'), ('152', '1', '9'), ('153', '1', '10'), ('154', '1', '11'), ('155', '1', '12'), ('156', '1', '13'), ('157', '1', '14'), ('158', '1', '15'), ('159', '1', '16'), ('160', '1', '17'), ('161', '1', '18'), ('162', '1', '19'), ('163', '1', '20'), ('164', '1', '21'), ('165', '1', '22'), ('166', '1', '23'), ('167', '1', '24'), ('168', '1', '25'), ('169', '1', '26');
COMMIT;

-- ----------------------------
--  Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `phone` varchar(13) DEFAULT NULL COMMENT '手机号',
  `email` varchar(60) DEFAULT NULL COMMENT '邮箱',
  `last_login_ip` varchar(60) DEFAULT NULL COMMENT '最后登录IP',
  `last_login_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后登陆时间',
  `avatar` varchar(100) DEFAULT NULL COMMENT '头像',
  `dept_id` bigint(11) DEFAULT NULL COMMENT '部门id 一个用户只有 一个部门',
  `dept_name` varchar(64) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '状态 0无效 1有效',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `creator` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '创建人',
  `modify_date` datetime NOT NULL COMMENT '修改时间',
  `modifier` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '修改人',
  `remarks` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `del_flag` int(1) NOT NULL COMMENT '是否删除 (0 是  1否)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `sys_user`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('1', 'admin', '超级管理员', '$2a$10$ts07XkBaX7OwC5xA449gh.MO1Sa3KfyJlcx./lZKkMEgP8XDSoR9e', '1', '123456789', '1234@qq.com', '115.205.167.113', '2020-03-22 14:41:21', 'https://avatar.csdnimg.cn/4/4/0/3_wangdingfeng5141_1583506277.jpg', '7', '研发部', '1', '2020-03-19 14:35:18', 'admin', '2020-03-22 14:41:21', 'system', null, '0'), ('7', 'system', '小王', '$2a$10$oFol0M7BlopTxvVYMos35uLwnF2g2YobjderyjY2srSmefuBoSXKG', '0', '123456789', '123@qq.com', 'string', '2020-03-19 17:09:50', null, '0', null, '1', '2020-03-19 17:09:31', 'admin', '2020-03-19 17:09:31', 'admin', null, '1'), ('8', 'test', '测试用户', '$2a$10$dmBV0Cy0dh2bDzkCclF5yerWRRPHawU5O.MEYll9.r0IUlwZKUA7q', '0', '12345677', '123@qq.com', null, '2020-03-22 13:22:08', null, '6', '测试部', '1', '2020-03-19 20:22:18', 'admin', '2020-03-22 14:01:33', 'admin', '123', '0'), ('9', 'test1', '测试用户1', '$2a$10$NsOBCqf3LOXiQxGWs/QkteofPQTfd2qBuAfG31Y6IJx5bsObLY4am', '0', '1231231231', '123@qq.com', null, '2020-03-19 22:34:34', null, null, null, '1', '2020-03-19 20:24:03', 'admin', '2020-03-19 20:24:03', 'admin', null, '1'), ('10', 'spark', '火花', '$2a$10$a6TPwO6wnXbouCwfowwb/.MqnfKgs3bxW3EwH7SUiUHeF4PfJYK7e', '1', '123123', '123@qq.com', null, '2020-03-21 13:05:52', null, '3', '研发一部', '1', '2020-03-19 20:31:04', 'admin', '2020-03-21 13:05:53', 'admin', null, '0'), ('11', 'test2', '测试用户3', '$2a$10$kXbLvWcO3i155u7pTbjR4uCabdytnKNKUMB4ozaLCu5htDzVVKH4u', '1', '1231232199', '123@qq.com', null, '2020-03-19 21:01:38', null, '8', '测试一部', '1', '2020-03-19 20:47:09', 'admin', '2020-03-21 21:00:55', 'admin', '我是一个备注', '0'), ('12', 'wangdingfeng', '小王', '$2a$10$RtbN3jyBh5Zvd0H99PkYwuH6zmsMfN37bEZkyow78Dh/KTn0C4Ev.', '1', '1999999999', '12312312@qq.com', null, '2020-03-21 19:57:35', null, '2', '技术部', '1', '2020-03-21 19:56:30', 'admin', '2020-03-21 19:57:35', 'admin', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(11) DEFAULT NULL COMMENT '角色id',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `sys_user_role`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES ('4', '1', null), ('5', '2', '12'), ('6', '1', '1'), ('7', '2', '8');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
