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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL,
  `firstname` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `job` varchar(30) DEFAULT NULL,
  `salary` varchar(10) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (101,'Kamil','Asraf','20','Male','Housekeeping','15000','03326485478','kamil@gmail.com'),(102,'Lena','Smith','26','Female','Front Desk Clerks','15000','0326547895','lena@gmail.com'),(103,'Nicol','Green','21','Male','Driver','15000','03569874521','nicol@gmail.com'),(104,'Tom','Taylor','25','Male','Room Service','15000','03256985214','tom@gmail.com'),(105,'Paul','Miller','24','Male','Waiter/Waitress','15000','03214569875','paul@gmail.com'),(106,'Lee','Alen','23','Female','Manager','20000','03214569854','lee@gmail.com'),(107,'David','King','26','Male','Accountant','15000','03256985623','david@gmail.com'),(108,'Obmar','Wood','27','Male','Chef','15000','03246879512','obmar@gmail.com'),(109,'Lucy','White','28','Female','Front Desk Clerks','15000','03456987521','lucy@gmail.com'),(110,'Jone','Smith','24','Male','Housekeeping','15000','03256985214','jone@gmail.com'),(111,'Emma','Richardson','24','Female','Driver','15000','03265478954','Emma@gmail.com'),(112,'Olivia','Perry','25','Female','Room Service','15000','03265987452','olivia@gmail.com'),(113,'William','Long','29','Male','Waiter/Waitress','15000','03265478965','william@gmail.com'),(114,'Sophia','Martinez','22','Female','Manager','20000','03265478952','sophia@gmail.com'),(115,'Mason','Young','22','Male','Chef','15000','03214569875','mason@gmail.com'),(116,'Lupe','Santana','26','Male','Accountant','15000','03265789452','lupe@gmail.com');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-01 21:41:47
