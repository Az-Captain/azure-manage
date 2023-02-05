/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 12/02/2022 17:39:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(2) NULL DEFAULT 0 COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否删除 0：未删除，1：已删除',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('208032146709942272', '', 0, '1235', '0', 'Az', '2022-02-09 17:32:35', 'Az', '2022-02-10 15:19:46');
INSERT INTO `user` VALUES ('208041783924494336', 'ALI', 20, 'ali@az.com', '0', 'Az', '2022-02-09 18:10:47', NULL, NULL);
INSERT INTO `user` VALUES ('208348243850039296', 'akbar', 8, 'akbar@az.com', '0', 'Az', '2022-02-10 14:28:32', NULL, NULL);
INSERT INTO `user` VALUES ('208439428509732864', 'dad', 8, '12@qq.com', '0', 'Az', '2022-02-10 20:30:53', NULL, NULL);
INSERT INTO `user` VALUES ('239ccc9eb92aa9f85c4f32c22507e8da', 'jhon', 20, 'jhon@az.com', '0', 'Az', '2022-02-10 10:13:34', NULL, NULL);
INSERT INTO `user` VALUES ('3308f6f11d249bf98cd1afdecf277206', 'Az', 24, 'azt0903@163.com', '0', 'Az', '2022-02-10 11:45:25', 'Az', '2022-02-10 11:46:25');
INSERT INTO `user` VALUES ('69a51b0657af5ea4bb086337d7801fd5', 'kiram', 24, 'kiram@az.com', '0', 'Az', '2022-02-10 12:49:47', NULL, NULL);
INSERT INTO `user` VALUES ('898e45b31e2735e0c257744834851f9a', 'tohti', 20, 'tohti@az.com', '1', 'Az', '2022-02-10 10:32:47', NULL, NULL);
INSERT INTO `user` VALUES ('a4aa55f702f3e36feae913c8905c8201', 'samat', 18, 'samat007@az.com', '0', 'Az', '2022-02-10 11:44:09', 'Az', '2022-02-10 11:44:18');
INSERT INTO `user` VALUES ('bfb4efacfc0be3d11a141b61999ac56c', 'kasim', 8, 'kasim@az.com', '0', 'Az', '2022-02-10 14:26:02', NULL, NULL);
INSERT INTO `user` VALUES ('c5d922490f8f7bf51cc176e925434161', 'popi', 20, 'popi@az.com', '1', 'Az', '2022-02-10 09:58:29', NULL, NULL);
INSERT INTO `user` VALUES ('f231b7800fa70194de8dfad801f00465', 'ubul', 24, 'ubul@az.com', '0', 'Az', '2022-02-10 13:19:17', NULL, NULL);
INSERT INTO `user` VALUES ('fde109f7ce3a370ade793eff30a84eb4', 'mihray', 8, 'mihray@az.com', '0', 'Az', '2022-02-10 13:54:04', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
