CREATE DATABASE  IF NOT EXISTS `memberapp` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `memberapp`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: memberapp
-- ------------------------------------------------------
-- Server version	5.6.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_emailbean`
--

DROP TABLE IF EXISTS `tb_emailbean`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_emailbean` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `token` varchar(40) NOT NULL,
  `expire` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_feed`
--

DROP TABLE IF EXISTS `tb_feed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_feed` (
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
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_friend`
--

DROP TABLE IF EXISTS `tb_friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_friend` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `fromUserIDFK` bigint(20) NOT NULL,
  `targetUserIDFK` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_member`
--

DROP TABLE IF EXISTS `tb_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_member` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `UserIDFK` bigint(20) NOT NULL COMMENT '用户表主键',
  `AvatarUrl` varchar(500) DEFAULT NULL COMMENT '头像的地址 图片存在七牛云存储',
  `BackgroundUrl` varchar(500) DEFAULT NULL COMMENT '背景图片地址 ',
  `Name` varchar(500) DEFAULT NULL COMMENT '姓名',
  `Sex` int(11) DEFAULT NULL COMMENT '性别 0代表 男 1 代表女 ',
  `Birthday` datetime DEFAULT NULL COMMENT ' 出生日期',
  `Address` varchar(500) DEFAULT NULL COMMENT '地址',
  `Phone` varchar(500) DEFAULT NULL COMMENT '电话 ',
  `Introduction` varchar(500) DEFAULT NULL COMMENT '简介',
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UserIDFK_UNIQUE` (`UserIDFK`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_merchant`
--

DROP TABLE IF EXISTS `tb_merchant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_merchant` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `AvatarUrl` varchar(500) DEFAULT NULL COMMENT '头像的地址 图片存在七牛云存储',
  `Name` varchar(500) DEFAULT NULL COMMENT '店名',
  `Address` varchar(500) DEFAULT NULL COMMENT '地址',
  `Phone` varchar(500) DEFAULT NULL COMMENT '电话 JsonArray key 为 phones ',
  `Email` varchar(500) DEFAULT NULL COMMENT '电邮',
  `MerchantType` varchar(500) DEFAULT NULL COMMENT '类别 包括 饮食 美容 服务 饰物 娱乐 个人服务 教育 其他',
  `Introduction` varchar(500) DEFAULT NULL COMMENT '简介',
  `NameRequired` bit(1) DEFAULT b'0' COMMENT '会员提供资料 需要姓名',
  `SexRequired` bit(1) DEFAULT b'0' COMMENT '会员提供资料 需要性别',
  `PhoneRequired` bit(1) DEFAULT b'0' COMMENT '会员提供资料 需要电话',
  `AddressRequired` bit(1) DEFAULT b'0' COMMENT '会员提供资料 需要地址',
  `EmailRequired` bit(1) DEFAULT b'0' COMMENT '会员提供资料 需要邮箱',
  `BirthdayRequired` bit(1) DEFAULT b'0' COMMENT '会员提供资料 需要出生日期',
  `MemberSetting` bit(1) DEFAULT b'0' COMMENT '是否要设定会员消费金额及次数',
  `AmountRequired` int(11) DEFAULT NULL COMMENT '成为会员需要消费金额',
  `AmountCountRequired` int(11) DEFAULT NULL COMMENT '成为会员需要消费次数',
  `ScorePlan` bit(1) DEFAULT b'0' COMMENT '积分计划',
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `UserIDFK` bigint(20) NOT NULL,
  `BackgroundUrl` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UserIDFK_UNIQUE` (`UserIDFK`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2297 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_notification`
--

DROP TABLE IF EXISTS `tb_notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_notification` (
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
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
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
) ENGINE=InnoDB AUTO_INCREMENT=609 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_wsusersession`
--

DROP TABLE IF EXISTS `tb_wsusersession`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_wsusersession` (
  `ID` varchar(255) NOT NULL,
  `SessionKey` int(11) NOT NULL,
  `UserIDFK` bigint(20) DEFAULT NULL,
  `DeviceIdentifier` varchar(255) DEFAULT NULL,
  `PackageName` varchar(255) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `AccountType` int(11) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-05 15:58:11
