-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: superheroes
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
-- Table structure for table `personajes`
--

DROP TABLE IF EXISTS `personajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personajes` (
  `id_personaje` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre_real` varchar(20) NOT NULL,
  `personaje` varchar(20) NOT NULL,
  `inteligencia` int NOT NULL,
  `fuerza` varchar(10) NOT NULL,
  `velocidad` int NOT NULL,
  `poder` int NOT NULL,
  `aparicion` int NOT NULL,
  `ocupacion` varchar(30) DEFAULT NULL,
  `id_creador` int unsigned NOT NULL,
  PRIMARY KEY (`id_personaje`),
  KEY `id_creador` (`id_creador`),
  CONSTRAINT `personajes_ibfk_1` FOREIGN KEY (`id_creador`) REFERENCES `creador` (`id_creador`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personajes`
--

LOCK TABLES `personajes` WRITE;
/*!40000 ALTER TABLE `personajes` DISABLE KEYS */;
INSERT INTO `personajes` VALUES (1,'Bruce Banner','Hulk',160,'600 mil',75,98,1962,'Fisico Nuclear',1),(2,'Tony Stark','Iron Man',170,'200 mil',70,123,1963,'Inventor Industrial',1),(3,'Thor Odinson','Thor',145,'infinita',100,235,1962,'Rey de Asgard',1),(4,'Wanda Maximoff','Bruja Escarlata',170,'100 mil',90,345,1964,'Bruja',1),(5,'Carol Danvers','Capitana Marvel',157,'250 mil',85,128,1968,'Oficial de Inteligencia',1),(6,'Thanos','Thanos',170,'infinita',40,306,1973,'Adorador de la Muerte',1),(7,'Peter Parker','Spiderman',165,'25 mil',80,74,1962,'Fotografo',1),(8,'Steve Rogers','Capitan America',145,'600',45,60,1941,'Oficial Federal',1),(9,'Bobby Drake','Iceman',140,'2 mil',64,122,1963,'Contador',1),(11,'Bruce Wayne','Batman',170,'500',32,47,1939,'Hombre de Negocios',2),(12,'Clarck Kent','Superman',165,'infinita',120,182,1938,'Reportero',2),(13,'Diane Price','Mujer Maravilla',160,'infinita',95,127,1949,'Princesa Guerrera',2);
/*!40000 ALTER TABLE `personajes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-03 20:26:17
