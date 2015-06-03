/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : sms

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2015-06-02 13:08:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_course_enrollment_id` int(11) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL COMMENT '1=PRESENT,2=ABSENT, 3=ON_LEAVE, 4=SICK, 5=OTHERS',
  `taken_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student_course_enrollment_id` (`student_course_enrollment_id`),
  KEY `taken_by` (`taken_by`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`student_course_enrollment_id`) REFERENCES `student_course_enrollment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`taken_by`) REFERENCES `attendance_by` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3900 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for attendance_by
-- ----------------------------
DROP TABLE IF EXISTS `attendance_by`;
CREATE TABLE `attendance_by` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `taken_dtt` datetime DEFAULT NULL,
  `taken_by` varchar(255) DEFAULT NULL,
  `course_schedule_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `taken_by` (`taken_by`),
  KEY `course_schedule_id` (`course_schedule_id`),
  CONSTRAINT `attendance_by_ibfk_1` FOREIGN KEY (`taken_by`) REFERENCES `person` (`user_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `attendance_by_ibfk_2` FOREIGN KEY (`course_schedule_id`) REFERENCES `course_schedule` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3925 DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

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
-- Table structure for course_schedule
-- ----------------------------
DROP TABLE IF EXISTS `course_schedule`;
CREATE TABLE `course_schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
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
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;

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
