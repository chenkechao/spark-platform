/*
 Navicat Premium Data Transfer

 Source Server         :
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           :
 Source Schema         : spark

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 31/03/2020 16:29:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_api_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_api_log`;
CREATE TABLE `sys_api_log`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'url',
  `method` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '方法名',
  `params` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '参数',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '访问时间',
  `times` int(11) NULL DEFAULT NULL COMMENT '耗时',
  `creator` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '访问用户',
  `ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '访问ip',
  `address` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `status` int(3) NULL DEFAULT NULL COMMENT '状态',
  `error_log` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '错误日志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1244443881846009858 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `pid` bigint(11) NULL DEFAULT NULL COMMENT '父部门id',
  `pids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父级ids',
  `simple_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '简称',
  `full_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '全称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `dept_type` int(11) NULL DEFAULT NULL COMMENT '部门类型(0 公司1部门)',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `modifier` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` bit(1) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, 0, NULL, 'spark', 'spark开源公司', NULL, 0, 10, '2020-03-21 10:07:50', 'admin', '2020-03-21 10:07:50', 'admin', NULL, b'0');
INSERT INTO `sys_dept` VALUES (2, 1, NULL, '技术部', '信息技术部', NULL, 1, 10, '2020-03-21 10:11:50', 'admin', '2020-03-21 10:11:50', 'admin', NULL, b'0');
INSERT INTO `sys_dept` VALUES (3, 7, NULL, '研发一部', '研发一部门', NULL, 1, 10, '2020-03-21 10:12:31', 'admin', '2020-03-21 13:04:32', 'admin', NULL, b'0');
INSERT INTO `sys_dept` VALUES (4, 1, NULL, 'A事业部', 'A产品事业部', NULL, 1, 10, '2020-03-21 10:13:17', 'admin', '2020-03-21 10:13:17', 'admin', NULL, b'0');
INSERT INTO `sys_dept` VALUES (5, 4, NULL, 'A产品一部', 'A产品一部', NULL, 1, 10, '2020-03-21 10:13:56', 'admin', '2020-03-21 10:13:56', 'admin', NULL, b'0');
INSERT INTO `sys_dept` VALUES (6, 2, NULL, '测试部', '测试部', NULL, 1, 10, '2020-03-21 13:03:00', 'admin', '2020-03-21 13:03:00', 'admin', NULL, b'0');
INSERT INTO `sys_dept` VALUES (7, 2, NULL, '研发部', '研发部', NULL, 0, 10, '2020-03-21 13:04:01', 'admin', '2020-03-21 13:04:01', 'admin', NULL, b'0');
INSERT INTO `sys_dept` VALUES (8, 6, NULL, '测试一部', '测试一部门', NULL, 0, 10, '2020-03-21 13:05:09', 'admin', '2020-03-21 13:05:09', 'admin', NULL, b'0');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典名称',
  `type` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '字典类型',
  `description` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `modifier` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` bit(1) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (1, '用户状态', 'user_status', '用户状态', '2020-03-26 11:36:58', 'admin', '2020-03-26 11:36:58', 'admin', NULL, b'0');

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pid` int(10) NULL DEFAULT NULL COMMENT '父id',
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `label` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签值',
  `value` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典值',
  `sort` int(10) NULL DEFAULT NULL COMMENT '排序',
  `description` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_date` datetime(0) NOT NULL COMMENT '创建时间',
  `creator` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `modify_date` datetime(0) NOT NULL COMMENT '修改时间',
  `modifier` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改人',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` bit(1) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
INSERT INTO `sys_dict_item` VALUES (1, 1, 'user_status', '禁用', '0', 10, '禁用', '2020-03-26 13:32:22', 'admin', '2020-03-26 13:43:45', 'admin', NULL, b'0');
INSERT INTO `sys_dict_item` VALUES (2, 1, 'user_status', '正常', '1', 11, '正常', '2020-03-26 13:41:34', 'admin', '2020-03-26 13:41:34', 'admin', NULL, b'0');
INSERT INTO `sys_dict_item` VALUES (3, 1, 'user_status', '锁定', '2', 12, '锁定', '2020-03-26 13:46:17', 'admin', '2020-03-26 13:46:17', 'admin', NULL, b'0');
INSERT INTO `sys_dict_item` VALUES (4, 1, 'user_status', '过期', '3', 13, '过期', '2020-03-26 13:46:33', 'admin', '2020-03-26 13:46:33', 'admin', NULL, b'0');
INSERT INTO `sys_dict_item` VALUES (5, 1, 'user_status', '测试删除', '5', 16, '测试删除', '2020-03-26 13:46:50', 'admin', '2020-03-26 13:48:33', 'admin', NULL, b'1');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `pid` bigint(20) NOT NULL COMMENT '上级菜单ID',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `i_frame` bit(1) NULL DEFAULT NULL COMMENT '是否外链',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `component` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `permission` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `hidden` bit(1) NULL DEFAULT NULL COMMENT '是否隐藏',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `sort` bigint(20) NOT NULL COMMENT '排序',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `modifier` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` bit(1) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统设置', 0, '0', b'0', 'example', 'Layout', '', b'0', 'example', 1, '2020-04-02 15:37:06', 'admin', '2020-03-20 18:13:12', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (2, '用户管理', 1, '1', b'0', '/user', 'sys/user', '', b'0', 'user', 1, '2020-03-16 15:38:27', 'admin', '2020-03-16 15:38:32', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (3, '新增', 2, '2', b'0', NULL, NULL, 'user:add', b'0', NULL, 2, '2020-03-16 15:41:23', 'admin', '2020-03-21 21:29:53', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (4, '编辑', 2, '2', b'0', NULL, NULL, 'user:edit', b'0', NULL, 3, '2020-03-16 15:42:22', 'admin', '2020-03-21 21:32:02', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (5, '删除', 2, '2', b'0', NULL, NULL, 'user:delete', b'0', NULL, 4, '2020-03-16 15:43:05', 'admin', '2020-03-21 21:32:14', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (6, '角色管理', 1, '1', b'0', '/role', 'sys/role', NULL, b'0', 'tree', 5, '2020-03-16 15:44:21', 'admin', '2020-03-16 15:44:28', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (7, '新增', 6, '2', b'0', NULL, NULL, 'role:add', b'0', NULL, 6, '2020-03-18 15:05:22', 'admin', '2020-03-21 21:32:38', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (8, '编辑', 6, '2', b'0', NULL, NULL, 'role:edit', b'0', NULL, 7, '2020-03-18 15:06:05', 'admin', '2020-03-21 21:32:26', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (9, '删除', 6, '2', b'0', NULL, NULL, 'role:delete', b'0', NULL, 8, '2020-03-18 15:06:46', 'admin', '2020-03-21 21:32:47', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (10, '菜单管理', 1, '1', b'0', '/menu', 'sys/menu', NULL, b'0', 'table', 10, '2020-03-18 15:07:57', 'admin', '2020-03-18 15:08:04', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (11, '新增', 10, '2', b'0', '', '', 'menu:add', b'0', '', 100, '2020-03-20 13:45:34', 'admin', '2020-03-21 21:32:58', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (12, '编辑', 10, '2', b'0', '', '', 'menu:edit', b'0', '', 110, '2020-03-21 09:35:26', 'admin', '2020-03-21 21:33:09', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (13, '删除', 10, '2', b'0', '', '', 'menu:delete', b'0', '', 120, '2020-03-21 09:36:04', 'admin', '2020-03-21 21:33:18', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (14, '部门管理', 1, '1', b'0', '/dept', 'sys/dept', '', b'0', 'dept', 20, '2020-03-21 09:38:25', 'admin', '2020-03-21 09:38:25', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (15, '新增', 14, '2', b'0', '', '', 'dept:add', b'0', '', 210, '2020-03-21 09:39:01', 'admin', '2020-03-21 09:39:01', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (16, '编辑', 14, '2', b'0', '', '', 'dept:edit', b'0', '', 220, '2020-03-21 09:39:22', 'admin', '2020-03-21 09:39:22', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (17, '删除', 14, '2', b'0', '', '', 'dept:delete', b'0', '', 230, '2020-03-21 09:39:42', 'admin', '2020-03-21 09:39:42', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (18, '字典管理', 1, '1', b'0', '/dict', 'sys/dict', '', b'0', 'dictionary', 300, '2020-03-21 14:49:56', 'admin', '2020-03-26 11:23:17', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (19, '新增', 18, '2', b'0', '', '', 'dict:add', b'0', '', 10, '2020-03-21 14:50:31', 'admin', '2020-03-21 14:50:31', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (20, '编辑', 18, '2', b'0', '', '', 'dict:edit', b'0', '', 10, '2020-03-21 14:50:48', 'admin', '2020-03-21 14:50:48', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (21, '删除', 18, '2', b'0', '', '', 'dict:delete', b'0', '', 10, '2020-03-21 14:51:03', 'admin', '2020-03-21 14:51:03', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (22, '客户端管理', 1, '1', b'0', '/oauth', 'sys/oauth', '', b'0', 'oauthClient', 400, '2020-03-21 15:39:23', 'admin', '2020-03-25 11:26:18', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (23, '系统监控', 0, '0', b'0', 'Layout', 'Layout', '', b'0', 'sparkler', 10, '2020-03-21 21:37:44', 'admin', '2020-03-21 21:37:44', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (24, '接口文档', 23, '1', b'1', 'http://106.13.179.172:8002/swagger-ui.html', NULL, '', b'0', '', 10, '2020-03-21 21:39:27', 'admin', '2020-03-21 21:39:27', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (25, '注册中心', 23, '1', b'1', 'http://106.13.179.172:8761/', NULL, '', b'0', '', 10, '2020-03-21 21:58:22', 'admin', '2020-03-21 21:58:22', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (26, 'Admin监控', 23, '1', b'1', 'http://106.13.179.172:8980/wallboard', NULL, '', b'0', '', 10, '2020-03-22 14:12:05', 'admin', '2020-03-22 14:42:04', 'admin', NULL, b'0');
INSERT INTO `sys_menu` VALUES (27, '系统日志', 23, '1', b'0', '/log', 'sys/log', '', b'0', '', 5, '2020-03-25 10:02:45', 'admin', '2020-03-25 10:28:02', 'admin', NULL, b'0');

-- ----------------------------
-- Table structure for sys_oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `sys_oauth_client_details`;
CREATE TABLE `sys_oauth_client_details`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `client_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `resource_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `client_secret` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `scope` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authorized_grant_types` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authorities` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `access_token_validity` int(11) NULL DEFAULT NULL,
  `refresh_token_validity` int(11) NULL DEFAULT NULL,
  `autoapprove` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oauth_client_details
-- ----------------------------
INSERT INTO `sys_oauth_client_details` VALUES (1, 'spark-admin', NULL, 'spark-admin-secret', 'all,read,write', 'password,refresh_token,authorization_code,client_credentials', NULL, NULL, 21600, 28800, 'true');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色编号',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门id',
  `dept_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门简称',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态 0无效 1有效',
  `create_date` datetime(0) NOT NULL COMMENT '创建时间',
  `creator` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `modify_date` datetime(0) NOT NULL COMMENT '修改时间',
  `modifier` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改人',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` int(1) NOT NULL COMMENT '是否删除 (0 是  1否)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'admin', '超级管理员', 7, '研发部', NULL, '2020-03-19 22:54:10', 'admin', '2020-03-22 10:57:32', 'admin', NULL, 0);
INSERT INTO `sys_role` VALUES (2, '系统管理员', 'system', '我是', 7, '研发部', NULL, '2020-03-19 22:55:31', 'admin', '2020-03-22 14:01:50', 'admin', NULL, 0);
INSERT INTO `sys_role` VALUES (3, '测试角色', 'role_test', '', 2, NULL, NULL, '2020-03-19 22:56:06', 'admin', '2020-03-19 22:56:06', 'admin', NULL, 1);
INSERT INTO `sys_role` VALUES (4, '测试角色1', 'role_test1', '', 2, NULL, NULL, '2020-03-19 23:01:32', 'admin', '2020-03-19 23:01:32', 'admin', NULL, 1);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(11) NULL DEFAULT NULL COMMENT '角色id',
  `menu_id` bigint(11) NULL DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 223 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (74, 2, 1);
INSERT INTO `sys_role_menu` VALUES (75, 2, 2);
INSERT INTO `sys_role_menu` VALUES (76, 2, 3);
INSERT INTO `sys_role_menu` VALUES (77, 2, 4);
INSERT INTO `sys_role_menu` VALUES (78, 2, 5);
INSERT INTO `sys_role_menu` VALUES (79, 2, 6);
INSERT INTO `sys_role_menu` VALUES (80, 2, 7);
INSERT INTO `sys_role_menu` VALUES (81, 2, 10);
INSERT INTO `sys_role_menu` VALUES (197, 1, 1);
INSERT INTO `sys_role_menu` VALUES (198, 1, 2);
INSERT INTO `sys_role_menu` VALUES (199, 1, 3);
INSERT INTO `sys_role_menu` VALUES (200, 1, 4);
INSERT INTO `sys_role_menu` VALUES (201, 1, 5);
INSERT INTO `sys_role_menu` VALUES (202, 1, 6);
INSERT INTO `sys_role_menu` VALUES (203, 1, 7);
INSERT INTO `sys_role_menu` VALUES (204, 1, 8);
INSERT INTO `sys_role_menu` VALUES (205, 1, 9);
INSERT INTO `sys_role_menu` VALUES (206, 1, 10);
INSERT INTO `sys_role_menu` VALUES (207, 1, 11);
INSERT INTO `sys_role_menu` VALUES (208, 1, 12);
INSERT INTO `sys_role_menu` VALUES (209, 1, 13);
INSERT INTO `sys_role_menu` VALUES (210, 1, 14);
INSERT INTO `sys_role_menu` VALUES (211, 1, 15);
INSERT INTO `sys_role_menu` VALUES (212, 1, 16);
INSERT INTO `sys_role_menu` VALUES (213, 1, 17);
INSERT INTO `sys_role_menu` VALUES (214, 1, 18);
INSERT INTO `sys_role_menu` VALUES (215, 1, 19);
INSERT INTO `sys_role_menu` VALUES (216, 1, 20);
INSERT INTO `sys_role_menu` VALUES (217, 1, 22);
INSERT INTO `sys_role_menu` VALUES (218, 1, 23);
INSERT INTO `sys_role_menu` VALUES (219, 1, 24);
INSERT INTO `sys_role_menu` VALUES (220, 1, 25);
INSERT INTO `sys_role_menu` VALUES (221, 1, 26);
INSERT INTO `sys_role_menu` VALUES (222, 1, 27);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `last_login_ip` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最后登录IP',
  `last_login_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后登陆时间',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `dept_id` bigint(11) NULL DEFAULT NULL COMMENT '部门id 一个用户只有 一个部门',
  `dept_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '状态 0无效 1有效',
  `create_date` datetime(0) NOT NULL COMMENT '创建时间',
  `creator` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `modify_date` datetime(0) NOT NULL COMMENT '修改时间',
  `modifier` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改人',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` int(1) NOT NULL COMMENT '是否删除 (0 是  1否)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '超级管理员', '$2a$10$ts07XkBaX7OwC5xA449gh.MO1Sa3KfyJlcx./lZKkMEgP8XDSoR9e', 1, '123456789', '1234@qq.com', '122.224.152.194', '2020-03-30 09:57:50', 'https://portrait.gitee.com/uploads/avatars/user/630/1890906_dreamfeng_1584866008.png', 7, '研发部', 1, '2020-03-19 14:35:18', 'admin', '2020-03-30 09:57:50', 'system', '我是一个备注1', 0);
INSERT INTO `sys_user` VALUES (7, 'system', '小王', '$2a$10$oFol0M7BlopTxvVYMos35uLwnF2g2YobjderyjY2srSmefuBoSXKG', 0, '123456789', '123@qq.com', 'string', '2020-03-19 17:09:50', NULL, 0, NULL, 1, '2020-03-19 17:09:31', 'admin', '2020-03-19 17:09:31', 'admin', NULL, 1);
INSERT INTO `sys_user` VALUES (8, 'test', '测试用户', '$2a$10$dmBV0Cy0dh2bDzkCclF5yerWRRPHawU5O.MEYll9.r0IUlwZKUA7q', 0, '12345677', '123@qq.com', '122.224.152.194', '2020-03-26 09:40:02', NULL, 6, '测试部', 1, '2020-03-19 20:22:18', 'admin', '2020-03-26 09:40:02', 'system', '123', 0);
INSERT INTO `sys_user` VALUES (9, 'test1', '测试用户1', '$2a$10$NsOBCqf3LOXiQxGWs/QkteofPQTfd2qBuAfG31Y6IJx5bsObLY4am', 0, '1231231231', '123@qq.com', NULL, '2020-03-19 22:34:34', NULL, NULL, NULL, 1, '2020-03-19 20:24:03', 'admin', '2020-03-19 20:24:03', 'admin', NULL, 1);
INSERT INTO `sys_user` VALUES (10, 'spark', '火花', '$2a$10$a6TPwO6wnXbouCwfowwb/.MqnfKgs3bxW3EwH7SUiUHeF4PfJYK7e', 1, '123123', '123@qq.com', '0:0:0:0:0:0:0:1', '2020-03-23 22:24:03', NULL, 3, '研发一部', 1, '2020-03-19 20:31:04', 'admin', '2020-03-23 22:24:03', 'system', NULL, 0);
INSERT INTO `sys_user` VALUES (11, 'test2', '测试用户3', '$2a$10$kXbLvWcO3i155u7pTbjR4uCabdytnKNKUMB4ozaLCu5htDzVVKH4u', 1, '1231232199', '123@qq.com', NULL, '2020-03-19 21:01:38', NULL, 8, '测试一部', 1, '2020-03-19 20:47:09', 'admin', '2020-03-21 21:00:55', 'admin', '我是一个备注', 0);
INSERT INTO `sys_user` VALUES (12, 'wangdingfeng', '小王', '$2a$10$RtbN3jyBh5Zvd0H99PkYwuH6zmsMfN37bEZkyow78Dh/KTn0C4Ev.', 1, '1999999999', '12312312@qq.com', NULL, '2020-03-21 19:57:35', NULL, 2, '技术部', 1, '2020-03-21 19:56:30', 'admin', '2020-03-21 19:57:35', 'admin', NULL, 0);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(11) NULL DEFAULT NULL COMMENT '角色id',
  `user_id` bigint(11) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (5, 2, 12);
INSERT INTO `sys_user_role` VALUES (7, 2, 8);
INSERT INTO `sys_user_role` VALUES (9, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
