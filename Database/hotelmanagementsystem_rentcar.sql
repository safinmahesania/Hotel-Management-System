-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: hotelmanagementsystem
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `rentcar`
--

DROP TABLE IF EXISTS `rentcar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rentcar` (
  `reservation_id` int NOT NULL,
  `customer_id` int NOT NULL,
  `room_id` int NOT NULL,
  `customer_name` varchar(30) DEFAULT NULL,
  `customer_phone` varchar(30) DEFAULT NULL,
  `car_id` int NOT NULL,
  `car_name` varchar(30) DEFAULT NULL,
  `driver_id` int NOT NULL,
  `driver_name` varchar(30) DEFAULT NULL,
  `driver_phone` varchar(30) DEFAULT NULL,
  `rent` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `PK_Customer_ID_idx` (`customer_id`),
  KEY `PK_Room_ID_idx` (`room_id`),
  KEY `PK_Car_ID_idx` (`car_id`),
  KEY `FK_Driver_ID_idx` (`driver_id`),
  CONSTRAINT `FK_Car_ID` FOREIGN KEY (`car_id`) REFERENCES `car` (`carid`) ON UPDATE CASCADE,
  CONSTRAINT `FK_Customer_ID` FOREIGN KEY (`customer_id`) REFERENCES `account` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_Driver_ID` FOREIGN KEY (`driver_id`) REFERENCES `employee` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_Reservation_ID` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_Room_ID` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_number`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentcar`
--

LOCK TABLES `rentcar` WRITE;
/*!40000 ALTER TABLE `rentcar` DISABLE KEYS */;
/*!40000 ALTER TABLE `rentcar` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-01 21:41:46
