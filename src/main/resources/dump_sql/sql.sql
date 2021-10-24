-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: car
-- ------------------------------------------------------
-- Server version	5.7.35-log

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
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_Id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `company_Id` int(11) DEFAULT NULL,
  `image_Path` varchar(255) DEFAULT NULL,
  `price_From` float DEFAULT NULL,
  `price_To` float DEFAULT NULL,
  `information` varchar(355) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `type` varchar(32) DEFAULT NULL,
  `seats` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `usage` tinyint(4) DEFAULT NULL,
  `status_Car` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_Id` (`user_Id`),
  KEY `company_Id` (`company_Id`),
  CONSTRAINT `car_ibfk_1` FOREIGN KEY (`user_Id`) REFERENCES `user` (`id`),
  CONSTRAINT `car_ibfk_2` FOREIGN KEY (`company_Id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,2,'MERCEDES BENZ C200-Class',1,'/image/mec.jpg',2321,3300,'xe mới','0987654321','xanh','suv',5,1,1,0),(2,2,'VinFast LuxSA ',3,'/image/v22.jpg',1000,1200,'Xe s? d?ng ??ng c? V7',NULL,'Tr?ng','Sedan',5,1,1,0),(3,1,'MEc',1,'/image/mec1.jpg',30000,40000,'Xe ddejp ','0943189438','trắng','suv',5,1,1,1),(4,3,'MERCEDES BENZ C-Class',1,'/image/mec11.jpg',13000,20000,'- Hộp số tự động 9 cấp 9G Tronic','0943189438','trắng','Hạng A',4,1,1,1),(5,2,'MERCEDES BENZ G63',1,'/image/mec21.jpg',30000,40000,'- Hộp số tự động 9 cấp 9G Tronic','0943189438','Đen','SUV',5,1,1,1),(6,2,'MERCEDES BENZ C200-Class',1,'/image/mec31.jpg',30000,40000,'- Điều hoà tự động 3 vùng độc lập.Hệ thống loa vòm 13 loa Burmester nghe nhạc phê pha lắm ạ','0943189438','Trắng','HẠng A',4,1,0,1),(8,3,'MERCEDES BENZ C200-Class',1,'/image/mêc200.jpg',20000,30000,'- Điều hoà tự động 3 vùng độc lập.Hệ thống loa vòm 13 loa Burmester nghe nhạc phê pha lắm ạ','0943189438','Xanh','HẠNG A',4,1,0,1),(9,2,'VinFast President',3,'/image/v22.jpg',18000,20000,'khối động cơ V8 mạnh mẽ, với 8 xy-lanh xếp hình chữ V, dung tích 6.2L, cho công suất tối đa lên tới 455 mã lực và mô-men xoắn cực đại 624Nm, kết hợp với hộp số ZF 8 cấp và hệ dẫn động 4 bánh, xe có thể đạt tốc độ tối đa lên tới 300 km/h.','0943189438','đen','SUV',7,1,1,1),(10,2,'VINFAST LUX A2.0',3,'/image/v11.jpg',80000,40000,'khối động cơ V8 mạnh mẽ, với 8 xy-lanh xếp hình chữ V, dung tích 6.2L, cho công suất tối đa lên tới 455 mã lực và mô-men xoắn cực đại 624Nm, kết hợp với hộp số ZF 8 cấp và hệ dẫn động 4 bánh, xe có thể đạt tốc độ tối đa lên tới 300 km/h.','0943189438','Đỏ','Hạng A',4,1,0,1),(11,3,'VINFAST LUX SA2.0',3,'/image/v31.jpg',140000,40000,'khối động cơ V8 mạnh mẽ, với 8 xy-lanh xếp hình chữ V, dung tích 6.2L, cho công suất tối đa lên tới 455 mã lực và mô-men xoắn cực đại 624Nm, kết hợp với hộp số ZF 8 cấp và hệ dẫn động 4 bánh, xe có thể đạt tốc độ tối đa lên tới 300 km/h.','0943189438','Đen','Hạng A',4,1,0,1),(12,2,'VINFAST FADIL aaa',3,'/image/v41.jpg',40000,40000,'khối động cơ V8 mạnh mẽ, với 8 xy-lanh xếp hình chữ V, dung tích 6.2L, cho công suất tối đa lên tới 455 mã lực và mô-men xoắn cực đại 624Nm, kết hợp với hộp số ZF 8 cấp và hệ dẫn động 4 bánh, xe có thể đạt tốc độ tối đa lên tới 300 km/h.','0943189438','Đen','Hạng c',4,1,0,0),(13,2,'Lamborghini Huracan Evo',1,'/image/labo11.jpg',2000,500000,' Công nghệ Lamborghini Dynamic Vehicle Integration (LDVI): hệ thống kiểm soát động lực học của xe.','0943189438','Trắng','hạng d',2,1,1,1),(17,2,'MERCEDES BENZ C200-Class',1,'/image/mec31.jpg',2000,2300,'- Điều hoà tự động 3 vùng độc lập.Hệ thống loa vòm 13 loa Burmester nghe nhạc phê pha lắm ạ','0943189438','Trắng','hạng d',5,1,1,1),(18,3,'MERCEDES BENZ C200-Class',1,'/image/mec21.jpg',200,300,' Công nghệ Lamborghini Dynamic Vehicle Integration (LDVI): hệ thống kiểm soát động lực học của xe.','0943189438','Trắng','Hạng c',5,1,1,1),(19,1,'MERCEDES BENZ G63',1,'/image/mêc200.jpg',4000,6000,' Công nghệ Lamborghini Dynamic Vehicle Integration (LDVI): hệ thống kiểm soát động lực học của xe.','0987654321','Xanh','hạng a',7,1,1,1),(20,1,'MERCEDES BENZ G63',1,'/image/mec21.jpg',500,7000,' Công nghệ Lamborghini Dynamic Vehicle Integration (LDVI): hệ thống kiểm soát động lực học của xe.','0987654321','Trắng','Hạng c',5,1,1,1),(21,1,'MERCEDES BENZ C200-Class',1,'/image/mêc200.jpg',600,700,'khối động cơ V8 mạnh mẽ, với 8 xy-lanh xếp hình chữ V, dung tích 6.2L, cho công suất tối đa lên tới 455 mã lực và mô-men xoắn cực đại 624Nm, kết hợp với hộp số ZF 8 cấp và hệ dẫn động 4 bánh, xe có thể đạt tốc độ tối đa lên tới 300 km/h.','0987654321','Trắng','Hạng c',4,1,1,1),(22,2,'VINFAST LUX SA2.0',3,'/image/v11.jpg',700,1000,' Công nghệ Lamborghini Dynamic Vehicle Integration (LDVI): hệ thống kiểm soát động lực học của xe.','0987654321','Đen','Hạng A',7,1,1,1),(23,1,'Toyota vios 2019 ',8,'/image/v22.jpg',500,900,'- Điều hoà tự động 3 vùng độc lập.Hệ thống loa vòm 13 loa Burmester nghe nhạc phê pha lắm ạ','0987654321','Đen','Hạng B',5,1,1,1),(24,1,'Toyo ta',1,'/image/v11.jpg',500,600,' Công nghệ Lamborghini Dynamic Vehicle Integration (LDVI): hệ thống kiểm soát động lực học của xe.','0987654321','Đen','Hạng A',6,1,1,1),(25,1,'VINFAST LUX SA2.0',1,'/image/mêc200.jpg',699,700,' Công nghệ Lamborghini Dynamic Vehicle Integration (LDVI): hệ thống kiểm soát động lực học của xe.','0987654321','ĐEn','Hạng',0,1,1,1),(26,1,'VINFAST LUX SA2.0',1,'/image/v22.jpg',1000,111,'- Điều hoà tự động 3 vùng độc lập.Hệ thống loa vòm 13 loa Burmester nghe nhạc phê pha lắm ạ','0987','Đen','1hạng a',1,1,1,1),(27,2,'nguyễn văn huy',3,'image\\iconaddxe.png',1200,1300,'hhhhh','0987654321','Trắng','SUV',4,0,1,1),(28,2,'SQL1234',1,'image\\1-57.jpg',1200,2000,'huy','0987654321','Đen','Coupe',5,0,0,1),(29,2,'Mec123',1,'image\\bmw51.jpg',1233,12222,'bán ',NULL,'Đen','Sedan',5,1,1,1),(30,2,'BMW',2,'image\\bmw21.jpg',1222,12222,'huy ',NULL,'Đỏ','SUV',4,1,1,1),(31,2,'vin',3,'image\\1-57.jpg',1200,1300,'tôi chịu',NULL,'Đen','Sedan',4,0,1,1),(32,2,'nguyễn văn huy',2,'image\\1-57.jpg',1111,11111,'123',NULL,'Da cam','HatchBack',7,1,0,1),(33,2,'BMW',2,'image\\bmw11.jpg',11111,111111,'bán',NULL,'Đỏ','Sedan',5,1,0,1),(34,2,'BMW X7',2,'image\\bmw51.jpg',1111,11111,'11111',NULL,'Tr?ng','HatchBack',12,1,0,0),(35,2,'BMW X7',2,'image\\bmw51.jpg',1111,11111,'11111',NULL,'Tr?ng','HatchBack',12,1,1,1),(36,4,'mec',1,'image\\1-57.jpg',11110,1111110,'abc',NULL,'Trắng','Sedan',2,1,1,0);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_detail`
--

DROP TABLE IF EXISTS `car_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_detail` (
  `id` int(11) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `name_company` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `information` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price_from` float DEFAULT NULL,
  `price_to` float DEFAULT NULL,
  `seats` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `usage` bit(1) DEFAULT NULL,
  `status_car` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_detail`
--

LOCK TABLES `car_detail` WRITE;
/*!40000 ALTER TABLE `car_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `car_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_Company` varchar(32) NOT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,' MERCEDES','/image/logomec.jpg',_binary ''),(2,'BMW','/image/logolabo.jpg',_binary ''),(3,'VINFAST','/image/logovin.jpg',_binary ''),(4,'Audi','/image/logoaudi.jpg',_binary ''),(5,'MAZDA','/image/logomec.jpg',_binary ''),(6,'HUYNDAI','/image/logomec.jpg',_binary ''),(7,'HONDA','/image/logovin.jpg',_binary ''),(8,'TOYOTA','/image/logovin.jpg',_binary '');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historytrade`
--

DROP TABLE IF EXISTS `historytrade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historytrade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_Id` int(11) DEFAULT NULL,
  `user_Id_Partner` int(11) DEFAULT NULL,
  `car_Id` int(11) DEFAULT NULL,
  `money` float DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_Id` (`user_Id`),
  KEY `car_Id` (`car_Id`),
  CONSTRAINT `historytrade_ibfk_1` FOREIGN KEY (`user_Id`) REFERENCES `user` (`id`),
  CONSTRAINT `historytrade_ibfk_2` FOREIGN KEY (`car_Id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historytrade`
--

LOCK TABLES `historytrade` WRITE;
/*!40000 ALTER TABLE `historytrade` DISABLE KEYS */;
INSERT INTO `historytrade` VALUES (1,4,NULL,1,500,1,'03/01/2021'),(2,2,NULL,2,500,1,'03/02/2021'),(3,2,NULL,2,1000,1,'03/03/2021'),(4,2,NULL,2,1111,1,'03/04/2021'),(5,2,NULL,2,5000,1,'03/04/2021'),(6,2,NULL,2,5000,1,'03/05/2021'),(7,2,NULL,2,5000,1,'03/06/2021'),(8,2,NULL,2,5000,1,'03/07/2021'),(9,2,NULL,2,5000,1,'03/08/2021'),(10,2,NULL,2,500,1,'03/09/2021'),(11,2,NULL,12,500,1,'03/10/2021'),(12,2,NULL,1,5000,1,'03/11/2021'),(13,2,2,12,5000,1,'03/12/2021'),(14,2,2,12,0,1,'03/12/2021'),(15,2,2,12,0,1,'03/12/2021'),(16,2,2,12,50,1,'03/12/2021'),(17,4,NULL,36,111111,1,'13/10/2021'),(18,2,2,12,11111,1,'13/10/2021'),(19,2,2,2,111111,1,'13/10/2021'),(20,4,2,33,1111,1,'13/10/2021'),(21,4,2,1,1111,1,'13/10/2021'),(22,4,2,12,11111,1,'13/10/2021'),(23,4,2,13,11111,1,'13/10/2021'),(24,4,2,36,11111,1,'13/10/2021');
/*!40000 ALTER TABLE `historytrade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_Id` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`),
  KEY `car_Id` (`car_Id`),
  CONSTRAINT `image_ibfk_1` FOREIGN KEY (`car_Id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,1,'image\\bmw31.jpg',_binary ''),(2,1,'image\\bmw21.jpg',_binary ''),(3,1,'image\\mec11.jpg',_binary ''),(4,1,'/image/mec11.jpg',_binary ''),(5,1,'/image/mec21.jpg',_binary ''),(6,27,'image\\anhminhhoa1.jpg',_binary ''),(7,27,'image\\icon.jpg',_binary ''),(8,27,'image\\iconaddxe.png',_binary ''),(9,27,'image\\iconxe.png',_binary ''),(10,27,'image\\logo-removebg.png',_binary ''),(11,29,'image\\bmw21.jpg',_binary ''),(12,29,'image\\bmw31.jpg',_binary ''),(13,29,'image\\bmw41.jpg',_binary ''),(14,29,'image\\bmw51.jpg',_binary ''),(15,29,'image\\e200.jpg',_binary ''),(16,33,'image\\mec11.jpg',NULL),(17,33,'image\\mec21.jpg',NULL),(18,33,'image\\mec31.jpg',NULL),(19,33,'image\\mêc200.jpg',NULL),(20,33,'image\\sontungauto.jpg',NULL),(21,34,'image\\mec11.jpg',_binary ''),(22,34,'image\\mec21.jpg',_binary ''),(23,34,'image\\mec31.jpg',_binary ''),(24,34,'image\\mêc200.jpg',_binary ''),(25,34,'image\\sontungauto.jpg',_binary ''),(26,36,'image\\1-57.jpg',_binary ''),(27,36,'image\\bmw11.jpg',_binary ''),(28,36,'image\\bmw21.jpg',_binary ''),(29,36,'image\\bmw51.jpg',_binary ''),(30,36,'image\\mec11.jpg',_binary '');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list_order`
--

DROP TABLE IF EXISTS `list_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `list_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `car_name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_order`
--

LOCK TABLES `list_order` WRITE;
/*!40000 ALTER TABLE `list_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `list_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_Id` int(11) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`),
  KEY `user_Id` (`user_Id`),
  CONSTRAINT `login_ibfk_1` FOREIGN KEY (`user_Id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,1,'huynv','$2a$12$r0u5GGDGYlsIG9eyXZeMR.4UUYI/phX6BI0HUTr4ZJnIVvMO9MD02',_binary ''),(2,2,'longhk','$2a$12$r0u5GGDGYlsIG9eyXZeMR.4UUYI/phX6BI0HUTr4ZJnIVvMO9MD02',_binary ''),(3,3,'quocda','$2a$12$r0u5GGDGYlsIG9eyXZeMR.4UUYI/phX6BI0HUTr4ZJnIVvMO9MD02',_binary ''),(4,4,'quang','$2a$10$WQS1MoHHX6hupK4SScMCRO.OK9txMhZ3/udOJOT25GDIRScrGj0Pq',_binary ''),(5,7,'huy','$2a$12$r0u5GGDGYlsIG9eyXZeMR.4UUYI/phX6BI0HUTr4ZJnIVvMO9MD02',_binary ''),(6,8,'huyn','$2a$10$gJmFp0mxUFy.O8hGgJdtouE.pNz02AVBwi4nt80sRwG7UlAqgdQYi',_binary ''),(7,7,'huynv123','$2a$10$p9kLc5nwYlpRK3xPFPLy..YRR/YkpL1C9sZohP4SZ8TM0vyngaLL.',_binary ''),(8,9,'chauchet1133','$2a$10$jPlnTtLIbPZd4WhAzaqLp.sCkkMXbtRnqaTXb7lcPcM647V5faNwW',_binary ''),(9,10,'shannhicaaa','$2a$10$FUYn5Wcrne90e0Ce8vLtiufTH3wJ/VXa1V44C0yWtPgJA8YldlwCu',_binary ''),(10,11,'shannhicaaaaaaa','$2a$10$BIf8n3RVOZdOsmyiCO9FTeMNnyh9e.zDidzw56tWSVzxr0e3O2bKW',_binary ''),(11,12,'shannhicabbb','$2a$10$VBs3jzobLQs6retVD7tTku96LTIh.77oTakoW/4X25GI12hDsHELu',_binary ''),(12,13,'chauchet1111','$2a$10$1fbaOhQbSdvk3RPax9x5S.SfIPj7MOw6WSPCH1rtAFBnDQAoPksWW',_binary '');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_details` (
  `car_description` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `car_usage` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `more_description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `price_from` float DEFAULT NULL,
  `price_to` float DEFAULT NULL,
  `seats` int(11) DEFAULT NULL,
  PRIMARY KEY (`car_description`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_details`
--

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_Id` int(11) DEFAULT NULL,
  `user_Id` int(11) DEFAULT NULL,
  `status` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`),
  KEY `user_Id` (`user_Id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_Id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (3,1,4,_binary '\0'),(6,1,2,_binary '\0'),(7,1,3,_binary '\0'),(8,1,1,_binary '\0'),(9,1,4,_binary '\0'),(10,1,2,_binary '\0'),(11,1,2,_binary '\0'),(12,1,2,_binary '\0'),(13,1,2,_binary '\0'),(14,2,2,_binary '\0'),(15,2,2,_binary '\0'),(16,2,4,_binary '\0'),(17,2,4,_binary '\0'),(18,1,4,_binary '\0'),(19,1,4,_binary '\0'),(20,1,4,_binary '\0'),(21,1,4,_binary '\0'),(22,1,4,_binary '\0'),(23,1,4,_binary '\0'),(24,3,2,_binary ''),(25,3,2,_binary '\0'),(26,4,2,_binary ''),(27,4,2,_binary '\0'),(28,1,2,_binary '\0'),(29,1,2,_binary '\0'),(30,1,2,_binary '\0'),(31,12,2,_binary '\0'),(32,8,2,_binary ''),(33,11,2,_binary '\0'),(34,10,2,_binary '\0'),(35,36,4,_binary '\0'),(36,33,4,_binary '\0'),(37,12,4,_binary '\0'),(38,13,4,_binary '\0'),(39,36,4,_binary '\0');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postorder`
--

DROP TABLE IF EXISTS `postorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `postorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_Id` int(11) DEFAULT NULL,
  `typeCar` varchar(45) DEFAULT NULL,
  `price_From` float DEFAULT NULL,
  `price_To` float DEFAULT NULL,
  `seats` int(11) DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL,
  `more_Description` varchar(255) DEFAULT NULL,
  `car_Description` varchar(45) DEFAULT NULL,
  `car_Usage` varchar(3) DEFAULT NULL,
  `status` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`),
  KEY `postID_idx` (`user_Id`),
  CONSTRAINT `postorder_ibfk_1` FOREIGN KEY (`user_Id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postorder`
--

LOCK TABLES `postorder` WRITE;
/*!40000 ALTER TABLE `postorder` DISABLE KEYS */;
INSERT INTO `postorder` VALUES (1,2,'Xe Vinfast luxA',800,900,5,'/image/mec1.jpg','- Hộp số tự động 9 cấp 9G Tronic','- Hộp số tự động 9 cấp 9G Tronic','1',_binary ''),(2,2,'BWM x7',1200,1500,5,'/image/mec1.jpg','- Hộp số tự động 9 cấp 9G Tronic','- Hộp số tự động 9 cấp 9G Tronic','1',_binary ''),(3,2,'BWM x5',1000,1500,5,'/image/mec1.jpg','- Hộp số tự động 9 cấp 9G Tronic','- Hộp số tự động 9 cấp 9G Tronic','1',_binary ''),(4,2,'Vin x7',1200,1500,5,'/image/mec1.jpg','- Hộp số tự động 9 cấp 9G Tronic','- Hộp số tự động 9 cấp 9G Tronic','1',_binary ''),(5,3,'LUXA ',1200,1500,5,'/image/mec1.jpg','- Hộp số tự động 9 cấp 9G Tronic','- Hộp số tự động 9 cấp 9G Tronic','1',_binary ''),(6,1,'BWM x7',1200,1500,5,'/image/mec1.jpg','- Hộp số tự động 9 cấp 9G Tronic','- Hộp số tự động 9 cấp 9G Tronic','1',_binary ''),(7,1,'BWM x7',1200,1500,5,'/image/mec1.jpg','- Hộp số tự động 9 cấp 9G Tronic','- Hộp số tự động 9 cấp 9G Tronic','1',_binary ''),(8,2,'BWM x7',1200,1500,5,'/image/mec1.jpg','- Hộp số tự động 9 cấp 9G Tronic','- Hộp số tự động 9 cấp 9G Tronic','1',_binary ''),(9,2,'BWM x7',1200,1500,5,'/image/mec1.jpg','- Hộp số tự động 9 cấp 9G Tronic','- Hộp số tự động 9 cấp 9G Tronic','1',_binary ''),(10,1,'BWM x7',1200,1234,5,'/image/mec1.jpg','- Hộp số tự động 9 cấp 9G Tronic','- Hộp số tự động 9 cấp 9G Tronic','1',_binary ''),(11,2,NULL,11,111,4,'images\\bmw31.jpg','111','huy','old',_binary '\0'),(12,2,NULL,121,1111,4,'images\\bmw11.jpg','1111','huy','old',_binary '\0');
/*!40000 ALTER TABLE `postorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `status` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN',_binary ''),(2,'ROLE_CUSTOMER',_binary ''),(3,'ROLE_PARTNER',_binary '');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showroom`
--

DROP TABLE IF EXISTS `showroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `showroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_Id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `logo` varchar(355) DEFAULT NULL,
  `status` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`),
  KEY `user_Id` (`user_Id`),
  CONSTRAINT `showroom_ibfk_1` FOREIGN KEY (`user_Id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showroom`
--

LOCK TABLES `showroom` WRITE;
/*!40000 ALTER TABLE `showroom` DISABLE KEYS */;
INSERT INTO `showroom` VALUES (1,1,'CarLUCK','11 Ho tung mau - ha noi','0987654321','/image/logo.jpg',_binary ''),(2,2,'SonTungAuto','??a ch?:Sô? 2 Tôn Thâ?t Thuyê?t, P. My? ?i?nh 2,Qu?n Nam T?? Liêm, TP.','0943189438','/image/sontungauto.jpg',_binary '');
/*!40000 ALTER TABLE `showroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `todo`
--

DROP TABLE IF EXISTS `todo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `todo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `detail` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todo`
--

LOCK TABLES `todo` WRITE;
/*!40000 ALTER TABLE `todo` DISABLE KEYS */;
/*!40000 ALTER TABLE `todo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(245) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `role_Id` int(11) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT b'1',
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_Id` (`role_Id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_Id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Nguyễn Văn Huy','huy465773@gmail,com',1,'0943189438','hà nội',_binary '',NULL,NULL),(2,'HÀ Kim Long','longhk@gmail.com',3,'0987654321','quảng ninh ',_binary '',NULL,NULL),(3,'Đỗ Ái Quốc','quocDA@gmail.com',3,'123445567','Thái nguyên',_binary '',NULL,NULL),(4,'Quang','Quangbac@gmail.com',2,'0987654321','B?cGiang -hahahaa',_binary '',NULL,NULL),(5,'huy','huynvhe141080@fpt.edu.vn',2,'0943189439','Hà Nội',_binary '',NULL,NULL),(6,'huy van ','nguyen_vanhuy@yahoo.com.vn',2,'0943189439','xã Hạ Mỗ - huyện Đan Phượng - tp Hà Nội',_binary '',NULL,NULL),(7,'huy','huynvhe141080@fpt.edu.vn',2,'0943189439','xã Hạ Mỗ - huyện Đan Phượng - tp Hà Nội',_binary '',NULL,NULL),(8,'huy','nguyen_vanhuy@yahoo.com.vn',3,'0943189439','xã Hạ Mỗ - huyện Đan Phượng - tp Hà Nội',_binary '',NULL,NULL),(9,'Hà Kim Long','alabuba1020a0@agmail.com',3,'0768335679','Hà N?i',_binary '',NULL,NULL),(10,'[Output] FinalProject - LongHk','alabuba1022200@gmail.com',3,'0768335479','h? long',_binary '',NULL,NULL),(11,'[Output] FinalProject - LongHk','alabuba10444400@gmail.com',3,'0768335679','h? long',_binary '',NULL,NULL),(12,'[Output] FinalProject - LongHk','alabuba100333330@gmail.com',3,'0768335679','h? long',_binary '',NULL,NULL),(13,'[Output] FinalProject - LongHk','alabuba1003330@gmail.com',3,'0768335679','Hà N?i',_binary '',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-13 21:41:52
