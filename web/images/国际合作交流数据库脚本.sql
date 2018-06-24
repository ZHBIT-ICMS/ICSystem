
/*创建数据库*/
CREATE DATABASE `db_isc` /*!40100 DEFAULT CHARACTER SET utf8 */;
/*创建班级信息表*/
CREATE TABLE `tb_classes_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classNo` varchar(10) DEFAULT NULL,
  `descInfo` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*创建交换生*/
CREATE TABLE `tb_exchange_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goAbroadTime` datetime DEFAULT NULL,
  `replaceCourse` varchar(20) DEFAULT NULL,
  `replaceCredit` varchar(20) DEFAULT NULL,
  `schoolName` varchar(20) DEFAULT NULL,
  `schoolType` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `tb_foreign_college` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `foreignName` varchar(20) DEFAULT NULL,
  `foreignType` varchar(20) DEFAULT NULL,
  `stat` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*创建国外院校&雅思培训中间表*/
CREATE TABLE `tb_forcollege_ieltstrain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `foreignCollegeId` int(11) DEFAULT NULL,
  `ieltsTrainId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5vvd1u18tfs777625rrn9iocd` (`foreignCollegeId`),
  KEY `FK_a15uiu5xqp103oh1g4hwijt1x` (`ieltsTrainId`),
  CONSTRAINT `FK_5vvd1u18tfs777625rrn9iocd` FOREIGN KEY (`foreignCollegeId`) REFERENCES `tb_foreign_college` (`id`),
  CONSTRAINT `FK_a15uiu5xqp103oh1g4hwijt1x` FOREIGN KEY (`ieltsTrainId`) REFERENCES `tb_ielts_train` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*创建雅思考试表*/
CREATE TABLE `tb_ielts_exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examPlace` varchar(50) DEFAULT NULL,
  `examTime` datetime DEFAULT NULL,
  `score` int(11) NOT NULL,
  `ieltsTrainId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_228jrw1ghf61vrxm5tnnv8i3x` (`ieltsTrainId`),
  CONSTRAINT `FK_228jrw1ghf61vrxm5tnnv8i3x` FOREIGN KEY (`ieltsTrainId`) REFERENCES `tb_ielts_train` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*创建雅思培训表*/
CREATE TABLE `tb_ielts_train` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trainClassHours` varchar(20) DEFAULT NULL,
  `trainName` varchar(20) DEFAULT NULL,
  `trainTerm` varchar(20) DEFAULT NULL,
  `trainTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*创建出国学生表*/
CREATE TABLE `tb_international_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `major` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `cId` int(11) DEFAULT NULL,
  `classInfoId` int(11) DEFAULT NULL,
  `summerCampId` int(11) DEFAULT NULL,
  `overSeasStudentId` int(11) DEFAULT NULL,
  `exchangeStudentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1qv8tkr69ynafr2ov9visl5dl` (`exchangeStudentId`),
  KEY `FK_ooyfd17g0kbo5qflfy34tyo5i` (`cId`),
  KEY `FK_1gbfevd3tewn1pe5h8qevsvo1` (`classInfoId`),
  KEY `FK_c7dwihwf57kidv5d0i1fa2u31` (`summerCampId`),
  KEY `FK_gjbulfkqyugfn6bh5htptom5d` (`overSeasStudentId`),
  CONSTRAINT `FK_1gbfevd3tewn1pe5h8qevsvo1` FOREIGN KEY (`classInfoId`) REFERENCES `tb_classes_info` (`id`),
  CONSTRAINT `FK_1qv8tkr69ynafr2ov9visl5dl` FOREIGN KEY (`exchangeStudentId`) REFERENCES `tb_exchange_student` (`id`),
  CONSTRAINT `FK_c7dwihwf57kidv5d0i1fa2u31` FOREIGN KEY (`summerCampId`) REFERENCES `tb_summer_camp` (`id`),
  CONSTRAINT `FK_gjbulfkqyugfn6bh5htptom5d` FOREIGN KEY (`overSeasStudentId`) REFERENCES `tb_overseas_student` (`id`),
  CONSTRAINT `FK_ooyfd17g0kbo5qflfy34tyo5i` FOREIGN KEY (`cId`) REFERENCES `tb_classes_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*创建国际班考试和雅思考试的中间表*/
CREATE TABLE `tb_interstu_exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ieltsExamId` int(11) DEFAULT NULL,
  `internationalStudentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_s4xcgdxn111e40va1qaor3ta9` (`ieltsExamId`),
  KEY `FK_40x9yta5cib1mrb6ye0wr7n9a` (`internationalStudentId`),
  CONSTRAINT `FK_40x9yta5cib1mrb6ye0wr7n9a` FOREIGN KEY (`internationalStudentId`) REFERENCES `tb_international_student` (`id`),
  CONSTRAINT `FK_s4xcgdxn111e40va1qaor3ta9` FOREIGN KEY (`ieltsExamId`) REFERENCES `tb_ielts_exam` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*创建国际班考试和培训的中间表*/
CREATE TABLE `tb_interstu_train` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ieltsTrainId` int(11) DEFAULT NULL,
  `internationalStudentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_p8474i3fbgflvhdpup1o7tu7v` (`ieltsTrainId`),
  KEY `FK_dchrbe02w52lsj0yuqcmnuugn` (`internationalStudentId`),
  CONSTRAINT `FK_dchrbe02w52lsj0yuqcmnuugn` FOREIGN KEY (`internationalStudentId`) REFERENCES `tb_international_student` (`id`),
  CONSTRAINT `FK_p8474i3fbgflvhdpup1o7tu7v` FOREIGN KEY (`ieltsTrainId`) REFERENCES `tb_ielts_train` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*创建新闻信息表*/
CREATE TABLE `tb_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `createTime` datetime DEFAULT NULL,
  `people` varchar(20) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*创建公告表*/
CREATE TABLE `tb_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `createTime` datetime DEFAULT NULL,
  `people` varchar(20) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*创建出国生表*/
CREATE TABLE `tb_overseas_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goAbroadTime` datetime DEFAULT NULL,
  `replaceCourse` varchar(20) DEFAULT NULL,
  `replaceCredit` varchar(20) DEFAULT NULL,
  `schoolName` varchar(20) DEFAULT NULL,
  `schoolType` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*创建政策法规表表*/
CREATE TABLE `tb_policy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `createTime` datetime DEFAULT NULL,
  `people` varchar(20) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*创建夏令营活动表*/
CREATE TABLE `tb_summer_camp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activityTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*创建角色表*/
CREATE TABLE `tb_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(64) DEFAULT NULL COMMENT '角色code',
  `status` char(1) DEFAULT '1' COMMENT '1正常  0删除 -1全部',
  `remark` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `creator` int(20) DEFAULT NULL,
  `updater` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*创建角色表用户中间表*/
CREATE TABLE `tb_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `userId` (`user_id`),
  KEY `roleId` (`role_id`),
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';
/*创建用户表*/
CREATE TABLE `tb_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_no` varchar(128) DEFAULT NULL COMMENT '用户编号',
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `name` varchar(64) DEFAULT NULL COMMENT '用户姓名',
  `nickname` varchar(64) DEFAULT NULL COMMENT '昵称',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `login_ip` varchar(128) DEFAULT NULL COMMENT '登录ip',
  `login_date` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `photo` varchar(512) DEFAULT NULL COMMENT '用户头像',
  `phone` varchar(16) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `geneder` int(2) DEFAULT NULL COMMENT '性别 0不详 1男  2女',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门id',
  `locked` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否锁定 1锁定 0未锁定',
  `remark` varchar(512) DEFAULT NULL COMMENT '描述',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '1正常  0删除 -1全部',
  `creator` int(20) DEFAULT NULL COMMENT '创建者',
  `updater` int(20) DEFAULT NULL COMMENT '更新者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)


 
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='系统用户表';


/*创建链接表*/
CREATE TABLE `tb_resources` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(64) DEFAULT '' COMMENT '资源地址',
  `parent_id` int(20) DEFAULT NULL,
  `perm_code` varchar(64) DEFAULT NULL COMMENT '权限编码',
  `iconCls` varchar(64) DEFAULT NULL COMMENT '资源图标',
  `level` int(4) DEFAULT NULL COMMENT '资源级别',
  `sort` int(8) DEFAULT NULL COMMENT '排序',
  `type` char(1) DEFAULT NULL COMMENT '1菜单 2 权限 ',
  `remark` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` int(20) DEFAULT NULL COMMENT '更新者',
  `creator` int(20) DEFAULT NULL COMMENT '创建者',
  `status` char(1) DEFAULT '1' COMMENT '1正常  0删除 -1全部',
  PRIMARY KEY (`id`),
  KEY `parentId` (`parent_id`),
  CONSTRAINT `sys_resources_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `tb_resources` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='资源表';
/*创建链接用户表表*/
CREATE TABLE `tb_role_resources` (
  `role_id` int(11) NOT NULL,
  `resources_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`resources_id`),
  KEY `sys_role_privilege_ibfk_1` (`role_id`),
  KEY `sys_role_privilege_ibfk_2` (`resources_id`),
  CONSTRAINT `sys_role_resources_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE CASCADE,
  CONSTRAINT `sys_role_resources_ibfk_2` FOREIGN KEY (`resources_id`) REFERENCES `tb_resources` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源表';