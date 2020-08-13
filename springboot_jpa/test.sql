/*
 Navicat MySQL Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50643
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50643
 File Encoding         : 65001

 Date: 13/08/2020 17:32:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`city_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES (1, '中国首都', '北京');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_id` int(11) NULL DEFAULT NULL,
  `isdelete` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '张三', '男', 1, 0);
INSERT INTO `student` VALUES (2, '李四 ', '男', 1, 1);
INSERT INTO `student` VALUES (3, '王五', '女', 2, 1);
INSERT INTO `student` VALUES (4, '赵柳', '女', 2, 1);
INSERT INTO `student` VALUES (5, '溪若', '女', 3, 1);
INSERT INTO `student` VALUES (6, 'string', 'string', NULL, 1);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '张老师', '北京', 1);
INSERT INTO `teacher` VALUES (2, '鲁老师', '唐山', 2);
INSERT INTO `teacher` VALUES (3, '江老师', '郑州', 3);
INSERT INTO `teacher` VALUES (4, 'string', 'string', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `birthday` date NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `dept_id` int(11) NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT NULL,
  `modifier_id` int(11) NULL DEFAULT NULL,
  `modify_time` datetime(6) NULL DEFAULT NULL,
  `operator_id` int(11) NULL DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_name` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '2020-08-09', '2020-08-09 14:36:20.000000', 0, 1, 1, '2020-08-09 14:36:30.000000', 1, '1', '张三');
INSERT INTO `user` VALUES (2, '1996-11-02', '2020-08-09 14:36:20.000000', 0, 1, 1, '2020-08-09 14:36:30.000000', 1, '1', '张三2');

-- ----------------------------
-- Table structure for user_copy1
-- ----------------------------
DROP TABLE IF EXISTS `user_copy1`;
CREATE TABLE `user_copy1`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `birthday` date NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `dept_id` int(11) NULL DEFAULT NULL,
  `is_delete` bit(1) NULL DEFAULT NULL,
  `modifier_id` int(11) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `operator_id` int(11) NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_copy1
-- ----------------------------
INSERT INTO `user_copy1` VALUES (1, '1996-11-09', '2020-08-09 14:36:20', 0, b'1', 1, '2020-08-09 14:36:30', 1, '1', '张三');
INSERT INTO `user_copy1` VALUES (2, '1996-11-02', '2020-08-09 14:36:20', 0, b'1', 1, '2020-08-09 14:36:30', 1, '1', '张三2');

SET FOREIGN_KEY_CHECKS = 1;
