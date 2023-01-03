CREATE TABLE `boardmember` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `userid` varchar(45) COLLATE utf8_bin NOT NULL,
  `password` varchar(60) COLLATE utf8_bin NOT NULL,
  `username` varchar(45) COLLATE utf8_bin NOT NULL,
  `role` varchar(45) COLLATE utf8_bin NOT NULL DEFAULT 'USER',
  `regdate` datetime DEFAULT (now()),
  `editdate` datetime DEFAULT (now()),
  PRIMARY KEY (`idx`),
  UNIQUE KEY `userid_UNIQUE` (`userid`)
);