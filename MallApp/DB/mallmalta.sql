/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.5.52-MariaDB : Database - catike_mall
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`catike_mall` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `catike_mall`;

/*Table structure for table `advertise` */

DROP TABLE IF EXISTS `advertise`;

CREATE TABLE `advertise` (
  `PK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(36) DEFAULT NULL,
  `ENABLE` tinyint(1) DEFAULT '1',
  `POSITION` int(11) DEFAULT '0',
  `URL` varchar(1024) DEFAULT '/',
  `IMAGE_DIR` varchar(100) DEFAULT NULL,
  `DESCRIPTION` varchar(1024) DEFAULT NULL,
  `PRICE` decimal(10,0) DEFAULT '0',
  PRIMARY KEY (`PK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `advertise` */

insert  into `advertise`(`PK_ID`,`NAME`,`ENABLE`,`POSITION`,`URL`,`IMAGE_DIR`,`DESCRIPTION`,`PRICE`) values (1,'How to Open an Online Store',0,0,'http://www.mallmalta.com/path/HowToOpenAnOnlineStore.shopping','OpenStore.jpg',NULL,'0'),(2,'click HRER to Regist',0,0,'http://www.mallmalta.com/user/registpage.shopping','Register.jpg',NULL,'0'),(3,'click HRER to Regist',1,1,'http://www.mallmalta.com/user/registpage.shopping','z1.jpg',NULL,'0'),(4,'Login',1,1,'http://www.mallmalta.com/user/loginpage.shopping','y1.jpg',NULL,'0'),(5,'How to Open an Online Store',1,1,'http://www.mallmalta.com/path/HowToOpenAnOnlineStore.shopping','z2.jpg',NULL,'0'),(6,'Advantage of Opening Online Store',1,1,'http://www.mallmalta.com/path/HowToOpenAnOnlineStore.shopping','y2.jpg',NULL,'0');

/*Table structure for table `goods_detail_dis` */

DROP TABLE IF EXISTS `goods_detail_dis`;

CREATE TABLE `goods_detail_dis` (
  `PK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `GOODS_PK_ID` int(11) DEFAULT NULL,
  `DISCRIBE` varchar(1000) DEFAULT NULL,
  `MAKE_EMP` int(11) DEFAULT NULL,
  `MAKE_TIME` datetime DEFAULT NULL,
  `MODIFY_EMP` int(11) DEFAULT NULL,
  `MODIFY_TIME` datetime DEFAULT NULL,
  `VER` int(11) DEFAULT '0',
  PRIMARY KEY (`PK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `goods_detail_dis` */

insert  into `goods_detail_dis`(`PK_ID`,`GOODS_PK_ID`,`DISCRIBE`,`MAKE_EMP`,`MAKE_TIME`,`MODIFY_EMP`,`MODIFY_TIME`,`VER`) values (1,1,'Machine washable.\r\n54% Viscose, 37% Acrylic, 9% Nylon.',1,'2017-08-20 05:12:30',1,'2017-08-20 05:12:30',0),(2,2,'Prince of Wales style check, mini length and front pocket details.\r\nRegular waistband to hem 18\" / 46cm.\r\nMachine washable.\r\nMain 63% Polyester, 33% Viscose, 4% Elastane. Lining 100% Polyester.',1,'2017-08-20 05:13:46',1,'2017-08-20 05:13:46',0),(3,3,'An essential wardrobe piece, featuring a button-down collar and bucket pocket.\r\n100% Cotton.',1,'2017-08-20 05:15:02',1,'2017-08-20 05:15:02',0),(4,4,'100% Polyester.',1,'2017-08-20 05:18:48',1,'2017-08-20 05:18:48',0),(5,5,'With warm padding and fleece-lined pockets.\r\nShell 100% Polyester. Lining 100% Polyester. Wadding 100% Polyester.',1,'2017-08-20 05:20:58',1,'2017-08-20 05:20:58',0),(7,8,'Super sized Jack Daniels bottle with a neat swing cradle that assists pouring. Great conversation piece and a must for any serious JD collector (or drinker for that matter) Jack Daniel\"s Tennessee Whiskey is made using a very old process of passing the newly distilled whiskey through 10 foot high mellowing vats packed with sugar maple charcoal. Jack Daniel\"s still insist on the same meticulous processes and draw water from the same natural underground cave in Lynchburg, Tennessee Not for sale to persons under the age of 18.Drink responsiblyvisit us on:www.the818collector.webs.comFacebook pages:Jack Malta CollectorsThe 818 Collector (press like page for updates)',2,'2017-08-21 17:46:47',2,'2017-08-21 17:47:19',1),(8,9,'exclusive, Jack Daniel\'s No.27 Gold gained a wider release in Autumn 2015. Initially matured in virgin American white oak casks, it\'s been finished in maple-wood barrels and twice filtered though maple-wood charcoal, it\'s rich with extra notes of maple.\r\n\r\nNot for sale to persons under the age of 18.\r\nDrink responsibly\r\n\r\nvisit us on:\r\nwww.the818collector.webs.com\r\n\r\nFacebook pages:\r\nJack Malta Collectors\r\nThe 818 Collector (press like page for updates)\r\n\r\nRef:Rpc3566650',2,'2017-08-21 20:27:52',2,'2017-08-21 20:27:52',0),(9,10,'A set of 20cl Johnnie walker this is a collectors item. You will not find in  shops for sale in Malta',2,'2017-08-21 22:02:26',2,'2017-08-21 22:02:26',0),(10,11,'This is a limited edition bottle.\r\nOnly 750 were made!\r\nOwn one now. ',2,'2017-08-21 22:05:53',2,'2017-08-21 22:05:53',0),(11,12,'This is a bottle to celebrate 150 anniversary of Jack Daniels this bottle is a decanter',2,'2017-08-21 22:38:34',2,'2017-08-21 22:38:34',0),(12,13,'This 12 year old Johnnie Walker Black Label was bottled for the Asian market in 2011. The label and packaging were designed by renowned artist Jasper Goodall and portray the famous emblem of the \"Striding Man\' in flame format. \r\n\r\nNot for sale to persons under the age of 18.\r\nDrink responsibly\r\n\r\nvisit us on:\r\nwww.the818collector.webs.com\r\n\r\nFacebook pages:\r\nJack Malta Collectors\r\nThe 818 Collector (press like page for updates)\r\n\r\nRef:Rpc3568100',2,'2017-08-21 22:47:24',2,'2017-08-21 22:47:24',0);

/*Table structure for table `goods_info` */

DROP TABLE IF EXISTS `goods_info`;

CREATE TABLE `goods_info` (
  `PK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(36) DEFAULT NULL,
  `ENABLE` tinyint(1) DEFAULT NULL,
  `PRICE` decimal(10,0) DEFAULT NULL,
  `COUNT` int(11) DEFAULT NULL,
  `IMAGE_DIR` varchar(100) DEFAULT NULL,
  `STORE_PKID` int(11) DEFAULT NULL,
  `BRIEF_INTRODUCTION` varchar(1024) DEFAULT NULL,
  `EXPOSURE` int(11) DEFAULT '0',
  `WEIGHTS` int(11) DEFAULT '0',
  `MAKE_EMP` int(11) DEFAULT NULL,
  `MAKE_TIME` datetime DEFAULT NULL,
  `MODIFY_EMP` int(11) DEFAULT NULL,
  `MODIFY_TIME` datetime DEFAULT NULL,
  `VER` int(11) DEFAULT '0',
  PRIMARY KEY (`PK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `goods_info` */

insert  into `goods_info`(`PK_ID`,`NAME`,`ENABLE`,`PRICE`,`COUNT`,`IMAGE_DIR`,`STORE_PKID`,`BRIEF_INTRODUCTION`,`EXPOSURE`,`WEIGHTS`,`MAKE_EMP`,`MAKE_TIME`,`MODIFY_EMP`,`MODIFY_TIME`,`VER`) values (1,'Asymmetric Ribbed Shell',1,'23',668,'image/upload/goods/1503177149990745.jpg',1,'Machine washable. ',4658,0,1,'2017-08-20 05:12:29',1,'2017-08-20 05:12:29',0),(2,'Check Single Breasted Jacket ',1,'43',698,'image/upload/goods/1503177226789150.jpg',1,'Prince of Wales style check, mini length and front pocket details.',4647,0,1,'2017-08-20 05:13:46',1,'2017-08-20 05:13:46',0),(3,'Long Sleeve Oxford Shirt',1,'18',638,'image/upload/goods/1503177302627132.jpg',1,'An essential wardrobe piece',4661,0,1,'2017-08-20 05:15:02',1,'2017-08-20 05:15:02',0),(4,'Ecru Longline Satin Shirt',1,'23',681,'image/upload/goods/1503177528436872.jpg',1,'100% Polyester.',4658,0,1,'2017-08-20 05:18:48',1,'2017-08-20 05:18:48',0),(5,'Padded Gilet (3mths-6yrs)',1,'22',625,'image/upload/goods/1503177658862975.jpg',1,'With warm padding and fleece-lined pockets.',4651,0,1,'2017-08-20 05:20:58',1,'2017-08-20 05:20:58',0),(8,'Jack Daniel\'s 3ltr on cradle',1,'175',2,'image/upload/goods/1503308807760380.jpg',2,'Rare on the Island',4471,0,2,'2017-08-21 17:46:47',2,'2017-08-21 17:47:19',1),(9,'Jack Daniel\'s Gold No 27',1,'87',1,'image/upload/goods/1503318472095163.jpg',2,'Rare on the Island',4449,0,2,'2017-08-21 20:27:52',2,'2017-08-21 20:27:52',0),(10,'Johnnie walker Set',1,'135',2,'image/upload/goods/15033241463433.jpg',2,'Rare on the Island',4438,0,2,'2017-08-21 22:02:26',2,'2017-08-21 22:02:26',0),(11,'Johnnie walker Monkey',1,'375',3,'image/upload/goods/1503324353380778.jpg',2,'Limited edition',4437,0,2,'2017-08-21 22:05:53',2,'2017-08-21 22:05:53',0),(12,'Jack Daniel\'s 150th Anniversary',1,'165',3,'image/upload/goods/1503326314199988.jpg',2,'Collectors Item',4436,0,2,'2017-08-21 22:38:34',2,'2017-08-21 22:38:34',0),(13,'Johnnie walker Gasper Goodall',1,'165',3,'image/upload/goods/150332684425168.jpg',2,'Rare on the Island',4436,0,2,'2017-08-21 22:47:24',2,'2017-08-21 22:47:24',0);

/*Table structure for table `store_info` */

DROP TABLE IF EXISTS `store_info`;

CREATE TABLE `store_info` (
  `PK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STORE_NAME` varchar(36) DEFAULT NULL,
  `OWNER_PKID` int(11) DEFAULT NULL,
  `IMAGE_DIR` varchar(1024) DEFAULT NULL,
  `ADDRESS` varchar(36) DEFAULT NULL,
  `DISCRIPTION` varchar(512) DEFAULT NULL,
  `MAKE_EMP` int(11) DEFAULT NULL,
  `MAKE_TIME` datetime DEFAULT NULL,
  `MODIFY_EMP` int(11) DEFAULT NULL,
  `MODIFY_TIME` datetime DEFAULT NULL,
  `VER` int(11) DEFAULT '0',
  PRIMARY KEY (`PK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `store_info` */

insert  into `store_info`(`PK_ID`,`STORE_NAME`,`OWNER_PKID`,`IMAGE_DIR`,`ADDRESS`,`DISCRIPTION`,`MAKE_EMP`,`MAKE_TIME`,`MODIFY_EMP`,`MODIFY_TIME`,`VER`) values (1,'Next',1,'image/upload/store/1503177070793441.jpg','Triq It - Torri, Tas-Sliema, Malta','Shop the very latest fashion online at Next Malta. Excellent international shipping and return options available.',1,'2017-08-20 05:11:10',1,'2017-08-20 05:11:18',1),(2,'The 818 Collector',2,'image/upload/store/1503307990226954.jpg','Qawra','Hi I sell and buy Whisky for collectors .',2,'2017-08-21 17:33:10',2,'2017-08-21 17:33:41',1);

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `PK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(36) DEFAULT NULL,
  `PASSWORD` varchar(36) DEFAULT NULL,
  `ENABLED` tinyint(1) DEFAULT NULL,
  `AUTHORITY` varchar(36) DEFAULT NULL,
  `IMAGE_DIR` varchar(1024) DEFAULT NULL,
  `FIRSTNAME` varchar(36) DEFAULT NULL,
  `LASTNAME` varchar(36) DEFAULT NULL,
  `EMAIL` varchar(36) DEFAULT NULL,
  `TELEPHONE` varchar(36) DEFAULT NULL,
  `FAX` varchar(36) DEFAULT NULL,
  `COMPANY` varchar(36) DEFAULT NULL,
  `ADDRESS1` varchar(36) DEFAULT NULL,
  `ADDRESS2` varchar(36) DEFAULT NULL,
  `CITY` varchar(36) DEFAULT NULL,
  `POST_CODE` varchar(36) DEFAULT NULL,
  `COUNTRY` varchar(36) DEFAULT NULL,
  `REGION` varchar(36) DEFAULT NULL,
  `MAKE_IP` varchar(36) DEFAULT NULL,
  `MAKE_TIME` datetime DEFAULT NULL,
  `MODIFY_EMP` int(11) DEFAULT NULL,
  `MODIFY_TIME` datetime DEFAULT NULL,
  `VER` int(11) DEFAULT '0',
  PRIMARY KEY (`PK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `user_info` */

insert  into `user_info`(`PK_ID`,`USERNAME`,`PASSWORD`,`ENABLED`,`AUTHORITY`,`IMAGE_DIR`,`FIRSTNAME`,`LASTNAME`,`EMAIL`,`TELEPHONE`,`FAX`,`COMPANY`,`ADDRESS1`,`ADDRESS2`,`CITY`,`POST_CODE`,`COUNTRY`,`REGION`,`MAKE_IP`,`MAKE_TIME`,`MODIFY_EMP`,`MODIFY_TIME`,`VER`) values (1,'Next','nextnext',1,'ROLE_USER','image/upload/user/150317688581596.jpg','Next','Malian','','2778 0704','','','','','','','Malta',NULL,'127.0.0.1','2017-08-20 05:08:05',1,'2017-08-20 05:29:52',1),(2,'Joe818','21573304',1,'ROLE_USER','image/upload/user/1503307650447818.jpg','Joseph','Micallef','Surjoe@onvol.net','79683683','','The 818 Collector','','','Bugibba','Spb08','Malta',NULL,'127.0.0.1','2017-08-21 17:27:30',NULL,'2017-08-21 17:27:30',0),(4,'Maturingsun@hotmail.com','shithappens23',1,'ROLE_USER',NULL,'','','','','','','','','','','Malta',NULL,'127.0.0.1','2017-08-22 15:42:10',NULL,'2017-08-22 15:42:10',0),(5,'danielleattardportughes','daniel',1,'ROLE_USER',NULL,'','','','','','','','','','','Malta',NULL,'127.0.0.1','2017-08-22 15:46:42',NULL,'2017-08-22 15:46:42',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
