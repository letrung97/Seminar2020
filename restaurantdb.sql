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

--
-- Table structure for table `danh_sach_thong_tin`
--

DROP TABLE IF EXISTS `danh_sach_thong_tin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danh_sach_thong_tin` (
  `ID` int unsigned NOT NULL AUTO_INCREMENT,
  `quan_ly` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `so_nhan_cong` int unsigned NOT NULL,
  `so_ban` int unsigned NOT NULL,
  `trang_thai` bit(1) NOT NULL,
  `state` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danh_sach_thong_tin`
--

LOCK TABLES `danh_sach_thong_tin` WRITE;
/*!40000 ALTER TABLE `danh_sach_thong_tin` DISABLE KEYS */;
INSERT INTO `danh_sach_thong_tin` VALUES (1,'trung',20,3,_binary '','Hoạt động'),(3,'kim',10,7,_binary '','Hoạt động');
/*!40000 ALTER TABLE `danh_sach_thong_tin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `don_dat`
--

DROP TABLE IF EXISTS `don_dat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `don_dat` (
  `ma_don` int unsigned NOT NULL AUTO_INCREMENT,
  `ten_khach_hang` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `ngay_dat` date NOT NULL,
  `ma_nha_hang` int unsigned NOT NULL,
  `so_ban_dat` int unsigned NOT NULL,
  `ID` int unsigned NOT NULL,
  `ten_nha_hang` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ma_don`),
  UNIQUE KEY `ma_don_UNIQUE` (`ma_don`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `don_dat`
--

LOCK TABLES `don_dat` WRITE;
/*!40000 ALTER TABLE `don_dat` DISABLE KEYS */;
INSERT INTO `don_dat` VALUES (1,'trung','1997-12-11',1,1,2,'a'),(3,'trung','2020-08-30',2,1,3,'b');
/*!40000 ALTER TABLE `don_dat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `main_info`
--

DROP TABLE IF EXISTS `main_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `main_info` (
  `ID` int unsigned NOT NULL AUTO_INCREMENT,
  `ma_nha_hang` int unsigned NOT NULL,
  `ID_quan` int unsigned NOT NULL,
  `ID_phuong` int unsigned NOT NULL,
  `ten_quan` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten_phuong` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten_nha_hang` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `main_info`
--

LOCK TABLES `main_info` WRITE;
/*!40000 ALTER TABLE `main_info` DISABLE KEYS */;
INSERT INTO `main_info` VALUES (1,1,3,5,'Quận 3','5','a'),(2,1,1,1,'Quận 1','Bến Nghé','a'),(3,2,4,5,'Quận 4','5','b');
/*!40000 ALTER TABLE `main_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhan_vien`
--

DROP TABLE IF EXISTS `nhan_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhan_vien` (
  `ma_nhan_vien` int unsigned NOT NULL AUTO_INCREMENT,
  `ID` int unsigned NOT NULL,
  `ten_nhan_vien` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `id_num` int unsigned NOT NULL,
  `chuc_vu` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `so_ngay_nghi_co_phep` int unsigned NOT NULL,
  `so_ngay_nghi_khong_phep` int unsigned NOT NULL,
  PRIMARY KEY (`ma_nhan_vien`),
  UNIQUE KEY `ma_nhan_vien_UNIQUE` (`ma_nhan_vien`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhan_vien`
--

LOCK TABLES `nhan_vien` WRITE;
/*!40000 ALTER TABLE `nhan_vien` DISABLE KEYS */;
INSERT INTO `nhan_vien` VALUES (1,2,'trung',25762629,'Quản lý',1,0),(2,3,'kim',115454,'Lao công',4,5);
/*!40000 ALTER TABLE `nhan_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thuc_don`
--

DROP TABLE IF EXISTS `thuc_don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thuc_don` (
  `stt` int NOT NULL AUTO_INCREMENT,
  `ma_nha_hang` int NOT NULL,
  `ten_mon` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `gia` int NOT NULL,
  PRIMARY KEY (`stt`),
  UNIQUE KEY `stt_UNIQUE` (`stt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thuc_don`
--

LOCK TABLES `thuc_don` WRITE;
/*!40000 ALTER TABLE `thuc_don` DISABLE KEYS */;
/*!40000 ALTER TABLE `thuc_don` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tp_hcm`
--

DROP TABLE IF EXISTS `tp_hcm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tp_hcm` (
  `stt` int unsigned NOT NULL AUTO_INCREMENT,
  `ID_quan` int unsigned NOT NULL,
  `ten_quan` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `ID_phuong` int unsigned NOT NULL,
  `ten_phuong` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`stt`),
  UNIQUE KEY `stt_UNIQUE` (`stt`)
) ENGINE=InnoDB AUTO_INCREMENT=367 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci PACK_KEYS=1 DELAY_KEY_WRITE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_hcm`
--

LOCK TABLES `tp_hcm` WRITE;
/*!40000 ALTER TABLE `tp_hcm` DISABLE KEYS */;
INSERT INTO `tp_hcm` VALUES (1,1,'Quận 1',1,'Bến Nghé'),(2,1,'Quận 1',2,'Bến Thành'),(3,1,'Quận 1',3,'Cầu Kho'),(4,1,'Quận 1',4,'Cầu Ông Lãnh'),(5,1,'Quận 1',5,'Cô Giang'),(6,1,'Quận 1',6,'Đa Kao'),(7,1,'Quận 1',7,'Nguyễn Cư Trinh'),(8,1,'Quận 1',8,'Nguyễn Thái Bình'),(9,1,'Quận 1',9,'Phạm Ngũ Lão'),(10,1,'Quận 1',10,'Tân Định'),(11,2,'Quận 2',1,'An Khánh'),(12,2,'Quận 2',2,'An Lợi Đông'),(13,2,'Quận 2',3,'An Phú'),(14,2,'Quận 2',4,'Bình An'),(15,2,'Quận 2',5,'Bình Khánh'),(16,2,'Quận 2',6,'Bình Trưng Đông'),(17,2,'Quận 2',7,'Bình Trưng Tây'),(18,2,'Quận 2',8,'Cát Lái'),(19,2,'Quận 2',9,'Thạnh Mỹ Lợi'),(20,2,'Quận 2',10,'Thảo Điền'),(21,2,'Quận 2',11,'Thủ Thiêm'),(22,3,'Quận 3',1,'1'),(23,3,'Quận 3',2,'2'),(24,3,'Quận 3',3,'3'),(25,3,'Quận 3',4,'4'),(26,3,'Quận 3',5,'5'),(27,3,'Quận 3',6,'6'),(28,3,'Quận 3',7,'7'),(29,3,'Quận 3',8,'8'),(30,3,'Quận 3',9,'9'),(31,3,'Quận 3',10,'10'),(32,3,'Quận 3',11,'11'),(33,3,'Quận 3',12,'12'),(34,3,'Quận 3',13,'13'),(35,3,'Quận 3',14,'14'),(36,4,'Quận 4',1,'1'),(37,4,'Quận 4',2,'2'),(38,4,'Quận 4',3,'3'),(39,4,'Quận 4',4,'4'),(40,4,'Quận 4',5,'5'),(41,4,'Quận 4',6,'6'),(42,4,'Quận 4',7,'8'),(43,4,'Quận 4',8,'9'),(44,4,'Quận 4',9,'10'),(45,4,'Quận 4',10,'12'),(46,4,'Quận 4',11,'13'),(47,4,'Quận 4',12,'14'),(48,4,'Quận 4',13,'15'),(49,4,'Quận 4',14,'16'),(50,4,'Quận 4',15,'18'),(51,5,'Quận 5',1,'1'),(52,5,'Quận 5',2,'2'),(53,5,'Quận 5',3,'3'),(54,5,'Quận 5',4,'4'),(55,5,'Quận 5',5,'5'),(56,5,'Quận 5',6,'6'),(57,5,'Quận 5',7,'7'),(58,5,'Quận 5',8,'8'),(59,5,'Quận 5',9,'9'),(60,5,'Quận 5',10,'10'),(61,5,'Quận 5',11,'11'),(62,5,'Quận 5',12,'12'),(63,5,'Quận 5',13,'13'),(64,5,'Quận 5',14,'14'),(65,5,'Quận 5',15,'15'),(66,6,'Quận 6',1,'1'),(67,6,'Quận 6',2,'2'),(68,6,'Quận 6',3,'3'),(69,6,'Quận 6',4,'4'),(70,6,'Quận 6',5,'5'),(71,6,'Quận 6',6,'6'),(72,6,'Quận 6',7,'7'),(73,6,'Quận 6',8,'8'),(74,6,'Quận 6',9,'9'),(75,6,'Quận 6',10,'10'),(76,6,'Quận 6',11,'11'),(77,6,'Quận 6',12,'12'),(78,6,'Quận 6',13,'13'),(79,6,'Quận 6',14,'14'),(80,7,'Quận 7',1,'Bình Thuận'),(81,7,'Quận 7',2,'Phú Mỹ'),(82,7,'Quận 7',3,'Phú Thuận'),(83,7,'Quận 7',4,'Tân Hưng'),(84,7,'Quận 7',5,'Tân Kiểng'),(85,7,'Quận 7',6,'Tân Phong'),(86,7,'Quận 7',7,'Tân Phú'),(87,7,'Quận 7',8,'Tân Quy'),(88,7,'Quận 7',9,'Tân Thuận Đông'),(89,7,'Quận 7',10,'Tân Thuận Tây'),(90,8,'Quận 8',1,'1'),(91,8,'Quận 8',2,'2'),(92,8,'Quận 8',3,'3'),(93,8,'Quận 8',4,'4'),(94,8,'Quận 8',5,'5'),(95,8,'Quận 8',6,'6'),(96,8,'Quận 8',7,'7'),(97,8,'Quận 8',8,'8'),(98,8,'Quận 8',9,'9'),(99,8,'Quận 8',10,'10'),(100,8,'Quận 8',11,'11'),(101,8,'Quận 8',12,'12'),(102,8,'Quận 8',13,'13'),(103,8,'Quận 8',14,'14'),(104,8,'Quận 8',15,'15'),(105,8,'Quận 8',16,'16'),(150,9,'Quận 9',1,'Hiệp Phú'),(151,9,'Quận 9',2,'Long Bình'),(152,9,'Quận 9',3,'Long Phước'),(153,9,'Quận 9',4,'Long Thạnh Mỹ'),(154,9,'Quận 9',5,'Long Trường'),(155,9,'Quận 9',6,'Phú Hữu'),(156,9,'Quận 9',7,'Phước Bình'),(157,9,'Quận 9',8,'Phước Long A'),(158,9,'Quận 9',9,'Phước Long B'),(159,9,'Quận 9',10,'Tân Phú'),(160,9,'Quận 9',11,'Tăng Nhơn Phú A'),(161,9,'Quận 9',12,'Tăng Nhơn Phú B'),(162,9,'Quận 9',13,'Trường Thạnh'),(163,10,'Quận 10',1,'1'),(164,10,'Quận 10',2,'2'),(165,10,'Quận 10',3,'3'),(166,10,'Quận 10',4,'4'),(167,10,'Quận 10',5,'5'),(168,10,'Quận 10',6,'6'),(169,10,'Quận 10',7,'7'),(170,10,'Quận 10',8,'8'),(171,10,'Quận 10',9,'9'),(172,10,'Quận 10',10,'10'),(173,10,'Quận 10',11,'11'),(174,10,'Quận 10',12,'12'),(175,10,'Quận 10',13,'13'),(176,10,'Quận 10',14,'14'),(177,10,'Quận 10',15,'15'),(178,11,'Quận 11',1,'1'),(179,11,'Quận 11',2,'2'),(180,11,'Quận 11',3,'3'),(181,11,'Quận 11',4,'4'),(182,11,'Quận 11',5,'5'),(183,11,'Quận 11',6,'6'),(184,11,'Quận 11',7,'7'),(185,11,'Quận 11',8,'8'),(186,11,'Quận 11',9,'9'),(187,11,'Quận 11',10,'10'),(188,11,'Quận 11',11,'11'),(189,11,'Quận 11',12,'12'),(190,11,'Quận 11',13,'13'),(191,11,'Quận 11',14,'14'),(192,11,'Quận 11',15,'15'),(193,11,'Quận 11',16,'16'),(194,12,'Quận 12',1,'An Phú Đông'),(195,12,'Quận 12',2,'Đông Hưng Thuận'),(196,12,'Quận 12',3,'Hiệp Thành'),(197,12,'Quận 12',4,'Tân Chánh Hiệp'),(198,12,'Quận 12',5,'Tân Hưng Thuận'),(199,12,'Quận 12',6,'Tân Thới Hiệp'),(200,12,'Quận 12',7,'Tân Thới Nhất'),(201,12,'Quận 12',8,'Thạnh Lộc'),(202,12,'Quận 12',9,'Thạnh Xuân'),(203,12,'Quận 12',10,'Thới An'),(204,12,'Quận 12',11,'Trung Mỹ Tây'),(205,13,'Quận Bình Tân',1,'An Lạc'),(206,13,'Quận Bình Tân',2,'An Lạc A'),(207,13,'Quận Bình Tân',3,'Bình Hưng Hòa'),(208,13,'Quận Bình Tân',4,'Bình Hưng Hoà A'),(209,13,'Quận Bình Tân',5,'Bình Hưng Hoà B'),(210,13,'Quận Bình Tân',6,'Bình Trị Đông'),(211,13,'Quận Bình Tân',7,'Bình Trị Đông A'),(212,13,'Quận Bình Tân',8,'Bình Trị Đông B'),(213,13,'Quận Bình Tân',9,'Tân Tạo'),(214,13,'Quận Bình Tân',10,'Tân Tạo A'),(215,14,'Quận Bình Thạnh',1,'1'),(216,14,'Quận Bình Thạnh',2,'2'),(217,14,'Quận Bình Thạnh',3,'3'),(218,14,'Quận Bình Thạnh',4,'5'),(219,14,'Quận Bình Thạnh',5,'6'),(220,14,'Quận Bình Thạnh',6,'7'),(221,14,'Quận Bình Thạnh',7,'11'),(222,14,'Quận Bình Thạnh',8,'12'),(223,14,'Quận Bình Thạnh',9,'13'),(224,14,'Quận Bình Thạnh',10,'14'),(225,14,'Quận Bình Thạnh',11,'15'),(226,14,'Quận Bình Thạnh',12,'17'),(227,14,'Quận Bình Thạnh',13,'19'),(228,14,'Quận Bình Thạnh',14,'21'),(229,14,'Quận Bình Thạnh',15,'22'),(230,14,'Quận Bình Thạnh',16,'24'),(231,14,'Quận Bình Thạnh',17,'25'),(232,14,'Quận Bình Thạnh',18,'26'),(233,14,'Quận Bình Thạnh',19,'27'),(234,14,'Quận Bình Thạnh',20,'28'),(235,15,'Quận Gò Vấp',1,'1'),(236,15,'Quận Gò Vấp',2,'3'),(237,15,'Quận Gò Vấp',3,'4'),(238,15,'Quận Gò Vấp',4,'5'),(239,15,'Quận Gò Vấp',5,'6'),(240,15,'Quận Gò Vấp',6,'7'),(241,15,'Quận Gò Vấp',7,'8'),(242,15,'Quận Gò Vấp',8,'9'),(243,15,'Quận Gò Vấp',9,'10'),(244,15,'Quận Gò Vấp',10,'11'),(245,15,'Quận Gò Vấp',11,'12'),(246,15,'Quận Gò Vấp',12,'13'),(247,15,'Quận Gò Vấp',13,'14'),(248,15,'Quận Gò Vấp',14,'15'),(249,15,'Quận Gò Vấp',15,'16'),(250,15,'Quận Gò Vấp',16,'17'),(251,16,'Quận Phú Nhuận',1,'1'),(252,16,'Quận Phú Nhuận',2,'2'),(253,16,'Quận Phú Nhuận',3,'3'),(254,16,'Quận Phú Nhuận',4,'4'),(255,16,'Quận Phú Nhuận',5,'5'),(256,16,'Quận Phú Nhuận',6,'7'),(257,16,'Quận Phú Nhuận',7,'8'),(258,16,'Quận Phú Nhuận',8,'9'),(259,16,'Quận Phú Nhuận',9,'10'),(260,16,'Quận Phú Nhuận',10,'11'),(261,16,'Quận Phú Nhuận',11,'12'),(262,16,'Quận Phú Nhuận',12,'13'),(263,16,'Quận Phú Nhuận',13,'14'),(264,16,'Quận Phú Nhuận',14,'15'),(265,16,'Quận Phú Nhuận',15,'17'),(266,17,'Quận Tân Bình',1,'1'),(267,17,'Quận Tân Bình',2,'2'),(268,17,'Quận Tân Bình',3,'3'),(269,17,'Quận Tân Bình',4,'4'),(270,17,'Quận Tân Bình',5,'5'),(271,17,'Quận Tân Bình',6,'6'),(272,17,'Quận Tân Bình',7,'7'),(273,17,'Quận Tân Bình',8,'8'),(274,17,'Quận Tân Bình',9,'9'),(275,17,'Quận Tân Bình',10,'10'),(276,17,'Quận Tân Bình',11,'11'),(277,17,'Quận Tân Bình',12,'12'),(278,17,'Quận Tân Bình',13,'13'),(279,17,'Quận Tân Bình',14,'14'),(280,17,'Quận Tân Bình',15,'15'),(281,18,'Quận Tân Phú',1,'Hiệp Tân'),(282,18,'Quận Tân Phú',2,'Hoà Thạnh'),(283,18,'Quận Tân Phú',3,'Phú Thạnh'),(284,18,'Quận Tân Phú',4,'Phú Thọ Hoà'),(285,18,'Quận Tân Phú',5,'Phú Trung'),(286,18,'Quận Tân Phú',6,'Sơn Kỳ'),(287,18,'Quận Tân Phú',7,'Tân Quý'),(288,18,'Quận Tân Phú',8,'Tân Sơn Nhì'),(289,18,'Quận Tân Phú',9,'Tân Thành'),(290,18,'Quận Tân Phú',10,'Tân Thới Hoà'),(291,18,'Quận Tân Phú',11,'Tây Thạnh'),(292,19,'Quận Thủ Đức',1,'Bình Chiểu'),(293,19,'Quận Thủ Đức',2,'Bình Thọ'),(294,19,'Quận Thủ Đức',3,'Hiệp Bình Chánh'),(295,19,'Quận Thủ Đức',4,'Hiệp Bình Phước'),(296,19,'Quận Thủ Đức',5,'Linh Chiểu'),(297,19,'Quận Thủ Đức',6,'Linh Đông'),(298,19,'Quận Thủ Đức',7,'Linh Tây'),(299,19,'Quận Thủ Đức',8,'Linh Trung'),(300,19,'Quận Thủ Đức',9,'Linh Xuân'),(301,19,'Quận Thủ Đức',10,'Tam Bình'),(302,19,'Quận Thủ Đức',11,'Tam Phú'),(303,19,'Quận Thủ Đức',12,'Trường Thọ'),(304,20,'Huyện Bình Chánh',1,'Thị trấn Tân Túc'),(305,20,'Huyện Bình Chánh',2,'Xã An Phú Tây'),(306,20,'Huyện Bình Chánh',3,'Xã Bình Chánh'),(307,20,'Huyện Bình Chánh',4,'Xã Bình Hưng'),(308,20,'Huyện Bình Chánh',5,'Xã Bình Lợi'),(309,20,'Huyện Bình Chánh',6,'Xã Đa Phước'),(310,20,'Huyện Bình Chánh',7,'Xã Hưng Long'),(311,20,'Huyện Bình Chánh',8,'Xã Lê Minh Xuân'),(312,20,'Huyện Bình Chánh',9,'Xã Phạm Văn Hai'),(313,20,'Huyện Bình Chánh',10,'Xã Phong Phú'),(314,20,'Huyện Bình Chánh',11,'Xã Quy Đức'),(315,20,'Huyện Bình Chánh',12,'Xã Tân Kiên'),(316,20,'Huyện Bình Chánh',13,'Xã Tân Nhựt'),(317,20,'Huyện Bình Chánh',14,'Xã Tân Quý Tây'),(318,20,'Huyện Bình Chánh',15,'Xã Vĩnh Lộc A'),(319,20,'Huyện Bình Chánh',16,'Xã Vĩnh Lộc B'),(320,21,'Huyện Cần Giờ',1,'Thị trấn Cần Thạnh'),(321,21,'Huyện Cần Giờ',2,'Xã An Thới Đông'),(322,21,'Huyện Cần Giờ',3,'Xã Bình Khánh'),(323,21,'Huyện Cần Giờ',4,'Xã Long Hòa'),(324,21,'Huyện Cần Giờ',5,'Xã Lý Nhơn'),(325,21,'Huyện Cần Giờ',6,'Xã Tam Thôn Hiệp'),(326,21,'Huyện Cần Giờ',7,'Xã Thạnh An'),(327,22,'Huyện Củ Chi',1,'Thị trấn Củ Chi'),(328,22,'Huyện Củ Chi',2,'Xã An Nhơn Tây'),(329,22,'Huyện Củ Chi',3,'Xã An Phú'),(330,22,'Huyện Củ Chi',4,'Xã Bình Mỹ'),(331,22,'Huyện Củ Chi',5,'Xã Hòa Phú'),(332,22,'Huyện Củ Chi',6,'Xã Nhuận Đức'),(333,22,'Huyện Củ Chi',7,'Xã Phạm Văn Cội'),(334,22,'Huyện Củ Chi',8,'Xã Phú Hòa Đông'),(335,22,'Huyện Củ Chi',9,'Xã Phú Mỹ Hưng'),(336,22,'Huyện Củ Chi',10,'Xã Phước Hiệp'),(337,22,'Huyện Củ Chi',11,'Xã Phước Thạnh'),(338,22,'Huyện Củ Chi',12,'Xã Phước Vĩnh An'),(339,22,'Huyện Củ Chi',13,'Xã Tân An Hội'),(340,22,'Huyện Củ Chi',14,'Xã Tân Phú Trung'),(341,22,'Huyện Củ Chi',15,'Xã Tân Thạnh Đông'),(342,22,'Huyện Củ Chi',16,'Xã Tân Thạnh Tây'),(343,22,'Huyện Củ Chi',17,'Xã Tân Thông Hội'),(344,22,'Huyện Củ Chi',18,'Xã Thái Mỹ'),(345,22,'Huyện Củ Chi',19,'Xã Trung An'),(346,22,'Huyện Củ Chi',20,'Xã Trung Lập Hạ'),(347,22,'Huyện Củ Chi',21,'Xã Trung Lập Thượng'),(348,23,'Huyện Hóc Môn',1,'Thị trấn Hóc Môn'),(349,23,'Huyện Hóc Môn',2,'Xã Bà Điểm'),(350,23,'Huyện Hóc Môn',3,'Xã Đông Thạnh'),(351,23,'Huyện Hóc Môn',4,'Xã Nhị Bình'),(352,23,'Huyện Hóc Môn',5,'Xã Tân Hiệp'),(353,23,'Huyện Hóc Môn',6,'Xã Tân Thới Nhì'),(354,23,'Huyện Hóc Môn',7,'Xã Tân Xuân'),(355,23,'Huyện Hóc Môn',8,'Xã Thới Tam Thôn'),(356,23,'Huyện Hóc Môn',9,'Xã Trung Chánh'),(357,23,'Huyện Hóc Môn',10,'Xã Xuân Thới Đông'),(358,23,'Huyện Hóc Môn',11,'Xã Xuân Thới Sơn'),(359,23,'Huyện Hóc Môn',12,'Xã Xuân Thới Thượng'),(360,24,'Huyện Nhà Bè',1,'Huyện Nhà Bè'),(361,24,'Huyện Nhà Bè',2,'Xã Hiệp Phước'),(362,24,'Huyện Nhà Bè',3,'Xã Long Thới'),(363,24,'Huyện Nhà Bè',4,'Xã Nhơn Đức'),(364,24,'Huyện Nhà Bè',5,'Xã Phú Xuân'),(365,24,'Huyện Nhà Bè',6,'Xã Phước Kiển'),(366,24,'Huyện Nhà Bè',7,'Xã Phước Lộc');
/*!40000 ALTER TABLE `tp_hcm` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-17 11:08:14
