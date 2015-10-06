CREATE DATABASE  IF NOT EXISTS `farmacia`;
USE `farmacia`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: farmacia
-- ------------------------------------------------------
-- Server version	5.5.16-log


--
-- Table structure for table `componente`
--

DROP TABLE IF EXISTS `componente`;
CREATE TABLE `products` (
  `idComponente` char(4) NOT NULL,
  `nombreDelComponente` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`idComponente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `laboratorio`
--

DROP TABLE IF EXISTS `laboratorio`;
CREATE TABLE `suppliers` (
  `idLaboratorio` char(4) NOT NULL,
  `nombreDelLaboratorio` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`idLaboratorio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `unidaddemedida`
--

DROP TABLE IF EXISTS `unidaddemedida`;
CREATE TABLE `suppliers` (
  `idDeUnidadDeMedida` char(4) NOT NULL,
  `nombreDeLaUnidadDeMedida` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`idDeUnidadDeMedida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
CREATE TABLE `suppliers` (
  `idMedicamento` char(4) NOT NULL,
  `idLaboratorio` char(4) NOT NULL,
  `nombreComercial` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`idMedicamento`, `idLaboratorio`),
  KEY `idLaboratorio` (`idLaboratorio`),
  CONSTRAINT `medicamento_ibfk_1` FOREIGN KEY (`idLaboratorio`) REFERENCES `laboratorio` (`idLaboratorio`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE `suppliers` (
  `idMedicamento` char(4) NOT NULL,
  `idComponente` char(4) NOT NULL,
  `idUnidadDeMedida` char(4) NOT NULL,
  `cantidadDelComponente` float(5) DEFAULT NULL,
  PRIMARY KEY (`idMedicamento`,`idComponente`,`idUnidadDeMedida`),
  KEY `idComponente` (`idComponente`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idMedicamento`) REFERENCES `laboratorio` (`idMedicamento`),
  CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`idComponente`) REFERENCES `componente` (`idComponente`),
  CONSTRAINT `producto_ibfk_3` FOREIGN KEY (`idUnidadDeMedida`) REFERENCES `unidaddemedida` (`idUnidadDeMedida`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
