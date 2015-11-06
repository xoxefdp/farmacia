-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 13, 2015 at 05:41 PM
-- Server version: 5.5.44-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE DATABASE farmacia;

USE farmacia;

--
-- Database: `farmacia`
--

-- --------------------------------------------------------

--
-- Table structure for table `componente`
--

CREATE TABLE IF NOT EXISTS `componente` (
  `idComponente` int(11) NOT NULL AUTO_INCREMENT,
  `nombreDelComponente` varchar(60) NOT NULL,
  PRIMARY KEY (`idComponente`),
  UNIQUE KEY `nombreDelComponente` (`nombreDelComponente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `componente`
--

INSERT INTO `componente` (`idComponente`, `nombreDelComponente`) VALUES
(7, 'Acetaminofen'),
(10, 'Almidon de maiz'),
(12, 'Cafeina anhidra'),
(13, 'Clopidogrel sulfato '),
(19, 'Dextroclorfeniramina maleato'),
(15, 'Hidroclorotiazida'),
(17, 'Irbesartan'),
(8, 'Itraconazol'),
(11, 'Lactosa'),
(9, 'Loratadina'),
(1, 'N-butilbromuro de hioscina'),
(18, 'Rojo #40'),
(4, 'Valsartan'),
(16, 'Verapamilo Clorhidrato');

-- --------------------------------------------------------

--
-- Stand-in structure for view `fichadeproducto`
--
CREATE TABLE IF NOT EXISTS `fichadeproducto` (
`idMedicamento` int(11)
,`nombreComercial` varchar(60)
,`idComponente` int(6)
,`cantidadDelComponente` double
,`idUnidadDeMedida` int(6)
,`nombreDelComponente` varchar(60)
,`nombreDeLaUnidadDeMedida` varchar(20)
);
-- --------------------------------------------------------

--
-- Table structure for table `laboratorio`
--

CREATE TABLE IF NOT EXISTS `laboratorio` (
  `idLaboratorio` int(11) NOT NULL AUTO_INCREMENT,
  `nombreDelLaboratorio` varchar(40) NOT NULL,
  PRIMARY KEY (`idLaboratorio`),
  UNIQUE KEY `nombreDelLaboratorio` (`nombreDelLaboratorio`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Dumping data for table `laboratorio`
--

INSERT INTO `laboratorio` (`idLaboratorio`, `nombreDelLaboratorio`) VALUES
(13, 'Abbot'),
(15, 'Biotech'),
(6, 'Bluepharma'),
(20, 'Boehringer'),
(1, 'Calox'),
(18, 'Elmor'),
(17, 'Elter'),
(4, 'Genven'),
(21, 'Glenmark'),
(11, 'Klinos'),
(10, 'Leti'),
(8, 'Novartis'),
(9, 'Now Foods'),
(7, 'Pfizer'),
(14, 'Sanofi'),
(12, 'Wyeth');

-- --------------------------------------------------------

--
-- Table structure for table `medicamento`
--

CREATE TABLE IF NOT EXISTS `medicamento` (
  `idMedicamento` int(11) NOT NULL AUTO_INCREMENT,
  `nombreComercial` varchar(60) NOT NULL,
  `idLaboratorio` int(11) NOT NULL,
  PRIMARY KEY (`idMedicamento`),
  UNIQUE KEY `nombreComercial` (`nombreComercial`),
  KEY `idLaboratorio` (`idLaboratorio`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `medicamento`
--

INSERT INTO `medicamento` (`idMedicamento`, `nombreComercial`, `idLaboratorio`) VALUES
(6, 'Diovan 40 mg', 8),
(7, 'Buscapina', 20),
(10, 'Alres', 18),
(11, 'Diovan 40 HCT 12,5', 8);

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `idMedicamento` int(6) NOT NULL,
  `idComponente` int(6) NOT NULL,
  `cantidadDelComponente` double NOT NULL,
  `idUnidadDeMedida` int(6) NOT NULL,
  PRIMARY KEY (`idMedicamento`,`idComponente`),
  KEY `idUnidadDeMedida` (`idUnidadDeMedida`),
  KEY `idComponente` (`idComponente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `producto`
--

INSERT INTO `producto` (`idMedicamento`, `idComponente`, `cantidadDelComponente`, `idUnidadDeMedida`) VALUES
(6, 4, 40, 22),
(7, 1, 500, 22),
(7, 7, 50, 22),
(10, 7, 5, 23),
(10, 9, 500, 22),
(10, 10, 10, 22),
(11, 4, 12.5, 22),
(11, 15, 12.5, 22);

-- --------------------------------------------------------

--
-- Stand-in structure for view `ProductoLaboratorio`
--
CREATE TABLE IF NOT EXISTS `ProductoLaboratorio` (
`idMedicamento` int(11)
,`nombreComercial` varchar(60)
,`idLaboratorio` int(11)
,`nombreDelLaboratorio` varchar(40)
);
-- --------------------------------------------------------

--
-- Table structure for table `unidaddemedida`
--

CREATE TABLE IF NOT EXISTS `unidaddemedida` (
  `idDeUnidadDeMedida` int(11) NOT NULL AUTO_INCREMENT,
  `nombreDeLaUnidadDeMedida` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idDeUnidadDeMedida`),
  UNIQUE KEY `uMedida` (`nombreDeLaUnidadDeMedida`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `unidaddemedida`
--

INSERT INTO `unidaddemedida` (`idDeUnidadDeMedida`, `nombreDeLaUnidadDeMedida`) VALUES
(18, 'cc.'),
(23, 'gr.'),
(22, 'mg.'),
(17, 'ml.');

-- --------------------------------------------------------

--
-- Structure for view `fichadeproducto`
--
DROP TABLE IF EXISTS `fichadeproducto`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `fichadeproducto` AS select `medicamento`.`idMedicamento` AS `idMedicamento`,`medicamento`.`nombreComercial` AS `nombreComercial`,`producto`.`idComponente` AS `idComponente`,`producto`.`cantidadDelComponente` AS `cantidadDelComponente`,`producto`.`idUnidadDeMedida` AS `idUnidadDeMedida`,`componente`.`nombreDelComponente` AS `nombreDelComponente`,`unidaddemedida`.`nombreDeLaUnidadDeMedida` AS `nombreDeLaUnidadDeMedida` from (((`medicamento` join `producto`) join `componente`) join `unidaddemedida`) where ((`medicamento`.`idMedicamento` = `producto`.`idMedicamento`) and (`producto`.`idComponente` = `componente`.`idComponente`) and (`producto`.`idUnidadDeMedida` = `unidaddemedida`.`idDeUnidadDeMedida`));

-- --------------------------------------------------------

--
-- Structure for view `ProductoLaboratorio`
--
DROP TABLE IF EXISTS `ProductoLaboratorio`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `ProductoLaboratorio` AS select `medicamento`.`idMedicamento` AS `idMedicamento`,`medicamento`.`nombreComercial` AS `nombreComercial`,`laboratorio`.`idLaboratorio` AS `idLaboratorio`,`laboratorio`.`nombreDelLaboratorio` AS `nombreDelLaboratorio` from (`medicamento` join `laboratorio`) where (`medicamento`.`idLaboratorio` = `laboratorio`.`idLaboratorio`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `medicamento`
--
ALTER TABLE `medicamento`
  ADD CONSTRAINT `medicamento_ibfk_1` FOREIGN KEY (`idLaboratorio`) REFERENCES `laboratorio` (`idLaboratorio`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idMedicamento`) REFERENCES `medicamento` (`idMedicamento`),
  ADD CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`idComponente`) REFERENCES `componente` (`idComponente`),
  ADD CONSTRAINT `producto_ibfk_3` FOREIGN KEY (`idUnidadDeMedida`) REFERENCES `unidaddemedida` (`idDeUnidadDeMedida`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
