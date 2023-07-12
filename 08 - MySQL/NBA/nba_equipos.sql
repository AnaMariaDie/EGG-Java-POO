-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: nba
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
-- Table structure for table `equipos`
--

DROP TABLE IF EXISTS `equipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipos` (
  `Nombre` varchar(20) NOT NULL,
  `Ciudad` varchar(20) DEFAULT NULL,
  `Conferencia` varchar(4) DEFAULT NULL,
  `Division` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipos`
--

LOCK TABLES `equipos` WRITE;
/*!40000 ALTER TABLE `equipos` DISABLE KEYS */;
INSERT INTO `equipos` VALUES ('76ers','Philadelphia','East','Atlantic'),('Bobcats','Charlotte','East','SouthEast'),('Bucks','Milwaukee','East','Central'),('Bulls','Chicago','East','Central'),('Cavaliers','Cleveland','East','Central'),('Celtics','Boston','East','Atlantic'),('Clippers','Los Angeles','West','Pacific'),('Grizzlies','Memphis','West','SouthWest'),('Hawks','Atlanta','East','SouthEast'),('Heat','Miami','East','SouthEast'),('Hornets','New Orleans','West','SouthWest'),('Jazz','Utah','West','NorthWest'),('Kings','Sacramento','West','Pacific'),('Knicks','New York','East','Atlantic'),('Lakers','Los Angeles','West','Pacific'),('Magic','Orlando','East','SouthEast'),('Mavericks','Dallas','West','SouthWest'),('Nets','New Jersey','East','Atlantic'),('Nuggets','Denver','West','NorthWest'),('Pacers','Indiana','East','Central'),('Pistons','Detroit','East','Central'),('Raptors','Toronto','East','Atlantic'),('Rockets','Houston','West','SouthWest'),('Spurs','San Antonio','West','SouthWest'),('Suns','Phoenix','West','Pacific'),('Supersonics','Seattle','West','NorthWest'),('Timberwolves','Minnesota','West','NorthWest'),('Trail Blazers','Portland','West','NorthWest'),('Warriors','Golden State','West','Pacific'),('Wizards','Washington','East','SouthEast');
/*!40000 ALTER TABLE `equipos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-05 13:07:31
