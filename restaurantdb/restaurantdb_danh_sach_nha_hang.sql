-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: restaurantdb
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `danh_sach_nha_hang`
--

DROP TABLE IF EXISTS `danh_sach_nha_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danh_sach_nha_hang` (
  `ma_nha_hang` int unsigned NOT NULL AUTO_INCREMENT,
  `ten_nha_hang` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `so_chi_nhanh` int unsigned NOT NULL,
  `loai_nha_hang` bit(1) NOT NULL,
  `loai_nha_hang_str` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ma_nha_hang`),
  UNIQUE KEY `ten_nha_hang_UNIQUE` (`ten_nha_hang`),
  UNIQUE KEY `ma_nha_hang_UNIQUE` (`ma_nha_hang`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danh_sach_nha_hang`
--

LOCK TABLES `danh_sach_nha_hang` WRITE;
/*!40000 ALTER TABLE `danh_sach_nha_hang` DISABLE KEYS */;
INSERT INTO `danh_sach_nha_hang` VALUES (1,'a',1,_binary '\0','Trực tiếp'),(2,'b',2,_binary '','Đặt trước'),(4,'d',5,_binary '\0','Trực tiếp'),(6,'f',7,_binary '','Đặt trước'),(7,'g',1,_binary '','Đặt trước');
/*!40000 ALTER TABLE `danh_sach_nha_hang` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-13 11:37:15
