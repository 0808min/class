CREATE TABLE `member` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `uid` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `pw` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `uuid` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  `uname` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `uphoto` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`idx`),
  UNIQUE KEY `uid_UNIQUE` (`uid`)
) 