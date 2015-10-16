/*
SQLyog Enterprise - MySQL GUI v6.13
MySQL - 5.6.11 : Database - safetaxi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `comment_id` int(11) NOT NULL,
  `taxi_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `comment` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `rating` float NOT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `placas` */

DROP TABLE IF EXISTS `placas`;

CREATE TABLE `placas` (
  `placa_inter_id` int(11) NOT NULL AUTO_INCREMENT,
  `placa` varchar(20) CHARACTER SET utf8 NOT NULL,
  `hash` int(11) NOT NULL,
  PRIMARY KEY (`placa_inter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `ratings` */

DROP TABLE IF EXISTS `ratings`;

CREATE TABLE `ratings` (
  `taxi_id` int(11) NOT NULL,
  `rating` float NOT NULL,
  `comment` varchar(150) CHARACTER SET utf8 NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `taxis` */

DROP TABLE IF EXISTS `taxis`;

CREATE TABLE `taxis` (
  `taxi_id` int(11) NOT NULL AUTO_INCREMENT,
  `license_id` int(11) NOT NULL,
  `model` int(4) DEFAULT NULL,
  `make` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `rating_avg` float DEFAULT '4',
  `number_ratings` int(11) DEFAULT '1',
  PRIMARY KEY (`taxi_id`,`license_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
