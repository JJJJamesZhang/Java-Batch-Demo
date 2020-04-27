/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : java_batch

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 24/04/2020 20:37:56
*/
USE java_batch;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `EmpId` int(10) NOT NULL,
  `FullName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ManagerId` int(10) NULL DEFAULT NULL,
  `DateOfJoining` date NULL DEFAULT NULL,
  PRIMARY KEY (`EmpId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (121, 'Jon Snow', 321, '2014-01-31');
INSERT INTO `employee` VALUES (234, 'Mike Jason', 453, '2016-02-13');
INSERT INTO `employee` VALUES (235, 'Jack Wang', 212, '2018-06-23');
INSERT INTO `employee` VALUES (321, 'Night King', 986, '2015-01-30');
INSERT INTO `employee` VALUES (421, 'Arya Stark', 876, '2016-11-27');
INSERT INTO `employee` VALUES (456, 'Mike Jackson', 965, '2017-04-06');
INSERT INTO `employee` VALUES (489, 'Jack Snow', 467, '2014-01-31');
INSERT INTO `employee` VALUES (521, 'Sansa Stark', 876, '2017-12-02');
INSERT INTO `employee` VALUES (522, 'Sansa Stark', 876, '2017-12-02');

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : java_batch

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 24/04/2020 20:39:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `SalaryId` int(11) NOT NULL AUTO_INCREMENT,
  `EmpId` int(10) NOT NULL,
  `ProjectId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Salary` decimal(10, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`SalaryId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES (1, 121, 'p2', 8000);
INSERT INTO `salary` VALUES (2, 121, 'p4', 5000);
INSERT INTO `salary` VALUES (3, 321, 'p2', 1000);
INSERT INTO `salary` VALUES (4, 421, 'p1', 12000);
INSERT INTO `salary` VALUES (5, 721, 'p3', 6000);
INSERT INTO `salary` VALUES (6, 456, 'p1', 900);
INSERT INTO `salary` VALUES (7, 456, 'p3', 1100);
INSERT INTO `salary` VALUES (32, 489, 'p2', 8000);
INSERT INTO `salary` VALUES (33, 489, 'p4', 8000);

SET FOREIGN_KEY_CHECKS = 1;


/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : java_batch

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 24/04/2020 20:39:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `ProjectId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ProjectName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ProjectId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('p1', 'website');
INSERT INTO `project` VALUES ('p2', 'data analysis');
INSERT INTO `project` VALUES ('p3', 'account');
INSERT INTO `project` VALUES ('p4', 'design');

SET FOREIGN_KEY_CHECKS = 1;
