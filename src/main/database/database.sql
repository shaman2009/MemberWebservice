-- phpMyAdmin SQL Dump
-- http://www.phpmyadmin.net
--
-- 生成日期: 2013 年 10 月 28 日 11:41

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
-- 表的结构 `tb_user`
--

CREATE TABLE IF NOT EXISTS `tb_user` (
  `ID` char(38) NOT NULL,
  `Alias` varchar(128) DEFAULT NULL,
  `Password` varchar(32) NOT NULL,
  `UserState` bit(1) DEFAULT NULL,
  `UserEmail` varchar(64) NOT NULL,
  `LoginState` bit(1) DEFAULT b'0',
  `IPAddress` char(15) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0',
  `Birthday` datetime DEFAULT NULL,
  `Gender` bit(1) DEFAULT NULL,
  `UserSignature` varchar(200) DEFAULT NULL,
  `AvatarIDFK` char(38) DEFAULT NULL,
  `FriendCount` int(11) DEFAULT '0',
  `FanCount` int(11) DEFAULT '0',
  `FollowCount` int(11) DEFAULT '0',
  `ArticleCount` int(11) DEFAULT '0',
  `RegisterFrom` int(11) DEFAULT NULL,
  `BackgroundUrl` varchar(200) DEFAULT NULL,
  `PhoneNumber` char(30) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UserEmail_UNIQUE` (`UserEmail`),
  KEY `IX_EMAIL_PWD` (`UserEmail`,`Password`) USING BTREE,
  KEY `IX_ALIAS` (`Alias`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `tb_user`
--

INSERT INTO `tb_user` (`ID`, `Alias`, `Password`, `UserState`, `UserEmail`, `LoginState`, `IPAddress`, `CreatedDate`, `ModifiedDate`, `IsDeleted`, `Birthday`, `Gender`, `UserSignature`, `AvatarIDFK`, `FriendCount`, `FanCount`, `FollowCount`, `ArticleCount`, `RegisterFrom`, `BackgroundUrl`, `PhoneNumber`) VALUES
('0846eca9-e133-4656-9c96-c3475a34b08a', NULL, '123', NULL, 'tangyuxuaxxxx@qq.com', b'0', NULL, '2013-10-28 00:35:01', '2013-10-28 00:35:01', b'0', NULL, NULL, NULL, NULL, 0, 0, 0, 0, NULL, NULL, NULL),
('0a2943ca-1999-4529-9f6f-ed09c1278cc6', NULL, '123', NULL, 'tangyuxuaxx@qq.com', b'0', NULL, '2013-10-28 00:32:25', '2013-10-28 00:32:25', b'0', NULL, NULL, NULL, NULL, 0, 0, 0, 0, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `tb_wsusersession`
--

CREATE TABLE IF NOT EXISTS `tb_wsusersession` (
  `ID` char(38) NOT NULL,
  `SessionKey` int(11) NOT NULL,
  `UserIDFK` char(38) DEFAULT NULL,
  `DeviceIdentifier` varchar(255) DEFAULT NULL,
  `PackageName` varchar(255) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `tb_wsusersession`
--

INSERT INTO `tb_wsusersession` (`ID`, `SessionKey`, `UserIDFK`, `DeviceIdentifier`, `PackageName`, `CreatedDate`) VALUES
('765ab3bb-2870-4a21-8468-abd6a23a497f', 610015415, '0a2943ca-1999-4529-9f6f-ed09c1278cc6', '�M�', 'com.dandelion', NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;




CREATE TABLE `tb_emailbean` (
  `id` varchar(40) NOT NULL,
  `token` varchar(40) NOT NULL,
  `expire` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

