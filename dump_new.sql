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
-- Table structure for table `tblartisanitem`
--

use handmade;

DROP TABLE IF EXISTS `tblartisanitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblartisanitem` (
  `item_id` int(11) NOT NULL,
  `artisan_id` varchar(45) DEFAULT NULL,
  `item_name` varchar(90) DEFAULT NULL,
  `item_description` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblartisanitem`
--

LOCK TABLES `tblartisanitem` WRITE;
/*!40000 ALTER TABLE `tblartisanitem` DISABLE KEYS */;
INSERT INTO `tblartisanitem` VALUES (1,'1','Teddy Bear','Handmade teddy bear from the mountains in Peru!'),(2,'1','Billy Bear','Teddy bear but updated. Its Billy Bear!'),(3,'1','Jonny Bear','Billy bear but updated. Its Jonny Bear!'),(4,'1','Bobby Bear','Jonny bear but updated. Its Bobby Bear!'),(5,'1','Andy Bear','Bobby bear but updated. Its Andy Bear!'),(6,'2','Teddy Bear',NULL);
/*!40000 ALTER TABLE `tblartisanitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblartisans`
--

DROP TABLE IF EXISTS `tblartisans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblartisans` (
  `artisan_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `bio` varchar(2000) DEFAULT NULL,
  `phone_no` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`artisan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblartisans`
--

LOCK TABLES `tblartisans` WRITE;
/*!40000 ALTER TABLE `tblartisans` DISABLE KEYS */;
INSERT INTO `tblartisans` VALUES (1,'Maria','Lopez','I am an artisan based out of peru. My goal is to make goods that will put a smile on peoples face. I am an artisan based out of peru. My goal is to make goods that will put a smile on peoples face. I am an artisan based out of peru. My goal is to make goods that will put a smile on peoples face. I am an artisan based out of peru. My goal is to make goods that will put a smile on peoples face. I am an artisan based out of peru. My goal is to make goods that will put a smile on peoples face. I am an artisan based out of peru. My goal is to make goods that will put a smile on peoples face.',NULL),(2,'Debora','Hernendez','I am an artisan who lives in Mexico. I love making wicker baskets with my hand from the reeds at the nearby river.',NULL),(3,'Gloria','Rio','I am an artisan who lives in Mexico. I love making wicker baskets with my hand from the reeds at the nearby river.',NULL),(4,'Elena','Gonzales','I am an artisan who likes to play the flute by our local river. I also have a passion for making scarfs. I specialize in tube scarfs but I can make the normal kinds too. My favorite scaf color is red as it is the historic color of my village.',NULL),(5,'Jazmin','Lopez','I am from the village of etsicano in the andes mountains. We are known arount the world for our pottery. My specialty is vases. They are great for American Thanksgiving dinner and for putting on tables that are very narrow and easy to fall over. If it does fall over no worries because I provide replacement for a one time nominal fee of the original price of the vase.',NULL);
/*!40000 ALTER TABLE `tblartisans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblsoldItem`
--

DROP TABLE IF EXISTS `tblsoldItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblsoldItem` (
  `sold_product_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_sold` timestamp NULL DEFAULT NULL,
  `price` decimal(10,4) DEFAULT NULL,
  `artisan_id` int(11) DEFAULT NULL,
  `product_description` varchar(250) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sold_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblsoldItem`
--

LOCK TABLES `tblsoldItem` WRITE;
/*!40000 ALTER TABLE `tblsoldItem` DISABLE KEYS */;
INSERT INTO `tblsoldItem` VALUES (1,'2019-03-12 05:19:21',20.0000,1,'This is a teddy bear',2),(2,'2019-03-13 05:19:21',20.0000,1,'Different Teddy bear',3),(3,'2019-03-14 05:19:21',20.0000,1,'Different Teddy bear',2),(4,'2019-03-13 05:19:21',20.0000,1,'Different Teddy bear',2),(5,'2019-03-12 05:19:21',20.0000,1,'Different Teddy bear',3),(6,'2019-03-13 05:19:21',20.0000,1,'Different Teddy bear',3),(7,'2019-03-15 05:19:21',20.0000,1,'Different Teddy bear',3),(8,'2019-03-15 05:19:21',20.0000,1,'Different Teddy bear',3),(9,'2019-03-16 05:19:21',20.0000,1,'Different Teddy bear',3),(10,'2019-03-16 05:19:21',20.0000,1,'Different Teddy bear',3),(11,'2019-03-16 05:19:21',20.0000,1,'Different Teddy bear',3),(12,'2019-03-16 05:19:21',20.0000,1,'Different Teddy bear',3),(13,'2019-03-16 05:19:21',20.0000,1,'Different Teddy bear',3),(14,'2019-03-16 05:19:21',20.0000,1,'Different Teddy bear',3);
/*!40000 ALTER TABLE `tblsoldItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbluser`
--

DROP TABLE IF EXISTS `tbluser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbluser` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `company` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address1` varchar(45) DEFAULT NULL,
  `address2` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `postal` varchar(45) DEFAULT NULL,
  `is_active` int(2) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbluser`
--

LOCK TABLES `tbluser` WRITE;
/*!40000 ALTER TABLE `tbluser` DISABLE KEYS */;
INSERT INTO `tbluser` VALUES (1,'ybtriau@gmail.com','$2a$10$aa0GnGoVmYaBNxhW5xNbaO/51qp6lXNJr1vbfS2BjEc8k23RTOe0i','none','Matt','Triau','ybtriau@gmail.com',NULL,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `tbluser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbluserrolemap`
--

DROP TABLE IF EXISTS `tbluserrolemap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbluserrolemap` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbluserrolemap`
--

LOCK TABLES `tbluserrolemap` WRITE;
/*!40000 ALTER TABLE `tbluserrolemap` DISABLE KEYS */;
INSERT INTO `tbluserrolemap` VALUES (1,1,1);
/*!40000 ALTER TABLE `tbluserrolemap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbluserroles`
--

DROP TABLE IF EXISTS `tbluserroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbluserroles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbluserroles`
--

LOCK TABLES `tbluserroles` WRITE;
/*!40000 ALTER TABLE `tbluserroles` DISABLE KEYS */;
INSERT INTO `tbluserroles` VALUES (1,'ROLE_ADMIN');
/*!40000 ALTER TABLE `tbluserroles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-12  0:55:08