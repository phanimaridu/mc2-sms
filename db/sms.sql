/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : sms

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2015-03-31 18:46:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `user_name` varchar(255) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `sex` varchar(10) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `e_mail` varchar(255) DEFAULT NULL,
  `future_use` text,
  PRIMARY KEY (`user_name`),
  CONSTRAINT `person_user_name` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('phanimaridu', 'Venkata', 'Maridu', 'M', '001 216-820-3556', '1700 E,13 ST,APT 5R', 'phani.vjec@gmail.com', '');
INSERT INTO `person` VALUES ('sunnymaridu', 'Sunny', 'Maridu', 'M', null, null, null, null);
INSERT INTO `person` VALUES ('tejamaridu', 'Teja', 'Maridu', 'M', null, null, null, null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `role` VALUES ('2', 'ROLE_STAFF');
INSERT INTO `role` VALUES ('3', 'ROLE_STUDENT');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_name` varchar(255) NOT NULL,
  `password` varchar(500) NOT NULL COMMENT 'md5',
  `active` tinyint(1) NOT NULL,
  `created_ts` datetime DEFAULT NULL,
  `modified_ts` datetime DEFAULT NULL,
  `last_access_ts` datetime DEFAULT NULL,
  `credentials_expire_ts` datetime DEFAULT NULL,
  `account_expire_ts` datetime DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('phanimaridu', '1a1dc91c907325c69271ddf0c944bc72', '1', '2015-02-13 21:27:00', '2015-02-13 21:27:03', '2015-02-13 21:27:06', null, null);
INSERT INTO `user` VALUES ('sunnymaridu', '5f4dcc3b5aa765d61d8327deb882cf99', '1', '2015-03-21 01:38:50', '2015-03-21 01:38:53', '2015-03-21 01:38:55', null, null);
INSERT INTO `user` VALUES ('tejamaridu', '5f4dcc3b5aa765d61d8327deb882cf99', '1', '2015-03-21 01:36:54', '2015-03-21 01:36:57', '2015-03-21 01:36:59', null, null);

-- ----------------------------
-- Table structure for user_in_role
-- ----------------------------
DROP TABLE IF EXISTS `user_in_role`;
CREATE TABLE `user_in_role` (
  `user_name` varchar(255) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `users_in_roles_user_name` (`user_name`),
  KEY `users_in_roles_role_id` (`role_id`),
  CONSTRAINT `users_in_roles_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `users_in_roles_user_name` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_in_role
-- ----------------------------
INSERT INTO `user_in_role` VALUES ('phanimaridu', '1');
INSERT INTO `user_in_role` VALUES ('tejamaridu', '2');
INSERT INTO `user_in_role` VALUES ('phanimaridu', '2');
INSERT INTO `user_in_role` VALUES ('phanimaridu', '3');
INSERT INTO `user_in_role` VALUES ('sunnymaridu', '3');
INSERT INTO `user_in_role` VALUES ('tejamaridu', '3');
