/*
Navicat MySQL Data Transfer

Source Server         : 本机数据库
Source Server Version : 50096
Source Host           : localhost:3307
Source Database       : androidpn

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2015-05-26 22:56:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for send_message_tb
-- ----------------------------
DROP TABLE IF EXISTS `send_message_tb`;
CREATE TABLE `send_message_tb` (
  `id` int(11) NOT NULL auto_increment,
  `message` text,
  `send_time` timestamp NOT NULL default '0000-00-00 00:00:00' on update CURRENT_TIMESTAMP,
  `send_uuid` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7033 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of send_message_tb
-- ----------------------------
INSERT INTO `send_message_tb` VALUES ('6954', 'ce953faa-ff46-4548-bdc2-bbce66e6ab93', '2015-05-05 11:05:24', '经过考核');
INSERT INTO `send_message_tb` VALUES ('6955', 'ce953faa-ff46-4548-bdc2-bbce66e6ab93', '2015-05-05 11:05:24', '经过考核');
INSERT INTO `send_message_tb` VALUES ('6956', 'd09aba2a-7968-425a-94cc-9ed048b5d2e3', '2015-05-05 11:12:32', '吧vfdaf\r\n');
INSERT INTO `send_message_tb` VALUES ('6957', 'd09aba2a-7968-425a-94cc-9ed048b5d2e3', '2015-05-05 11:12:32', '吧vfdaf\r\n');
INSERT INTO `send_message_tb` VALUES ('6958', 'd09aba2a-7968-425a-94cc-9ed048b5d2e3', '2015-05-05 11:12:32', '吧vfdaf\r\n');
INSERT INTO `send_message_tb` VALUES ('6959', 'd09aba2a-7968-425a-94cc-9ed048b5d2e3', '2015-05-05 11:12:33', '吧vfdaf\r\n');
INSERT INTO `send_message_tb` VALUES ('6960', 'd09aba2a-7968-425a-94cc-9ed048b5d2e3', '2015-05-05 11:12:33', '吧vfdaf\r\n');
INSERT INTO `send_message_tb` VALUES ('6961', 'b39e05ab-69a3-4cb6-bc83-e01019646f6b', '2015-05-05 11:21:37', 'gjjhv');
INSERT INTO `send_message_tb` VALUES ('6962', 'b39e05ab-69a3-4cb6-bc83-e01019646f6b', '2015-05-05 11:22:51', '警察');
INSERT INTO `send_message_tb` VALUES ('6963', 'b39e05ab-69a3-4cb6-bc83-e01019646f6b', '2015-05-05 11:25:23', '警察');
INSERT INTO `send_message_tb` VALUES ('6964', '32e03d2c-12a0-4293-8118-bbabb7714ee8', '2015-05-05 11:51:15', 'jhfqwfqwd');
INSERT INTO `send_message_tb` VALUES ('6965', '644adc46-1507-4165-b3c3-48fa4c26b395', '2015-05-05 11:51:48', 'jhfqwfqwd');
INSERT INTO `send_message_tb` VALUES ('6966', '644adc46-1507-4165-b3c3-48fa4c26b395', '2015-05-05 11:51:49', 'jhfqwfqwd');
INSERT INTO `send_message_tb` VALUES ('6967', '644adc46-1507-4165-b3c3-48fa4c26b395', '2015-05-05 11:51:49', 'jhfqwfqwd');
INSERT INTO `send_message_tb` VALUES ('6968', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-05 12:18:11', '你好');
INSERT INTO `send_message_tb` VALUES ('6969', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-05 12:18:23', '你好1');
INSERT INTO `send_message_tb` VALUES ('6970', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-05 12:18:26', '你好2');
INSERT INTO `send_message_tb` VALUES ('6971', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-05 12:18:29', '你好3');
INSERT INTO `send_message_tb` VALUES ('6972', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-05 12:22:16', 'ubadsa1');
INSERT INTO `send_message_tb` VALUES ('6973', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-05 12:22:17', 'ubadsa1');
INSERT INTO `send_message_tb` VALUES ('6974', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-05 12:22:17', 'ubadsa1');
INSERT INTO `send_message_tb` VALUES ('6975', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-05 12:22:45', '你好');
INSERT INTO `send_message_tb` VALUES ('6976', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-05 12:22:52', '你好1');
INSERT INTO `send_message_tb` VALUES ('6977', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-05 12:22:54', '你好12');
INSERT INTO `send_message_tb` VALUES ('6978', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-05 12:22:56', '你好123');
INSERT INTO `send_message_tb` VALUES ('6979', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-05 12:24:53', 'ceshi1');
INSERT INTO `send_message_tb` VALUES ('6980', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-05 12:25:25', 'ceshi12\r\n');
INSERT INTO `send_message_tb` VALUES ('6981', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-05 12:25:52', '离线数据1');
INSERT INTO `send_message_tb` VALUES ('6982', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-05 12:29:50', '年后');
INSERT INTO `send_message_tb` VALUES ('6983', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-05 12:30:03', '离线数据1');
INSERT INTO `send_message_tb` VALUES ('6984', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-05 12:30:08', '离线数据2');
INSERT INTO `send_message_tb` VALUES ('6985', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-05 12:31:26', '离线数据2');
INSERT INTO `send_message_tb` VALUES ('6986', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-05 12:31:48', '你好');
INSERT INTO `send_message_tb` VALUES ('6987', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-05 12:32:08', '立项数据111');
INSERT INTO `send_message_tb` VALUES ('6988', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-05 12:32:38', '立项数据111');
INSERT INTO `send_message_tb` VALUES ('6989', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-05 12:32:55', '离线数据12312124');
INSERT INTO `send_message_tb` VALUES ('6990', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-05 12:33:21', '离线数据12312124');
INSERT INTO `send_message_tb` VALUES ('6991', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-05 12:33:21', '离线数据12312124');
INSERT INTO `send_message_tb` VALUES ('6992', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-05 12:39:03', '年后');
INSERT INTO `send_message_tb` VALUES ('6993', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-05 12:39:03', '年后');
INSERT INTO `send_message_tb` VALUES ('6994', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-05 12:39:03', '年后');
INSERT INTO `send_message_tb` VALUES ('6995', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-05 12:39:08', '年后');
INSERT INTO `send_message_tb` VALUES ('6996', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-05 12:39:08', '年后');
INSERT INTO `send_message_tb` VALUES ('6997', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-05 12:39:09', '年后');
INSERT INTO `send_message_tb` VALUES ('6998', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-25 08:39:16', 'JHAGSFKASF');
INSERT INTO `send_message_tb` VALUES ('6999', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-25 10:46:09', '阿巴嘎g');
INSERT INTO `send_message_tb` VALUES ('7000', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-25 10:46:22', '阿巴嘎g');
INSERT INTO `send_message_tb` VALUES ('7001', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-25 10:46:22', '阿巴嘎g');
INSERT INTO `send_message_tb` VALUES ('7002', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-25 10:46:23', '阿巴嘎g');
INSERT INTO `send_message_tb` VALUES ('7003', '8ab95f14-04a8-4978-8bcb-e46f7ddba44c', '2015-05-25 10:46:25', '阿巴嘎g');
INSERT INTO `send_message_tb` VALUES ('7004', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-25 10:48:06', '啊基本常识看来你');
INSERT INTO `send_message_tb` VALUES ('7005', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-25 10:48:12', '啊基本常识看来你');
INSERT INTO `send_message_tb` VALUES ('7006', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-25 10:48:19', '啊基本常识看来你');
INSERT INTO `send_message_tb` VALUES ('7007', 'db79a1d0-e992-40f7-9c48-97016f61412d', '2015-05-25 10:49:24', '查看l；没带零钱');
INSERT INTO `send_message_tb` VALUES ('7008', 'db79a1d0-e992-40f7-9c48-97016f61412d', '2015-05-25 10:49:28', '查看l；没带零钱');
INSERT INTO `send_message_tb` VALUES ('7009', 'db79a1d0-e992-40f7-9c48-97016f61412d', '2015-05-25 10:49:29', '查看l；没带零钱');
INSERT INTO `send_message_tb` VALUES ('7010', 'db79a1d0-e992-40f7-9c48-97016f61412d', '2015-05-25 10:49:29', '查看l；没带零钱');
INSERT INTO `send_message_tb` VALUES ('7011', 'db79a1d0-e992-40f7-9c48-97016f61412d', '2015-05-25 10:49:29', '查看l；没带零钱');
INSERT INTO `send_message_tb` VALUES ('7012', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-25 10:49:56', '查看l；没带零钱');
INSERT INTO `send_message_tb` VALUES ('7013', 'e3d04f3c-88c6-4a6b-92e8-d44ced67783a', '2015-05-25 10:49:57', '查看l；没带零钱');
INSERT INTO `send_message_tb` VALUES ('7014', '7518700b-8edb-4b0f-b18f-465e54100747', '2015-05-25 10:54:30', '坚持不卡死你的');
INSERT INTO `send_message_tb` VALUES ('7015', '7518700b-8edb-4b0f-b18f-465e54100747', '2015-05-25 10:54:43', '坚持不卡死你的1');
INSERT INTO `send_message_tb` VALUES ('7016', '7518700b-8edb-4b0f-b18f-465e54100747', '2015-05-25 10:54:45', '坚持不卡死你的12');
INSERT INTO `send_message_tb` VALUES ('7017', '7518700b-8edb-4b0f-b18f-465e54100747', '2015-05-25 10:54:46', '坚持不卡死你的123');
INSERT INTO `send_message_tb` VALUES ('7018', '7518700b-8edb-4b0f-b18f-465e54100747', '2015-05-25 10:54:59', 'hvj');
INSERT INTO `send_message_tb` VALUES ('7019', '7518700b-8edb-4b0f-b18f-465e54100747', '2015-05-25 10:55:13', 'hvj');
INSERT INTO `send_message_tb` VALUES ('7020', '67c1f25d-c52f-4670-9ea9-31679095240a', '2015-05-25 10:55:27', '了咯卡了从哪里\r\n');
INSERT INTO `send_message_tb` VALUES ('7021', 'f9ca5761-41ec-4bb1-bb49-2f1a76e5b288', '2015-05-25 11:20:10', '酒啊后看出你');
INSERT INTO `send_message_tb` VALUES ('7022', 'f9ca5761-41ec-4bb1-bb49-2f1a76e5b288', '2015-05-25 11:20:18', '酒啊后看出你');
INSERT INTO `send_message_tb` VALUES ('7023', 'f9ca5761-41ec-4bb1-bb49-2f1a76e5b288', '2015-05-25 11:20:19', '酒啊后看出你');
INSERT INTO `send_message_tb` VALUES ('7024', 'f9ca5761-41ec-4bb1-bb49-2f1a76e5b288', '2015-05-25 11:20:19', '酒啊后看出你');
INSERT INTO `send_message_tb` VALUES ('7025', 'f9ca5761-41ec-4bb1-bb49-2f1a76e5b288', '2015-05-25 11:20:21', '酒啊后看出你1');
INSERT INTO `send_message_tb` VALUES ('7026', 'f9ca5761-41ec-4bb1-bb49-2f1a76e5b288', '2015-05-25 11:20:23', '酒啊后看出你12');
INSERT INTO `send_message_tb` VALUES ('7027', 'f9ca5761-41ec-4bb1-bb49-2f1a76e5b288', '2015-05-25 11:20:24', '酒啊后看出你123');
INSERT INTO `send_message_tb` VALUES ('7028', '37b7e5ca-1577-4e20-8670-3a47b8ec8f5b', '2015-05-25 11:20:34', '酒啊后看出你123');
INSERT INTO `send_message_tb` VALUES ('7029', 'd1a0057a-a4e8-4093-a8ca-5df21dfee5f2', '2015-05-25 11:21:03', '酒啊后看出你123');
INSERT INTO `send_message_tb` VALUES ('7030', 'd1a0057a-a4e8-4093-a8ca-5df21dfee5f2', '2015-05-25 11:21:10', '酒啊后看出你123');
INSERT INTO `send_message_tb` VALUES ('7031', 'd1a0057a-a4e8-4093-a8ca-5df21dfee5f2', '2015-05-25 11:21:14', '');
INSERT INTO `send_message_tb` VALUES ('7032', 'd1a0057a-a4e8-4093-a8ca-5df21dfee5f2', '2015-05-25 12:00:22', '往后IQof1');

-- ----------------------------
-- Table structure for tb
-- ----------------------------
DROP TABLE IF EXISTS `tb`;
CREATE TABLE `tb` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb
-- ----------------------------
INSERT INTO `tb` VALUES ('1', '你2');
INSERT INTO `tb` VALUES ('1', '你好');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `uuid` varchar(255) NOT NULL,
  `username` varchar(255) default NULL,
  `create_time` timestamp NOT NULL default '0000-00-00 00:00:00',
  `last_connect_time` timestamp NULL default NULL,
  PRIMARY KEY  (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('07bbdcb0-e2c3-47fb-8315-e95bbf2c7eed', 'connect', '2015-05-25 10:59:15', '2015-05-25 11:20:50');
INSERT INTO `users` VALUES ('37b7e5ca-1577-4e20-8670-3a47b8ec8f5b', 'connect', '2015-05-25 11:18:39', '2015-05-25 11:19:13');
INSERT INTO `users` VALUES ('67c1f25d-c52f-4670-9ea9-31679095240a', 'connect', '2015-05-25 10:55:06', '2015-05-25 10:59:12');
INSERT INTO `users` VALUES ('7518700b-8edb-4b0f-b18f-465e54100747', 'connect', '2015-05-25 10:50:17', '2015-05-25 10:55:04');
INSERT INTO `users` VALUES ('8ab95f14-04a8-4978-8bcb-e46f7ddba44c', 'connect', '2015-05-05 12:06:03', '2015-05-05 12:22:24');
INSERT INTO `users` VALUES ('d1a0057a-a4e8-4093-a8ca-5df21dfee5f2', 'connect', '2015-05-25 11:20:44', '2015-05-25 12:00:10');
INSERT INTO `users` VALUES ('db79a1d0-e992-40f7-9c48-97016f61412d', 'connect', '2015-05-05 12:00:57', '2015-05-05 12:02:23');
INSERT INTO `users` VALUES ('e3d04f3c-88c6-4a6b-92e8-d44ced67783a', 'connect', '2015-05-05 12:22:24', '2015-05-25 10:50:13');
INSERT INTO `users` VALUES ('f0cef5a6-6d4e-442c-bbab-c253c3ba6c4a', 'connect', '2015-05-25 11:19:24', '2015-05-25 11:19:34');
INSERT INTO `users` VALUES ('f9ca5761-41ec-4bb1-bb49-2f1a76e5b288', 'connect', '2015-05-25 11:19:45', '2015-05-25 11:21:06');
