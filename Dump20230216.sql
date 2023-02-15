CREATE DATABASE  IF NOT EXISTS `freedb_BazaZaTicTacToe` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `freedb_BazaZaTicTacToe`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: sql.freedb.tech    Database: freedb_BazaZaTicTacToe
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `igraci`
--

DROP TABLE IF EXISTS `igraci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `igraci` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) DEFAULT NULL,
  `brojPobjeda` int DEFAULT NULL,
  `brojPoraza` int DEFAULT NULL,
  `brojNerijesenih` int DEFAULT NULL,
  `kojiJeIgrac` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `igraci`
--

LOCK TABLES `igraci` WRITE;
/*!40000 ALTER TABLE `igraci` DISABLE KEYS */;
INSERT INTO `igraci` VALUES (1,'Sead',0,0,0,NULL),(2,'Emir',0,0,0,NULL);
/*!40000 ALTER TABLE `igraci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mecevi`
--

DROP TABLE IF EXISTS `mecevi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mecevi` (
  `idMeca` int NOT NULL AUTO_INCREMENT,
  `idX` int DEFAULT NULL,
  `idO` int DEFAULT NULL,
  `idTipa` int DEFAULT NULL,
  PRIMARY KEY (`idMeca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mecevi`
--

LOCK TABLES `mecevi` WRITE;
/*!40000 ALTER TABLE `mecevi` DISABLE KEYS */;
/*!40000 ALTER TABLE `mecevi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipovi`
--

DROP TABLE IF EXISTS `tipovi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipovi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `opis` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipovi`
--

LOCK TABLES `tipovi` WRITE;
/*!40000 ALTER TABLE `tipovi` DISABLE KEYS */;
INSERT INTO `tipovi` VALUES (1,'Pobjeda X'),(2,'Pobjeda O'),(3,'Neriješeno');
/*!40000 ALTER TABLE `tipovi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-16  0:43:48
