CREATE TABLE `potato_user` (
  `userid` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `joindate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `loc` varchar(45) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `deleteuser` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `potato_board` (
  `boardid` int NOT NULL AUTO_INCREMENT,
  `userid` varchar(255) NOT NULL,
  `category` int NOT NULL,
  `product` varchar(255) NOT NULL,
  `writedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `saleprice` int NOT NULL,
  `salestatus` tinyint NOT NULL DEFAULT '1',
  `tradeloc` varchar(45) NOT NULL,
  PRIMARY KEY (`boardid`),
  KEY `userid_idx` (`userid`),
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `potato_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `potato_trade` (
  `orderid` int NOT NULL AUTO_INCREMENT,
  `boardid` int NOT NULL,
  `userid` varchar(255) NOT NULL,
  PRIMARY KEY (`orderid`),
  KEY `item` (`boardid`),
  KEY `user` (`userid`),
  CONSTRAINT `item` FOREIGN KEY (`boardid`) REFERENCES `potato_board` (`boardid`),
  CONSTRAINT `user` FOREIGN KEY (`userid`) REFERENCES `potato_user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


