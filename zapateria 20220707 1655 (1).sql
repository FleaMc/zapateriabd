-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.11


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema zapateria
--

CREATE DATABASE IF NOT EXISTS zapateria;
USE zapateria;

--
-- Definition of table `dependientes`
--

DROP TABLE IF EXISTS `dependientes`;
CREATE TABLE `dependientes` (
  `Id_Dep` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`Id_Dep`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dependientes`
--

/*!40000 ALTER TABLE `dependientes` DISABLE KEYS */;
INSERT INTO `dependientes` (`Id_Dep`,`Nombre`) VALUES 
 (1,'Admin'),
 (3,'Michael Cabrera');
/*!40000 ALTER TABLE `dependientes` ENABLE KEYS */;


--
-- Definition of table `tallas`
--

DROP TABLE IF EXISTS `tallas`;
CREATE TABLE `tallas` (
  `IdTallas` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Modelo` varchar(45) NOT NULL,
  `Talla` int(10) unsigned NOT NULL,
  `Disponible` int(10) unsigned NOT NULL,
  PRIMARY KEY (`IdTallas`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tallas`
--

/*!40000 ALTER TABLE `tallas` DISABLE KEYS */;
INSERT INTO `tallas` (`IdTallas`,`Modelo`,`Talla`,`Disponible`) VALUES 
 (1,'B2 Running',15,0),
 (2,'Chucky Cheese',15,3),
 (3,'B2-3',17,0),
 (4,'B2-3',20,4),
 (5,'B2-3',18,3),
 (6,'Chucky Cheese',16,5);
/*!40000 ALTER TABLE `tallas` ENABLE KEYS */;


--
-- Definition of table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
CREATE TABLE `ventas` (
  `Id_Venta` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Id_Dependiente` int(10) unsigned NOT NULL,
  `Id_Zapato` int(10) unsigned NOT NULL,
  `FechaVenta` varchar(45) NOT NULL,
  `Importe` int(10) unsigned NOT NULL,
  `Modelo` varchar(45) NOT NULL,
  PRIMARY KEY (`Id_Venta`),
  KEY `FK_ventas_1` (`Id_Zapato`),
  KEY `FK_ventas_2` (`Id_Dependiente`),
  CONSTRAINT `FK_ventas_1` FOREIGN KEY (`Id_Zapato`) REFERENCES `zapatos` (`Id_Zapato`),
  CONSTRAINT `FK_ventas_2` FOREIGN KEY (`Id_Dependiente`) REFERENCES `dependientes` (`Id_Dep`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ventas`
--

/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` (`Id_Venta`,`Id_Dependiente`,`Id_Zapato`,`FechaVenta`,`Importe`,`Modelo`) VALUES 
 (1,1,8,'2022-07-07',3100,'B2 Running'),
 (2,3,13,'2022-07-07',1200,'Chucky Cheese'),
 (3,3,17,'2022-07-07',1150,'B2-3'),
 (4,3,17,'2022-07-07',1150,'B2-3'),
 (5,3,17,'2022-07-07',1150,'B2-3'),
 (6,1,17,'2022-07-07',1150,'B2-3'),
 (7,1,17,'2022-07-07',1150,'B2-3'),
 (8,3,17,'2022-07-07',1150,'B2-3'),
 (9,3,17,'2022-07-07',1150,'B2-3');
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;


--
-- Definition of table `zapatos`
--

DROP TABLE IF EXISTS `zapatos`;
CREATE TABLE `zapatos` (
  `Id_Zapato` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Zapato` varchar(45) NOT NULL,
  `Modelo` varchar(45) NOT NULL,
  `Precio` varchar(45) NOT NULL,
  PRIMARY KEY (`Id_Zapato`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `zapatos`
--

/*!40000 ALTER TABLE `zapatos` DISABLE KEYS */;
INSERT INTO `zapatos` (`Id_Zapato`,`Zapato`,`Modelo`,`Precio`) VALUES 
 (8,'Nike','B2 Running','3100'),
 (9,'Adidas','Q812','2500'),
 (10,'DC','Skinny BC','1000'),
 (13,'Converse','Chucky Cheese','1200'),
 (14,'Nike','Runn Flex','1300'),
 (17,'Nike','B2-3','1150');
/*!40000 ALTER TABLE `zapatos` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
