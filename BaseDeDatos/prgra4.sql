-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: proy_progra4
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estudiante` (
  `estudiante_id` varchar(15) NOT NULL,
  `estudiante_nrc` int(6) NOT NULL,
  `estudiante_apellidos` varchar(60) NOT NULL,
  `estudiante_nombre` varchar(45) NOT NULL,
  `estudiante_secuencia` int(6) NOT NULL,
  `estudiante_clave` varchar(20) NOT NULL,
  `estudiante_ultimo_acceso` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `estudiante_grupo_id` int(6) DEFAULT NULL,
  PRIMARY KEY (`estudiante_id`),
  KEY `fk_estudiante_grupo_idx` (`estudiante_grupo_id`),
  CONSTRAINT `fk_estudiante_grupo` FOREIGN KEY (`estudiante_grupo_id`) REFERENCES `grupo` (`grupo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES ('1',40639,'Cárdenas Alpízar','Lea',9,'12345','2019-04-21 18:36:01',NULL),('113030275',40639,'Cambronero Murillo','Mariela',7,'1',NULL,NULL),('114260854',40639,'Siles Madrigal','Alejandra',28,'1',NULL,NULL),('115140633',40639,'Sánchez Loaiza','Adriana Daniela',26,'1',NULL,NULL),('115520070',40643,'Vargas Jiménez','Luis',28,'1',NULL,NULL),('115690792',40643,'Cruz Rojas','Andrea',9,'1',NULL,NULL),('115900955',40639,'Solís Quesada','Christian',29,'1',NULL,NULL),('115930789',40643,'Aguilar Vidaurre','Luis',1,'1',NULL,NULL),('116040135',40643,'Cordero Rodríguez','Daniel',7,'1',NULL,NULL),('116240874',40643,'Solano Arias','Stephany',26,'1',NULL,NULL),('116310252',40643,'Álvarez Carranza','David',4,'1',NULL,NULL),('116330698',40643,'Artavia Donaire','Joséph',5,'1',NULL,NULL),('116340204',40643,'Madrigal Vásquez','Juan',15,'1',NULL,NULL),('116360813',40643,'Matarrita Villalobos','Javier',16,'1',NULL,NULL),('116420011',40643,'Ureña Rojas','Melissa',27,'1',NULL,NULL),('116440310',40639,'Gómez Chaves','Danny',14,'1',NULL,NULL),('116500065',40639,'Quesada Valerio','José',21,'1',NULL,NULL),('116550242',40643,'Zapata Narváez','Michael',30,'1',NULL,NULL),('116570271',40639,'Garro Eduarte','Bryan',13,'1',NULL,NULL),('116570472',40643,'Corrales Fonseca','Luis',8,'1',NULL,NULL),('116680496',40643,'Bonilla Valerio','Alicia',6,'1',NULL,NULL),('116760031',40639,'Rodríguez Chavarría','Julio',23,'1',NULL,NULL),('116770115',40643,'Alvarado Solórzano','Cristobal',3,'1',NULL,NULL),('116770151',40643,'Montenegro Brenes','Elmer',17,'1',NULL,NULL),('116810263',40643,'Monterrey Benavides','Diego',18,'1',NULL,NULL),('116810717',40643,'Pico García','Javier',21,'1',NULL,NULL),('116840372',40639,'Moraga Alfaro','Moisés',17,'1',NULL,NULL),('116850387',40639,'Molina Sánchez','Monserrath',16,'1',NULL,NULL),('116920756',40639,'Rojas Hernández','Naomi',24,'1',NULL,NULL),('116960431',40639,'Morales Alfaro','Adrian',18,'1',NULL,NULL),('116960863',40639,'Babb Jiménez','Diego',4,'1',NULL,NULL),('116970427',40639,'Esquivel Jiménez','Josef',12,'1',NULL,NULL),('117200555',40643,'Zamora Hernández','Marco',29,'1',NULL,NULL),('117210245',40639,'Peralta Chaves','Cristhian',19,'1',NULL,NULL),('117280151',40643,'Piedra Walsh','Luis',22,'1',NULL,NULL),('206580363',40643,'Díaz Gutiérrez','Miguel',10,'1',NULL,NULL),('207140702',40643,'Lobo Campos','Jeremy',14,'1',NULL,NULL),('207600808',40643,'Alvarado Salas','Gabriela',2,'1',NULL,NULL),('207630059',40639,'Salgado Rodríguez','Fiorella',25,'1',NULL,NULL),('207660568',40639,'Chaves Acuña','Josue',11,'1',NULL,NULL),('207970180',40639,'Arroyo Solórzano','Luis',3,'1',NULL,NULL),('304910102',40643,'Fernández Villalobos','Nataly',11,'1',NULL,NULL),('305030937',40639,'Richmond Solís','John',22,'1',NULL,NULL),('305090739',40643,'Navarro Castillo','Heison',19,'1',NULL,NULL),('402110202',40643,'Jiménez Cambronero','Jazmín',13,'1',NULL,NULL),('402250407',40639,'Alvarado Ferreto','María',2,'1',NULL,NULL),('402290312',40639,'Méndez Acuña','Boris',15,'1',NULL,NULL),('402290463',40639,'Sánchez Ramírez','Brandon',27,'1',NULL,NULL),('402300046',40639,'Carvajal Salazar','Robert',10,'1',NULL,NULL),('402310866',40643,'Sánchez Chaves','Enibeth',25,'1',NULL,NULL),('402360123',40639,'Soto Cruz','Luis',30,'1',NULL,NULL),('402360503',40639,'Campos Montero','Mauricio',8,'1',NULL,NULL),('402370159',40643,'Obando Avendaña','Carlos',20,'1',NULL,NULL),('402370259',40639,'Alfaro Rodríguez','Ismael',1,'1',NULL,NULL),('402380339',40639,'Bravo Zúñiga','Luis',6,'1',NULL,NULL),('504190395',40639,'Picado Solano','Arelis',20,'1',NULL,NULL),('504210953',40643,'Hernández Rodríguez','Djenane',12,'1',NULL,NULL),('801030879',40639,'Basulto Arzola','Rachel',5,'1',NULL,NULL),('A00119566',40643,'Restrepo Veintemilla','Luis',23,'1',NULL,NULL),('A00131303',40643,'Salinas Gómez','Joseline',24,'1',NULL,NULL);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `estudiantes_x_grupo`
--

DROP TABLE IF EXISTS `estudiantes_x_grupo`;
/*!50001 DROP VIEW IF EXISTS `estudiantes_x_grupo`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `estudiantes_x_grupo` AS SELECT 
 1 AS `grupo_id`,
 1 AS `grupo_nombre`,
 1 AS `estudiante_id`,
 1 AS `estudiante_nrc`,
 1 AS `estudiante_apellidos`,
 1 AS `estudiante_nombre`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `grupo_id` int(6) NOT NULL AUTO_INCREMENT,
  `grupo_nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`grupo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'proy_progra4'
--

--
-- Final view structure for view `estudiantes_x_grupo`
--

/*!50001 DROP VIEW IF EXISTS `estudiantes_x_grupo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `estudiantes_x_grupo` AS select `g`.`grupo_id` AS `grupo_id`,`g`.`grupo_nombre` AS `grupo_nombre`,`e`.`estudiante_id` AS `estudiante_id`,`e`.`estudiante_nrc` AS `estudiante_nrc`,`e`.`estudiante_apellidos` AS `estudiante_apellidos`,`e`.`estudiante_nombre` AS `estudiante_nombre` from (`estudiante` `e` join `grupo` `g`) where (`e`.`estudiante_grupo_id` = `g`.`grupo_id`) order by `e`.`estudiante_grupo_id`,`e`.`estudiante_nrc`,`e`.`estudiante_id`,`e`.`estudiante_apellidos`,`e`.`estudiante_nombre` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-23 17:21:38
