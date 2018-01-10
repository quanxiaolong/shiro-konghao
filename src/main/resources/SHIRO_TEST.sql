/*
 Navicat Premium Data Transfer

 Source Server         : private
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost
 Source Database       : SHIRO_TEST

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : utf-8

 Date: 01/10/2018 15:09:20 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `SYS_PERMISSIONS`
-- ----------------------------
DROP TABLE IF EXISTS `SYS_PERMISSIONS`;
CREATE TABLE `SYS_PERMISSIONS` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PERMISSION` varchar(100) DEFAULT NULL,
  `URL` varchar(100) DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `AVAILABLE` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `IDX_SYS_PERMISSIONS_PERMISSION` (`PERMISSION`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `SYS_PERMISSIONS`
-- ----------------------------
BEGIN;
INSERT INTO `SYS_PERMISSIONS` VALUES ('1', 'USER:CREATE', '/USER/CREATE', '用户模块新增', '1'), ('2', 'USER:UPDATE', '/USER/UPDATE', '用户模块修改', '1'), ('3', 'MENU:*', '/MENU/*', '菜单模块新增', '1'), ('4', 'ADMIN:*', '/admin/**', '管理员', '1'), ('5', 'USER:*', '/user/**', '用户模块', '1');
COMMIT;

-- ----------------------------
--  Table structure for `SYS_ROLES`
-- ----------------------------
DROP TABLE IF EXISTS `SYS_ROLES`;
CREATE TABLE `SYS_ROLES` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE` varchar(100) DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `AVAILABLE` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `IDX_SYS_ROLES_ROLE` (`ROLE`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `SYS_ROLES`
-- ----------------------------
BEGIN;
INSERT INTO `SYS_ROLES` VALUES ('1', 'ADMIN', '管理员', '1'), ('2', 'USER', '用户管理员', '1'), ('3', 'NORMAL', '游客', '1');
COMMIT;

-- ----------------------------
--  Table structure for `SYS_ROLES_PERMISSIONS`
-- ----------------------------
DROP TABLE IF EXISTS `SYS_ROLES_PERMISSIONS`;
CREATE TABLE `SYS_ROLES_PERMISSIONS` (
  `ROLE_ID` bigint(20) NOT NULL DEFAULT '0',
  `PERMISSION_ID` bigint(20) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `SYS_ROLES_PERMISSIONS`
-- ----------------------------
BEGIN;
INSERT INTO `SYS_ROLES_PERMISSIONS` VALUES ('1', '1'), ('1', '2'), ('2', '1'), ('1', '4'), ('1', '5');
COMMIT;

-- ----------------------------
--  Table structure for `SYS_USERS`
-- ----------------------------
DROP TABLE IF EXISTS `SYS_USERS`;
CREATE TABLE `SYS_USERS` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(100) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `SALT` varchar(100) DEFAULT NULL,
  `LOCKED` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `IDX_SYS_USERS_USERNAME` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `SYS_USERS`
-- ----------------------------
BEGIN;
INSERT INTO `SYS_USERS` VALUES ('1', 'kh', '827c441987e31d19095918a4e71cf895', null, '0'), ('2', 'zs', 'cdc6d1963928d5c349a4eebf11c8b4a5', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `SYS_USERS_ROLES`
-- ----------------------------
DROP TABLE IF EXISTS `SYS_USERS_ROLES`;
CREATE TABLE `SYS_USERS_ROLES` (
  `USER_ID` bigint(20) NOT NULL DEFAULT '0',
  `ROLE_ID` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`USER_ID`,`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `SYS_USERS_ROLES`
-- ----------------------------
BEGIN;
INSERT INTO `SYS_USERS_ROLES` VALUES ('1', '1'), ('1', '2');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
