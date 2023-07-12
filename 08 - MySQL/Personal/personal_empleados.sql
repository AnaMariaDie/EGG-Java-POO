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
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `id_emp` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` char(30) NOT NULL,
  `sex_emp` char(1) NOT NULL,
  `fec_nac` date NOT NULL,
  `fec_incorporacion` date NOT NULL,
  `sal_emp` float NOT NULL,
  `comision_emp` float NOT NULL,
  `cargo_emp` varchar(15) NOT NULL,
  `id_depto` int unsigned NOT NULL,
  PRIMARY KEY (`id_emp`),
  KEY `id_depto` (`id_depto`),
  CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`id_depto`) REFERENCES `departamentos` (`id_depto`)
) ENGINE=InnoDB AUTO_INCREMENT=899 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (60,'Darío Casas','M','1960-04-05','1992-11-01',4500000,500000,'Investigador',3000),(99,'Diana Solarte','F','1957-11-19','1990-05-16',1250000,500000,'Secretaria',1000),(111,'Irene Díaz','F','1979-09-28','2004-06-01',1050000,200000,'Mecánico',4200),(144,'Rosa Angulo','F','1957-03-15','1998-08-16',3250000,3500000,'Jefe Ventas',2000),(219,'Melissa Roa','F','1960-06-19','2001-03-16',2250000,2500000,'Vendedor',2100),(221,'Carla López','F','1975-05-11','2005-07-16',4500000,500000,'Jefe Mercadeo',3500),(222,'José Giraldo','M','1985-01-20','2000-11-01',1200000,400000,'Asesor',3500),(269,'María Rojas','F','1959-01-15','1990-05-16',6250000,1500000,'Gerente',1000),(331,'Carlos Rozo','M','1975-05-11','2001-09-16',750000,500000,'Vigilante',3500),(333,'Pedro Blanco','M','1987-10-28','2000-10-01',800000,3000000,'Vendedor',2000),(334,'Marisol Pulido','F','1979-10-01','1990-05-16',3250000,1000000,'Investigador',3000),(335,'Ana Moreno','F','1992-01-05','2004-06-01',1200000,400000,'Secretaria',3000),(336,'Carolina Ríos','F','1992-02-15','2000-10-01',1250000,500000,'Secretaria',1500),(337,'Edith Muñoz','F','1992-03-31','2000-10-01',800000,3600000,'Vendedor',2100),(338,'Abel Gómez','M','1939-12-24','2000-10-01',1050000,200000,'Mecánico',4300),(343,'Elisa Rojas','F','1979-09-28','2004-06-01',3000000,1000000,'Jefe Mecánicos',4000),(383,'Luis Pérez','M','1956-02-25','2000-01-01',5050000,0,'Director',1500),(444,'Jesús Alfonso','M','1988-03-14','2000-10-01',800000,3500000,'Vendedor',2000),(555,'Julián Mora','M','1989-07-03','2000-10-01',800000,3100000,'Vendedor',2200),(666,'Manuel Millán','M','1990-12-08','2004-06-01',800000,3700000,'Vendedor',2300),(689,'Mario Llano','M','1945-08-30','1990-05-16',2250000,2500000,'Vendedor',2300),(777,'Marcos Cortez','M','1986-06-23','2000-04-16',2550000,500000,'Mecánico',4000),(782,'Antonio Gil','M','1980-01-23','2010-04-16',850000,1500000,'Técnico',1500),(785,'Joaquín Rosas','M','1947-07-07','1990-05-16',2250000,2500000,'Vendedor',2200),(802,'William Daza','M','1982-10-09','1999-12-16',2250000,1000000,'Investigador',3000),(898,'Iván Duarte','M','1955-08-12','1998-05-16',1050000,200000,'Mecánico',4100);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
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
