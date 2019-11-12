-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 12 nov. 2019 à 12:37
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `jeeprj`
--

-- --------------------------------------------------------

--
-- Structure de la table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE IF NOT EXISTS `employees` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(25) NOT NULL,
  `FIRSTNAME` varchar(25) NOT NULL,
  `TELHOME` varchar(10) NOT NULL,
  `TELMOB` varchar(10) NOT NULL,
  `TELPRO` varchar(10) NOT NULL,
  `ADRESS` varchar(150) NOT NULL,
  `POSTALCODE` varchar(5) NOT NULL,
  `CITY` varchar(25) NOT NULL,
  `EMAIL` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `employees`
--

INSERT INTO `employees` (`ID`, `NAME`, `FIRSTNAME`, `TELHOME`, `TELMOB`, `TELPRO`, `ADRESS`, `POSTALCODE`, `CITY`, `EMAIL`) VALUES
(1, 'Simpson', 'Homer', '0123456789', '0612345678', '0698765432', '2 avenue Duff', '92700', 'Colombes', 'hsimpson@gmail.com'),
(2, 'Simpson', 'Bart', '0145362787', '0645362718', '0611563477', '10 rue des Rebelles', '92270', 'Bois-colombes', 'bsimpson@gmail.com'),
(3, 'Lagaffe', 'Gaston', '0187665987', '0623334256', '0654778654', '65 rue de la Paresse', '92700', 'Colombes', 'glagaffe@yahoo.fr'),
(4, 'Mafalda', 'Querida', '0187611987', '0783334256', '0658878654', '6 rue de Buenos Aires', '75016', 'Paris', 'qmafalda@hotmail.ar'),
(7, 'Brown', 'Charlie', '0122456678', '0699854673', '0623445166', '140 avenue Foche', '90000', 'Nanterre', 'cbrown@live.com'),
(10, 'Woodpecker', 'Woody', '0187384987', '0622494256', '0674178654', '5 bvd des Picoreurs', '21000', 'Dijon', 'woody@mail.co.uk');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
