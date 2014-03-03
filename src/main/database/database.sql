-- phpMyAdmin SQL Dump
-- http://www.phpmyadmin.net
--
-- 生成日期: 2014 年 02 月 28 日 01:24

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `NYyoOVyPLyYvWsbLwSEH`
--

-- --------------------------------------------------------

--
-- 表的结构 `tb_emailbean`
--

CREATE TABLE IF NOT EXISTS `tb_emailbean` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `token` varchar(40) NOT NULL,
  `expire` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `tb_feed`
--

CREATE TABLE IF NOT EXISTS `tb_feed` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `UserIDFK` bigint(20) NOT NULL,
  `Content` varchar(250) DEFAULT NULL,
  `URL` varchar(500) DEFAULT NULL,
  `ImageURL` varchar(500) DEFAULT NULL,
  `AllowComment` bit(1) NOT NULL DEFAULT b'1',
  `IsPublic` bit(1) NOT NULL DEFAULT b'1',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0',
  `ForwardIDFK` char(38) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `CommentCount` int(11) NOT NULL DEFAULT '0',
  `ForwardCount` int(11) NOT NULL DEFAULT '0',
  `LikeCount` int(11) NOT NULL DEFAULT '0',
  `Level` int(11) NOT NULL DEFAULT '0',
  `Weight` int(12) DEFAULT '0',
  `Sort` int(12) DEFAULT '0',
  `Title` varchar(200) DEFAULT '0',
  `Referrer` varchar(2000) DEFAULT '0',
  `Remark1` varchar(200) DEFAULT '0',
  `Remark2` varchar(200) DEFAULT '0',
  `Remark3` varchar(200) DEFAULT '0',
  `isOfficial` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=93 ;

--
-- 转存表中的数据 `tb_feed`
--

INSERT INTO `tb_feed` (`ID`, `UserIDFK`, `Content`, `URL`, `ImageURL`, `AllowComment`, `IsPublic`, `IsDeleted`, `ForwardIDFK`, `CreatedDate`, `ModifiedDate`, `CommentCount`, `ForwardCount`, `LikeCount`, `Level`, `Weight`, `Sort`, `Title`, `Referrer`, `Remark1`, `Remark2`, `Remark3`, `isOfficial`) VALUES
(69, 425, 'ddfgg cf', NULL, 'ef9976d9-3f3f-4f6c-ad0b-b0c2137b1af7', b'1', b'1', b'0', NULL, '2014-01-01 21:41:54', '2014-01-01 21:41:54', 0, 0, 0, 0, 0, 0, 'ddxxx', '0', '0', '0', '0', b'0'),
(70, 425, 'ddfgg cf', NULL, '8b00ad45-b64f-492f-a97d-942c95b3e94a', b'1', b'1', b'0', NULL, '2014-01-01 21:44:54', '2014-01-01 21:44:54', 0, 0, 0, 0, 0, 0, 'ddxxx', '0', '0', '0', '0', b'0'),
(71, 423, 'edxtfchhvcvghcv edxtfchhvcvghcv dggfffygggggghgggffvg', NULL, '080f2abf-9a4b-4148-a64b-59f8b3edc59d', b'1', b'1', b'0', NULL, '2014-01-01 23:15:31', '2014-01-01 23:15:31', 0, 0, 0, 0, 0, 0, 'ACCA', '0', '0', '0', '0', b'0'),
(72, 423, 'edxtfchhvcvghcv edxtfchhvcvghcv dggfffygggggghgggffvg', NULL, 'a1eb0c73-60ad-4c8c-af4d-94f95df619c4', b'1', b'1', b'0', NULL, '2014-01-01 23:15:45', '2014-01-01 23:15:45', 0, 0, 0, 0, 0, 0, 'ACCAffggg', '0', '0', '0', '0', b'0'),
(73, 429, 'hello', NULL, 'e6eee869-db81-4a91-a882-e82654dc6351', b'1', b'1', b'0', NULL, '2014-01-02 00:41:55', '2014-01-02 00:41:55', 0, 0, 0, 0, 0, 0, 'hello', '0', '0', '0', '0', b'0'),
(74, 429, 'hello', NULL, 'e6eee869-db81-4a91-a882-e82654dc6351', b'1', b'1', b'0', NULL, '2014-01-02 00:41:55', '2014-01-02 00:41:55', 0, 0, 0, 0, 0, 0, 'hello', '0', '0', '0', '0', b'0'),
(75, 429, 'hello', NULL, 'e6eee869-db81-4a91-a882-e82654dc6351', b'1', b'1', b'0', NULL, '2014-01-02 00:41:56', '2014-01-02 00:41:56', 0, 0, 0, 0, 0, 0, 'hello', '0', '0', '0', '0', b'0'),
(76, 429, 'hello', NULL, 'e6eee869-db81-4a91-a882-e82654dc6351', b'1', b'1', b'0', NULL, '2014-01-02 00:41:56', '2014-01-02 00:41:56', 0, 0, 0, 0, 0, 0, 'hello', '0', '0', '0', '0', b'0'),
(77, 429, 'hello', NULL, 'e6eee869-db81-4a91-a882-e82654dc6351', b'1', b'1', b'0', NULL, '2014-01-02 00:41:56', '2014-01-02 00:41:56', 0, 0, 0, 0, 0, 0, 'hello', '0', '0', '0', '0', b'0'),
(78, 429, 'xxxx', NULL, 'a8a4f517-0c7c-46f6-908f-07efabd84a97', b'1', b'1', b'0', NULL, '2014-01-06 17:35:02', '2014-01-06 17:35:02', 0, 0, 0, 0, 0, 0, 'ddd', '0', '0', '0', '0', b'0'),
(79, 423, '2009', NULL, '815808d2-fb31-438d-9416-4f4e09837b0d', b'1', b'1', b'0', NULL, '2014-01-14 21:11:11', '2014-01-14 21:11:11', 0, 0, 0, 0, 0, 0, '大酒神', '0', '0', '0', '0', b'0'),
(80, 423, '外设店', NULL, '397aae29-a6c3-4f32-9a12-44c930a9ee09', b'1', b'1', b'0', NULL, '2014-01-14 21:15:54', '2014-01-14 21:15:54', 0, 0, 0, 0, 0, 0, '2009', '0', '0', '0', '0', b'0'),
(81, 423, '(>﹏<)', NULL, '1e7a5562-6c53-4436-9b65-ad034572d110', b'1', b'1', b'0', NULL, '2014-01-14 21:21:27', '2014-01-14 21:21:27', 0, 0, 0, 0, 0, 0, '啧啧⊙▽⊙', '0', '0', '0', '0', b'0'),
(82, 429, '點心限時半價', NULL, 'bcda85d2-5b45-47d9-aff2-81a6aa7381c6', b'1', b'1', b'0', NULL, '2014-01-15 20:08:26', '2014-01-15 20:08:26', 0, 0, 0, 0, 0, 0, '一月促銷', '0', '0', '0', '0', b'0'),
(83, 423, 'm', NULL, '3fee014c-a2cc-482f-a1fa-bcdd18ecf1fb', b'1', b'1', b'0', NULL, '2014-01-18 18:32:12', '2014-01-18 18:32:12', 0, 0, 0, 0, 0, 0, 'hi', '0', '0', '0', '0', b'0'),
(84, 429, 'test', NULL, 'a8a30a36-51d9-416f-9239-b274e51b4347', b'1', b'1', b'0', NULL, '2014-01-20 00:37:08', '2014-01-20 00:37:08', 0, 0, 0, 0, 0, 0, 'test', '0', '0', '0', '0', b'0'),
(85, 456, 'kjffyjyftfjydjtrxrtgfcjytdytdjhgcvb htfvhgchghgv.  hgvjgvvugfuy\n:-) ', NULL, '2ba36b1a-7a1a-4f73-b5a0-5dc0119422a7', b'1', b'1', b'0', NULL, '2014-01-20 23:02:54', '2014-01-20 23:02:54', 0, 0, 0, 0, 0, 0, 'qwe', '0', '0', '0', '0', b'0'),
(86, 460, 'testestesteast', NULL, 'f7811fe9-7367-49d1-9f3f-94fe0723485e', b'1', b'1', b'0', NULL, '2014-01-26 15:47:13', '2014-01-26 15:47:13', 0, 0, 0, 0, 0, 0, 'testest', '0', '0', '0', '0', b'0'),
(87, 460, 'msg', NULL, 'd440c224-dd30-4b29-aaba-2508a1196e31', b'1', b'1', b'0', NULL, '2014-01-28 16:17:38', '2014-01-28 16:17:38', 0, 0, 0, 0, 0, 0, 'test', '0', '0', '0', '0', b'0'),
(88, 460, 'msg', NULL, 'cbcdcd2c-bcf5-46a6-abbe-6dcae9346151', b'1', b'1', b'0', NULL, '2014-01-28 16:18:11', '2014-01-28 16:18:11', 0, 0, 0, 0, 0, 0, 'tedt', '0', '0', '0', '0', b'0'),
(89, 460, 'msg', NULL, 'cbcdcd2c-bcf5-46a6-abbe-6dcae9346151', b'1', b'1', b'0', NULL, '2014-01-28 16:18:28', '2014-01-28 16:18:28', 0, 0, 0, 0, 0, 0, 'tedt', '0', '0', '0', '0', b'0'),
(90, 460, 'test', NULL, 'a985643e-c431-4f42-af8b-4990e49f069b', b'1', b'1', b'0', NULL, '2014-01-29 12:25:50', '2014-01-29 12:25:50', 0, 0, 0, 0, 0, 0, 'test', '0', '0', '0', '0', b'0'),
(91, 423, 'test\n', NULL, '8d3eb1a4-2f35-4e35-bc99-8eb749bb17ef', b'1', b'1', b'0', NULL, '2014-01-29 12:26:56', '2014-01-29 12:26:56', 0, 0, 0, 0, 0, 0, 'test', '0', '0', '0', '0', b'0'),
(92, 467, 'vhhhhh', NULL, '2bb2b6a3-2b4a-4fd7-ba7b-b8939d2f4c14', b'1', b'1', b'0', NULL, '2014-02-22 22:47:19', '2014-02-22 22:47:19', 0, 0, 0, 0, 0, 0, 'bnbnmmnnx', '0', '0', '0', '0', b'0');

-- --------------------------------------------------------

--
-- 表的结构 `tb_friend`
--

CREATE TABLE IF NOT EXISTS `tb_friend` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `fromUserIDFK` bigint(20) NOT NULL,
  `targetUserIDFK` bigint(20) NOT NULL,
  `isMember` bit(1) NOT NULL DEFAULT b'0',
  `amount` bigint(20) NOT NULL DEFAULT '0',
  `amountCount` bigint(20) NOT NULL DEFAULT '0',
  `score` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=134 ;

--
-- 转存表中的数据 `tb_friend`
--

INSERT INTO `tb_friend` (`ID`, `fromUserIDFK`, `targetUserIDFK`, `isMember`, `amount`, `amountCount`, `score`) VALUES
(107, 452, 423, b'1', 0, 0, 9734),
(108, 454, 423, b'1', 0, 0, 6753),
(109, 423, 452, b'0', 0, 0, 0),
(110, 444, 429, b'0', 333, 1, 0),
(111, 446, 423, b'1', 0, 0, 183),
(112, 423, 446, b'0', 0, 0, 0),
(113, 423, 424, b'0', 0, 0, 0),
(114, 452, 425, b'0', 0, 0, 0),
(115, 423, 454, b'0', 0, 0, 0),
(116, 423, 426, b'0', 0, 0, 0),
(117, 455, 423, b'1', 0, 0, 10082),
(118, 455, 425, b'0', 0, 0, 0),
(119, 423, 427, b'0', 0, 0, 0),
(120, 423, 430, b'0', 0, 0, 0),
(121, 423, 449, b'0', 0, 0, 0),
(122, 423, 455, b'0', 0, 0, 0),
(123, 452, 456, b'1', 0, 0, 0),
(124, 456, 452, b'0', 0, 0, 0),
(125, 452, 457, b'0', 28, 2, 0),
(126, 459, 423, b'0', 91, 2, 0),
(127, 429, 427, b'0', 0, 0, 0),
(128, 462, 423, b'0', 0, 0, 0),
(129, 451, 423, b'0', 0, 0, 0),
(130, 446, 460, b'1', 0, 0, 1000),
(131, 460, 446, b'0', 0, 0, 0),
(132, 452, 434, b'0', 0, 0, 0),
(133, 452, 428, b'0', 0, 0, 0);

-- --------------------------------------------------------

--
-- 表的结构 `tb_member`
--

CREATE TABLE IF NOT EXISTS `tb_member` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `UserIDFK` bigint(20) NOT NULL COMMENT '用户表主键',
  `AvatarUrl` varchar(500) DEFAULT '308fe522-6d36-408f-81e7-a468053a556e' COMMENT '头像的地址 图片存在七牛云存储',
  `BackgroundUrl` varchar(500) DEFAULT NULL COMMENT '背景图片地址 ',
  `Name` varchar(500) DEFAULT NULL COMMENT '姓名',
  `Sex` int(11) DEFAULT '0' COMMENT '性别 0代表 男 1 代表女 ',
  `Birthday` datetime DEFAULT NULL COMMENT ' 出生日期',
  `Address` varchar(500) DEFAULT NULL COMMENT '地址',
  `Phone` varchar(500) DEFAULT NULL COMMENT '电话 ',
  `Introduction` varchar(500) DEFAULT NULL COMMENT '简介',
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UserIDFK_UNIQUE` (`UserIDFK`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=120 ;

--
-- 转存表中的数据 `tb_member`
--

INSERT INTO `tb_member` (`ID`, `UserIDFK`, `AvatarUrl`, `BackgroundUrl`, `Name`, `Sex`, `Birthday`, `Address`, `Phone`, `Introduction`, `CreatedDate`, `ModifiedDate`) VALUES
(94, 422, 'd537cd14-efde-4ee2-8af0-437b51c7bdc9', NULL, 'qw', 0, NULL, NULL, NULL, NULL, '2014-01-01 14:18:22', '2014-01-01 14:18:22'),
(95, 424, '941d9259-8e23-47af-8722-c0187b558eb5', NULL, '今天天氣不錯', 0, NULL, NULL, NULL, NULL, '2014-01-01 16:11:10', '2014-01-01 16:11:10'),
(96, 426, 'd537cd14-efde-4ee2-8af0-437b51c7bdc9', NULL, 'dffg', 0, NULL, NULL, NULL, NULL, '2014-01-01 21:45:49', '2014-01-01 21:45:49'),
(97, 427, 'd537cd14-efde-4ee2-8af0-437b51c7bdc9', NULL, 'thhhhgh', 0, NULL, NULL, NULL, NULL, '2014-01-01 23:16:13', '2014-01-01 23:16:13'),
(98, 430, 'd537cd14-efde-4ee2-8af0-437b51c7bdc9', NULL, '1234', 0, NULL, NULL, NULL, NULL, '2014-01-02 00:43:20', '2014-01-02 00:43:20'),
(99, 431, 'd537cd14-efde-4ee2-8af0-437b51c7bdc9', NULL, '4321', 0, NULL, NULL, NULL, NULL, '2014-01-02 00:52:05', '2014-01-02 00:52:05'),
(100, 432, 'd537cd14-efde-4ee2-8af0-437b51c7bdc9', NULL, 'vghvhjd', 0, NULL, NULL, NULL, NULL, '2014-01-02 19:50:12', '2014-01-02 19:50:12'),
(101, 433, 'd537cd14-efde-4ee2-8af0-437b51c7bdc9', NULL, '5678', 0, NULL, NULL, NULL, NULL, '2014-01-02 20:27:22', '2014-01-02 20:27:22'),
(102, 435, 'd537cd14-efde-4ee2-8af0-437b51c7bdc9', NULL, 'vvffg', 0, NULL, NULL, NULL, NULL, '2014-01-02 20:45:36', '2014-01-02 20:45:36'),
(103, 442, 'd537cd14-efde-4ee2-8af0-437b51c7bdc9', NULL, 'fcgy', 0, NULL, NULL, NULL, NULL, '2014-01-05 01:54:08', '2014-01-05 01:54:08'),
(104, 443, 'd537cd14-efde-4ee2-8af0-437b51c7bdc9', NULL, 'f chh', 0, NULL, NULL, NULL, NULL, '2014-01-05 02:02:44', '2014-01-05 02:02:44'),
(105, 444, 'd537cd14-efde-4ee2-8af0-437b51c7bdc9', NULL, 'test', 0, NULL, NULL, NULL, NULL, '2014-01-05 10:25:04', '2014-01-05 10:25:04'),
(106, 446, 'd537cd14-efde-4ee2-8af0-437b51c7bdc9', NULL, 'Cow', 0, NULL, NULL, NULL, NULL, '2014-01-05 23:12:59', '2014-01-05 23:12:59'),
(107, 448, 'd537cd14-efde-4ee2-8af0-437b51c7bdc9', NULL, '出来了咯', 0, NULL, NULL, NULL, NULL, '2014-01-07 15:51:13', '2014-01-07 15:51:13'),
(108, 449, 'd537cd14-efde-4ee2-8af0-437b51c7bdc9', NULL, 'AAAA', 0, NULL, NULL, NULL, NULL, '2014-01-10 21:51:21', '2014-01-10 21:51:21'),
(109, 450, '308fe522-6d36-408f-81e7-a468053a556e', NULL, '普罗', 0, NULL, NULL, NULL, NULL, '2014-01-14 21:40:20', '2014-01-14 21:40:20'),
(110, 451, '308fe522-6d36-408f-81e7-a468053a556e', '', '1234567', 0, '1970-01-01 08:00:00', 'thuiyfjj', '222222222', '', '2014-01-26 21:31:04', '2014-01-26 21:31:04'),
(111, 452, '9e59339f-f536-4201-bfda-84f03fc05fa6', '', '杠杠头', 0, '1970-01-01 08:00:00', '恩', '36', '', '2014-01-20 23:01:26', '2014-01-20 23:01:26'),
(112, 454, '308fe522-6d36-408f-81e7-a468053a556e', NULL, '啊啊啊啊啊', 0, NULL, NULL, NULL, NULL, '2014-01-16 23:42:15', '2014-01-16 23:42:15'),
(113, 455, '308fe522-6d36-408f-81e7-a468053a556e', '', 'Taylor Wang ', 0, '1970-01-01 08:00:00', 'cvgh', '', '', '2014-01-19 20:55:09', '2014-01-19 20:55:09'),
(114, 459, '308fe522-6d36-408f-81e7-a468053a556e', NULL, 'zzzz', 0, NULL, NULL, NULL, NULL, '2014-01-26 00:52:55', '2014-01-26 00:52:55'),
(115, 462, '308fe522-6d36-408f-81e7-a468053a556e', NULL, 'Roy', 0, NULL, NULL, NULL, NULL, '2014-01-26 19:36:04', '2014-01-26 19:36:04'),
(116, 464, '308fe522-6d36-408f-81e7-a468053a556e', NULL, 'sadfsadf', 0, NULL, NULL, NULL, NULL, '2014-02-17 22:30:06', '2014-02-17 22:30:06'),
(117, 465, '308fe522-6d36-408f-81e7-a468053a556e', NULL, 'sadfsadf', 0, NULL, NULL, NULL, NULL, '2014-02-17 22:30:37', '2014-02-17 22:30:37'),
(118, 468, '308fe522-6d36-408f-81e7-a468053a556e', NULL, 'qwer', 0, NULL, NULL, NULL, NULL, '2014-02-25 15:31:21', '2014-02-25 15:31:21'),
(119, 469, '308fe522-6d36-408f-81e7-a468053a556e', NULL, 'qwer', 0, NULL, NULL, NULL, NULL, '2014-02-25 15:35:03', '2014-02-25 15:35:03');

-- --------------------------------------------------------

--
-- 表的结构 `tb_merchant`
--

CREATE TABLE IF NOT EXISTS `tb_merchant` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `AvatarUrl` varchar(500) DEFAULT '1e7a5562-6c53-4436-9b65-ad034572d110' COMMENT '头像的地址 图片存在七牛云存储',
  `Name` varchar(500) DEFAULT NULL COMMENT '店名',
  `Address` varchar(500) DEFAULT NULL COMMENT '地址',
  `Phone` varchar(500) DEFAULT NULL COMMENT '电话 JsonArray key 为 phones ',
  `Email` varchar(500) DEFAULT NULL COMMENT '电邮',
  `MerchantType` varchar(500) DEFAULT '1' COMMENT '类别 包括 饮食 美容 服务 饰物 娱乐 个人服务 教育 其他',
  `Introduction` varchar(500) DEFAULT NULL COMMENT '简介',
  `NameRequired` bit(1) DEFAULT b'0' COMMENT '会员提供资料 需要姓名',
  `SexRequired` bit(1) DEFAULT b'0' COMMENT '会员提供资料 需要性别',
  `PhoneRequired` bit(1) DEFAULT b'0' COMMENT '会员提供资料 需要电话',
  `AddressRequired` bit(1) DEFAULT b'0' COMMENT '会员提供资料 需要地址',
  `EmailRequired` bit(1) DEFAULT b'0' COMMENT '会员提供资料 需要邮箱',
  `BirthdayRequired` bit(1) DEFAULT b'0' COMMENT '会员提供资料 需要出生日期',
  `MemberSetting` bit(1) DEFAULT b'0' COMMENT '是否要设定会员消费金额及次数',
  `AmountRequired` int(11) NOT NULL DEFAULT '0' COMMENT '成为会员需要消费金额',
  `AmountCountRequired` int(11) DEFAULT '0' COMMENT '成为会员需要消费次数',
  `ScorePlan` bit(1) DEFAULT b'0' COMMENT '积分计划',
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `UserIDFK` bigint(20) NOT NULL,
  `BackgroundUrl` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UserIDFK_UNIQUE` (`UserIDFK`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2164 ;

--
-- 转存表中的数据 `tb_merchant`
--

INSERT INTO `tb_merchant` (`ID`, `AvatarUrl`, `Name`, `Address`, `Phone`, `Email`, `MerchantType`, `Introduction`, `NameRequired`, `SexRequired`, `PhoneRequired`, `AddressRequired`, `EmailRequired`, `BirthdayRequired`, `MemberSetting`, `AmountRequired`, `AmountCountRequired`, `ScorePlan`, `CreatedDate`, `ModifiedDate`, `UserIDFK`, `BackgroundUrl`) VALUES
(2142, '3db07b89-c787-4e6d-a05f-f97494af00da', '津津有味茶餐廳', '九龍塘', '180165', 'fengfei0330@gmail.com', '6', '津津有味茶餐廳是一間傳統港式茶餐廳。其絲襪奶茶受到廣大食客的熱烈歡迎。', b'1', b'1', b'1', b'0', b'1', b'0', b'0', 25, 0, b'1', '2014-01-01 16:10:33', '2014-02-21 22:56:12', 423, ''),
(2143, '31b40253-40b8-410a-a24c-2466c588bb78', 'eff', NULL, NULL, 'etd@dfc.com', '1', NULL, b'0', b'0', b'0', b'0', b'0', b'0', b'0', 0, 0, b'0', '2014-01-01 20:48:20', '2014-01-01 20:48:20', 425, NULL),
(2144, '31b40253-40b8-410a-a24c-2466c588bb78', '點點心', NULL, NULL, 'ddx@gmail.com', '1', NULL, b'0', b'0', b'0', b'0', b'0', b'0', b'0', 0, 0, b'0', '2014-01-02 00:08:22', '2014-01-02 00:08:22', 428, NULL),
(2145, '31b40253-40b8-410a-a24c-2466c588bb78', '自家點心', NULL, NULL, 'zjdx@gmail.com', '1', NULL, b'0', b'0', b'0', b'0', b'0', b'0', b'0', 0, 0, b'0', '2014-01-02 00:39:05', '2014-01-02 00:39:05', 429, NULL),
(2146, '31b40253-40b8-410a-a24c-2466c588bb78', 'xdchh', NULL, NULL, 'hhbvg@dfgg.com', '1', NULL, b'0', b'0', b'0', b'0', b'0', b'0', b'0', 0, 0, b'0', '2014-01-02 20:43:34', '2014-01-02 20:43:34', 434, NULL),
(2147, '31b40253-40b8-410a-a24c-2466c588bb78', 'yvvvvb', NULL, NULL, 'fghjbhu@ghb.com', '1', NULL, b'0', b'0', b'0', b'0', b'0', b'0', b'0', 0, 0, b'0', '2014-01-03 18:55:25', '2014-01-03 18:55:25', 436, NULL),
(2148, '31b40253-40b8-410a-a24c-2466c588bb78', 'dxf', NULL, NULL, 'rfggggg@gh.com', '1', NULL, b'0', b'0', b'0', b'0', b'0', b'0', b'0', 0, 0, b'0', '2014-01-03 22:19:23', '2014-01-03 22:19:23', 437, NULL),
(2149, '31b40253-40b8-410a-a24c-2466c588bb78', 'fghh', NULL, NULL, 'rfggggg@gh.combbb', '1', NULL, b'0', b'0', b'0', b'0', b'0', b'0', b'0', 0, 0, b'0', '2014-01-03 23:28:47', '2014-01-03 23:28:47', 438, NULL),
(2150, '31b40253-40b8-410a-a24c-2466c588bb78', 'fgvv', NULL, NULL, 'hg gg@gh.com', '1', NULL, b'0', b'0', b'0', b'0', b'0', b'0', b'0', 0, 0, b'0', '2014-01-03 23:31:34', '2014-01-03 23:31:34', 439, NULL),
(2151, '31b40253-40b8-410a-a24c-2466c588bb78', 'hbbb*', '*tvh v', '*69885', '*vhhbb@', '1', 'fgggvj\n', b'0', b'1', b'1', b'0', b'0', b'0', b'1', 588, 0, b'1', '2014-01-03 23:35:22', '2014-01-05 01:30:54', 440, ''),
(2152, '31b40253-40b8-410a-a24c-2466c588bb78', 'yg*', '*rcg', '*585', '*fcv@f', '1', 'qerty', b'1', b'1', b'1', b'0', b'1', b'1', b'1', 12588, 0, b'1', '2014-01-05 01:39:45', '2014-01-05 01:53:23', 441, ''),
(2153, '31b40253-40b8-410a-a24c-2466c588bb78', 'qywh', NULL, NULL, 'areyoulookon@gmail.com', '1', NULL, b'0', b'0', b'0', b'0', b'0', b'0', b'0', 0, 0, b'0', '2014-01-05 18:27:51', '2014-01-05 18:27:51', 445, NULL),
(2154, '31b40253-40b8-410a-a24c-2466c588bb78', 'cow', NULL, NULL, 'toomany_ho@gmail.com', '1', NULL, b'0', b'0', b'0', b'0', b'0', b'0', b'0', 0, 0, b'0', '2014-01-06 17:27:17', '2014-01-06 17:27:17', 447, NULL),
(2155, '1e7a5562-6c53-4436-9b65-ad034572d110', '擦擦头', NULL, NULL, 'caca@qq.com', '1', NULL, b'0', b'0', b'0', b'0', b'0', b'0', b'0', 0, 0, b'0', '2014-01-16 23:41:26', '2014-01-16 23:41:26', 453, NULL),
(2156, '70639441-55d6-459d-98f8-95c7e47b54c7', 'w*%66cyguw%=', 'null', 'null', 'asuncjhndsac@uwunednijswd.com', '1', 'null', b'0', b'0', b'0', b'1', b'0', b'1', b'0', 0, 0, b'0', '2014-01-20 22:54:21', '2014-01-20 23:12:27', 456, ''),
(2157, '2bd5fdb4-e253-4bd1-8f30-f67196c52ce1', 'xrcdfttfdfjjmm\n', 'null', 'null', 'xxrctfctfyt@dd.com', '1', 'nullassd\n', b'0', b'0', b'0', b'0', b'0', b'0', b'0', 0, 0, b'0', '2014-01-20 23:13:51', '2014-01-20 23:18:33', 457, ''),
(2158, '1e7a5562-6c53-4436-9b65-ad034572d110', 'zzzz', NULL, NULL, 'hahbs@d.com', '1', NULL, b'0', b'0', b'0', b'0', b'0', b'0', b'0', 0, 0, b'0', '2014-01-26 00:52:33', '2014-01-26 00:52:33', 458, NULL),
(2159, '', 'test shop', 'qfjkv', '94984140', 'toomanyho@gmail.com', '1', 'hfubx', b'1', b'1', b'1', b'1', b'1', b'0', b'1', 1000, 0, b'0', '2014-01-26 15:12:30', '2014-01-26 15:14:23', 460, ''),
(2160, '', 'H•P', '香港', '94476681', 'cthroy@gmail.com', '1', '', b'1', b'1', b'1', b'0', b'1', b'0', b'1', 0, 0, b'0', '2014-01-26 19:29:29', '2014-01-26 19:31:44', 461, ''),
(2161, '1e7a5562-6c53-4436-9b65-ad034572d110', '你', NULL, NULL, 'fengfei01@gmail.com', '1', NULL, b'0', b'0', b'0', b'0', b'0', b'0', b'0', 0, 0, b'0', '2014-02-17 22:25:13', '2014-02-17 22:25:13', 463, NULL),
(2162, '1e7a5562-6c53-4436-9b65-ad034572d110', '科技楼', NULL, NULL, 'amtmh@55.com', '1', NULL, b'0', b'0', b'0', b'0', b'0', b'0', b'0', 0, 0, b'0', '2014-02-21 23:24:50', '2014-02-21 23:24:50', 466, NULL),
(2163, '', ' 咯', 'TM郁闷', '999', 'vhbhj@66.con', '2', '图', b'0', b'0', b'0', b'1', b'0', b'1', b'0', 0, 0, b'1', '2014-02-21 23:29:08', '2014-02-21 23:30:21', 467, '');

-- --------------------------------------------------------

--
-- 表的结构 `tb_notification`
--

CREATE TABLE IF NOT EXISTS `tb_notification` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FromUserIDFK` bigint(20) NOT NULL,
  `ToUserIDFK` bigint(20) NOT NULL,
  `Content` varchar(200) DEFAULT NULL,
  `IsRead` bit(1) NOT NULL DEFAULT b'0',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0',
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `Sort` int(12) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=106 ;

--
-- 转存表中的数据 `tb_notification`
--

INSERT INTO `tb_notification` (`ID`, `FromUserIDFK`, `ToUserIDFK`, `Content`, `IsRead`, `IsDeleted`, `CreatedDate`, `ModifiedDate`, `Sort`) VALUES
(49, 424, 423, '', b'1', b'0', '2014-01-01 20:05:34', '2014-01-20 22:42:37', 1),
(50, 424, 423, '', b'1', b'0', '2014-01-01 20:08:56', '2014-01-20 00:40:56', 1),
(51, 424, 423, '', b'1', b'0', '2014-01-01 20:09:18', '2014-01-19 12:55:00', 1),
(52, 426, 423, '', b'1', b'0', '2014-01-01 21:46:59', '2014-01-19 12:55:37', 1),
(53, 426, 425, '', b'0', b'0', '2014-01-01 22:58:07', '2014-01-01 22:58:07', 1),
(54, 427, 423, '', b'1', b'0', '2014-01-01 23:16:34', '2014-01-26 00:38:23', 1),
(55, 427, 425, '', b'0', b'0', '2014-01-01 23:16:40', '2014-01-01 23:16:40', 1),
(56, 430, 423, '', b'1', b'0', '2014-01-02 00:44:20', '2014-01-26 22:55:09', 1),
(57, 427, 428, '', b'0', b'0', '2014-01-02 11:55:45', '2014-01-02 11:55:45', 1),
(58, 427, 429, '', b'1', b'0', '2014-01-02 11:55:52', '2014-01-26 11:51:57', 1),
(59, 432, 423, '', b'0', b'0', '2014-01-02 19:50:45', '2014-01-02 19:50:45', 1),
(60, 433, 425, '', b'0', b'0', '2014-01-02 20:28:02', '2014-01-02 20:28:02', 1),
(61, 435, 423, '', b'0', b'0', '2014-01-02 20:45:47', '2014-01-02 20:45:47', 1),
(62, 443, 423, '', b'0', b'0', '2014-01-05 02:02:52', '2014-01-05 02:02:52', 1),
(63, 444, 429, '', b'0', b'0', '2014-01-05 10:25:25', '2014-01-05 10:25:25', 1),
(64, 446, 423, '', b'0', b'0', '2014-01-06 17:39:37', '2014-01-06 17:39:37', 1),
(65, 448, 423, '', b'0', b'0', '2014-01-07 15:52:17', '2014-01-07 15:52:17', 1),
(66, 448, 441, '', b'0', b'0', '2014-01-07 15:53:16', '2014-01-07 15:53:16', 1),
(67, 448, 425, '', b'0', b'0', '2014-01-07 15:53:25', '2014-01-07 15:53:25', 1),
(68, 448, 428, '', b'0', b'0', '2014-01-07 15:53:31', '2014-01-07 15:53:31', 1),
(69, 449, 423, '', b'0', b'0', '2014-01-10 21:53:11', '2014-01-10 21:53:11', 1),
(70, 449, 429, '', b'0', b'0', '2014-01-10 21:55:20', '2014-01-10 21:55:20', 1),
(71, 449, 436, '', b'0', b'0', '2014-01-10 21:55:34', '2014-01-10 21:55:34', 1),
(72, 449, 441, '', b'0', b'0', '2014-01-10 21:56:58', '2014-01-10 21:56:58', 1),
(73, 423, 424, '', b'0', b'0', '2014-01-12 23:38:03', '2014-01-12 23:38:03', 2),
(74, 423, 449, '', b'0', b'0', '2014-01-12 23:41:33', '2014-01-12 23:41:33', 2),
(75, 423, 432, '', b'0', b'0', '2014-01-13 14:52:10', '2014-01-13 14:52:10', 2),
(76, 423, 443, '', b'0', b'0', '2014-01-13 21:26:30', '2014-01-13 21:26:30', 2),
(77, 423, 446, '', b'0', b'0', '2014-01-13 21:47:45', '2014-01-13 21:47:45', 2),
(78, 429, 427, '', b'0', b'0', '2014-01-13 23:28:23', '2014-01-13 23:28:23', 2),
(79, 450, 423, '', b'0', b'0', '2014-01-14 21:40:45', '2014-01-14 21:40:45', 1),
(80, 450, 425, '', b'0', b'0', '2014-01-14 22:03:04', '2014-01-14 22:03:04', 1),
(81, 423, 430, '', b'0', b'0', '2014-01-14 22:10:09', '2014-01-14 22:10:09', 2),
(82, 444, 434, '', b'0', b'0', '2014-01-14 22:12:12', '2014-01-14 22:12:12', 1),
(83, 450, 439, '', b'0', b'0', '2014-01-15 17:41:59', '2014-01-15 17:41:59', 1),
(84, 451, 423, '', b'0', b'0', '2014-01-15 18:31:57', '2014-01-15 18:31:57', 1),
(85, 452, 423, '', b'1', b'0', '2014-01-16 23:35:09', '2014-01-19 12:55:23', 1),
(86, 454, 423, '', b'1', b'0', '2014-01-16 23:42:33', '2014-01-19 12:55:13', 1),
(87, 423, 452, '', b'0', b'0', '2014-01-16 23:49:10', '2014-01-16 23:49:10', 2),
(88, 444, 429, '', b'0', b'0', '2014-01-17 02:03:33', '2014-01-17 02:03:33', 1),
(89, 446, 423, '', b'1', b'0', '2014-01-17 12:04:38', '2014-01-19 12:55:11', 1),
(90, 423, 446, '', b'0', b'0', '2014-01-17 21:08:40', '2014-01-17 21:08:40', 2),
(91, 452, 425, '', b'0', b'0', '2014-01-18 18:25:10', '2014-01-18 18:25:10', 1),
(92, 423, 454, '', b'0', b'0', '2014-01-19 12:55:13', '2014-01-19 12:55:13', 2),
(93, 455, 423, '', b'1', b'0', '2014-01-19 20:53:37', '2014-01-20 22:42:41', 1),
(94, 455, 425, '', b'0', b'0', '2014-01-19 20:53:59', '2014-01-19 20:53:59', 1),
(95, 423, 455, '', b'0', b'0', '2014-01-20 22:42:41', '2014-01-20 22:42:41', 2),
(96, 452, 456, '', b'1', b'0', '2014-01-20 23:02:15', '2014-01-20 23:02:24', 1),
(97, 456, 452, '', b'0', b'0', '2014-01-20 23:02:24', '2014-01-20 23:02:24', 2),
(98, 452, 457, '', b'0', b'0', '2014-01-20 23:14:58', '2014-01-20 23:14:58', 1),
(99, 459, 423, '', b'0', b'0', '2014-01-26 00:53:04', '2014-01-26 00:53:04', 1),
(100, 462, 423, '', b'0', b'0', '2014-01-26 19:37:13', '2014-01-26 19:37:13', 1),
(101, 451, 423, '', b'0', b'0', '2014-01-26 21:32:02', '2014-01-26 21:32:02', 1),
(102, 446, 460, '', b'1', b'0', '2014-01-28 16:15:46', '2014-01-28 16:17:04', 1),
(103, 460, 446, '', b'0', b'0', '2014-01-28 16:17:04', '2014-01-28 16:17:04', 2),
(104, 452, 434, '', b'0', b'0', '2014-02-15 21:44:52', '2014-02-15 21:44:52', 1),
(105, 452, 428, '', b'0', b'0', '2014-02-15 21:45:02', '2014-02-15 21:45:02', 1);

-- --------------------------------------------------------

--
-- 表的结构 `tb_user`
--

CREATE TABLE IF NOT EXISTS `tb_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Alias` varchar(128) DEFAULT NULL,
  `Password` varchar(100) NOT NULL,
  `UserEmail` varchar(64) NOT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0',
  `FriendCount` int(11) DEFAULT '0',
  `FanCount` int(11) DEFAULT '0',
  `FollowCount` int(11) DEFAULT '0',
  `ArticleCount` int(11) DEFAULT '0',
  `RegisterFrom` int(11) DEFAULT NULL,
  `AccountType` int(11) DEFAULT '0',
  `merchantIDFK` bigint(20) DEFAULT NULL,
  `memberIDFK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UserEmail_UNIQUE` (`UserEmail`),
  KEY `IX_EMAIL_PWD` (`UserEmail`,`Password`) USING BTREE,
  KEY `IX_ALIAS` (`Alias`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=470 ;

--
-- 转存表中的数据 `tb_user`
--

INSERT INTO `tb_user` (`ID`, `Alias`, `Password`, `UserEmail`, `CreatedDate`, `ModifiedDate`, `IsDeleted`, `FriendCount`, `FanCount`, `FollowCount`, `ArticleCount`, `RegisterFrom`, `AccountType`, `merchantIDFK`, `memberIDFK`) VALUES
(422, 'qw', 'qwqw', 'q@w.com', '2014-01-01 14:18:22', '2014-01-01 14:18:22', b'0', 0, 0, 0, 0, NULL, 0, NULL, 94),
(423, 'dcghhg', '81dc9bdb52d04dc20036dbd8313ed055', 'fengfei0330@gmail.com', '2014-01-01 16:10:33', '2014-01-01 16:10:33', b'0', 0, 0, 0, 0, NULL, 1, 2142, NULL),
(424, 'cghbh', 'b13d364587c71f79ec8b9356cb655d4f', 'fffg@cgvh.com', '2014-01-01 16:11:10', '2014-01-01 16:11:10', b'0', 0, 0, 0, 0, NULL, 0, NULL, 95),
(425, 'eff', 'dfa0ce9f0e3ff93a8227b9e22f289457', 'etd@dfc.com', '2014-01-01 20:48:20', '2014-01-01 20:48:20', b'0', 0, 0, 0, 0, NULL, 1, 2143, NULL),
(426, 'dffg', '81dc9bdb52d04dc20036dbd8313ed055', 'tffg@ffff.com', '2014-01-01 21:45:49', '2014-01-01 21:45:49', b'0', 0, 0, 0, 0, NULL, 0, NULL, 96),
(427, 'thhhhgh', 'c103235aee71a7ce10315305293715ed', 'fgg@ggh.com', '2014-01-01 23:16:13', '2014-01-01 23:16:13', b'0', 0, 0, 0, 0, NULL, 0, NULL, 97),
(428, '點點心', 'e10adc3949ba59abbe56e057f20f883e', 'ddx@gmail.com', '2014-01-02 00:08:22', '2014-01-02 00:08:22', b'0', 0, 0, 0, 0, NULL, 1, 2144, NULL),
(429, '自家點心', 'e10adc3949ba59abbe56e057f20f883e', 'zjdx@gmail.com', '2014-01-02 00:39:04', '2014-01-02 00:39:04', b'0', 0, 0, 0, 0, NULL, 1, 2145, NULL),
(430, '1234', '81dc9bdb52d04dc20036dbd8313ed055', '1234@gmail.com', '2014-01-02 00:43:20', '2014-01-02 00:43:20', b'0', 0, 0, 0, 0, NULL, 0, NULL, 98),
(431, '4321', 'd93591bdf7860e1e4ee2fca799911215', '4321@Gmail.com', '2014-01-02 00:52:05', '2014-01-02 00:52:05', b'0', 0, 0, 0, 0, NULL, 0, NULL, 99),
(432, 'vghvhjd', '3a93609324455786478b1f96921111f5', 'sgubs@shx.com', '2014-01-02 19:50:12', '2014-01-02 19:50:12', b'0', 0, 0, 0, 0, NULL, 0, NULL, 100),
(433, '5678', '674f3c2c1a8a6f90461e8a66fb5550ba', '5678@gmail.com', '2014-01-02 20:27:22', '2014-01-02 20:27:22', b'0', 0, 0, 0, 0, NULL, 0, NULL, 101),
(434, 'xdchh', '324a2eec207a91517b316dc82cb0c892', 'hhbvg@dfgg.com', '2014-01-02 20:43:34', '2014-01-02 20:43:34', b'0', 0, 0, 0, 0, NULL, 1, 2146, NULL),
(435, 'vvffg', '461ea92241ab80c4cd642069b19606e3', 'gfhgg@ddf.com', '2014-01-02 20:45:35', '2014-01-02 20:45:35', b'0', 0, 0, 0, 0, NULL, 0, NULL, 102),
(436, 'yvvvvb', '76e77807d9035a7cc1f357dbe055413e', 'fghjbhu@ghb.com', '2014-01-03 18:55:25', '2014-01-03 18:55:25', b'0', 0, 0, 0, 0, NULL, 1, 2147, NULL),
(437, 'dxf', 'ef487d17906f2df059527ee227bf5df9', 'rfggggg@gh.com', '2014-01-03 22:19:23', '2014-01-03 22:19:23', b'0', 0, 0, 0, 0, NULL, 1, 2148, NULL),
(438, 'fghh', '753a19859072dfa97c74880065e68835', 'rfggggg@gh.combbb', '2014-01-03 23:28:47', '2014-01-03 23:28:47', b'0', 0, 0, 0, 0, NULL, 1, 2149, NULL),
(439, 'fgvv', '2a91912a68650020a3ce6d17418d2bbf', 'hg gg@gh.com', '2014-01-03 23:31:34', '2014-01-03 23:31:34', b'0', 0, 0, 0, 0, NULL, 1, 2150, NULL),
(440, 'rcvj', '94a61336c2a2321742793b9d48ee7ffd', 'eugvh rfggggg@gh.com', '2014-01-03 23:35:22', '2014-01-03 23:35:22', b'0', 0, 0, 0, 0, NULL, 1, 2151, NULL),
(441, 'dx', 'bb810f7c53a25c3648decaad32c1ae0f', 'efff rfggggg@gh.com', '2014-01-05 01:39:45', '2014-01-05 01:39:45', b'0', 0, 0, 0, 0, NULL, 1, 2152, NULL),
(442, 'fcgy', 'b65ab2292e2a35e6cea29dab8e0d5c30', 'rfuv@ffg.com', '2014-01-05 01:54:08', '2014-01-05 01:54:08', b'0', 0, 0, 0, 0, NULL, 0, NULL, 103),
(443, 'f chh', 'dacb7bf2bfa0d3b3ab6926646903c659', 'rfv v f rfggggg@gh.com', '2014-01-05 02:02:44', '2014-01-05 02:02:44', b'0', 0, 0, 0, 0, NULL, 0, NULL, 104),
(444, 'test', '81dc9bdb52d04dc20036dbd8313ed055', 'test@gmail.com', '2014-01-05 10:25:04', '2014-01-05 10:25:04', b'0', 0, 0, 0, 0, NULL, 0, NULL, 105),
(445, 'qywh', '3a2c03a9435f72e10eb9f655f2f79c1c', 'areyoulookon@gmail.com', '2014-01-05 18:27:51', '2014-01-05 18:27:51', b'0', 0, 0, 0, 0, NULL, 1, 2153, NULL),
(446, 'Cow', '81dc9bdb52d04dc20036dbd8313ed055', 'toomany_ho@hotmail.com', '2014-01-05 23:12:59', '2014-01-05 23:12:59', b'0', 0, 0, 0, 0, NULL, 0, NULL, 106),
(447, 'cow', '81dc9bdb52d04dc20036dbd8313ed055', 'toomany_ho@gmail.com', '2014-01-06 17:27:16', '2014-01-06 17:27:16', b'0', 0, 0, 0, 0, NULL, 1, 2154, NULL),
(448, '出来了咯', 'd126af14cbfa8234e30c3b0d503dcfbe', 'rfgfgh@455.com', '2014-01-07 15:51:13', '2014-01-07 15:51:13', b'0', 0, 0, 0, 0, NULL, 0, NULL, 107),
(449, 'AAAA', '827ccb0eea8a706c4c34a16891f84e7b', '12345@gmail.com', '2014-01-10 21:51:21', '2014-01-10 21:51:21', b'0', 0, 0, 0, 0, NULL, 0, NULL, 108),
(450, '普罗', '5ca803ae76417cfaad05b1dfa6786c21', 'dnjnn@66.com', '2014-01-14 21:40:20', '2014-01-14 21:40:20', b'0', 0, 0, 0, 0, NULL, 0, NULL, 109),
(451, '1234567', 'fcea920f7412b5da7be0cf42b8c93759', '1234567@gmail.com', '2014-01-15 18:30:55', '2014-01-15 18:30:55', b'0', 0, 0, 0, 0, NULL, 0, NULL, 110),
(452, '杠杠头', '81dc9bdb52d04dc20036dbd8313ed055', 'fengfei@gmail.com', '2014-01-16 23:32:48', '2014-01-16 23:32:48', b'0', 0, 0, 0, 0, NULL, 0, NULL, 111),
(453, '擦擦头', '81dc9bdb52d04dc20036dbd8313ed055', 'caca@qq.com', '2014-01-16 23:41:26', '2014-01-16 23:41:26', b'0', 0, 0, 0, 0, NULL, 1, 2155, NULL),
(454, '啊啊啊啊啊', '81dc9bdb52d04dc20036dbd8313ed055', 'cacaca@qq.com', '2014-01-16 23:42:15', '2014-01-16 23:42:15', b'0', 0, 0, 0, 0, NULL, 0, NULL, 112),
(455, 'Taylor Wang ', '228baab40faed1f4613935e2b2297f1f', 'ttw789@gmail.com', '2014-01-19 20:52:46', '2014-01-19 20:52:46', b'0', 0, 0, 0, 0, NULL, 0, NULL, 113),
(456, 'w*%66cyguw%=', '3766caaa596ce6a1a9f0b52f8869c6fb', 'asuncjhndsac@uwunednijswd.com', '2014-01-20 22:54:20', '2014-01-20 22:54:20', b'0', 0, 0, 0, 0, NULL, 1, 2156, NULL),
(457, 'xrcdfttfdf', '9f954bb6f73cd860f848d6630809c624', 'xxrctfctfyt@dd.com', '2014-01-20 23:13:51', '2014-01-20 23:13:51', b'0', 0, 0, 0, 0, NULL, 1, 2157, NULL),
(458, 'zzzz', 'b21e67ad942c95f60f040d58f2b9d916', 'hahbs@d.com', '2014-01-26 00:52:33', '2014-01-26 00:52:33', b'0', 0, 0, 0, 0, NULL, 1, NULL, NULL),
(459, 'zzzz', 'b21e67ad942c95f60f040d58f2b9d916', 'hahbs@gmail.com', '2014-01-26 00:52:55', '2014-01-26 00:52:55', b'0', 0, 0, 0, 0, NULL, 0, NULL, 114),
(460, 'Cowcow', 'e10adc3949ba59abbe56e057f20f883e', 'toomanyho@gmail.com', '2014-01-26 15:12:30', '2014-01-26 15:12:30', b'0', 0, 0, 0, 0, NULL, 1, 2159, NULL),
(461, 'roy', 'b285b600bd4d4cfd15431987da30111a', 'cthroy@gmail.com', '2014-01-26 19:29:29', '2014-01-26 19:29:29', b'0', 0, 0, 0, 0, NULL, 1, 2160, NULL),
(462, 'Roy', 'b285b600bd4d4cfd15431987da30111a', 'cthroychan@gmail.com', '2014-01-26 19:36:04', '2014-01-26 19:36:04', b'0', 0, 0, 0, 0, NULL, 0, NULL, 115),
(463, '你', '190e0fe686016645780d807f470c48d3', 'fengfei01@gmail.com', '2014-02-17 22:25:13', '2014-02-17 22:25:13', b'0', 0, 0, 0, 0, NULL, 1, 2161, NULL),
(464, 'sadfsadf', 'asdff', '1sss@2.com', '2014-02-17 22:30:06', '2014-02-17 22:30:06', b'0', 0, 0, 0, 0, NULL, 0, NULL, 116),
(465, 'sadfsadf', 'asdff', '1ssss@2.com', '2014-02-17 22:30:37', '2014-02-17 22:30:37', b'0', 0, 0, 0, 0, NULL, 0, NULL, 117),
(466, '科技楼', '74751e8e7065613d78b4941c6a4c6080', 'amtmh@55.com', '2014-02-21 23:24:50', '2014-02-21 23:24:50', b'0', 0, 0, 0, 0, NULL, 1, 2162, NULL),
(467, '铝土矿', '019e479a45072ad49d671e43ecdb743f', 'fvgg@89.com', '2014-02-21 23:29:08', '2014-02-21 23:29:08', b'0', 0, 0, 0, 0, NULL, 1, 2163, NULL),
(468, 'qwer', 'asdfsadf', 'qwert@gmail.com', '2014-02-25 15:31:21', '2014-02-25 15:31:21', b'0', 0, 0, 0, 0, NULL, 0, NULL, 118),
(469, 'qwer', 'asdfsadf', 'qwesdrt@gmail.com', '2014-02-25 15:35:03', '2014-02-25 15:35:03', b'0', 0, 0, 0, 0, NULL, 0, NULL, 119);

-- --------------------------------------------------------

--
-- 表的结构 `tb_wsusersession`
--

CREATE TABLE IF NOT EXISTS `tb_wsusersession` (
  `ID` varchar(255) NOT NULL,
  `SessionKey` int(11) NOT NULL,
  `UserIDFK` bigint(20) DEFAULT NULL,
  `DeviceIdentifier` varchar(255) DEFAULT NULL,
  `PackageName` varchar(255) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `AccountType` int(11) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `tb_wsusersession`
--

INSERT INTO `tb_wsusersession` (`ID`, `SessionKey`, `UserIDFK`, `DeviceIdentifier`, `PackageName`, `CreatedDate`, `AccountType`) VALUES
('0821fc11-3917-4637-8450-8e4a41c8c95b', 681404386, 447, '�N���;�M�', 'com.dandelion.memberandroid', NULL, 0),
('0a3afba4-e559-491c-b5d9-050c683be688', 2133080943, 437, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('148a6c72-7f6a-4389-99cc-1c408a999916', 1327902293, 452, '���ԿXߟ4', 'com.dandelion.memberandroid', NULL, 0),
('169a2e62-b36b-4edb-b7dd-fae17b9798ac', 322240248, 423, '�G���7G�', 'com.dandelion.memberandroid', NULL, 0),
('1cc702af-1300-4d3d-a181-a37835333939', 2138644783, 461, '���{}YW�|', 'com.dandelion.memberandroid', NULL, 0),
('2b4c5bb7-bdb9-4bb3-9298-6781fef7037f', 428437260, 423, '�F�}��W^�', 'com.dandelion.memberandroid', NULL, 0),
('2bb622d9-9f08-481c-91a5-332aac34e382', 862774217, 434, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('2d22ce3e-e59a-457f-8f2d-370692239931', 71826617, 453, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('2e31f54f-122b-45bc-822a-c76406dc1460', 812848648, 422, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('2fad78e2-b0c8-4f0c-a246-638f7f58a411', 2076551519, 429, '�N���;�M�', 'com.dandelion.memberandroid', NULL, 0),
('2fd32f6f-ec93-4aff-a278-169789a1a18d', 1638754271, 457, '�G���7G�', 'com.dandelion.memberandroid', NULL, 0),
('33a187d8-e4ae-476a-9279-524fa3725449', 829445771, 446, '�G��ݷ��', 'com.dandelion.memberandroid', NULL, 0),
('3b692319-74f9-4d46-ac4f-34ab6ebfa2b9', 685402831, 438, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('425e9f61-c85c-4eae-84eb-7a856255a241', 1020012557, 424, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('429eb657-8a58-40df-b50d-440171c5cf70', 582597504, 455, 'S�7���', 'com.dandelion.memberandroid', NULL, 0),
('4a8dff12-08d3-4577-b5ec-c130d09c4695', 1820943392, 443, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('4d9e4de4-b073-43de-ac74-442b0bb41b21', 1375575916, 444, '�F�}��W^�', 'com.dandelion.memberandroid', NULL, 0),
('52863804-d72d-45af-af5a-8669dc0295c9', 113429147, 456, '�G���7G�', 'com.dandelion.memberandroid', NULL, 0),
('5363e437-00a7-40bb-bca9-c77e43d7f61b', 1899719369, 423, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('597e8b7f-92ad-4111-8fb2-0b4dcd187fe6', 177934333, 423, '�N���;�M�', 'com.dandelion.memberandroid', NULL, 0),
('5ba3d91b-d6ac-4334-81c8-7137c0b5703a', 402089494, 467, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('600a83c2-ae5e-475b-92e3-df12742e45e4', 1665478445, 425, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('6028c62f-7ce8-495d-a113-ebb42db56b78', 433965392, 423, '���ԿXߟ4', 'com.dandelion.memberandroid', NULL, 0),
('6263efa4-2ea0-453e-9c55-984777895585', 1906416177, 459, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('62d3ae5a-6f72-40db-81fc-8bfb2c392258', 494061439, 439, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('6301b868-edc5-432d-9848-c26f0da46251', 662432273, 450, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('72aa721d-9e00-4504-9e7d-e7f34971fee0', 1975217438, 428, '�N���;�M�', 'com.dandelion.memberandroid', NULL, 0),
('7740058e-3ce4-4f95-9029-148582e0d1ca', 379237956, 423, '�G��ݷ��', 'com.dandelion.memberandroid', NULL, 0),
('79f32f4e-3a83-4e03-b9a9-763888b66f2c', 1437012373, 440, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('83a3f8a0-4c66-4fb2-af0f-34d2f9a3e18e', 657509159, 444, '�N���;�M�', 'com.dandelion.memberandroid', NULL, 0),
('8a8874dc-da2b-478e-93bb-83c24d7bf124', 1146649941, 442, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('8d790db2-d835-4e05-9547-f167e6990fb7', 174753813, 436, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('9cc57925-5174-4f21-a12a-561ad279fa3e', 1442424009, 463, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('9e8c8398-3cd5-41c0-bda6-1d0615b9589e', 29404534, 430, '�N���;�M�', 'com.dandelion.memberandroid', NULL, 0),
('a0099a03-cb7e-415c-8884-af72f87db569', 753469752, 451, '�N���;�M�', 'com.dandelion.memberandroid', NULL, 0),
('a46db932-fcae-4eb4-bc08-7a81906642e4', 1896072875, 432, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('a660b221-5a4c-473c-ad47-c061721c28a6', 1036634465, 427, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('aa73a17c-02cd-4b0f-8e91-ba7530af073e', 1517809949, 462, '���{}YW�|', 'com.dandelion.memberandroid', NULL, 0),
('c168bb60-d4a4-4dbe-b43c-68a04e3bf6db', 1177936963, 452, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('c59941d2-b44d-4c47-8c93-39f021a8de8d', 426440328, 449, '�N���;�M�', 'com.dandelion.memberandroid', NULL, 0),
('c70c006e-5eb9-4492-9418-a2e302a68afc', 633566094, 460, '�G��ݷ��', 'com.dandelion.memberandroid', NULL, 0),
('c9ae5dfa-422f-4739-ac7b-d1fa8996a801', 346282177, 445, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('d1a60104-8247-46a1-8319-662fe9e720c2', 2107560258, 435, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('e142d44e-3480-45e0-825a-054db7651ccf', 414311077, 433, '�N���;�M�', 'com.dandelion.memberandroid', NULL, 0),
('e212b4b2-9c29-406b-ad7e-928de1541d7a', 1002597757, 423, 'I��W�Ս�', 'com.dandelion.memberandroid', NULL, 0),
('f1ed6068-61f6-4e8f-9ab7-7bd8f8bd9b1b', 1846525838, 441, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('f3691605-56bc-411f-b990-7cb198de974e', 1845062437, 426, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('f8ff7dd9-9c80-4cd1-8f32-d2bcaefdf4e9', 415590887, 422, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('fe5d5e85-0914-42af-b90c-39a1d6357a2b', 1336197549, 448, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('ff7926a4-f020-4eee-bb5b-e03ca08cabdd', 2087854664, 454, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0),
('ffeef741-0000-4c7d-b6e5-46bf7cc7610a', 1762379265, 466, 'O�;��}�{', 'com.dandelion.memberandroid', NULL, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
