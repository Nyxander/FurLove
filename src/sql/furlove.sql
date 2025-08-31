-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 31, 2025 at 09:06 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `furlove`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_ID` int(11) NOT NULL,
  `emer` varchar(100) DEFAULT NULL,
  `mbiemer` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_ID`, `emer`, `mbiemer`, `email`, `password`) VALUES
(1, 'Lorena', 'Cobaj', 'cobajlore@nyx.com', '240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9');

-- --------------------------------------------------------

--
-- Table structure for table `adoptime`
--

CREATE TABLE `adoptime` (
  `adoption_ID` int(11) NOT NULL,
  `kafsha_ID` int(11) NOT NULL,
  `aplikim_ID` int(11) DEFAULT NULL,
  `emer` varchar(100) NOT NULL,
  `mbiemer` varchar(100) DEFAULT NULL,
  `telefoni` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `data_adoptimit` date NOT NULL DEFAULT curdate(),
  `tarifa` decimal(10,2) DEFAULT NULL,
  `kontrat` varchar(255) DEFAULT NULL,
  `shenime` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `adoptime`
--

INSERT INTO `adoptime` (`adoption_ID`, `kafsha_ID`, `aplikim_ID`, `emer`, `mbiemer`, `telefoni`, `email`, `data_adoptimit`, `tarifa`, `kontrat`, `shenime`) VALUES
(9, 3, 6, 'Alba', 'Hoxha', '12345', 'ce@sdv.com', '2025-08-20', 100.00, 'C:\\Users\\User\\Downloads\\FurLove\\src\\contracts\\contract_6.txt', 'bgf'),
(10, 2, 5, 'Sara', 'Hoxha', '123', 'dfg@fgg.co', '2025-08-18', 100.00, 'C:\\Users\\User\\Downloads\\FurLove\\src\\contracts\\contract_5.txt', 'fghj');

-- --------------------------------------------------------

--
-- Table structure for table `caktimi_i_kafsheve_ne_streha`
--

CREATE TABLE `caktimi_i_kafsheve_ne_streha` (
  `id` int(11) NOT NULL,
  `kafsha_ID` int(11) NOT NULL,
  `streha_ID` int(11) NOT NULL,
  `start_date` date NOT NULL DEFAULT curdate(),
  `end_date` date DEFAULT NULL,
  `notes` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `caktimi_i_kafsheve_ne_streha`
--

INSERT INTO `caktimi_i_kafsheve_ne_streha` (`id`, `kafsha_ID`, `streha_ID`, `start_date`, `end_date`, `notes`) VALUES
(1, 2, 1, '2025-08-19', '2025-08-19', NULL),
(2, 1, 1, '2025-08-19', NULL, NULL),
(3, 3, 1, '2025-08-19', '2025-08-19', NULL),
(5, 7, 1, '2025-08-19', NULL, NULL),
(7, 4, 2, '2025-08-20', '2025-08-21', NULL),
(8, 5, 2, '2025-08-20', NULL, NULL),
(12, 4, 1, '2025-08-21', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `fotot_kafsheve`
--

CREATE TABLE `fotot_kafsheve` (
  `foto_ID` int(11) NOT NULL,
  `kafsha_ID` int(11) NOT NULL,
  `foto_path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `fotot_kafsheve`
--

INSERT INTO `fotot_kafsheve` (`foto_ID`, `kafsha_ID`, `foto_path`) VALUES
(9, 2, 'src\\furlove\\foto\\1755083120242_1901995555.jpg'),
(10, 2, 'src\\furlove\\foto\\1755083358311_1901995555.jpg'),
(11, 1, 'src\\furlove\\foto\\1755084092971_306061623.png');

-- --------------------------------------------------------

--
-- Table structure for table `kafshet`
--

CREATE TABLE `kafshet` (
  `kafsha_ID` int(11) NOT NULL,
  `emri` varchar(100) DEFAULT NULL,
  `specia` varchar(100) DEFAULT NULL,
  `gjinia` enum('M','F') NOT NULL,
  `gjendjaShendetesore` text NOT NULL,
  `statusiShendetesor` enum('Shëndetshëm','I sëmurë','Në trajtim','Në rikuperim') NOT NULL DEFAULT 'Shëndetshëm',
  `vendndodhjaFundit` text DEFAULT NULL,
  `komente` text DEFAULT NULL,
  `adoption_status` enum('I LIRE','I ZENE','I ADOPTUAR','JO I MUNDUR') NOT NULL DEFAULT 'I LIRE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kafshet`
--

INSERT INTO `kafshet` (`kafsha_ID`, `emri`, `specia`, `gjinia`, `gjendjaShendetesore`, `statusiShendetesor`, `vendndodhjaFundit`, `komente`, `adoption_status`) VALUES
(1, 'Luna', 'Qen', 'F', 'E vaksinuar, e sterilizuar', 'Shëndetshëm', 'Tirana, rr. Elbasanit', 'Shumë e dashur me fëmijët dhe te rriturit.', 'I LIRE'),
(2, 'Tom', 'Mace', 'M', 'Infeksion në sy', 'Në trajtim', 'Durrës, rr. Currila', 'Kërkon kujdes mjekësor', 'I ADOPTUAR'),
(3, 'Bubi', 'Qen', 'M', 'Mbipeshe', 'Në rikuperim', 'Shkodër, rr. Parrucë', 'Energjik dhe i gjallë', 'I ADOPTUAR'),
(4, 'Dino', 'Breshke', 'M', 'shguall i demtuar', 'I sëmurë', 'Laprake', 'ca femije po e zinin me gur', 'I LIRE'),
(5, 'Buni', 'Lepur', 'M', 'Pa nje vesh', 'Në trajtim', 'Afer shkolles', 'Pa nje vesh', 'I LIRE'),
(7, 'Leo', 'Hardhuce', 'M', 'Kembe e plagosur', 'Në trajtim', 'Rr.', 'E gjeten te lenduar', 'I LIRE'),
(8, 'Kuki', 'Mace', 'M', 'Ja ashtu', 'Shëndetshëm', 'Bryli', 'Shenim', 'I LIRE');

-- --------------------------------------------------------

--
-- Table structure for table `kerkesatadoptim`
--

CREATE TABLE `kerkesatadoptim` (
  `ka_ID` int(11) NOT NULL,
  `streha_ID` int(11) DEFAULT NULL,
  `kafsha_ID` int(11) DEFAULT NULL,
  `kerkuesi` varchar(100) DEFAULT NULL,
  `dataKerkeses` date DEFAULT NULL,
  `status` enum('NË PRITJE','MIRATUAR','REFUZUAR','ANULUAR') NOT NULL DEFAULT 'NË PRITJE',
  `telefoni` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `shenim` text DEFAULT NULL,
  `krijuar_me` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kerkesatadoptim`
--

INSERT INTO `kerkesatadoptim` (`ka_ID`, `streha_ID`, `kafsha_ID`, `kerkuesi`, `dataKerkeses`, `status`, `telefoni`, `email`, `shenim`, `krijuar_me`) VALUES
(2, 2, 2, 'Mimoza Kelmendi', '2025-08-03', 'NË PRITJE', '34566543', 'example@gmail.com', 'dfgh', '2025-08-18 10:45:53'),
(5, 1, 2, 'Sara Hoxha', '2025-08-19', 'MIRATUAR', '2345676', 'dfg@fgg.co', 'fghj', '2025-08-19 12:35:27'),
(6, 1, 3, 'Alba Hoxha', '2025-08-19', 'MIRATUAR', '12345', 'ce@sdv.com', 'bgf', '2025-08-19 13:06:00'),
(8, 2, 5, 'Amar Boraj', '2025-08-21', 'NË PRITJE', '12345678', 'as@gmail.com', 'efbvd', '2025-08-21 11:21:24'),
(9, 2, 4, 'Kreshnik Spahiu', '2025-08-21', 'NË PRITJE', '1234567898', 'kspahiu@hgf.com', 'Shenime', '2025-08-21 11:56:08'),
(10, 1, 1, 'Heili Bieber', '2025-08-26', 'NË PRITJE', '56543223', 'sd@gmail.com', 'fgfds', '2025-08-26 11:21:58'),
(13, 1, 4, 'Heili Bieber', '2025-08-26', 'NË PRITJE', '1234567898', 'asdf@asdf.com', 'asdfg', '2025-08-26 14:58:53');

-- --------------------------------------------------------

--
-- Table structure for table `ndjekjamjekesore`
--

CREATE TABLE `ndjekjamjekesore` (
  `nm_ID` int(11) NOT NULL,
  `kafsha_ID` int(11) DEFAULT NULL,
  `llojiProcedures` text DEFAULT NULL,
  `mjeku` varchar(100) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `rezultati` text DEFAULT NULL,
  `komente` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ndjekjamjekesore`
--

INSERT INTO `ndjekjamjekesore` (`nm_ID`, `kafsha_ID`, `llojiProcedures`, `mjeku`, `data`, `rezultati`, `komente`) VALUES
(1, 1, 'Vaksinim', 'Dr. Eva Bregu', '2025-08-11', 'Me sukses', 'Pa probleme fare'),
(2, 1, 'Vaksinim antirabik', 'Dr. Ada Kola', '2025-08-11', 'I suksesshëm', 'Pa efekte anësore');

-- --------------------------------------------------------

--
-- Table structure for table `specia`
--

CREATE TABLE `specia` (
  `specia_id` int(11) NOT NULL,
  `specia` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `specia`
--

INSERT INTO `specia` (`specia_id`, `specia`) VALUES
(3, 'Breshke'),
(4, 'Hardhuce'),
(5, 'Lepur'),
(2, 'Mace'),
(1, 'Qen');

-- --------------------------------------------------------

--
-- Table structure for table `strehezaperkohshme`
--

CREATE TABLE `strehezaperkohshme` (
  `streha_ID` int(11) NOT NULL,
  `adresa` text DEFAULT NULL,
  `emer` varchar(100) DEFAULT NULL,
  `kapaciteti` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `strehezaperkohshme`
--

INSERT INTO `strehezaperkohshme` (`streha_ID`, `adresa`, `emer`, `kapaciteti`) VALUES
(1, 'Tirane', 'Strehe per Kafshe “PawSafe”', 20),
(2, 'Durres', 'Qendra per Kafshe Endacake “HopeHome”', 30);

-- --------------------------------------------------------

--
-- Table structure for table `veterineret`
--

CREATE TABLE `veterineret` (
  `id` int(11) NOT NULL,
  `emri` varchar(100) NOT NULL,
  `specializimi` varchar(100) NOT NULL,
  `telefoni` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `veterineret`
--

INSERT INTO `veterineret` (`id`, `emri`, `specializimi`, `telefoni`) VALUES
(1, 'Dr. Arben Hoxha', 'Kafshet e vogla', '0691234563'),
(2, 'Dr. Elira Kola', 'Kafshet e fermes', '0687654321'),
(3, 'Dr. Besim Pasha', 'Kafshet ekzotike', '0671122334'),
(4, 'Dr. Lira Çela', 'Kafshet shtepiake', '0699988776'),
(5, 'Dr. Eva Bregu', 'Kafshet shtepiake', '0691988776'),
(6, 'Dr. Ada Kola', 'Kafshet shtepiake', '0699988716'),
(7, 'Dr. Petrit Deda', 'Kafshet e egra', '0674455667'),
(8, 'Dr. Krist Hoxha', 'Kafshet shtepiake', '0684938585');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_ID`);

--
-- Indexes for table `adoptime`
--
ALTER TABLE `adoptime`
  ADD PRIMARY KEY (`adoption_ID`),
  ADD KEY `fk_adopt_animal` (`kafsha_ID`),
  ADD KEY `fk_adopt_app` (`aplikim_ID`);

--
-- Indexes for table `caktimi_i_kafsheve_ne_streha`
--
ALTER TABLE `caktimi_i_kafsheve_ne_streha`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_asa_shelter` (`streha_ID`),
  ADD KEY `kafsha_ID` (`kafsha_ID`,`end_date`);

--
-- Indexes for table `fotot_kafsheve`
--
ALTER TABLE `fotot_kafsheve`
  ADD PRIMARY KEY (`foto_ID`),
  ADD KEY `fk_foto_animal` (`kafsha_ID`);

--
-- Indexes for table `kafshet`
--
ALTER TABLE `kafshet`
  ADD PRIMARY KEY (`kafsha_ID`);

--
-- Indexes for table `kerkesatadoptim`
--
ALTER TABLE `kerkesatadoptim`
  ADD PRIMARY KEY (`ka_ID`),
  ADD KEY `streha_ID` (`streha_ID`),
  ADD KEY `kafsha_ID` (`kafsha_ID`);

--
-- Indexes for table `ndjekjamjekesore`
--
ALTER TABLE `ndjekjamjekesore`
  ADD PRIMARY KEY (`nm_ID`),
  ADD KEY `kafsha_ID` (`kafsha_ID`);

--
-- Indexes for table `specia`
--
ALTER TABLE `specia`
  ADD PRIMARY KEY (`specia_id`),
  ADD UNIQUE KEY `specia` (`specia`);

--
-- Indexes for table `strehezaperkohshme`
--
ALTER TABLE `strehezaperkohshme`
  ADD PRIMARY KEY (`streha_ID`);

--
-- Indexes for table `veterineret`
--
ALTER TABLE `veterineret`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adoptime`
--
ALTER TABLE `adoptime`
  MODIFY `adoption_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `caktimi_i_kafsheve_ne_streha`
--
ALTER TABLE `caktimi_i_kafsheve_ne_streha`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `fotot_kafsheve`
--
ALTER TABLE `fotot_kafsheve`
  MODIFY `foto_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `kafshet`
--
ALTER TABLE `kafshet`
  MODIFY `kafsha_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `kerkesatadoptim`
--
ALTER TABLE `kerkesatadoptim`
  MODIFY `ka_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `ndjekjamjekesore`
--
ALTER TABLE `ndjekjamjekesore`
  MODIFY `nm_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `specia`
--
ALTER TABLE `specia`
  MODIFY `specia_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `veterineret`
--
ALTER TABLE `veterineret`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `adoptime`
--
ALTER TABLE `adoptime`
  ADD CONSTRAINT `fk_adopt_animal` FOREIGN KEY (`kafsha_ID`) REFERENCES `kafshet` (`kafsha_ID`),
  ADD CONSTRAINT `fk_adopt_app` FOREIGN KEY (`aplikim_ID`) REFERENCES `kerkesatadoptim` (`ka_ID`) ON DELETE SET NULL;

--
-- Constraints for table `caktimi_i_kafsheve_ne_streha`
--
ALTER TABLE `caktimi_i_kafsheve_ne_streha`
  ADD CONSTRAINT `fk_asa_animal` FOREIGN KEY (`kafsha_ID`) REFERENCES `kafshet` (`kafsha_ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_asa_shelter` FOREIGN KEY (`streha_ID`) REFERENCES `strehezaperkohshme` (`streha_ID`);

--
-- Constraints for table `fotot_kafsheve`
--
ALTER TABLE `fotot_kafsheve`
  ADD CONSTRAINT `fk_foto_animal` FOREIGN KEY (`kafsha_ID`) REFERENCES `kafshet` (`kafsha_ID`) ON DELETE CASCADE;

--
-- Constraints for table `kerkesatadoptim`
--
ALTER TABLE `kerkesatadoptim`
  ADD CONSTRAINT `kerkesatadoptim_ibfk_1` FOREIGN KEY (`streha_ID`) REFERENCES `strehezaperkohshme` (`streha_ID`),
  ADD CONSTRAINT `kerkesatadoptim_ibfk_2` FOREIGN KEY (`kafsha_ID`) REFERENCES `kafshet` (`kafsha_ID`);

--
-- Constraints for table `ndjekjamjekesore`
--
ALTER TABLE `ndjekjamjekesore`
  ADD CONSTRAINT `ndjekjamjekesore_ibfk_1` FOREIGN KEY (`kafsha_ID`) REFERENCES `kafshet` (`kafsha_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
