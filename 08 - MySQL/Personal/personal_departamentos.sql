-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: personal
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
-- Table structure for table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamentos` (
  `id_depto` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre_depto` varchar(20) NOT NULL,
  `ciudad` varchar(15) DEFAULT NULL,
  `nombre_jefe_depto` char(30) DEFAULT NULL,
  PRIMARY KEY (`id_depto`)
) ENGINE=InnoDB AUTO_INCREMENT=4301 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamentos`
--

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` VALUES (1000,'GERENCIA','CIUDAD REAL','Bruno Cebrian'),(1500,'PRODUCCIÓN','CIUDAD REAL','Jesica Duran'),(2000,'VENTAS','CIUDAD REAL','Alicia Andres'),(2100,'VENTAS','BARCELONA','Fabian Soto'),(2200,'VENTAS','VALENCIA','Mari Plaza'),(2300,'VENTAS','MADRID','Jonatan Acuña'),(3000,'INVESTIGACIÓN','CIUDAD REAL','Valentina Sola'),(3500,'MERCADEO','CIUDAD REAL','Abraham Diego'),(4000,'MANTENIMIENTO','CIUDAD REAL','Raúl Carrero'),(4100,'MANTENIMIENTO','BARCELONA','Catalina Valdes'),(4200,'MANTENIMIENTO','VALENCIA','Adriana Rocha'),(4300,'MANTENIMIENTO','MADRID','German Luna');
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-03 20:37:59
