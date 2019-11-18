/*
SQLyog Professional v12.08 (64 bit)
MySQL - 8.0.18 : Database - db-book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db-book` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `db-book`;

/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `booktypeid` int(11) DEFAULT NULL,
  `bookdesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `booktypeid` (`booktypeid`),
  CONSTRAINT `t_book_ibfk_1` FOREIGN KEY (`booktypeid`) REFERENCES `t_booktype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_book` */

insert  into `t_book`(`id`,`bookname`,`author`,`sex`,`price`,`booktypeid`,`bookdesc`) values (1,'计算机网络','sxy','男',100,1,'简述计算机网络'),(2,'信息项目管理','我','男',80,1,'主要使用python进行编程'),(3,'建筑工程','你','女',20,2,'建筑'),(4,'test1','sxy','男',25,6,'test1'),(5,'test2','zfl','男',33,3,'test2'),(6,'test3','ch','男',3,3,'test3');

/*Table structure for table `t_booktype` */

DROP TABLE IF EXISTS `t_booktype`;

CREATE TABLE `t_booktype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookTypeName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `bookTypeDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_booktype` */

insert  into `t_booktype`(`id`,`bookTypeName`,`bookTypeDesc`) values (1,'计算机类','关于计算机科学的图书'),(2,'建筑类','关于建筑的图书'),(3,'马哲类','关于马克思主义哲学的图书'),(4,'数学类','关于数学的书'),(5,'英语','英语类图书'),(6,'德语','德语类的图书');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `passWord` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`userName`,`passWord`) values (1,'sxy','1233210');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
