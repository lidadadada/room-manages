/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : room_manage

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-02-18 14:32:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `serial_num` int(11) NOT NULL AUTO_INCREMENT,
  `pre_people_id` int(11) DEFAULT NULL,
  `pre_room_num` varchar(50) DEFAULT NULL,
  `pre_theme` varchar(100) DEFAULT NULL,
  `pre_day` date DEFAULT NULL,
  `pre_start_time` time DEFAULT NULL,
  `pre_end_time` time DEFAULT NULL,
  `pre_jion` int(11) DEFAULT '0',
  `pre_member_path` varchar(100) DEFAULT NULL,
  `pre_picture_path` varchar(100) DEFAULT NULL,
  `other` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`serial_num`),
  KEY `pre_people_id` (`pre_people_id`) USING BTREE,
  KEY `pre_room_num` (`pre_room_num`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('81', '1', '1117房间', 'ssd', '2019-02-16', '11:30:00', '00:00:00', '1', 'book/ssd2019-02-16/member.txt', null, 'ddd');
INSERT INTO `book` VALUES ('82', '1', '1116房间', 'ljlk', '2019-02-16', '07:00:00', '09:00:00', '1', 'book/ljlk2019-02-16/member.txt', null, 'ioujoi');
INSERT INTO `book` VALUES ('83', '1', '1116房间', 'fasgggg', '2019-02-16', '15:00:00', '16:00:00', '1', 'book/fasgggg2019-02-16/member.txt', null, 'ggsfs');
INSERT INTO `book` VALUES ('84', '1', '1117房间', 'dfsaga', '2019-02-16', '07:00:00', '09:00:00', '0', 'book/dfsaga2019-02-16/member.txt', null, 'gsadg gg');
INSERT INTO `book` VALUES ('85', '1', '1117房间', 'fasdfg', '2019-02-16', '10:30:00', '11:00:00', '0', 'book/fasdfg2019-02-16/member.txt', null, 'ggasfsa');
INSERT INTO `book` VALUES ('86', '1', '1117房间', 'fsadfg', '2019-02-16', '11:00:00', '11:30:00', '1', 'book/fsadfg2019-02-16/member.txt', null, 'sdfsaf');
INSERT INTO `book` VALUES ('87', '1', '1117房间', 'fasg', '2019-02-16', '12:00:00', '14:00:00', '1', 'book/fasg2019-02-16/member.txt', null, 'fasgg');
INSERT INTO `book` VALUES ('88', '1', '1117房间', 'dasfg', '2019-02-17', '09:00:00', '09:30:00', '1', 'book/dasfg2019-02-17/member.txt', null, 'fsagsafsfsadfasggfsafsf');
INSERT INTO `book` VALUES ('89', '1', '1116房间', 'sdafdasg', '2019-02-17', '09:30:00', '10:30:00', '1', 'book/sdafdasg2019-02-17/member.txt', null, 'gasdfas');
INSERT INTO `book` VALUES ('90', '1', '1116房间', 'fsadgas', '2019-02-17', '10:30:00', '12:00:00', '1', 'book/fsadgas2019-02-17/member.txt', null, 'gsadggsdgfs');
INSERT INTO `book` VALUES ('91', '1', '1116房间', 'fasdgasg', '2019-02-17', '12:30:00', '14:00:00', '1', 'book/fasdgasg2019-02-17/member.txt', null, 'gasgsagsdfsf');
INSERT INTO `book` VALUES ('92', '1', '1116房间', 'sdfsa', '2019-02-17', '14:00:00', '15:00:00', '1', 'book/sdfsa2019-02-17/member.txt', null, 'gsgsdf');
INSERT INTO `book` VALUES ('93', '1', '1116房间', '大法官', '2019-02-17', '15:00:00', '16:00:00', '1', 'book/大法官2019-02-17/member.txt', null, '大噶');
INSERT INTO `book` VALUES ('94', '2', '1117房间', '号的', '2019-02-17', '07:00:00', '07:30:00', '1', 'book/号的2019-02-17/member.txt', null, '顶顶顶');
INSERT INTO `book` VALUES ('95', '2', '1117房间', '订单', '2019-02-17', '07:30:00', '08:00:00', '1', 'book/订单2019-02-17/member.txt', null, '订单');
INSERT INTO `book` VALUES ('96', '2', '1117房间', 'ddddd', '2019-02-17', '08:00:00', '08:30:00', '1', 'book/ddddd2019-02-17/member.txt', null, 'ddd');
INSERT INTO `book` VALUES ('97', '2', '1116房间', '订单的', '2019-02-17', '07:00:00', '07:30:00', '0', 'book/22019-02-17/member.txt', null, '顶顶顶');
INSERT INTO `book` VALUES ('98', '2', '1117房间', '科', '2019-02-17', '09:30:00', '10:00:00', '1', 'book/22019-02-17/member.txt', null, 'hadgah');
INSERT INTO `book` VALUES ('99', '2', '1117房间', '看看电视看', '2019-02-17', '08:30:00', '09:00:00', '0', 'book/2cd5c02019-02-17/member.txt', null, '第三方');

-- ----------------------------
-- Table structure for `book_file`
-- ----------------------------
DROP TABLE IF EXISTS `book_file`;
CREATE TABLE `book_file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_owner_id` int(11) DEFAULT NULL,
  `file_book_id` int(11) DEFAULT NULL,
  `file_title` varchar(50) DEFAULT NULL,
  `file_sava_path` varchar(100) DEFAULT NULL,
  `file_other` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_file
-- ----------------------------
INSERT INTO `book_file` VALUES ('9', '1', '53', 'eclipse.exe', 'D:\\room\\room-manages\\sadgas2019-02-13\\files\\eclipse.exe', 'd对方');
INSERT INTO `book_file` VALUES ('10', '1', '53', '大师傅.xml', 'D:\\room\\room-manages\\sadgas2019-02-13\\files\\大师傅.xml', '的');
INSERT INTO `book_file` VALUES ('11', '1', '53', 'artifacts.xml', 'D:\\room\\room-manages\\sadgas2019-02-13\\files\\artifacts.xml', '的');
INSERT INTO `book_file` VALUES ('12', '1', '83', 'd.exe', '172.20.10.2:21//book/fasgggg2019-02-16/files/d.exe', 'd');
INSERT INTO `book_file` VALUES ('13', '2', '88', 'a.ini', 'book/dasfg2019-02-17/files/a.ini', 'sdfsadf');
INSERT INTO `book_file` VALUES ('14', '2', '88', 'a.exe', 'book/dasfg2019-02-17/files/a.exe', 'a');

-- ----------------------------
-- Table structure for `join_apply`
-- ----------------------------
DROP TABLE IF EXISTS `join_apply`;
CREATE TABLE `join_apply` (
  `join_id` int(11) NOT NULL AUTO_INCREMENT,
  `join_people_id` int(11) DEFAULT NULL,
  `join_book_id` int(11) DEFAULT NULL,
  `join_book_owner_id` int(11) DEFAULT NULL,
  `join_deal_state` int(11) DEFAULT '0',
  `join_other` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`join_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of join_apply
-- ----------------------------
INSERT INTO `join_apply` VALUES ('2', '2', '81', '1', '1', '');

-- ----------------------------
-- Table structure for `manage_people`
-- ----------------------------
DROP TABLE IF EXISTS `manage_people`;
CREATE TABLE `manage_people` (
  `manage_name` varchar(25) NOT NULL,
  `manage_password` varchar(25) DEFAULT NULL,
  `manage_phone` varchar(25) DEFAULT NULL,
  `manage_empid` int(11) DEFAULT NULL,
  PRIMARY KEY (`manage_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manage_people
-- ----------------------------
INSERT INTO `manage_people` VALUES ('root', 'root', '123456', '1606010312');

-- ----------------------------
-- Table structure for `people`
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `peo_serial_num` int(11) NOT NULL AUTO_INCREMENT,
  `peo_employee_id` int(11) DEFAULT NULL,
  `peo_employee_name` varchar(25) DEFAULT NULL,
  `peo_password` varchar(50) DEFAULT NULL,
  `peo_phone` varchar(15) DEFAULT NULL,
  `peo_post` varchar(50) DEFAULT NULL,
  `peo_address` varchar(50) DEFAULT NULL,
  `peo_email` varchar(50) DEFAULT NULL,
  `peo_image_path` varchar(50) DEFAULT NULL,
  `peo_other` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`peo_serial_num`),
  KEY `peo_employee_id` (`peo_employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=505 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES ('1', '2', '姓名2', 'root2', '1398421', '职位', 'izhi', null, '/myimg/people/2.png', null);
INSERT INTO `people` VALUES ('503', '1', 'root', 'root', '1826262', '职位', '地址', '1@qq.com', '/myimg/people/1.png', '无备注');
INSERT INTO `people` VALUES ('504', '123', 'fdag', 'root2', '12656', null, null, null, null, null);

-- ----------------------------
-- Table structure for `ply`
-- ----------------------------
DROP TABLE IF EXISTS `ply`;
CREATE TABLE `ply` (
  `ply_id` int(11) NOT NULL AUTO_INCREMENT,
  `ply_peo_id` int(11) DEFAULT NULL,
  `ply_peo_name` varchar(50) DEFAULT NULL,
  `ply_peo_picture_path` varchar(100) DEFAULT NULL,
  `ply_book_num` int(11) DEFAULT NULL,
  `ply_time` datetime DEFAULT NULL,
  `ply_message` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ply
-- ----------------------------
INSERT INTO `ply` VALUES ('1', '1', 'root', null, '53', '2019-02-14 21:45:54', '你好啊');
INSERT INTO `ply` VALUES ('2', '2', '姓名2', null, '53', '2019-02-13 21:46:34', '第二');
INSERT INTO `ply` VALUES ('3', '1', 'root', '', '53', '2019-02-15 00:00:00', '所发生的给');
INSERT INTO `ply` VALUES ('4', '1', 'root', '', '53', '2019-02-15 00:00:00', '士大夫');
INSERT INTO `ply` VALUES ('5', '1', 'root', '', '53', '2019-02-15 15:45:03', 'sdagsag');
INSERT INTO `ply` VALUES ('6', '1', 'root', '', '53', '2019-02-15 15:45:15', 'sdfgsdag');
INSERT INTO `ply` VALUES ('7', '1', 'root', '', '53', '2019-02-15 15:45:37', 'dfsagasg');
INSERT INTO `ply` VALUES ('8', '1', 'root', '', '53', '2019-02-15 15:47:02', 'sdagg');
INSERT INTO `ply` VALUES ('9', '1', 'root', '', '53', '2019-02-15 15:47:14', 'fsadgasdf');
INSERT INTO `ply` VALUES ('10', '1', 'root', '', '53', '2019-02-15 15:47:50', 'asdgsadgsdf');
INSERT INTO `ply` VALUES ('11', '1', 'root', '', '53', '2019-02-15 15:49:25', 'dafgasdfa');
INSERT INTO `ply` VALUES ('12', '1', 'root', '', '53', '2019-02-15 17:35:15', 'sdafsf');
INSERT INTO `ply` VALUES ('13', '1', 'root', '', '53', '2019-02-15 17:36:41', 'ddddd');
INSERT INTO `ply` VALUES ('14', '1', 'root', '', '53', '2019-02-15 17:39:16', 'sdfsgfgag');
INSERT INTO `ply` VALUES ('15', '1', 'root', '', '53', '2019-02-15 17:42:16', '订单');
INSERT INTO `ply` VALUES ('16', '1', 'root', '', '53', '2019-02-15 18:44:52', '地方官大使馆');
INSERT INTO `ply` VALUES ('17', '1', 'root', '', '53', '2019-02-15 18:45:11', '地方官大使馆');
INSERT INTO `ply` VALUES ('18', '1', 'root', '', '53', '2019-02-15 18:47:12', 'sdfas');
INSERT INTO `ply` VALUES ('19', '1', 'root', '', '53', '2019-02-15 18:53:31', '都是');
INSERT INTO `ply` VALUES ('20', '1', 'root', '', '81', '2019-02-16 15:59:14', 'df');
INSERT INTO `ply` VALUES ('21', '1', 'root', '', '81', '2019-02-16 15:59:28', '经过刚刚');
INSERT INTO `ply` VALUES ('22', '1', 'root', '/myimg/people/2.png', '81', '2019-02-16 16:58:19', 'dsf');
INSERT INTO `ply` VALUES ('23', '2', '姓名2', '/myimg/people/2.png', '83', '2019-02-16 22:00:27', 'sdaf');
INSERT INTO `ply` VALUES ('24', '2', '姓名2', '/myimg/people/2.png', '82', '2019-02-16 22:00:27', 'sdaf');
INSERT INTO `ply` VALUES ('25', '2', '姓名2', '/myimg/people/2.png', '81', '2019-02-16 22:00:27', 'sdaf');
INSERT INTO `ply` VALUES ('26', '2', '姓名2', '/myimg/people/2.png', '81', '2019-02-16 22:00:27', 'sdaf');
INSERT INTO `ply` VALUES ('27', '2', '姓名2', '/myimg/people/2.png', '82', '2019-02-16 22:00:27', 'sdaf');
INSERT INTO `ply` VALUES ('28', '2', '姓名2', '/myimg/people/2.png', '81', '2019-02-16 22:00:31', 'sdaf');
INSERT INTO `ply` VALUES ('29', '2', '姓名2', '/myimg/people/2.png', '81', '2019-02-16 22:00:31', 'sdaf');
INSERT INTO `ply` VALUES ('30', '2', '姓名2', '/myimg/people/2.png', '82', '2019-02-16 22:00:31', 'sdaf');
INSERT INTO `ply` VALUES ('31', '2', '姓名2', '/myimg/people/2.png', '82', '2019-02-16 22:00:31', 'sdaf');
INSERT INTO `ply` VALUES ('32', '2', '姓名2', '/myimg/people/2.png', '83', '2019-02-16 22:00:31', 'sdaf');
INSERT INTO `ply` VALUES ('33', '2', '姓名2', '/myimg/people/2.png', '81', '2019-02-16 22:00:47', '号');
INSERT INTO `ply` VALUES ('34', '2', '姓名2', '/myimg/people/2.png', '92', '2019-02-17 13:56:07', 'fsdfsad');
INSERT INTO `ply` VALUES ('35', '2', '姓名2', '/myimg/people/2.png', '93', '2019-02-17 13:56:07', 'fsdfsad');
INSERT INTO `ply` VALUES ('36', '2', '姓名2', '/myimg/people/2.png', '81', '2019-02-17 13:56:07', 'fsdfsad');
INSERT INTO `ply` VALUES ('37', '2', '姓名2', '/myimg/people/2.png', '91', '2019-02-17 13:56:07', 'fsdfsad');
INSERT INTO `ply` VALUES ('38', '2', '姓名2', '/myimg/people/2.png', '91', '2019-02-17 13:56:07', 'fsdfsad');
INSERT INTO `ply` VALUES ('39', '2', '姓名2', '/myimg/people/2.png', '85', '2019-02-17 13:56:07', 'fsdfsad');
INSERT INTO `ply` VALUES ('40', '2', '姓名2', '/myimg/people/2.png', '81', '2019-02-17 13:56:07', 'fsdfsad');
INSERT INTO `ply` VALUES ('41', '2', '姓名2', '/myimg/people/2.png', '90', '2019-02-17 13:56:07', 'fsdfsad');
INSERT INTO `ply` VALUES ('42', '2', '姓名2', '/myimg/people/2.png', '90', '2019-02-17 13:56:07', 'fsdfsad');
INSERT INTO `ply` VALUES ('43', '2', '姓名2', '/myimg/people/2.png', '81', '2019-02-17 13:56:16', 'fsdfsad');
INSERT INTO `ply` VALUES ('44', '2', '姓名2', '/myimg/people/2.png', '85', '2019-02-17 13:56:16', 'fsdfsad');
INSERT INTO `ply` VALUES ('45', '2', '姓名2', '/myimg/people/2.png', '92', '2019-02-17 13:56:16', 'fsdfsad');
INSERT INTO `ply` VALUES ('46', '2', '姓名2', '/myimg/people/2.png', '91', '2019-02-17 13:56:16', 'fsdfsad');
INSERT INTO `ply` VALUES ('47', '2', '姓名2', '/myimg/people/2.png', '90', '2019-02-17 13:56:16', 'fsdfsad');
INSERT INTO `ply` VALUES ('48', '2', '姓名2', '/myimg/people/2.png', '93', '2019-02-17 13:56:16', 'fsdfsad');
INSERT INTO `ply` VALUES ('49', '2', '姓名2', '/myimg/people/2.png', '84', '2019-02-17 13:56:16', 'fsdfsad');
INSERT INTO `ply` VALUES ('50', '2', '姓名2', '/myimg/people/2.png', '81', '2019-02-17 13:56:16', 'fsdfsad');
INSERT INTO `ply` VALUES ('51', '2', '姓名2', '/myimg/people/2.png', '85', '2019-02-17 13:56:16', 'fsdfsad');
INSERT INTO `ply` VALUES ('52', '2', '姓名2', '/myimg/people/2.png', '91', '2019-02-17 13:56:16', 'fsdfsad');
INSERT INTO `ply` VALUES ('53', '2', '姓名2', '/myimg/people/2.png', '90', '2019-02-17 13:56:16', 'fsdfsad');

-- ----------------------------
-- Table structure for `reply`
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `reply_id` int(11) NOT NULL AUTO_INCREMENT,
  `reply_peo_id` int(11) DEFAULT NULL,
  `reply_peo_id_name` varchar(50) DEFAULT NULL,
  `reply_to_ply_id` int(11) DEFAULT NULL,
  `reply_to_ply_peo_id` int(11) DEFAULT NULL,
  `reply_to_ply_peo_name` varchar(50) DEFAULT NULL,
  `replyt_time` datetime DEFAULT NULL,
  `reply_message` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '2', '姓名2', '1', '1', 'root', '2019-02-15 21:48:40', '你也好啊');
INSERT INTO `reply` VALUES ('2', '1', 'root', '53', '2', '姓名2', '2019-02-15 17:49:35', '第三方');
INSERT INTO `reply` VALUES ('3', '1', 'root', '53', '2', '姓名2', '2019-02-15 17:50:12', '适当方式改革');
INSERT INTO `reply` VALUES ('4', '1', 'root', '18', '1', 'root', '2019-02-15 18:49:53', '上帝发誓');
INSERT INTO `reply` VALUES ('5', '1', 'root', '1', '2', '姓名2', '2019-02-15 18:50:15', '范德萨');
INSERT INTO `reply` VALUES ('6', '1', 'root', '1', '2', '姓名2', '2019-02-15 18:50:34', '发大水');
INSERT INTO `reply` VALUES ('7', '1', 'root', '18', '1', 'root', '2019-02-15 18:53:21', '撒地方');
INSERT INTO `reply` VALUES ('8', '2', '姓名2', '39', '2', '姓名2', '2019-02-17 15:11:40', '第三方');

-- ----------------------------
-- Table structure for `room_info`
-- ----------------------------
DROP TABLE IF EXISTS `room_info`;
CREATE TABLE `room_info` (
  `room_num` int(11) NOT NULL,
  `room_name` varchar(25) DEFAULT NULL,
  `room_address` varchar(100) DEFAULT NULL,
  `room_max_num` int(11) DEFAULT NULL,
  `room_equipment` varchar(200) DEFAULT NULL,
  `room_other` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`room_num`),
  KEY `room_name` (`room_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_info
-- ----------------------------
INSERT INTO `room_info` VALUES ('1116', '1116房间', '之高楼', '50', '无设备', '无');
INSERT INTO `room_info` VALUES ('1117', '1117房间', '妈妈们楼', '100', '无设备', '无');

-- ----------------------------
-- Table structure for `un_emp_id`
-- ----------------------------
DROP TABLE IF EXISTS `un_emp_id`;
CREATE TABLE `un_emp_id` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of un_emp_id
-- ----------------------------
INSERT INTO `un_emp_id` VALUES ('1', '123456');
