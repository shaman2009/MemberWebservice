SET SQL_SAFE_UPDATES=0;

CREATE TABLE `tb_emailbean` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `token` varchar(40) NOT NULL,
  `expire` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_friend` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `fromUserIDFK` bigint(20) NOT NULL,
  `targetUserIDFK` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Alias` varchar(128) DEFAULT NULL,
  `Password` varchar(100) NOT NULL,
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
  `AccountType` int(11) DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UserEmail_UNIQUE` (`UserEmail`),
  KEY `IX_EMAIL_PWD` (`UserEmail`,`Password`) USING BTREE,
  KEY `IX_ALIAS` (`Alias`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;

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
