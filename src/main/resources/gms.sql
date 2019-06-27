

SET FOREIGN_KEY_CHECKS=0;

drop database if exists `gms1`;
create database gms1;
use gms1;
-- ----------------------------
-- Table structure for dayearning
-- ----------------------------
DROP TABLE IF EXISTS `dayearning`;
CREATE TABLE `dayearning` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dayEarning` decimal(10,0) DEFAULT NULL COMMENT '日收入',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `createTimestamp` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(255) DEFAULT NULL COMMENT '货物名',
  `typeId` int(11) DEFAULT NULL COMMENT '类型id',
  `imageAddress` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `createTimestamp` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `goodsUnit` varchar(255) DEFAULT NULL COMMENT '货物单位',
  PRIMARY KEY (`id`),
  UNIQUE KEY `goodsName` (`goodsName`),
  KEY `typeId` (`typeId`),
  CONSTRAINT `typeId` FOREIGN KEY (`typeId`) REFERENCES `type` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for purchaseorder
-- ----------------------------
DROP TABLE IF EXISTS `purchaseorder`;
CREATE TABLE `purchaseorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsId` int(11) DEFAULT NULL COMMENT '货物id',
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  `goodsUnit` varchar(255) DEFAULT NULL COMMENT '进货单位',
  `goodsQuantity` decimal(10,2) DEFAULT NULL COMMENT '进货数量',
  `goodsUnitPrice` decimal(10,2) DEFAULT NULL COMMENT '进货单价',
  `goodsTotalPrice` decimal(10,2) DEFAULT NULL COMMENT '进货总价',
  `createTimeStamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `goodsId` (`goodsId`),
  KEY `userId` (`userId`),
  CONSTRAINT `goodsId` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shipmentorder
-- ----------------------------
DROP TABLE IF EXISTS `shipmentorder`;
CREATE TABLE `shipmentorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsId` int(11) DEFAULT NULL COMMENT '货物id',
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  `goodsUnit` varchar(255) DEFAULT NULL COMMENT '出货单位',
  `goodsQuantity` decimal(10,2) DEFAULT NULL COMMENT '出货数量',
  `goodsUnitPrice` decimal(10,2) DEFAULT NULL COMMENT '出货单价',
  `goodsTotalPrice` decimal(10,2) DEFAULT NULL COMMENT '出货总价',
  `createTimeStamp` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `goodsId` (`goodsId`) USING BTREE,
  KEY `userId` (`userId`) USING BTREE,
  CONSTRAINT `shipmentorder_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `shipmentorder_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(255) DEFAULT NULL COMMENT '类型名',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `createTimestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsId` int(11) DEFAULT NULL COMMENT '货物id',
  `stock` decimal(10,2) DEFAULT NULL COMMENT '库存',
  `latestSellingPrice` decimal(10,2) DEFAULT NULL COMMENT '最新出货价',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `latestCostPrice` decimal(10,2) DEFAULT NULL COMMENT '最新进货价',
  PRIMARY KEY (`id`),
  UNIQUE KEY `goodsId` (`goodsId`) USING BTREE,
  CONSTRAINT `warehouse_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Procedure structure for cunchu1
-- ----------------------------
DROP PROCEDURE IF EXISTS `cunchu1`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cunchu1`(`cunchu1` int)
BEGIN
	#Routine body goes here...


SELECT
           
            @temp:= case when @date=DATE_FORMAT(p.createTimestamp,'%Y-%m-%d') then @temp else @temp+1 end as temp,
            @date:=DATE_FORMAT(p.createTimestamp,'%Y-%m-%d') as day
            from purchaseOrder as p,(select @temp:=0,@date='') as b 
            order by id desc;

END
;;
DELIMITER ;
