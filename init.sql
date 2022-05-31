/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : course

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 04/05/2022 14:39:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `institute_id` int UNSIGNED NOT NULL,
  `course_hour` int UNSIGNED NOT NULL,
  `credit` float NOT NULL,
  PRIMARY KEY (`course_id`) USING BTREE,
  INDEX `institute_id`(`institute_id`) USING BTREE,
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`institute_id`) REFERENCES `institute` (`institute_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for course_head
-- ----------------------------
DROP TABLE IF EXISTS `course_head`;
CREATE TABLE `course_head`  (
  `head_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `teacher_id` bigint UNSIGNED NOT NULL,
  `head_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `head_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` bigint UNSIGNED NOT NULL,
  `head_year` int UNSIGNED NOT NULL,
  `volume` int UNSIGNED NOT NULL,
  `volume_left` int UNSIGNED NOT NULL,
  `head_term` tinyint NOT NULL,
  PRIMARY KEY (`head_id`) USING BTREE,
  INDEX `teacher_id`(`teacher_id`) USING BTREE,
  INDEX `course_id`(`course_id`) USING BTREE,
  CONSTRAINT `course_head_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `course_head_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for head_user_rel
-- ----------------------------
DROP TABLE IF EXISTS `head_user_rel`;
CREATE TABLE `head_user_rel`  (
  `head_id` bigint UNSIGNED NOT NULL,
  `student_id` bigint UNSIGNED NOT NULL,
  `grade` float UNSIGNED NOT NULL,
  `state` tinyint NOT NULL,
  PRIMARY KEY (`head_id`, `student_id`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE,
  CONSTRAINT `head_user_rel_ibfk_1` FOREIGN KEY (`head_id`) REFERENCES `course_head` (`head_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `head_user_rel_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for institute
-- ----------------------------
DROP TABLE IF EXISTS `institute`;
CREATE TABLE `institute`  (
  `institute_id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `institute_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`institute_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` tinyint NOT NULL,
  `roll_date` date NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `institute_id` int UNSIGNED NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `institute_id`(`institute_id`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`institute_id`) REFERENCES `institute` (`institute_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
