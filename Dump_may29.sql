-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: handmade
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `tbldonation`
--
use leftovers;

DROP TABLE IF EXISTS `tbldonation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbldonation` (
  `donationId` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(150) DEFAULT NULL,
  `xcoord` double DEFAULT NULL,
  `ycoord` double DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `vegetarian` int(11) DEFAULT NULL,
  `dairy` int(11) DEFAULT NULL,
  `gluten` int(11) DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `notes` varchar(200) DEFAULT NULL,
  `parishable` int(11) DEFAULT NULL,
  `soy` int(11) DEFAULT NULL,
  `wheat` int(11) DEFAULT NULL,
  `peanut` int(11) DEFAULT NULL,
  `nut` int(11) DEFAULT NULL,
  `shellfish` int(11) DEFAULT NULL,
  `fish` int(11) DEFAULT NULL,
  `image_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`donationId`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbldonation`
--

LOCK TABLES `tbldonation` WRITE;
/*!40000 ALTER TABLE `tbldonation` DISABLE KEYS */;
INSERT INTO `tbldonation` VALUES (40,'Pasta',35.12,-120.39,1,NULL,NULL,NULL,1,'2018-04-24 18:46:12','Fresh!',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(41,'Rice',35.48,-120.12,1,NULL,NULL,NULL,1,'2018-04-24 15:12:12','Special recipe',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(42,'Cookies',35.59,-120.098,1,NULL,NULL,NULL,1,'2018-04-24 11:55:12','Might be bad',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(43,'Chips',35.62,-120.98,1,NULL,NULL,NULL,1,'2018-04-24 16:26:12','Forks in the bag',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(44,'Granola',35.98,-120.36,1,NULL,NULL,NULL,1,'2018-04-24 09:12:12','Tastes great!',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(45,'Popcorn',35.71,-120.87,1,NULL,NULL,NULL,1,'2018-04-24 10:53:12','Awesome!',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(46,'Pizza',35.14,-120.29,1,NULL,NULL,NULL,1,'2018-04-24 11:32:12','Tasty!',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(91,'Fish Tacos',35.2926913,-120.6629941,1,1,0,1,0,'2018-04-30 16:36:25','Theyre great!!',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(92,'donation',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(93,'donation',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(94,'donation',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(95,'updated donation',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(96,'donation',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(97,'donation',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(98,'Tst',39.1272433,-77.1481344,1,0,0,1,1,'2018-05-21 14:16:48','testing',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(99,'Test',39.1272433,-77.1481344,1,0,0,1,1,'2018-05-21 14:19:02','sefd',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(100,'another test',39.1272433,-77.1481344,1,0,0,1,1,'2018-05-21 14:21:14','test',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(101,'testing yet again',39.1272433,-77.1481344,1,1,0,0,1,'2018-05-21 14:22:23','These are my notes',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(102,'This is a test',39.1272433,-77.1481344,1,1,0,0,1,'2018-05-21 14:23:19','testing notes',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(103,'Testings',39.1272433,-77.1481344,1,1,0,1,1,'2018-05-21 14:24:57','Testing again',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(104,'Another test',39.1272433,-77.1481344,1,1,0,0,1,'2018-05-21 14:26:22','These are my notes',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(105,'Testing',39.1272433,-77.1481344,1,1,0,0,1,'2018-05-21 14:27:42','test',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(106,'test',39.1272433,-77.1481344,1,1,0,0,1,'2018-05-21 14:30:37','Testing',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(107,'test',39.1272433,-77.1481344,1,1,1,1,1,'2018-05-21 14:32:34','This is a test',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(108,'testing',39.1272433,-77.1481344,1,0,1,1,1,'2018-05-21 14:34:53','test',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(109,'jiiojofaew',39.1272433,-77.1481344,1,0,0,1,1,'2018-05-21 14:38:01','sdffdsf',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(110,'sdfsafsad',39.1272433,-77.1481344,1,1,0,1,1,'2018-05-21 14:38:53','test notes',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(111,'test',39.1272433,-77.1481344,1,1,0,1,1,'2018-05-21 14:39:52','tetsting notes',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(112,'testing',39.1272433,-77.1481344,1,1,0,0,1,'2018-05-21 14:44:24','testing',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(113,'testing',39.1272433,-77.1481344,1,1,0,1,1,'2018-05-21 14:46:03','test',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(114,'testing',39.1272433,-77.1481344,1,1,0,1,1,'2018-05-21 14:52:42','notes',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(115,'testing',39.1272433,-77.1481344,1,1,0,1,1,'2018-05-21 14:57:02','testing',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(116,'testing',39.1272433,-77.1481344,1,1,0,0,1,'2018-05-21 14:58:57','tests',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(117,'testing',39.1272433,-77.1481344,1,1,0,1,1,'2018-05-21 15:07:31','test notess',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(118,'testing',39.1272433,-77.1481344,1,1,1,0,1,'2018-05-21 15:08:52','testing',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(119,'testing',39.1272433,-77.1481344,1,1,0,1,1,'2018-05-21 15:09:48','test',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(120,'test donation',39.1272433,-77.1481344,1,1,0,1,1,'2018-05-21 15:10:50','test',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(121,'taco',39.1272433,-77.1481344,1,1,0,1,1,'2018-05-21 15:31:40','notes',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(122,'taco',39.1272433,-77.1481344,1,1,0,1,1,'2018-05-21 15:32:24','testing notes',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbldonation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-29 16:12:17