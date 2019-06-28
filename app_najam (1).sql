-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 28, 2019 at 02:31 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `app_najam`
--

-- --------------------------------------------------------

--
-- Table structure for table `klijent`
--

CREATE TABLE `klijent` (
  `ID_klijent` int(11) NOT NULL,
  `ime` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `brojTelefona` varchar(25) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `mjesto`
--

CREATE TABLE `mjesto` (
  `mjesto_id` int(11) NOT NULL,
  `nazivMjesta` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `zupanija` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `mjesto`
--

INSERT INTO `mjesto` (`mjesto_id`, `nazivMjesta`, `zupanija`) VALUES
(1, 'Mostar', 1),
(2, 'Grude', 3),
(3, 'Kupres', 2);

-- --------------------------------------------------------

--
-- Table structure for table `stan`
--

CREATE TABLE `stan` (
  `ID_stan` int(11) NOT NULL,
  `vlasnik_id` int(11) NOT NULL,
  `adresa_stan` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `brojKvadrata` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `brojSoba` int(11) NOT NULL,
  `cijena` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `id_mjesto` int(11) NOT NULL,
  `vrstaStana_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `stan`
--

INSERT INTO `stan` (`ID_stan`, `vlasnik_id`, `adresa_stan`, `brojKvadrata`, `brojSoba`, `cijena`, `id_mjesto`, `vrstaStana_id`) VALUES
(1, 6, 'mostar', '100', 3, '350', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `ugovor`
--

CREATE TABLE `ugovor` (
  `ID_ugovor` int(11) NOT NULL,
  `opis` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `datum` date NOT NULL,
  `id_stan` int(11) NOT NULL,
  `id_vlasnik` int(11) NOT NULL,
  `id_klijent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `vlasnik`
--

CREATE TABLE `vlasnik` (
  `ID_vlasnik` int(11) NOT NULL,
  `ime` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `korisnickoIme` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `lozinka` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `uloga` enum('ADMIN','VLASNIK','KLIJENT','') COLLATE utf8_unicode_ci NOT NULL,
  `brojTelefona` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `adresa` varchar(25) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `vlasnik`
--

INSERT INTO `vlasnik` (`ID_vlasnik`, `ime`, `prezime`, `korisnickoIme`, `lozinka`, `uloga`, `brojTelefona`, `adresa`) VALUES
(1, 'Anamarija', 'Dumancic', 'anamarija', 'anamarija', 'ADMIN', '274785', 'Kupres'),
(5, 'marin', 'marin', 'marin', 'marin', 'KLIJENT', '1234', 'mostar'),
(6, 'pero', 'pero', 'pero', 'pero', 'VLASNIK', '1234', 'mostar');

-- --------------------------------------------------------

--
-- Table structure for table `vrstastana`
--

CREATE TABLE `vrstastana` (
  `ID_vrstaStana` int(11) NOT NULL,
  `vrstaStana` varchar(55) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `vrstastana`
--

INSERT INTO `vrstastana` (`ID_vrstaStana`, `vrstaStana`) VALUES
(1, 'namješten'),
(2, 'nenamješten');

-- --------------------------------------------------------

--
-- Table structure for table `zupanija`
--

CREATE TABLE `zupanija` (
  `ID_zupanija` int(11) NOT NULL,
  `nazivZupanije` varchar(55) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `zupanija`
--

INSERT INTO `zupanija` (`ID_zupanija`, `nazivZupanije`) VALUES
(1, 'HNZ'),
(2, 'HBZ'),
(3, 'ZH');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `klijent`
--
ALTER TABLE `klijent`
  ADD PRIMARY KEY (`ID_klijent`);

--
-- Indexes for table `mjesto`
--
ALTER TABLE `mjesto`
  ADD PRIMARY KEY (`mjesto_id`),
  ADD KEY `zupanija_fk` (`zupanija`);

--
-- Indexes for table `stan`
--
ALTER TABLE `stan`
  ADD PRIMARY KEY (`ID_stan`),
  ADD KEY `vlasnik_fk` (`vlasnik_id`),
  ADD KEY `vrstaStana_fk` (`vrstaStana_id`),
  ADD KEY `mjesto_fk` (`id_mjesto`);

--
-- Indexes for table `ugovor`
--
ALTER TABLE `ugovor`
  ADD PRIMARY KEY (`ID_ugovor`),
  ADD KEY `stan_fk` (`id_stan`),
  ADD KEY `id_klijent` (`id_klijent`);

--
-- Indexes for table `vlasnik`
--
ALTER TABLE `vlasnik`
  ADD PRIMARY KEY (`ID_vlasnik`);

--
-- Indexes for table `vrstastana`
--
ALTER TABLE `vrstastana`
  ADD PRIMARY KEY (`ID_vrstaStana`);

--
-- Indexes for table `zupanija`
--
ALTER TABLE `zupanija`
  ADD PRIMARY KEY (`ID_zupanija`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `klijent`
--
ALTER TABLE `klijent`
  MODIFY `ID_klijent` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `mjesto`
--
ALTER TABLE `mjesto`
  MODIFY `mjesto_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `stan`
--
ALTER TABLE `stan`
  MODIFY `ID_stan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ugovor`
--
ALTER TABLE `ugovor`
  MODIFY `ID_ugovor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `vlasnik`
--
ALTER TABLE `vlasnik`
  MODIFY `ID_vlasnik` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `vrstastana`
--
ALTER TABLE `vrstastana`
  MODIFY `ID_vrstaStana` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `zupanija`
--
ALTER TABLE `zupanija`
  MODIFY `ID_zupanija` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mjesto`
--
ALTER TABLE `mjesto`
  ADD CONSTRAINT `mjesto_ibfk_1` FOREIGN KEY (`zupanija`) REFERENCES `zupanija` (`ID_zupanija`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `stan`
--
ALTER TABLE `stan`
  ADD CONSTRAINT `stan_ibfk_1` FOREIGN KEY (`vlasnik_id`) REFERENCES `vlasnik` (`ID_vlasnik`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stan_ibfk_2` FOREIGN KEY (`id_mjesto`) REFERENCES `mjesto` (`mjesto_id`),
  ADD CONSTRAINT `stan_ibfk_3` FOREIGN KEY (`vrstaStana_id`) REFERENCES `vrstastana` (`ID_vrstaStana`);

--
-- Constraints for table `ugovor`
--
ALTER TABLE `ugovor`
  ADD CONSTRAINT `ugovor_ibfk_1` FOREIGN KEY (`id_klijent`) REFERENCES `klijent` (`ID_klijent`),
  ADD CONSTRAINT `ugovor_ibfk_2` FOREIGN KEY (`id_stan`) REFERENCES `stan` (`ID_stan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
