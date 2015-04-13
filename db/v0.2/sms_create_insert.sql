/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : sms

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2015-04-13 18:37:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_course_enrollment_id` int(11) DEFAULT NULL,
  `taken_dtt` datetime DEFAULT NULL,
  `taken_by` varchar(50) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL COMMENT '1=PRESENT,2=ABSENT, 3=ON_LEAVE, 4=SICK, 5=OTHERS',
  PRIMARY KEY (`id`),
  KEY `student_course_enrollment_id_fk` (`student_course_enrollment_id`),
  KEY `staff_id_fk3` (`taken_by`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`taken_by`) REFERENCES `staff` (`user_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`student_course_enrollment_id`) REFERENCES `student_course_enrollment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=878 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES ('1', '1', '2015-04-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('2', '4', '2015-04-13 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('3', '7', '2015-04-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('4', '10', '2015-04-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('5', '13', '2015-04-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('6', '16', '2015-04-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('7', '19', '2015-04-13 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('8', '22', '2015-04-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('9', '25', '2015-04-13 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('10', '28', '2015-04-13 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('11', '31', '2015-04-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('12', '34', '2015-04-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('13', '37', '2015-04-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('14', '40', '2015-04-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('15', '43', '2015-04-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('16', '46', '2015-04-13 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('17', '49', '2015-04-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('18', '52', '2015-04-13 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('19', '55', '2015-04-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('20', '1', '2015-04-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('21', '4', '2015-04-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('22', '7', '2015-04-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('23', '10', '2015-04-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('24', '13', '2015-04-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('25', '16', '2015-04-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('26', '19', '2015-04-14 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('27', '22', '2015-04-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('28', '25', '2015-04-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('29', '28', '2015-04-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('30', '31', '2015-04-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('31', '34', '2015-04-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('32', '37', '2015-04-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('33', '40', '2015-04-14 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('34', '43', '2015-04-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('35', '46', '2015-04-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('36', '49', '2015-04-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('37', '52', '2015-04-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('38', '55', '2015-04-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('39', '1', '2015-04-15 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('40', '4', '2015-04-15 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('41', '7', '2015-04-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('42', '10', '2015-04-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('43', '13', '2015-04-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('44', '16', '2015-04-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('45', '19', '2015-04-15 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('46', '22', '2015-04-15 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('47', '25', '2015-04-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('48', '28', '2015-04-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('49', '31', '2015-04-15 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('50', '34', '2015-04-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('51', '37', '2015-04-15 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('52', '40', '2015-04-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('53', '43', '2015-04-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('54', '46', '2015-04-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('55', '49', '2015-04-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('56', '52', '2015-04-15 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('57', '55', '2015-04-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('58', '1', '2015-04-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('59', '4', '2015-04-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('60', '7', '2015-04-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('61', '10', '2015-04-16 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('62', '13', '2015-04-16 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('63', '16', '2015-04-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('64', '19', '2015-04-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('65', '22', '2015-04-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('66', '25', '2015-04-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('67', '28', '2015-04-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('68', '31', '2015-04-16 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('69', '34', '2015-04-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('70', '37', '2015-04-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('71', '40', '2015-04-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('72', '43', '2015-04-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('73', '46', '2015-04-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('74', '49', '2015-04-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('75', '52', '2015-04-16 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('76', '55', '2015-04-16 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('77', '1', '2015-04-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('78', '4', '2015-04-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('79', '7', '2015-04-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('80', '10', '2015-04-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('81', '13', '2015-04-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('82', '16', '2015-04-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('83', '19', '2015-04-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('84', '22', '2015-04-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('85', '25', '2015-04-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('86', '28', '2015-04-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('87', '31', '2015-04-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('88', '34', '2015-04-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('89', '37', '2015-04-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('90', '40', '2015-04-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('91', '43', '2015-04-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('92', '46', '2015-04-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('93', '49', '2015-04-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('94', '52', '2015-04-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('95', '55', '2015-04-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('96', '1', '2015-04-18 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('97', '4', '2015-04-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('98', '7', '2015-04-18 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('99', '10', '2015-04-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('100', '13', '2015-04-18 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('101', '16', '2015-04-18 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('102', '19', '2015-04-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('103', '22', '2015-04-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('104', '25', '2015-04-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('105', '28', '2015-04-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('106', '31', '2015-04-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('107', '34', '2015-04-18 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('108', '37', '2015-04-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('109', '40', '2015-04-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('110', '43', '2015-04-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('111', '46', '2015-04-18 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('112', '49', '2015-04-18 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('113', '52', '2015-04-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('114', '55', '2015-04-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('115', '1', '2015-04-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('116', '4', '2015-04-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('117', '7', '2015-04-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('118', '10', '2015-04-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('119', '13', '2015-04-19 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('120', '16', '2015-04-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('121', '19', '2015-04-19 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('122', '22', '2015-04-19 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('123', '25', '2015-04-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('124', '28', '2015-04-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('125', '31', '2015-04-19 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('126', '34', '2015-04-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('127', '37', '2015-04-19 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('128', '40', '2015-04-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('129', '43', '2015-04-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('130', '46', '2015-04-19 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('131', '49', '2015-04-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('132', '52', '2015-04-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('133', '55', '2015-04-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('134', '1', '2015-04-20 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('135', '4', '2015-04-20 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('136', '7', '2015-04-20 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('137', '10', '2015-04-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('138', '13', '2015-04-20 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('139', '16', '2015-04-20 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('140', '19', '2015-04-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('141', '22', '2015-04-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('142', '25', '2015-04-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('143', '28', '2015-04-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('144', '31', '2015-04-20 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('145', '34', '2015-04-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('146', '37', '2015-04-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('147', '40', '2015-04-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('148', '43', '2015-04-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('149', '46', '2015-04-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('150', '49', '2015-04-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('151', '52', '2015-04-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('152', '55', '2015-04-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('153', '1', '2015-04-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('154', '4', '2015-04-21 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('155', '7', '2015-04-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('156', '10', '2015-04-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('157', '13', '2015-04-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('158', '16', '2015-04-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('159', '19', '2015-04-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('160', '22', '2015-04-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('161', '25', '2015-04-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('162', '28', '2015-04-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('163', '31', '2015-04-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('164', '34', '2015-04-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('165', '37', '2015-04-21 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('166', '40', '2015-04-21 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('167', '43', '2015-04-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('168', '46', '2015-04-21 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('169', '49', '2015-04-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('170', '52', '2015-04-21 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('171', '55', '2015-04-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('172', '1', '2015-04-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('173', '4', '2015-04-22 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('174', '7', '2015-04-22 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('175', '10', '2015-04-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('176', '13', '2015-04-22 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('177', '16', '2015-04-22 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('178', '19', '2015-04-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('179', '22', '2015-04-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('180', '25', '2015-04-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('181', '28', '2015-04-22 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('182', '31', '2015-04-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('183', '34', '2015-04-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('184', '37', '2015-04-22 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('185', '40', '2015-04-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('186', '43', '2015-04-22 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('187', '46', '2015-04-22 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('188', '49', '2015-04-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('189', '52', '2015-04-22 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('190', '55', '2015-04-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('191', '1', '2015-04-23 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('192', '4', '2015-04-23 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('193', '7', '2015-04-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('194', '10', '2015-04-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('195', '13', '2015-04-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('196', '16', '2015-04-23 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('197', '19', '2015-04-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('198', '22', '2015-04-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('199', '25', '2015-04-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('200', '28', '2015-04-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('201', '31', '2015-04-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('202', '34', '2015-04-23 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('203', '37', '2015-04-23 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('204', '40', '2015-04-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('205', '43', '2015-04-23 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('206', '46', '2015-04-23 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('207', '49', '2015-04-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('208', '52', '2015-04-23 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('209', '55', '2015-04-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('210', '1', '2015-04-24 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('211', '4', '2015-04-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('212', '7', '2015-04-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('213', '10', '2015-04-24 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('214', '13', '2015-04-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('215', '16', '2015-04-24 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('216', '19', '2015-04-24 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('217', '22', '2015-04-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('218', '25', '2015-04-24 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('219', '28', '2015-04-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('220', '31', '2015-04-24 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('221', '34', '2015-04-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('222', '37', '2015-04-24 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('223', '40', '2015-04-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('224', '43', '2015-04-24 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('225', '46', '2015-04-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('226', '49', '2015-04-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('227', '52', '2015-04-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('228', '55', '2015-04-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('229', '1', '2015-04-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('230', '4', '2015-04-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('231', '7', '2015-04-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('232', '10', '2015-04-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('233', '13', '2015-04-25 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('234', '16', '2015-04-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('235', '19', '2015-04-25 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('236', '22', '2015-04-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('237', '25', '2015-04-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('238', '28', '2015-04-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('239', '31', '2015-04-25 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('240', '34', '2015-04-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('241', '37', '2015-04-25 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('242', '40', '2015-04-25 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('243', '43', '2015-04-25 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('244', '46', '2015-04-25 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('245', '49', '2015-04-25 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('246', '52', '2015-04-25 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('247', '55', '2015-04-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('248', '1', '2015-04-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('249', '4', '2015-04-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('250', '7', '2015-04-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('251', '10', '2015-04-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('252', '13', '2015-04-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('253', '16', '2015-04-26 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('254', '19', '2015-04-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('255', '22', '2015-04-26 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('256', '25', '2015-04-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('257', '28', '2015-04-26 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('258', '31', '2015-04-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('259', '34', '2015-04-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('260', '37', '2015-04-26 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('261', '40', '2015-04-26 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('262', '43', '2015-04-26 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('263', '46', '2015-04-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('264', '49', '2015-04-26 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('265', '52', '2015-04-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('266', '55', '2015-04-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('267', '1', '2015-04-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('268', '4', '2015-04-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('269', '7', '2015-04-27 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('270', '10', '2015-04-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('271', '13', '2015-04-27 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('272', '16', '2015-04-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('273', '19', '2015-04-27 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('274', '22', '2015-04-27 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('275', '25', '2015-04-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('276', '28', '2015-04-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('277', '31', '2015-04-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('278', '34', '2015-04-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('279', '37', '2015-04-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('280', '40', '2015-04-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('281', '43', '2015-04-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('282', '46', '2015-04-27 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('283', '49', '2015-04-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('284', '52', '2015-04-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('285', '55', '2015-04-27 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('286', '1', '2015-04-28 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('287', '4', '2015-04-28 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('288', '7', '2015-04-28 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('289', '10', '2015-04-28 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('290', '13', '2015-04-28 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('291', '16', '2015-04-28 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('292', '19', '2015-04-28 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('293', '22', '2015-04-28 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('294', '25', '2015-04-28 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('295', '28', '2015-04-28 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('296', '31', '2015-04-28 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('297', '34', '2015-04-28 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('298', '37', '2015-04-28 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('299', '40', '2015-04-28 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('300', '43', '2015-04-28 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('301', '46', '2015-04-28 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('302', '49', '2015-04-28 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('303', '52', '2015-04-28 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('304', '55', '2015-04-28 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('305', '1', '2015-04-29 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('306', '4', '2015-04-29 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('307', '7', '2015-04-29 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('308', '10', '2015-04-29 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('309', '13', '2015-04-29 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('310', '16', '2015-04-29 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('311', '19', '2015-04-29 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('312', '22', '2015-04-29 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('313', '25', '2015-04-29 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('314', '28', '2015-04-29 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('315', '31', '2015-04-29 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('316', '34', '2015-04-29 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('317', '37', '2015-04-29 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('318', '40', '2015-04-29 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('319', '43', '2015-04-29 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('320', '46', '2015-04-29 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('321', '49', '2015-04-29 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('322', '52', '2015-04-29 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('323', '55', '2015-04-29 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('324', '1', '2015-04-30 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('325', '4', '2015-04-30 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('326', '7', '2015-04-30 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('327', '10', '2015-04-30 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('328', '13', '2015-04-30 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('329', '16', '2015-04-30 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('330', '19', '2015-04-30 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('331', '22', '2015-04-30 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('332', '25', '2015-04-30 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('333', '28', '2015-04-30 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('334', '31', '2015-04-30 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('335', '34', '2015-04-30 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('336', '37', '2015-04-30 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('337', '40', '2015-04-30 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('338', '43', '2015-04-30 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('339', '46', '2015-04-30 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('340', '49', '2015-04-30 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('341', '52', '2015-04-30 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('342', '55', '2015-04-30 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('343', '1', '2015-05-01 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('344', '4', '2015-05-01 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('345', '7', '2015-05-01 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('346', '10', '2015-05-01 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('347', '13', '2015-05-01 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('348', '16', '2015-05-01 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('349', '19', '2015-05-01 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('350', '22', '2015-05-01 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('351', '25', '2015-05-01 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('352', '28', '2015-05-01 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('353', '31', '2015-05-01 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('354', '34', '2015-05-01 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('355', '37', '2015-05-01 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('356', '40', '2015-05-01 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('357', '43', '2015-05-01 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('358', '46', '2015-05-01 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('359', '49', '2015-05-01 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('360', '52', '2015-05-01 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('361', '55', '2015-05-01 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('362', '1', '2015-05-02 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('363', '4', '2015-05-02 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('364', '7', '2015-05-02 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('365', '10', '2015-05-02 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('366', '13', '2015-05-02 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('367', '16', '2015-05-02 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('368', '19', '2015-05-02 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('369', '22', '2015-05-02 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('370', '25', '2015-05-02 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('371', '28', '2015-05-02 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('372', '31', '2015-05-02 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('373', '34', '2015-05-02 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('374', '37', '2015-05-02 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('375', '40', '2015-05-02 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('376', '43', '2015-05-02 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('377', '46', '2015-05-02 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('378', '49', '2015-05-02 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('379', '52', '2015-05-02 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('380', '55', '2015-05-02 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('381', '1', '2015-05-03 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('382', '4', '2015-05-03 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('383', '7', '2015-05-03 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('384', '10', '2015-05-03 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('385', '13', '2015-05-03 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('386', '16', '2015-05-03 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('387', '19', '2015-05-03 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('388', '22', '2015-05-03 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('389', '25', '2015-05-03 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('390', '28', '2015-05-03 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('391', '31', '2015-05-03 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('392', '34', '2015-05-03 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('393', '37', '2015-05-03 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('394', '40', '2015-05-03 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('395', '43', '2015-05-03 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('396', '46', '2015-05-03 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('397', '49', '2015-05-03 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('398', '52', '2015-05-03 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('399', '55', '2015-05-03 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('400', '1', '2015-05-04 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('401', '4', '2015-05-04 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('402', '7', '2015-05-04 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('403', '10', '2015-05-04 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('404', '13', '2015-05-04 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('405', '16', '2015-05-04 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('406', '19', '2015-05-04 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('407', '22', '2015-05-04 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('408', '25', '2015-05-04 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('409', '28', '2015-05-04 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('410', '31', '2015-05-04 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('411', '34', '2015-05-04 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('412', '37', '2015-05-04 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('413', '40', '2015-05-04 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('414', '43', '2015-05-04 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('415', '46', '2015-05-04 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('416', '49', '2015-05-04 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('417', '52', '2015-05-04 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('418', '55', '2015-05-04 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('419', '1', '2015-05-05 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('420', '4', '2015-05-05 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('421', '7', '2015-05-05 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('422', '10', '2015-05-05 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('423', '13', '2015-05-05 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('424', '16', '2015-05-05 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('425', '19', '2015-05-05 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('426', '22', '2015-05-05 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('427', '25', '2015-05-05 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('428', '28', '2015-05-05 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('429', '31', '2015-05-05 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('430', '34', '2015-05-05 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('431', '37', '2015-05-05 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('432', '40', '2015-05-05 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('433', '43', '2015-05-05 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('434', '46', '2015-05-05 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('435', '49', '2015-05-05 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('436', '52', '2015-05-05 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('437', '55', '2015-05-05 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('438', '1', '2015-05-06 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('439', '4', '2015-05-06 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('440', '7', '2015-05-06 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('441', '10', '2015-05-06 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('442', '13', '2015-05-06 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('443', '16', '2015-05-06 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('444', '19', '2015-05-06 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('445', '22', '2015-05-06 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('446', '25', '2015-05-06 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('447', '28', '2015-05-06 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('448', '31', '2015-05-06 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('449', '34', '2015-05-06 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('450', '37', '2015-05-06 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('451', '40', '2015-05-06 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('452', '43', '2015-05-06 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('453', '46', '2015-05-06 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('454', '49', '2015-05-06 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('455', '52', '2015-05-06 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('456', '55', '2015-05-06 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('457', '1', '2015-05-07 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('458', '4', '2015-05-07 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('459', '7', '2015-05-07 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('460', '10', '2015-05-07 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('461', '13', '2015-05-07 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('462', '16', '2015-05-07 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('463', '19', '2015-05-07 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('464', '22', '2015-05-07 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('465', '25', '2015-05-07 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('466', '28', '2015-05-07 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('467', '31', '2015-05-07 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('468', '34', '2015-05-07 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('469', '37', '2015-05-07 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('470', '40', '2015-05-07 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('471', '43', '2015-05-07 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('472', '46', '2015-05-07 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('473', '49', '2015-05-07 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('474', '52', '2015-05-07 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('475', '55', '2015-05-07 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('476', '1', '2015-05-08 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('477', '4', '2015-05-08 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('478', '7', '2015-05-08 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('479', '10', '2015-05-08 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('480', '13', '2015-05-08 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('481', '16', '2015-05-08 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('482', '19', '2015-05-08 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('483', '22', '2015-05-08 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('484', '25', '2015-05-08 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('485', '28', '2015-05-08 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('486', '31', '2015-05-08 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('487', '34', '2015-05-08 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('488', '37', '2015-05-08 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('489', '40', '2015-05-08 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('490', '43', '2015-05-08 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('491', '46', '2015-05-08 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('492', '49', '2015-05-08 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('493', '52', '2015-05-08 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('494', '55', '2015-05-08 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('495', '1', '2015-05-09 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('496', '4', '2015-05-09 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('497', '7', '2015-05-09 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('498', '10', '2015-05-09 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('499', '13', '2015-05-09 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('500', '16', '2015-05-09 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('501', '19', '2015-05-09 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('502', '22', '2015-05-09 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('503', '25', '2015-05-09 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('504', '28', '2015-05-09 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('505', '31', '2015-05-09 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('506', '34', '2015-05-09 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('507', '37', '2015-05-09 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('508', '40', '2015-05-09 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('509', '43', '2015-05-09 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('510', '46', '2015-05-09 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('511', '49', '2015-05-09 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('512', '52', '2015-05-09 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('513', '55', '2015-05-09 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('514', '1', '2015-05-10 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('515', '4', '2015-05-10 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('516', '7', '2015-05-10 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('517', '10', '2015-05-10 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('518', '13', '2015-05-10 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('519', '16', '2015-05-10 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('520', '19', '2015-05-10 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('521', '22', '2015-05-10 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('522', '25', '2015-05-10 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('523', '28', '2015-05-10 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('524', '31', '2015-05-10 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('525', '34', '2015-05-10 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('526', '37', '2015-05-10 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('527', '40', '2015-05-10 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('528', '43', '2015-05-10 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('529', '46', '2015-05-10 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('530', '49', '2015-05-10 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('531', '52', '2015-05-10 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('532', '55', '2015-05-10 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('533', '1', '2015-05-11 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('534', '4', '2015-05-11 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('535', '7', '2015-05-11 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('536', '10', '2015-05-11 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('537', '13', '2015-05-11 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('538', '16', '2015-05-11 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('539', '19', '2015-05-11 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('540', '22', '2015-05-11 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('541', '25', '2015-05-11 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('542', '28', '2015-05-11 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('543', '31', '2015-05-11 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('544', '34', '2015-05-11 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('545', '37', '2015-05-11 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('546', '40', '2015-05-11 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('547', '43', '2015-05-11 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('548', '46', '2015-05-11 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('549', '49', '2015-05-11 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('550', '52', '2015-05-11 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('551', '55', '2015-05-11 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('552', '1', '2015-05-12 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('553', '4', '2015-05-12 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('554', '7', '2015-05-12 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('555', '10', '2015-05-12 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('556', '13', '2015-05-12 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('557', '16', '2015-05-12 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('558', '19', '2015-05-12 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('559', '22', '2015-05-12 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('560', '25', '2015-05-12 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('561', '28', '2015-05-12 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('562', '31', '2015-05-12 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('563', '34', '2015-05-12 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('564', '37', '2015-05-12 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('565', '40', '2015-05-12 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('566', '43', '2015-05-12 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('567', '46', '2015-05-12 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('568', '49', '2015-05-12 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('569', '52', '2015-05-12 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('570', '55', '2015-05-12 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('571', '1', '2015-05-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('572', '4', '2015-05-13 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('573', '7', '2015-05-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('574', '10', '2015-05-13 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('575', '13', '2015-05-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('576', '16', '2015-05-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('577', '19', '2015-05-13 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('578', '22', '2015-05-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('579', '25', '2015-05-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('580', '28', '2015-05-13 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('581', '31', '2015-05-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('582', '34', '2015-05-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('583', '37', '2015-05-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('584', '40', '2015-05-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('585', '43', '2015-05-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('586', '46', '2015-05-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('587', '49', '2015-05-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('588', '52', '2015-05-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('589', '55', '2015-05-13 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('590', '1', '2015-05-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('591', '4', '2015-05-14 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('592', '7', '2015-05-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('593', '10', '2015-05-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('594', '13', '2015-05-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('595', '16', '2015-05-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('596', '19', '2015-05-14 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('597', '22', '2015-05-14 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('598', '25', '2015-05-14 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('599', '28', '2015-05-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('600', '31', '2015-05-14 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('601', '34', '2015-05-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('602', '37', '2015-05-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('603', '40', '2015-05-14 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('604', '43', '2015-05-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('605', '46', '2015-05-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('606', '49', '2015-05-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('607', '52', '2015-05-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('608', '55', '2015-05-14 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('609', '1', '2015-05-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('610', '4', '2015-05-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('611', '7', '2015-05-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('612', '10', '2015-05-15 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('613', '13', '2015-05-15 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('614', '16', '2015-05-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('615', '19', '2015-05-15 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('616', '22', '2015-05-15 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('617', '25', '2015-05-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('618', '28', '2015-05-15 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('619', '31', '2015-05-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('620', '34', '2015-05-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('621', '37', '2015-05-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('622', '40', '2015-05-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('623', '43', '2015-05-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('624', '46', '2015-05-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('625', '49', '2015-05-15 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('626', '52', '2015-05-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('627', '55', '2015-05-15 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('628', '1', '2015-05-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('629', '4', '2015-05-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('630', '7', '2015-05-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('631', '10', '2015-05-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('632', '13', '2015-05-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('633', '16', '2015-05-16 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('634', '19', '2015-05-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('635', '22', '2015-05-16 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('636', '25', '2015-05-16 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('637', '28', '2015-05-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('638', '31', '2015-05-16 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('639', '34', '2015-05-16 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('640', '37', '2015-05-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('641', '40', '2015-05-16 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('642', '43', '2015-05-16 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('643', '46', '2015-05-16 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('644', '49', '2015-05-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('645', '52', '2015-05-16 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('646', '55', '2015-05-16 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('647', '1', '2015-05-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('648', '4', '2015-05-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('649', '7', '2015-05-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('650', '10', '2015-05-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('651', '13', '2015-05-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('652', '16', '2015-05-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('653', '19', '2015-05-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('654', '22', '2015-05-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('655', '25', '2015-05-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('656', '28', '2015-05-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('657', '31', '2015-05-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('658', '34', '2015-05-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('659', '37', '2015-05-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('660', '40', '2015-05-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('661', '43', '2015-05-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('662', '46', '2015-05-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('663', '49', '2015-05-17 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('664', '52', '2015-05-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('665', '55', '2015-05-17 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('666', '1', '2015-05-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('667', '4', '2015-05-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('668', '7', '2015-05-18 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('669', '10', '2015-05-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('670', '13', '2015-05-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('671', '16', '2015-05-18 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('672', '19', '2015-05-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('673', '22', '2015-05-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('674', '25', '2015-05-18 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('675', '28', '2015-05-18 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('676', '31', '2015-05-18 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('677', '34', '2015-05-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('678', '37', '2015-05-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('679', '40', '2015-05-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('680', '43', '2015-05-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('681', '46', '2015-05-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('682', '49', '2015-05-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('683', '52', '2015-05-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('684', '55', '2015-05-18 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('685', '1', '2015-05-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('686', '4', '2015-05-19 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('687', '7', '2015-05-19 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('688', '10', '2015-05-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('689', '13', '2015-05-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('690', '16', '2015-05-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('691', '19', '2015-05-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('692', '22', '2015-05-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('693', '25', '2015-05-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('694', '28', '2015-05-19 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('695', '31', '2015-05-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('696', '34', '2015-05-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('697', '37', '2015-05-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('698', '40', '2015-05-19 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('699', '43', '2015-05-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('700', '46', '2015-05-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('701', '49', '2015-05-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('702', '52', '2015-05-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('703', '55', '2015-05-19 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('704', '1', '2015-05-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('705', '4', '2015-05-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('706', '7', '2015-05-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('707', '10', '2015-05-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('708', '13', '2015-05-20 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('709', '16', '2015-05-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('710', '19', '2015-05-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('711', '22', '2015-05-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('712', '25', '2015-05-20 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('713', '28', '2015-05-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('714', '31', '2015-05-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('715', '34', '2015-05-20 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('716', '37', '2015-05-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('717', '40', '2015-05-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('718', '43', '2015-05-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('719', '46', '2015-05-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('720', '49', '2015-05-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('721', '52', '2015-05-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('722', '55', '2015-05-20 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('723', '1', '2015-05-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('724', '4', '2015-05-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('725', '7', '2015-05-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('726', '10', '2015-05-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('727', '13', '2015-05-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('728', '16', '2015-05-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('729', '19', '2015-05-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('730', '22', '2015-05-21 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('731', '25', '2015-05-21 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('732', '28', '2015-05-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('733', '31', '2015-05-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('734', '34', '2015-05-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('735', '37', '2015-05-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('736', '40', '2015-05-21 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('737', '43', '2015-05-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('738', '46', '2015-05-21 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('739', '49', '2015-05-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('740', '52', '2015-05-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('741', '55', '2015-05-21 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('742', '1', '2015-05-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('743', '4', '2015-05-22 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('744', '7', '2015-05-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('745', '10', '2015-05-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('746', '13', '2015-05-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('747', '16', '2015-05-22 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('748', '19', '2015-05-22 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('749', '22', '2015-05-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('750', '25', '2015-05-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('751', '28', '2015-05-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('752', '31', '2015-05-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('753', '34', '2015-05-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('754', '37', '2015-05-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('755', '40', '2015-05-22 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('756', '43', '2015-05-22 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('757', '46', '2015-05-22 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('758', '49', '2015-05-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('759', '52', '2015-05-22 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('760', '55', '2015-05-22 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('761', '1', '2015-05-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('762', '4', '2015-05-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('763', '7', '2015-05-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('764', '10', '2015-05-23 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('765', '13', '2015-05-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('766', '16', '2015-05-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('767', '19', '2015-05-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('768', '22', '2015-05-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('769', '25', '2015-05-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('770', '28', '2015-05-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('771', '31', '2015-05-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('772', '34', '2015-05-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('773', '37', '2015-05-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('774', '40', '2015-05-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('775', '43', '2015-05-23 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('776', '46', '2015-05-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('777', '49', '2015-05-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('778', '52', '2015-05-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('779', '55', '2015-05-23 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('780', '1', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('781', '4', '2015-05-24 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('782', '7', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('783', '10', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('784', '13', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('785', '16', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('786', '19', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('787', '22', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('788', '25', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('789', '28', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('790', '31', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('791', '34', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('792', '37', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('793', '40', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('794', '43', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('795', '46', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('796', '49', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('797', '52', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('798', '55', '2015-05-24 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('799', '1', '2015-05-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('800', '4', '2015-05-25 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('801', '7', '2015-05-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('802', '10', '2015-05-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('803', '13', '2015-05-25 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('804', '16', '2015-05-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('805', '19', '2015-05-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('806', '22', '2015-05-25 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('807', '25', '2015-05-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('808', '28', '2015-05-25 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('809', '31', '2015-05-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('810', '34', '2015-05-25 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('811', '37', '2015-05-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('812', '40', '2015-05-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('813', '43', '2015-05-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('814', '46', '2015-05-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('815', '49', '2015-05-25 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('816', '52', '2015-05-25 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('817', '55', '2015-05-25 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('818', '1', '2015-05-26 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('819', '4', '2015-05-26 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('820', '7', '2015-05-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('821', '10', '2015-05-26 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('822', '13', '2015-05-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('823', '16', '2015-05-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('824', '19', '2015-05-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('825', '22', '2015-05-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('826', '25', '2015-05-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('827', '28', '2015-05-26 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('828', '31', '2015-05-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('829', '34', '2015-05-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('830', '37', '2015-05-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('831', '40', '2015-05-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('832', '43', '2015-05-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('833', '46', '2015-05-26 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('834', '49', '2015-05-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('835', '52', '2015-05-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('836', '55', '2015-05-26 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('837', '1', '2015-05-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('838', '4', '2015-05-27 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('839', '7', '2015-05-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('840', '10', '2015-05-27 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('841', '13', '2015-05-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('842', '16', '2015-05-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('843', '19', '2015-05-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('844', '22', '2015-05-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('845', '25', '2015-05-27 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('846', '28', '2015-05-27 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('847', '31', '2015-05-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('848', '34', '2015-05-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('849', '37', '2015-05-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('850', '40', '2015-05-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('851', '43', '2015-05-27 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('852', '46', '2015-05-27 15:34:37', 'math_teacher', 'Absent', '2');
INSERT INTO `attendance` VALUES ('853', '49', '2015-05-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('854', '52', '2015-05-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('855', '55', '2015-05-27 15:34:37', 'math_teacher', null, '1');
INSERT INTO `attendance` VALUES ('859', '1', '2015-04-11 18:00:23', 'admin', null, '1');
INSERT INTO `attendance` VALUES ('860', '4', '2015-04-11 18:00:54', 'admin', null, '1');
INSERT INTO `attendance` VALUES ('861', '7', '2015-04-11 18:34:00', 'admin', 'Absent', '2');
INSERT INTO `attendance` VALUES ('862', '10', '2015-04-11 18:34:00', 'admin', 'Absent', '2');
INSERT INTO `attendance` VALUES ('863', '13', '2015-04-11 18:34:00', 'admin', 'Absent', '2');
INSERT INTO `attendance` VALUES ('864', '16', '2015-04-11 18:34:00', 'admin', 'Absent', '2');
INSERT INTO `attendance` VALUES ('865', '19', '2015-04-11 18:34:00', 'admin', 'Absent', '2');
INSERT INTO `attendance` VALUES ('866', '22', '2015-04-11 18:34:00', 'admin', 'Absent', '2');
INSERT INTO `attendance` VALUES ('867', '25', '2015-04-11 18:34:00', 'admin', 'Absent', '2');
INSERT INTO `attendance` VALUES ('868', '28', '2015-04-11 18:34:00', 'admin', 'Absent', '2');
INSERT INTO `attendance` VALUES ('869', '31', '2015-04-11 18:34:00', 'admin', 'Absent', '2');
INSERT INTO `attendance` VALUES ('870', '34', '2015-04-11 18:34:00', 'admin', 'Absent', '2');
INSERT INTO `attendance` VALUES ('871', '37', '2015-04-11 18:34:00', 'admin', 'Absent', '2');
INSERT INTO `attendance` VALUES ('872', '40', '2015-04-11 18:34:00', 'admin', 'Absent', '2');
INSERT INTO `attendance` VALUES ('873', '43', '2015-04-11 18:34:00', 'admin', 'Absent', '2');
INSERT INTO `attendance` VALUES ('874', '46', '2015-04-11 18:34:00', 'admin', 'Absent', '2');
INSERT INTO `attendance` VALUES ('875', '49', '2015-04-11 18:34:00', 'admin', 'Absent', '2');
INSERT INTO `attendance` VALUES ('876', '52', '2015-04-11 18:34:00', 'admin', 'Absent', '2');
INSERT INTO `attendance` VALUES ('877', '55', '2015-04-11 18:34:00', 'admin', 'Absent', '2');

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `home_phone` varchar(20) DEFAULT NULL,
  `address_line_1` varchar(255) DEFAULT NULL,
  `address_line_2` varchar(255) DEFAULT NULL,
  `apartment` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `zip` int(10) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of contact
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `dept` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `credits` tinyint(1) DEFAULT NULL,
  `academic_year` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'Physics K10', 'Physics', null, '3', '2015-04-10');
INSERT INTO `course` VALUES ('2', 'Math K10', 'Math', null, '4', '2015-04-10');
INSERT INTO `course` VALUES ('3', 'Science K10', 'Science ', null, '3', '2015-04-10');

-- ----------------------------
-- Table structure for course_schedule
-- ----------------------------
DROP TABLE IF EXISTS `course_schedule`;
CREATE TABLE `course_schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL,
  `instructor_user_name` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `term` varchar(25) DEFAULT NULL,
  `start_dt` date DEFAULT NULL,
  `end_dt` date DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `room_no` varchar(50) DEFAULT NULL,
  `future_use` varchar(1000) DEFAULT NULL,
  `notes` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `course_fk` (`course_id`),
  KEY `instructor_id_fk` (`instructor_user_name`),
  CONSTRAINT `course_schedule_ibfk_1` FOREIGN KEY (`instructor_user_name`) REFERENCES `staff` (`user_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `course_schedule_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of course_schedule
-- ----------------------------
INSERT INTO `course_schedule` VALUES ('1', '1', 'physics_teacher', '1', 'spring', '2015-01-12', '2015-05-09', '16:00:00', '18:00:00', 'BU 102', 'MN,WE', null);
INSERT INTO `course_schedule` VALUES ('2', '2', 'math_teacher', '1', 'spring', '2015-01-12', '2015-05-09', '16:00:00', '18:00:00', 'BU 103', 'TU,TH', null);
INSERT INTO `course_schedule` VALUES ('3', '3', 'science_teacher', '1', 'spring', '2015-01-12', '2015-05-09', '18:00:00', '19:30:00', 'BU 102', 'MN,WE,FR', null);

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `user_name` varchar(255) NOT NULL,
  `id` varchar(50) NOT NULL DEFAULT '',
  `f_name` varchar(255) DEFAULT NULL,
  `m_name` varchar(255) DEFAULT NULL,
  `l_name` varchar(255) DEFAULT NULL,
  `prefix` varchar(255) DEFAULT NULL,
  `suffix` varchar(255) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `height` float DEFAULT NULL COMMENT 'feet units',
  `weight` float DEFAULT NULL COMMENT 'in lbs',
  `race` varchar(100) DEFAULT NULL,
  `eye_color` tinyint(1) DEFAULT NULL COMMENT '1 - black, 2 - blue, 3 - green, 4 - brown',
  `hair_color` tinyint(1) DEFAULT NULL COMMENT '1 - black, 2 - blonde,3 - red, 4 - brown, 5 - other',
  `sex` bit(1) DEFAULT NULL COMMENT '0 - female , 1 - male , null - unknown',
  `picture_uri` varchar(1000) DEFAULT NULL,
  `ssn` int(9) DEFAULT NULL,
  `joining_dtt` datetime DEFAULT NULL,
  `contact` int(11) DEFAULT NULL,
  `emr_contact` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_name`),
  KEY `user_name_fk` (`user_name`),
  KEY `contact_fk` (`contact`),
  KEY `emr_contact_fk` (`emr_contact`),
  CONSTRAINT `person_ibfk_1` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `person_ibfk_2` FOREIGN KEY (`contact`) REFERENCES `contact` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `person_ibfk_3` FOREIGN KEY (`emr_contact`) REFERENCES `contact` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('admin', '12133133', 'Venkat', 'SPS', 'Maridu', 'Mr', null, '1989-06-28 17:29:03', '5.9', '190', 'indian', '1', '1', '', null, '123456789', '2014-07-17 17:30:18', null, null);
INSERT INTO `person` VALUES ('brock.sosa', '', 'Sosa', null, 'Brock', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('bruno.noble', '', 'bruno', null, 'noble', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('curran.roach', '', 'curran', null, 'roach', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('ethan.flores', '', 'ethan', null, 'flores', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('evan.fitzpatrick', '', 'evan', null, 'fitzpatrick', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('gannon.pierce', '', 'gannon', null, 'pierce', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('ivor.dejesus', '', 'ivor', null, 'dejesus', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('jamal.guzman', '', 'jamal', null, 'guzman', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('jarrod.burch', '', 'jarrod', null, 'burch', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('lee.stanton', '', 'lee', null, 'stanton', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('math_teacher', '12133133', 'Kirt', 'A', 'Harrison', 'Mr', null, '1989-06-28 17:29:03', '5.9', '190', null, '1', '1', '', null, '123456789', '2014-07-17 17:30:18', null, null);
INSERT INTO `person` VALUES ('nathan.ochoa', '', 'nathan', null, 'ochoa', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('neil.poole', '', 'neil', null, 'poole', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('noble.keller', '', 'noble', null, 'keller', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('oscar.wilkinson', '', 'oscar', null, 'wilkinson', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('otto.stephenson', '', 'otto', null, 'stephenson', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('perry.montgomery', '', 'Sosa', null, 'montgomery', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('perry.pickett', '', 'perry', null, 'pickett', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('physics_teacher', '12133133', 'Ken', 'B', 'Watson', 'Mr', null, '1989-06-28 17:29:03', '5.9', '190', null, '1', '1', '', null, '123456789', '2014-07-17 17:30:18', null, null);
INSERT INTO `person` VALUES ('ray.cantrell', '', 'ray', null, 'cantrell', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('science_teacher', '12133133', 'Mina', 'G', 'Siedel', 'Mr', null, '1989-06-28 17:29:03', '5.2', '190', null, '1', '1', '\0', null, '123456789', '2014-07-17 17:30:18', null, null);
INSERT INTO `person` VALUES ('vaughan.white', '', 'vaughan', null, 'white', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `person` VALUES ('walter.kaufman', '', 'walter', null, 'kaufman', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

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
-- Table structure for school_schedule
-- ----------------------------
DROP TABLE IF EXISTS `school_schedule`;
CREATE TABLE `school_schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_name` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `start_dtt` datetime DEFAULT NULL,
  `end_dtt` datetime DEFAULT NULL,
  `annonced_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of school_schedule
-- ----------------------------

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `user_name` varchar(255) NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `future_use` varchar(1000) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_name`),
  CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`user_name`) REFERENCES `person` (`user_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('admin', '1', '', null, null);
INSERT INTO `staff` VALUES ('math_teacher', '1', null, null, null);
INSERT INTO `staff` VALUES ('physics_teacher', '1', null, null, null);
INSERT INTO `staff` VALUES ('science_teacher', '1', null, null, null);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `user_name` varchar(255) NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `parent_email` varchar(255) DEFAULT NULL,
  `future_use` varchar(1000) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL COMMENT 'class name,grade_type',
  PRIMARY KEY (`user_name`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`user_name`) REFERENCES `person` (`user_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('brock.sosa', '1', null, null, '');
INSERT INTO `student` VALUES ('bruno.noble', '1', null, null, '');
INSERT INTO `student` VALUES ('curran.roach', '1', null, null, '');
INSERT INTO `student` VALUES ('ethan.flores', '1', null, null, '');
INSERT INTO `student` VALUES ('evan.fitzpatrick', '1', null, null, '');
INSERT INTO `student` VALUES ('gannon.pierce', '1', null, null, '');
INSERT INTO `student` VALUES ('ivor.dejesus', '1', null, null, '');
INSERT INTO `student` VALUES ('jamal.guzman', '1', null, null, '');
INSERT INTO `student` VALUES ('jarrod.burch', '1', null, null, '');
INSERT INTO `student` VALUES ('lee.stanton', '1', null, null, '');
INSERT INTO `student` VALUES ('nathan.ochoa', '1', null, null, '');
INSERT INTO `student` VALUES ('neil.poole', '1', null, null, '');
INSERT INTO `student` VALUES ('noble.keller', '1', null, null, '');
INSERT INTO `student` VALUES ('oscar.wilkinson', '1', null, null, '');
INSERT INTO `student` VALUES ('otto.stephenson', '1', null, null, '');
INSERT INTO `student` VALUES ('perry.montgomery', '1', null, null, '');
INSERT INTO `student` VALUES ('perry.pickett', '1', null, null, '');
INSERT INTO `student` VALUES ('ray.cantrell', '1', null, null, '');
INSERT INTO `student` VALUES ('vaughan.white', '1', null, null, '');
INSERT INTO `student` VALUES ('walter.kaufman', '1', null, null, '');

-- ----------------------------
-- Table structure for student_course_enrollment
-- ----------------------------
DROP TABLE IF EXISTS `student_course_enrollment`;
CREATE TABLE `student_course_enrollment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_schedule_id` int(11) DEFAULT NULL,
  `student_user_name` varchar(255) DEFAULT NULL,
  `enrolled_dtt` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `grade` varchar(10) DEFAULT NULL,
  `graded_dtt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `course_schedule_id_fk` (`course_schedule_id`),
  KEY `student_id_fk_2` (`student_user_name`),
  CONSTRAINT `student_course_enrollment_ibfk_1` FOREIGN KEY (`student_user_name`) REFERENCES `student` (`user_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_course_enrollment_ibfk_2` FOREIGN KEY (`course_schedule_id`) REFERENCES `course_schedule` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student_course_enrollment
-- ----------------------------
INSERT INTO `student_course_enrollment` VALUES ('1', '1', 'brock.sosa', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('2', '2', 'brock.sosa', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('3', '3', 'brock.sosa', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('4', '1', 'curran.roach', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('5', '2', 'curran.roach', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('6', '3', 'curran.roach', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('7', '1', 'ethan.flores', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('8', '2', 'ethan.flores', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('9', '3', 'ethan.flores', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('10', '1', 'jarrod.burch', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('11', '2', 'jarrod.burch', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('12', '3', 'jarrod.burch', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('13', '1', 'ivor.dejesus', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('14', '2', 'ivor.dejesus', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('15', '3', 'ivor.dejesus', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('16', '1', 'jamal.guzman', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('17', '2', 'jamal.guzman', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('18', '3', 'jamal.guzman', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('19', '1', 'vaughan.white', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('20', '2', 'vaughan.white', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('21', '3', 'vaughan.white', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('22', '1', 'perry.pickett', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('23', '2', 'perry.pickett', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('24', '3', 'perry.pickett', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('25', '1', 'lee.stanton', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('26', '2', 'lee.stanton', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('27', '3', 'lee.stanton', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('28', '1', 'walter.kaufman', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('29', '2', 'walter.kaufman', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('30', '3', 'walter.kaufman', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('31', '1', 'bruno.noble', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('32', '2', 'bruno.noble', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('33', '3', 'bruno.noble', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('34', '1', 'otto.stephenson', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('35', '2', 'otto.stephenson', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('36', '3', 'otto.stephenson', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('37', '1', 'nathan.ochoa', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('38', '2', 'nathan.ochoa', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('39', '3', 'nathan.ochoa', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('40', '1', 'ray.cantrell', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('41', '2', 'ray.cantrell', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('42', '3', 'ray.cantrell', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('43', '1', 'noble.keller', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('44', '2', 'noble.keller', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('45', '3', 'noble.keller', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('46', '1', 'gannon.pierce', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('47', '2', 'gannon.pierce', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('48', '3', 'gannon.pierce', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('49', '1', 'evan.fitzpatrick', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('50', '2', 'evan.fitzpatrick', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('51', '3', 'evan.fitzpatrick', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('52', '1', 'perry.montgomery', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('53', '2', 'perry.montgomery', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('54', '3', 'perry.montgomery', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('55', '1', 'neil.poole', '2015-01-02 03:05:29', '1', '', null);
INSERT INTO `student_course_enrollment` VALUES ('56', '2', 'neil.poole', '2015-01-02 03:05:29', '1', null, null);
INSERT INTO `student_course_enrollment` VALUES ('57', '3', 'neil.poole', '2015-01-02 03:05:29', '1', null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_name` varchar(255) NOT NULL,
  `password` varchar(500) NOT NULL COMMENT 'md5',
  `password_salt` varchar(255) DEFAULT NULL,
  `active` tinyint(1) NOT NULL COMMENT '0 - inactive , 1 - active, 2 - blocked, 3 - temp_blocked',
  `e_mail` varchar(255) DEFAULT NULL,
  `last_access_dtt` datetime DEFAULT NULL,
  `credentials_expire_dtt` datetime DEFAULT NULL,
  `account_expire_dtt` datetime DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', '', '1', 'admin@mc2-sms.edu', '2015-04-10 16:27:25', null, null);
INSERT INTO `user` VALUES ('brock.sosa', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'brock.sosa@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('bruno.noble', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'bruno.noble@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('curran.roach', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'curran.roach@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('ethan.flores', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'ethan.flores@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('evan.fitzpatrick', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'evan.fitzpatrick@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('gannon.pierce', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'gannon.pierce@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('ivor.dejesus', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'ivor.dejesus@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('jamal.guzman', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'jamal.guzman@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('jarrod.burch', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'jarrod.burch@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('lee.stanton', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'lee.stanton@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('math_teacher', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'math_teacher@mc2-sms.edu', '2015-04-10 16:29:08', null, null);
INSERT INTO `user` VALUES ('nathan.ochoa', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'nathan.ochoa@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('neil.poole', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'neil.poole@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('noble.keller', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'noble.keller@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('oscar.wilkinson', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'oscar.wilkinson@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('otto.stephenson', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'otto.stephenson@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('perry.montgomery', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'perry.montgomery@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('perry.pickett', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'perry.pickett@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('physics_teacher', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'physics_teacher@mc2-sms.edu', '2015-04-10 16:30:30', null, null);
INSERT INTO `user` VALUES ('ray.cantrell', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'ray.cantrell@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('science_teacher', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'science_teacher@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('vaughan.white', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'vaughan.white@mc2-sms.edu', '2015-04-10 16:30:02', null, null);
INSERT INTO `user` VALUES ('walter.kaufman', '$2a$10$9.atRfnAZPzacyoxYEPP2uM1tY0BcizuAxmuFLcPqDVznehOCGcEi', null, '1', 'walter.kaufman@mc2-sms.edu', '2015-04-10 16:30:02', null, null);

-- ----------------------------
-- Table structure for user_in_role
-- ----------------------------
DROP TABLE IF EXISTS `user_in_role`;
CREATE TABLE `user_in_role` (
  `user_name` varchar(255) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `users_in_roles_user_name` (`user_name`),
  KEY `users_in_roles_role_id` (`role_id`),
  CONSTRAINT `user_in_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_in_role_ibfk_2` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_in_role
-- ----------------------------
INSERT INTO `user_in_role` VALUES ('admin', '1');
INSERT INTO `user_in_role` VALUES ('math_teacher', '2');
INSERT INTO `user_in_role` VALUES ('physics_teacher', '2');
INSERT INTO `user_in_role` VALUES ('science_teacher', '2');
INSERT INTO `user_in_role` VALUES ('curran.roach', '3');
INSERT INTO `user_in_role` VALUES ('ethan.flores', '3');
INSERT INTO `user_in_role` VALUES ('jarrod.burch', '3');
INSERT INTO `user_in_role` VALUES ('ivor.dejesus', '3');
INSERT INTO `user_in_role` VALUES ('jamal.guzman', '3');
INSERT INTO `user_in_role` VALUES ('vaughan.white', '3');
INSERT INTO `user_in_role` VALUES ('perry.pickett', '3');
INSERT INTO `user_in_role` VALUES ('lee.stanton', '3');
INSERT INTO `user_in_role` VALUES ('walter.kaufman', '3');
INSERT INTO `user_in_role` VALUES ('bruno.noble', '3');
INSERT INTO `user_in_role` VALUES ('otto.stephenson', '3');
INSERT INTO `user_in_role` VALUES ('nathan.ochoa', '3');
INSERT INTO `user_in_role` VALUES ('brock.sosa', '3');
INSERT INTO `user_in_role` VALUES ('ray.cantrell', '3');
INSERT INTO `user_in_role` VALUES ('noble.keller', '3');
INSERT INTO `user_in_role` VALUES ('gannon.pierce', '3');
INSERT INTO `user_in_role` VALUES ('evan.fitzpatrick', '3');
INSERT INTO `user_in_role` VALUES ('perry.montgomery', '3');
INSERT INTO `user_in_role` VALUES ('neil.poole', '3');
INSERT INTO `user_in_role` VALUES ('oscar.wilkinson', '3');
