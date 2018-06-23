/*
 Navicat Premium Data Transfer

 Source Server         : Test
 Source Server Type    : MySQL
 Source Server Version : 50712
 Source Host           : localhost:3306
 Source Schema         : db_ics

 Target Server Type    : MySQL
 Target Server Version : 50712
 File Encoding         : 65001

 Date: 20/06/2018 20:37:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_agreement
-- ----------------------------
DROP TABLE IF EXISTS `tb_agreement`;
CREATE TABLE `tb_agreement`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `agreementTime` datetime(0) NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_auth`;
CREATE TABLE `tb_auth`  (
  `CID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CDESC` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CNAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CSEQ` decimal(22, 0) NULL DEFAULT NULL,
  `CURL` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CPID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`CID`) USING BTREE,
  INDEX `FK_l1sjt3gdk40vdodyg6972gqgc`(`CPID`) USING BTREE,
  CONSTRAINT `FK_l1sjt3gdk40vdodyg6972gqgc` FOREIGN KEY (`CPID`) REFERENCES `tb_auth` (`CID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_auth
-- ----------------------------
INSERT INTO `tb_auth` VALUES ('0', '国际合作交流管理系统', '首页', 1, NULL, NULL);
INSERT INTO `tb_auth` VALUES ('bjgl', NULL, '班级管理', 2, '', 'gjxxgl');
INSERT INTO `tb_auth` VALUES ('bjglym', NULL, '班级管理页面', 1, '/classesInfo!classesInfo.action', 'bjgl');
INSERT INTO `tb_auth` VALUES ('bjsc', NULL, '班级删除', 6, '/classesInfo!delete.action', 'bjgl');
INSERT INTO `tb_auth` VALUES ('bjtj', NULL, '班级添加', 2, '/classesInfo!add.action', 'bjgl');
INSERT INTO `tb_auth` VALUES ('bjtjym', NULL, '添加班级页面', 3, '/classesInfo!classesInfoAdd.action', 'bjgl');
INSERT INTO `tb_auth` VALUES ('bjxg', NULL, '班级修改', 4, '/classesInfo!edit.action', 'bjgl');
INSERT INTO `tb_auth` VALUES ('bjxgym', NULL, '修改班级页面', 5, '/classesInfo!classesEdit.action', 'bjgl');
INSERT INTO `tb_auth` VALUES ('gjxxgl', NULL, '国际信息管理', 2, NULL, '0');
INSERT INTO `tb_auth` VALUES ('icms', NULL, '系统管理', 2, NULL, '0');
INSERT INTO `tb_auth` VALUES ('jsbj', '修改角色', '角色编辑', 6, '/role!edit.action', 'jsgl');
INSERT INTO `tb_auth` VALUES ('jsbjym', '修改角色', '编辑角色页面', 5, '/role!roleEdit.action', 'jsgl');
INSERT INTO `tb_auth` VALUES ('jscx', NULL, '角色查询', 2, '/role!datagrid.action', 'jsgl');
INSERT INTO `tb_auth` VALUES ('jsgl', NULL, '角色管理', 2, NULL, 'icms');
INSERT INTO `tb_auth` VALUES ('jsglym', NULL, '角色管理页面', 1, '/role!role.action', 'jsgl');
INSERT INTO `tb_auth` VALUES ('jsplbj', '批量修改用户角色', '角色批量编辑', 9, '/user!roleEdit.action', 'yhgl');
INSERT INTO `tb_auth` VALUES ('jsplbjym', '批量修改用户角色', '角色批量编辑页面', 8, '/user!userRoleEdit.action', 'yhgl');
INSERT INTO `tb_auth` VALUES ('jssc', NULL, '角色删除', 7, '/role!delete.action', 'jsgl');
INSERT INTO `tb_auth` VALUES ('jstj', NULL, '角色添加', 4, '/role!add.action', 'jsgl');
INSERT INTO `tb_auth` VALUES ('jstjym', NULL, '添加角色页面', 3, '/role!roleAdd.action', 'jsgl');
INSERT INTO `tb_auth` VALUES ('qxbj', NULL, '权限编辑', 6, '/auth!edit.action', 'qxgl');
INSERT INTO `tb_auth` VALUES ('qxbjym', NULL, '编辑权限页面', 5, '/auth!authEdit.action', 'qxgl');
INSERT INTO `tb_auth` VALUES ('qxcx', NULL, '权限查询', 2, '/auth!treegrid.action', 'qxgl');
INSERT INTO `tb_auth` VALUES ('qxgl', NULL, '权限管理', 3, '', 'icms');
INSERT INTO `tb_auth` VALUES ('qxglym', NULL, '权限管理页面', 1, '/auth!auth.action', 'qxgl');
INSERT INTO `tb_auth` VALUES ('qxsc', NULL, '权限删除', 7, '/auth!edit.action', 'qxgl');
INSERT INTO `tb_auth` VALUES ('qxtj', NULL, '权限添加', 4, '/auth!add.action', 'qxgl');
INSERT INTO `tb_auth` VALUES ('qxtjym', NULL, '添加权限页面', 3, '/auth!authAdd.action', 'qxgl');
INSERT INTO `tb_auth` VALUES ('xwcx', NULL, '新闻查询', 2, '/pubNews!datagrid.action', 'xwgl');
INSERT INTO `tb_auth` VALUES ('xwgl', NULL, '新闻管理', 3, '', 'xxfbgl');
INSERT INTO `tb_auth` VALUES ('xwglym', NULL, '新闻管理页面', 1, '/pubNews!news.action', 'xwgl');
INSERT INTO `tb_auth` VALUES ('xwsc', NULL, '新闻删除', 7, '/pubNews!delete.action', 'xwgl');
INSERT INTO `tb_auth` VALUES ('xwtj', NULL, '新闻添加', 3, '/pubNews!add.action', 'xwgl');
INSERT INTO `tb_auth` VALUES ('xwtjym', NULL, '添加新闻页面', 4, '/pubNews!newsAdd.action', 'xwgl');
INSERT INTO `tb_auth` VALUES ('xwxg', NULL, '新闻修改', 5, '/pubNews!edit.action', 'xwgl');
INSERT INTO `tb_auth` VALUES ('xwxgym', NULL, '修改新闻页面', 6, '/pubNews!newsEdit.action', 'xwgl');
INSERT INTO `tb_auth` VALUES ('xwyl', NULL, '新闻预览', 8, 'pubNews!showContent.action', 'xwgl');
INSERT INTO `tb_auth` VALUES ('xxfbgl', NULL, '信息发布管理', 3, '', '0');
INSERT INTO `tb_auth` VALUES ('xycx', NULL, '学院查询', 3, '/collegeInfo!datagrid.action', 'xygl');
INSERT INTO `tb_auth` VALUES ('xygl', NULL, '学院管理', 5, '', 'gjxxgl');
INSERT INTO `tb_auth` VALUES ('xyglym', '', '学院管理页面', 1, '/collegeInfo!collegeInfos.action', 'xygl');
INSERT INTO `tb_auth` VALUES ('xysc', NULL, '学院删除', 8, '/collegeInfo!delete.action', 'xygl');
INSERT INTO `tb_auth` VALUES ('xytj', NULL, '学院添加', 4, '/collegeInfo!add.action', 'xygl');
INSERT INTO `tb_auth` VALUES ('xytjym', NULL, '添加学院页面', 5, '/collegeInfo!collegeInfosAdd.action', 'xygl');
INSERT INTO `tb_auth` VALUES ('xyxg', NULL, '学院修改', 6, '/collegeInfo!edit.action', 'xygl');
INSERT INTO `tb_auth` VALUES ('xyxgym', NULL, '修改学院页面', 7, '/collegeInfo!collegeInfosEdit.action', 'xygl');
INSERT INTO `tb_auth` VALUES ('yhcx', NULL, '用户查询', 2, '/user!datagrid.action', 'yhgl');
INSERT INTO `tb_auth` VALUES ('yhgl', NULL, '用户管理', 1, NULL, 'icms');
INSERT INTO `tb_auth` VALUES ('yhglym', NULL, '用户管理页面', 1, '/user!user.action', 'yhgl');
INSERT INTO `tb_auth` VALUES ('yhsc', NULL, '用户删除', 7, '/user!delete.action', 'yhgl');
INSERT INTO `tb_auth` VALUES ('yhtj', NULL, '用户添加', 4, '/user!add.action', 'yhgl');
INSERT INTO `tb_auth` VALUES ('yhtjym', NULL, '添加用户页面', 3, '/user!userAdd.action', 'yhgl');
INSERT INTO `tb_auth` VALUES ('yhxg', NULL, '用户修改', 6, '/user!edit.action', 'yhgl');
INSERT INTO `tb_auth` VALUES ('yhxgym', NULL, '修改用户页面', 5, '/user!userEdit.action', 'yhgl');

-- ----------------------------
-- Table structure for tb_classes_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_classes_info`;
CREATE TABLE `tb_classes_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classNo` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `descInfo` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `CollegeInfoId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_l059pkgmkgh760vq3cq61nnhf`(`CollegeInfoId`) USING BTREE,
  CONSTRAINT `FK_l059pkgmkgh760vq3cq61nnhf` FOREIGN KEY (`CollegeInfoId`) REFERENCES `tb_college_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_classes_info
-- ----------------------------
INSERT INTO `tb_classes_info` VALUES (2, '1002', '软件工程12班', 1);

-- ----------------------------
-- Table structure for tb_college_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_college_info`;
CREATE TABLE `tb_college_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `collegeName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `descInfo` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_college_info
-- ----------------------------
INSERT INTO `tb_college_info` VALUES (1, '计算机学院', '计算机学院啊安安');
INSERT INTO `tb_college_info` VALUES (2, '你麻痹学院', '傻逼');

-- ----------------------------
-- Table structure for tb_exchange_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_exchange_student`;
CREATE TABLE `tb_exchange_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goAbroadTime` datetime(0) NULL DEFAULT NULL,
  `replaceCourse` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `replaceCredit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `schoolName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `schoolType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_forcollege_ieltstrain
-- ----------------------------
DROP TABLE IF EXISTS `tb_forcollege_ieltstrain`;
CREATE TABLE `tb_forcollege_ieltstrain`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `foreignCollegeId` int(11) NULL DEFAULT NULL,
  `ieltsTrainId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_5vvd1u18tfs777625rrn9iocd`(`foreignCollegeId`) USING BTREE,
  INDEX `FK_a15uiu5xqp103oh1g4hwijt1x`(`ieltsTrainId`) USING BTREE,
  CONSTRAINT `FK_5vvd1u18tfs777625rrn9iocd` FOREIGN KEY (`foreignCollegeId`) REFERENCES `tb_foreign_college` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_a15uiu5xqp103oh1g4hwijt1x` FOREIGN KEY (`ieltsTrainId`) REFERENCES `tb_ielts_train` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_foreign_college
-- ----------------------------
DROP TABLE IF EXISTS `tb_foreign_college`;
CREATE TABLE `tb_foreign_college`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activityTime` datetime(0) NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `visitTime` datetime(0) NULL DEFAULT NULL,
  `foreignName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `foreignType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stat` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `foreignCollegeId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_abtcw7t0n7me97ocbtf5tol7x`(`foreignCollegeId`) USING BTREE,
  CONSTRAINT `FK_abtcw7t0n7me97ocbtf5tol7x` FOREIGN KEY (`foreignCollegeId`) REFERENCES `tb_foreign_college` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_foreign_college_agreement
-- ----------------------------
DROP TABLE IF EXISTS `tb_foreign_college_agreement`;
CREATE TABLE `tb_foreign_college_agreement`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `agreementId` int(11) NULL DEFAULT NULL,
  `foreignCollegeId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_f8yvaiw9463po6fs97f64chc6`(`agreementId`) USING BTREE,
  INDEX `FK_olim817tcjs3smloiy17eb4ms`(`foreignCollegeId`) USING BTREE,
  CONSTRAINT `FK_f8yvaiw9463po6fs97f64chc6` FOREIGN KEY (`agreementId`) REFERENCES `tb_agreement` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_olim817tcjs3smloiy17eb4ms` FOREIGN KEY (`foreignCollegeId`) REFERENCES `tb_foreign_college` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_ielts_exam
-- ----------------------------
DROP TABLE IF EXISTS `tb_ielts_exam`;
CREATE TABLE `tb_ielts_exam`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examPlace` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examTime` datetime(0) NULL DEFAULT NULL,
  `score` int(11) NOT NULL,
  `ieltsTrainId` int(11) NULL DEFAULT NULL,
  `sign` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_1eu9oyfwcl783qd368vks51vs`(`examId`) USING BTREE,
  INDEX `FK_228jrw1ghf61vrxm5tnnv8i3x`(`ieltsTrainId`) USING BTREE,
  CONSTRAINT `FK_228jrw1ghf61vrxm5tnnv8i3x` FOREIGN KEY (`ieltsTrainId`) REFERENCES `tb_ielts_train` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_ielts_train
-- ----------------------------
DROP TABLE IF EXISTS `tb_ielts_train`;
CREATE TABLE `tb_ielts_train`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ieltsTrainId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trainClassHours` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trainName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trainTerm` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trainTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_nv247yh5q0jo239dgldkh1vmv`(`ieltsTrainId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_international_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_international_student`;
CREATE TABLE `tb_international_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `major` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stuId` bigint(20) NULL DEFAULT NULL,
  `classInfoId` int(11) NULL DEFAULT NULL,
  `exchangeStudentId` int(11) NULL DEFAULT NULL,
  `overSeasStudentId` int(11) NULL DEFAULT NULL,
  `summerCampId` int(11) NULL DEFAULT NULL,
  `userId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_1qv8tkr69ynafr2ov9visl5dl`(`exchangeStudentId`) USING BTREE,
  UNIQUE INDEX `UK_4puaiyfumsrfku7r4bw71uh9c`(`userId`) USING BTREE,
  INDEX `FK_1gbfevd3tewn1pe5h8qevsvo1`(`classInfoId`) USING BTREE,
  INDEX `FK_gjbulfkqyugfn6bh5htptom5d`(`overSeasStudentId`) USING BTREE,
  INDEX `FK_c7dwihwf57kidv5d0i1fa2u31`(`summerCampId`) USING BTREE,
  CONSTRAINT `FK_1gbfevd3tewn1pe5h8qevsvo1` FOREIGN KEY (`classInfoId`) REFERENCES `tb_classes_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_1qv8tkr69ynafr2ov9visl5dl` FOREIGN KEY (`exchangeStudentId`) REFERENCES `tb_exchange_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_4puaiyfumsrfku7r4bw71uh9c` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_c7dwihwf57kidv5d0i1fa2u31` FOREIGN KEY (`summerCampId`) REFERENCES `tb_summer_camp` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_gjbulfkqyugfn6bh5htptom5d` FOREIGN KEY (`overSeasStudentId`) REFERENCES `tb_overseas_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_interstu_exam
-- ----------------------------
DROP TABLE IF EXISTS `tb_interstu_exam`;
CREATE TABLE `tb_interstu_exam`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ieltsExamId` int(11) NULL DEFAULT NULL,
  `internationalStudentId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_s4xcgdxn111e40va1qaor3ta9`(`ieltsExamId`) USING BTREE,
  INDEX `FK_40x9yta5cib1mrb6ye0wr7n9a`(`internationalStudentId`) USING BTREE,
  CONSTRAINT `FK_40x9yta5cib1mrb6ye0wr7n9a` FOREIGN KEY (`internationalStudentId`) REFERENCES `tb_international_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_s4xcgdxn111e40va1qaor3ta9` FOREIGN KEY (`ieltsExamId`) REFERENCES `tb_ielts_exam` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_interstu_train
-- ----------------------------
DROP TABLE IF EXISTS `tb_interstu_train`;
CREATE TABLE `tb_interstu_train`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ieltsTrainId` int(11) NULL DEFAULT NULL,
  `internationalStudentId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_p8474i3fbgflvhdpup1o7tu7v`(`ieltsTrainId`) USING BTREE,
  INDEX `FK_dchrbe02w52lsj0yuqcmnuugn`(`internationalStudentId`) USING BTREE,
  CONSTRAINT `FK_dchrbe02w52lsj0yuqcmnuugn` FOREIGN KEY (`internationalStudentId`) REFERENCES `tb_international_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_p8474i3fbgflvhdpup1o7tu7v` FOREIGN KEY (`ieltsTrainId`) REFERENCES `tb_ielts_train` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu`  (
  `CID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CICONCLS` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CNAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CSEQ` decimal(22, 0) NULL DEFAULT NULL,
  `CURL` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CPID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`CID`) USING BTREE,
  INDEX `FK_svr2tx4nm1w2s5t5lyfu2np54`(`CPID`) USING BTREE,
  CONSTRAINT `FK_svr2tx4nm1w2s5t5lyfu2np54` FOREIGN KEY (`CPID`) REFERENCES `tb_menu` (`CID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('bjgl', 'icon-classInfo', '班级管理', 2, '/classesInfo!classesInfos.action', 'gjxxgl');
INSERT INTO `tb_menu` VALUES ('gjxxgl', 'icon-international', '国际信息管理', 1, '', NULL);
INSERT INTO `tb_menu` VALUES ('icms', 'icon-system', '系统信息管理', 1, '', NULL);
INSERT INTO `tb_menu` VALUES ('jsgl', 'icon-role', '角色管理', 2, '/role!role.action', 'icms');
INSERT INTO `tb_menu` VALUES ('qxgl', 'icon-auth', '权限管理', 3, '/auth!auth.action', 'icms');
INSERT INTO `tb_menu` VALUES ('xwgl', 'icon-newsPub', '新闻管理', 1, '/pubNews!news.action', 'xxfb');
INSERT INTO `tb_menu` VALUES ('xxfb', 'icon-publish', '信息发布管理', 3, NULL, NULL);
INSERT INTO `tb_menu` VALUES ('xygl', 'icon-collegeInfo', '学院管理', 2, '/collegeInfo!collegeInfos.action', 'gjxxgl');
INSERT INTO `tb_menu` VALUES ('yhgl', 'icon-user', '用户管理', 1, '/user!user.action', 'icms');

-- ----------------------------
-- Table structure for tb_news
-- ----------------------------
DROP TABLE IF EXISTS `tb_news`;
CREATE TABLE `tb_news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `createTime` datetime(0) NULL DEFAULT NULL,
  `people` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_notice
-- ----------------------------
DROP TABLE IF EXISTS `tb_notice`;
CREATE TABLE `tb_notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `createTime` datetime(0) NULL DEFAULT NULL,
  `people` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_overseas_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_overseas_student`;
CREATE TABLE `tb_overseas_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goAbroadTime` datetime(0) NULL DEFAULT NULL,
  `replaceCourse` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `replaceCredit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `schoolName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `schoolType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_policy
-- ----------------------------
DROP TABLE IF EXISTS `tb_policy`;
CREATE TABLE `tb_policy`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `createTime` datetime(0) NULL DEFAULT NULL,
  `people` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `CID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CDESC` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CNAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`CID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('0', '拥有系统所有权限', '超级管理员');
INSERT INTO `tb_role` VALUES ('1', NULL, '访客');
INSERT INTO `tb_role` VALUES ('4b110571-a61c-4e00-b3d8-e4e875278a13', '新闻管理', '新闻管理员');
INSERT INTO `tb_role` VALUES ('5d0a1a22-06df-4e03-bfda-0480eeed24b3', '负责角色管理', '角色管理员');

-- ----------------------------
-- Table structure for tb_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_auth`;
CREATE TABLE `tb_role_auth`  (
  `CID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CAUTHID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CROLEID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`CID`) USING BTREE,
  INDEX `FK_a7nmnv83am0ip7e5cwlulpgwr`(`CAUTHID`) USING BTREE,
  INDEX `FK_s38lcs55ghyx2y63wqj2wypex`(`CROLEID`) USING BTREE,
  CONSTRAINT `FK_a7nmnv83am0ip7e5cwlulpgwr` FOREIGN KEY (`CAUTHID`) REFERENCES `tb_auth` (`CID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_s38lcs55ghyx2y63wqj2wypex` FOREIGN KEY (`CROLEID`) REFERENCES `tb_role` (`CID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role_auth
-- ----------------------------
INSERT INTO `tb_role_auth` VALUES ('00d72c04-aed2-4d52-8a44-0175c3b10af7', 'yhxg', '0');
INSERT INTO `tb_role_auth` VALUES ('01248c9a-b78f-4c02-a870-941ae7df31b8', 'bjsc', '0');
INSERT INTO `tb_role_auth` VALUES ('01578e7d-d813-46c3-9fee-2e71552126e4', 'xwtjym', '0');
INSERT INTO `tb_role_auth` VALUES ('02cdc2ea-7a32-4226-9dde-23536f0c1514', 'xwsc', '0');
INSERT INTO `tb_role_auth` VALUES ('05ac312e-c3a0-4dce-bce4-8c692d80805d', 'jsbjym', '5d0a1a22-06df-4e03-bfda-0480eeed24b3');
INSERT INTO `tb_role_auth` VALUES ('07307761-7922-4a37-8985-4d274948c4c2', 'jstj', '5d0a1a22-06df-4e03-bfda-0480eeed24b3');
INSERT INTO `tb_role_auth` VALUES ('0c7c02aa-5296-497b-9f65-afd611abb00d', 'jssc', '5d0a1a22-06df-4e03-bfda-0480eeed24b3');
INSERT INTO `tb_role_auth` VALUES ('0f570a09-c49a-4943-8e6c-64e02f167200', 'qxcx', '0');
INSERT INTO `tb_role_auth` VALUES ('18322aba-444a-4aaf-b1ed-4d65207edc19', 'qxtj', '0');
INSERT INTO `tb_role_auth` VALUES ('1b8819d5-548c-4684-b0b4-8116dea6c421', 'xyglym', '0');
INSERT INTO `tb_role_auth` VALUES ('1d6f761c-2b95-4b6a-b022-2e9393c2759f', 'bjtj', '0');
INSERT INTO `tb_role_auth` VALUES ('239899cc-7187-4c88-8b22-72c714c868ed', 'xytj', '0');
INSERT INTO `tb_role_auth` VALUES ('25fe34ef-b7bf-4bad-808c-77c1818233b6', 'qxsc', '0');
INSERT INTO `tb_role_auth` VALUES ('2ce0b9fc-f832-46a9-b4f1-70b8fd1ba46e', 'xwgl', '0');
INSERT INTO `tb_role_auth` VALUES ('2e08115f-76ad-4c97-be31-0e18c9b97603', 'jsglym', '0');
INSERT INTO `tb_role_auth` VALUES ('3804bb33-55a4-4e15-b972-d365cd78e25a', 'yhgl', '0');
INSERT INTO `tb_role_auth` VALUES ('3b960466-94df-436e-9dc5-bae801f75dfa', 'xwyl', '4b110571-a61c-4e00-b3d8-e4e875278a13');
INSERT INTO `tb_role_auth` VALUES ('3edd87db-b6a8-4857-9ff0-de80baf5c829', 'qxglym', '0');
INSERT INTO `tb_role_auth` VALUES ('3efdd52e-81e5-439a-8297-6f0466f2ee17', 'jsplbj', '0');
INSERT INTO `tb_role_auth` VALUES ('414465eb-5b94-4113-8312-7e9af523b8f1', 'xwxg', '4b110571-a61c-4e00-b3d8-e4e875278a13');
INSERT INTO `tb_role_auth` VALUES ('4494e171-8896-4aa2-a4bd-31d63c6be237', 'yhtj', '0');
INSERT INTO `tb_role_auth` VALUES ('49f61adf-33f5-43ea-86f3-4f2769da7f5b', 'qxgl', '0');
INSERT INTO `tb_role_auth` VALUES ('4ae47278-2cde-43a3-a1b8-c56dc4d7ae6e', 'xwtj', '4b110571-a61c-4e00-b3d8-e4e875278a13');
INSERT INTO `tb_role_auth` VALUES ('54266ebc-c340-472e-8fa5-76e0de04ea06', 'icms', '0');
INSERT INTO `tb_role_auth` VALUES ('55eb1e62-d8f1-428d-adba-4a342a8442d6', 'xyglym', '0');
INSERT INTO `tb_role_auth` VALUES ('5b10cb64-ef25-497d-8488-2decb3c55a53', 'jstj', '0');
INSERT INTO `tb_role_auth` VALUES ('5c8f8f38-f1a7-470c-a7b1-c8ff45b384aa', 'jstjym', '5d0a1a22-06df-4e03-bfda-0480eeed24b3');
INSERT INTO `tb_role_auth` VALUES ('5e700ea3-4a47-4691-9404-3ec345da07f7', 'jstjym', '0');
INSERT INTO `tb_role_auth` VALUES ('5f08a6a8-5055-47a1-a3f6-6eeda697ba42', 'xwsc', '4b110571-a61c-4e00-b3d8-e4e875278a13');
INSERT INTO `tb_role_auth` VALUES ('60408790-b187-4136-8462-33c95f6000d4', 'yhsc', '0');
INSERT INTO `tb_role_auth` VALUES ('65b0c993-2bf5-4bc2-a360-818996e3d56c', 'xysc', '0');
INSERT INTO `tb_role_auth` VALUES ('65f567bd-a12e-4c06-89ac-a97a1a79d2f3', 'jsglym', '5d0a1a22-06df-4e03-bfda-0480eeed24b3');
INSERT INTO `tb_role_auth` VALUES ('667191ec-9009-4bf8-ac1c-7f7deb8523e1', 'jscx', '0');
INSERT INTO `tb_role_auth` VALUES ('67b00ec8-9460-451f-8bac-7ad3c48b9dea', 'jsbj', '0');
INSERT INTO `tb_role_auth` VALUES ('69641440-e559-4557-b39b-091c9b5599dc', 'qxbj', '0');
INSERT INTO `tb_role_auth` VALUES ('6df44ddd-853d-481b-b842-51cfebc7810d', 'jsbjym', '0');
INSERT INTO `tb_role_auth` VALUES ('71754550-7b0c-4368-9694-2f4b8cc6f0aa', 'jssc', '0');
INSERT INTO `tb_role_auth` VALUES ('7380ad23-4f1a-46d6-a536-f29bcbf05d94', 'bjglym', '0');
INSERT INTO `tb_role_auth` VALUES ('7398ea2e-1803-4952-a918-fd2c4e9931ae', 'xwgl', '4b110571-a61c-4e00-b3d8-e4e875278a13');
INSERT INTO `tb_role_auth` VALUES ('748a70f0-250d-4d57-ab2f-d8930e9567ae', 'xwxgym', '0');
INSERT INTO `tb_role_auth` VALUES ('7f972a4d-5261-4dd9-84f2-2e15d70ffaeb', 'jsgl', '0');
INSERT INTO `tb_role_auth` VALUES ('7fdf4fa9-ca32-44df-8ae0-157330bba46c', 'xwcx', '0');
INSERT INTO `tb_role_auth` VALUES ('80ef2f64-3baf-474a-ae2c-93628b463dfd', 'yhglym', '0');
INSERT INTO `tb_role_auth` VALUES ('8490c363-95f0-499b-b311-5d83c520538c', 'gjxxgl', '0');
INSERT INTO `tb_role_auth` VALUES ('8607bf9b-5f86-4238-83e9-f9e8d0126c61', 'yhxgym', '0');
INSERT INTO `tb_role_auth` VALUES ('89d5bfcb-cc02-4bf9-bf0a-b4dde2c7ffa9', 'bjxg', '0');
INSERT INTO `tb_role_auth` VALUES ('8a000a4d-61bd-4a25-8d3d-0e1c9e659a56', 'qxtjym', '0');
INSERT INTO `tb_role_auth` VALUES ('9965bf9e-7924-473e-9b0d-d9105869c670', 'jsbj', '5d0a1a22-06df-4e03-bfda-0480eeed24b3');
INSERT INTO `tb_role_auth` VALUES ('9ab5fc8d-df06-4cea-883f-d449d66b9d8f', 'xwtj', '0');
INSERT INTO `tb_role_auth` VALUES ('a02b6227-b3d0-4dbc-a0a3-d90e2de7dfe3', 'yhtjym', '0');
INSERT INTO `tb_role_auth` VALUES ('a78e5189-c59b-4625-a997-f166efd49577', 'bjxgym', '0');
INSERT INTO `tb_role_auth` VALUES ('a8523356-b73b-4641-ac59-4c28241ab904', 'xycx', '0');
INSERT INTO `tb_role_auth` VALUES ('a8571f56-0331-403a-a93f-b62101ad522d', 'jsgl', '5d0a1a22-06df-4e03-bfda-0480eeed24b3');
INSERT INTO `tb_role_auth` VALUES ('a8cdadd9-c2c6-44ba-b7fa-081c6fd8843b', 'xytjym', '0');
INSERT INTO `tb_role_auth` VALUES ('a9a5e212-be76-4278-985b-0319dbdb8edf', 'xwxgym', '4b110571-a61c-4e00-b3d8-e4e875278a13');
INSERT INTO `tb_role_auth` VALUES ('ad75b61c-a7a3-4875-a50a-75fdae5f12a0', 'jscx', '5d0a1a22-06df-4e03-bfda-0480eeed24b3');
INSERT INTO `tb_role_auth` VALUES ('b0858fdc-4b4d-4b49-8f95-5c5f5415f104', 'xwglym', '4b110571-a61c-4e00-b3d8-e4e875278a13');
INSERT INTO `tb_role_auth` VALUES ('b1a77f64-83d6-4a4c-b4f7-766457fa2464', 'xygl', '0');
INSERT INTO `tb_role_auth` VALUES ('b375aef2-602c-48c9-a3b9-bcf69c25cefd', 'xwxg', '0');
INSERT INTO `tb_role_auth` VALUES ('be7032b2-7aa2-4219-a322-bad94b333006', 'xwcx', '4b110571-a61c-4e00-b3d8-e4e875278a13');
INSERT INTO `tb_role_auth` VALUES ('beea24a6-f710-4fc2-8930-60fcbc0773ed', 'jsplbjym', '0');
INSERT INTO `tb_role_auth` VALUES ('bf8f6d74-b29b-4924-8dfb-7478c645b3ad', 'qxbjym', '0');
INSERT INTO `tb_role_auth` VALUES ('c6b3d729-5a28-4e6c-93aa-4fc669a46991', 'xxfbgl', '0');
INSERT INTO `tb_role_auth` VALUES ('c765e846-268e-426b-89aa-4a9bc35ed02d', 'yhcx', '0');
INSERT INTO `tb_role_auth` VALUES ('c8377489-fe23-4403-8278-7e8e390aeb1c', 'xyxg', '0');
INSERT INTO `tb_role_auth` VALUES ('ca196969-a6c6-4894-b905-66e85e9b6ebf', 'qxglym', '0');
INSERT INTO `tb_role_auth` VALUES ('e5fbf063-d501-4fe2-88ab-85ce739edd0d', 'xyxgym', '0');
INSERT INTO `tb_role_auth` VALUES ('ed78265f-6cc4-435d-83c8-e30a03e139b9', 'xwglym', '0');
INSERT INTO `tb_role_auth` VALUES ('efe70709-0377-4b38-9e11-625665418534', 'xwtjym', '4b110571-a61c-4e00-b3d8-e4e875278a13');
INSERT INTO `tb_role_auth` VALUES ('f43e8a64-bfca-42a4-963f-db1d1ce5aa9c', 'bjtjym', '0');
INSERT INTO `tb_role_auth` VALUES ('f8d447a8-a47a-4b30-bac9-5b2f0b8ef86e', 'bjgl', '0');

-- ----------------------------
-- Table structure for tb_summer_camp
-- ----------------------------
DROP TABLE IF EXISTS `tb_summer_camp`;
CREATE TABLE `tb_summer_camp`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activityTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `birthday` datetime(0) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `creator` int(11) NULL DEFAULT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` int(11) NULL DEFAULT NULL,
  `locked` int(11) NULL DEFAULT NULL,
  `loginDate` datetime(0) NULL DEFAULT NULL,
  `loginIp` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `photo` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sign` int(11) NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL,
  `updater` int(11) NULL DEFAULT NULL,
  `userName` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userNo` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `collegeId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_66g462c6tcv9umbhe8gkes5kh`(`collegeId`) USING BTREE,
  CONSTRAINT `FK_66g462c6tcv9umbhe8gkes5kh` FOREIGN KEY (`collegeId`) REFERENCES `tb_college_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, '2018-06-12 11:21:33', '2018-06-13 16:45:05', 1, '764974@qq.com', 1, 0, '2018-06-12 11:23:21', '127.0.0.1', '21232f297a57a5a743894a0e4a801fc3', '', NULL, NULL, 0, '2018-06-12 16:45:26', 1, '张润', 'admin', 1);
INSERT INTO `tb_user` VALUES (2, NULL, '2018-06-13 19:56:47', 0, '1192686412@qq.com', 0, 0, NULL, NULL, '202cb962ac59075b964b07152d234b70', NULL, NULL, NULL, 0, '2018-06-13 19:56:47', 0, '王博越', 'adminwby', 1);
INSERT INTO `tb_user` VALUES (5, NULL, '2018-06-14 10:44:20', 0, '764974614@qq.com', 0, 0, NULL, NULL, '202cb962ac59075b964b07152d234b70', NULL, NULL, NULL, 0, '2018-06-14 10:44:20', 0, '孔文轩', 'kwx', 1);
INSERT INTO `tb_user` VALUES (6, NULL, '2018-06-14 11:21:16', 0, '123@.com', 0, 0, NULL, NULL, '202cb962ac59075b964b07152d234b70', NULL, NULL, NULL, 0, NULL, 0, '杨宇杰', 'yyj', 1);
INSERT INTO `tb_user` VALUES (7, NULL, '2018-06-14 11:34:55', 0, '123@.com', 0, 0, NULL, NULL, '202cb962ac59075b964b07152d234b70', NULL, NULL, NULL, 1, '2018-06-14 11:34:55', 0, '王成彬', 'wcb', 1);
INSERT INTO `tb_user` VALUES (8, NULL, '2018-06-14 11:37:32', 0, '77@qq.com', 0, 0, NULL, NULL, '202cb962ac59075b964b07152d234b70', NULL, NULL, NULL, 1, NULL, 0, '大傻逼', 'qqw', 1);
INSERT INTO `tb_user` VALUES (9, NULL, '2018-06-18 14:14:39', 0, '7649@qq.com', 0, 0, NULL, NULL, '202cb962ac59075b964b07152d234b70', NULL, NULL, NULL, 0, '2018-06-18 14:14:39', 0, '大傻逼2', 'xwgl', 1);

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role`  (
  `CID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CROLEID` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CUSERID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`CID`) USING BTREE,
  INDEX `FK_dloodt7cs8h630hyt387tf5ot`(`CROLEID`) USING BTREE,
  INDEX `FK_r9t7cjbshfs1y2m52uscv3o7k`(`CUSERID`) USING BTREE,
  CONSTRAINT `FK_dloodt7cs8h630hyt387tf5ot` FOREIGN KEY (`CROLEID`) REFERENCES `tb_role` (`CID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_r9t7cjbshfs1y2m52uscv3o7k` FOREIGN KEY (`CUSERID`) REFERENCES `tb_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('75901146-d5e9-4774-9c98-7baf3a2941eb', '0', 1);
INSERT INTO `tb_user_role` VALUES ('941150c7-d706-4971-9b45-5c62356ec621', '1', 5);
INSERT INTO `tb_user_role` VALUES ('966e1ab2-84a9-4762-8317-6a433a95abdc', '5d0a1a22-06df-4e03-bfda-0480eeed24b3', 7);
INSERT INTO `tb_user_role` VALUES ('9c3e3dfd-dd7a-451f-aa80-48e4a4c516da', '4b110571-a61c-4e00-b3d8-e4e875278a13', 9);
INSERT INTO `tb_user_role` VALUES ('ba05a31e-355e-4a67-9ccc-ba6bee9bf94d', '4b110571-a61c-4e00-b3d8-e4e875278a13', 6);
INSERT INTO `tb_user_role` VALUES ('bebc2e5a-36d2-4cb1-b3e4-5ccc500e9c89', '5d0a1a22-06df-4e03-bfda-0480eeed24b3', 8);

SET FOREIGN_KEY_CHECKS = 1;
