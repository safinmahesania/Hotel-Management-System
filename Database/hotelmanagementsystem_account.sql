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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL,
  `firstname` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (101,'Ahsan','Akbar','23','Male','ahsan@gmail.com','03326458751'),(102,'Arsalan','Salim','21','Male','ahsan@gmail.com','03345985247'),(103,'Barjees','Atiq','23','Male','barjees@gmail.com','03398567425'),(104,'Fatima','Aslam','22','Female','fatima','03356984524'),(105,'Iqra','Amin','25','Female','iqra@gmail.com','03398547624'),(106,'Wendi','Bean','20','Female','wendi@gmail.com','03254156985'),(107,'Marcia','Burris','26','Female','marcia@gmail.com','03245875241'),(108,'Gerald','Caudill','25','Male','gerald@gmail.com','03214569875'),(109,'Valarie','Dillard','24','Female','valarie@gmail.com','03214569875'),(110,'Clair','Erickson','22','Female','clair@gmail.com','03256987541'),(111,'Tatiana','Howe','24','Female','tatiana@gmail.com','0357951258'),(112,'Ezra','Lyon','28','Female','ezra@gmail.com','03698521478'),(113,'Sal','Whalery','28','Male','sal@gmail.com','03254789652'),(114,'Shauna','Werner','26','Female','shauna@gmail.com','03258964785'),(115,'Cesar','Talley','22','Male','cesar@gmail.com','0324569852'),(116,'Lucio','Staley','21','Male','lucio@gmail.com','03569874521'),(117,'Peter','Small','26','Male','peter@gmail.com','0321456987456'),(118,'Valentin','Marind','23','Female','valentin@gmail.com','03569874563'),(119,'Janis','Mata','24','Female','janis@gmail.com','03258964781'),(120,'Karon','Bryan','22','Male','karon@gmail.com','03256412896');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
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
