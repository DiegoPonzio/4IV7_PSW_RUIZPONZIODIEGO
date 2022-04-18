-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: registroa
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
create database registroa;
use registroa;
--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `bol_al` int NOT NULL AUTO_INCREMENT,
  `nom_al` varchar(30) NOT NULL,
  `appat_al` varchar(30) NOT NULL,
  `apmat_al` varchar(30) NOT NULL,
  `img_al` varchar(30) NOT NULL,
  `grupo_al` varchar(5) NOT NULL,
  `turno_al` varchar(10) NOT NULL,
  PRIMARY KEY (`bol_al`),
  KEY `nom_al` (`nom_al`),
  KEY `appat_al` (`appat_al`)
) ENGINE=InnoDB AUTO_INCREMENT=2122458979 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (20210506,'Francisco','Ponzio','Anguiano','2b.png','3IV8','vespertino'),(1819090214,'Francisco','Ponzio','Galindo','nobara.jpg','6IV9','vespertino'),(1920156848,'Enrique','Galindo','De la Rosa','Diagrama sin tÃ­tulo.png','4IV9','vespertino'),(1920485678,'Maria Lizette','Ponzio','Galindo','El discurso literario.JPG','5IM7','matutino'),(2021048951,'Omar','Pulido','Moreno','1146921.png','4IM7','matutino'),(2021050617,'Juan','Perez','Moreno','2b.png','3IM9','matutino'),(2021090214,'Diego','Ruiz','Ponzio','foto.jpg','4IV7','vespertino'),(2122050617,'Francisco','Ponzio','Anguiano','1181347.jpg','3IV10','vespertino'),(2122154845,'Jorge','Cruz','Ruiz','BLk2WRl.png','3IM7','matutino'),(2122458978,'Francisco','Ponzio','Moreno','BLk2WRl.png','3IV8','vespertino');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data`
--

DROP TABLE IF EXISTS `data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `data` (
  `id_data` int NOT NULL AUTO_INCREMENT,
  `id_lab` int NOT NULL,
  `bol_al` int NOT NULL,
  PRIMARY KEY (`id_data`),
  KEY `id_lab` (`id_lab`),
  KEY `bol_al` (`bol_al`),
  CONSTRAINT `data_ibfk_1` FOREIGN KEY (`id_lab`) REFERENCES `laboratorio` (`id_lab`),
  CONSTRAINT `data_ibfk_2` FOREIGN KEY (`bol_al`) REFERENCES `alumno` (`bol_al`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data`
--

LOCK TABLES `data` WRITE;
/*!40000 ALTER TABLE `data` DISABLE KEYS */;
INSERT INTO `data` VALUES (1,1,2021090214),(2,51,2021050617),(3,51,2021050617),(4,51,20210506),(7,51,2122050617),(9,47,2021048951),(10,47,1920156848),(11,54,1920485678),(12,58,1819090214),(13,60,1819090214);
/*!40000 ALTER TABLE `data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratorio`
--

DROP TABLE IF EXISTS `laboratorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laboratorio` (
  `id_lab` int NOT NULL AUTO_INCREMENT,
  `nom_lab` varchar(4) NOT NULL,
  `id_uni` int NOT NULL,
  PRIMARY KEY (`id_lab`),
  KEY `id_uni` (`id_uni`),
  CONSTRAINT `laboratorio_ibfk_1` FOREIGN KEY (`id_uni`) REFERENCES `unidad` (`id_uni`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laboratorio`
--

LOCK TABLES `laboratorio` WRITE;
/*!40000 ALTER TABLE `laboratorio` DISABLE KEYS */;
INSERT INTO `laboratorio` VALUES (1,'4.0',4),(2,'4.0',1),(3,'4.0',2),(4,'4.0',3),(6,'4.0',5),(7,'4.0',6),(8,'4.0',7),(9,'4.0',8),(10,'4.0',9),(11,'4.0',10),(12,'4.0',11),(13,'4.0',12),(14,'4.0',13),(15,'4.0',14),(16,'4.0',15),(17,'LDS',1),(18,'LDS',2),(19,'LDS',3),(20,'LDS',4),(21,'LDS',5),(22,'LDS',6),(23,'LDS',7),(24,'LDS',8),(25,'LDS',9),(26,'LDS',10),(27,'LDS',11),(28,'LDS',12),(29,'LDS',13),(30,'LDS',14),(31,'LDS',15),(32,'LNV',1),(33,'LNV',2),(34,'LNV',3),(35,'LNV',4),(36,'LNV',5),(37,'LNV',6),(38,'LNV',7),(39,'LNV',8),(40,'LNV',9),(41,'LNV',10),(42,'LNV',11),(43,'LNV',12),(44,'LNV',13),(45,'LNV',14),(46,'LNV',15),(47,'LBD',1),(48,'LBD',2),(49,'LBD',3),(50,'LBD',4),(51,'LBD',5),(52,'LBD',6),(53,'LBD',7),(54,'LBD',8),(55,'LBD',9),(56,'LBD',10),(57,'LBD',11),(58,'LBD',12),(59,'LBD',13),(60,'LBD',14),(61,'LBD',15);
/*!40000 ALTER TABLE `laboratorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reporte`
--

DROP TABLE IF EXISTS `reporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reporte` (
  `id_rep` int NOT NULL AUTO_INCREMENT,
  `fecha_rep` date NOT NULL,
  `mac_rep` varchar(12) NOT NULL,
  `des_rep` varchar(35) NOT NULL,
  `id_data` int NOT NULL,
  PRIMARY KEY (`id_rep`),
  KEY `id_data` (`id_data`),
  CONSTRAINT `reporte_ibfk_1` FOREIGN KEY (`id_data`) REFERENCES `data` (`id_data`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reporte`
--

LOCK TABLES `reporte` WRITE;
/*!40000 ALTER TABLE `reporte` DISABLE KEYS */;
INSERT INTO `reporte` VALUES (1,'2022-04-13','24429593955','El teclado no funciona',1),(2,'2022-04-17','5487451','Marca pantalla azul',2),(3,'2022-04-18','5589412','Todo bien',3),(4,'2022-04-18','5589412','Todo bien',4),(5,'2022-04-18','5589412','Todo bien',7),(6,'2022-05-01','5589412','El teclado no funciona',9),(7,'2022-04-18','5589412','Todo bien',10),(8,'2022-04-18','5589412','Todo bien',11),(9,'2022-04-18','5589412','Todo bien',12),(10,'2022-04-18','558945','El teclado no funciona',13);
/*!40000 ALTER TABLE `reporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad`
--

DROP TABLE IF EXISTS `unidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidad` (
  `id_uni` int NOT NULL AUTO_INCREMENT,
  `nom_uni` varchar(60) NOT NULL,
  PRIMARY KEY (`id_uni`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad`
--

LOCK TABLES `unidad` WRITE;
/*!40000 ALTER TABLE `unidad` DISABLE KEYS */;
INSERT INTO `unidad` VALUES (1,'base de datos'),(2,'programacion y servicios web'),(3,'tecnicas de programacion personal con calidad'),(4,'laboratorio de proyectos de tecnologias de la informacion 2'),(5,'programacion orientada a objetos'),(6,'administracion de proyectos'),(7,'laboratorio de proyectos de tecnologias de la informacion 1'),(8,'seguridad web y aplicaciones'),(9,'ingenieria de pruebas'),(10,'laboratorio de proyectos de tecnologias de la informacion 3'),(11,'sistemas distribuidos'),(12,'metodos agiles de programacion'),(13,'laboratorio de proyectos de tecnologias de la informacion 4'),(14,'soporte de software'),(15,'ingenieria de software');
/*!40000 ALTER TABLE `unidad` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-18 17:00:55
