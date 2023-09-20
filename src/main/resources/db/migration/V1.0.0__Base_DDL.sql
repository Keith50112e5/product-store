-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: db_server
-- Erstellungszeit: 20. Sep 2023 um 10:00
-- Server-Version: 10.5.9-MariaDB-1:10.5.9+maria~focal
-- PHP-Version: 8.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `product-manager`
--

-- --------------------------------------------------------

CREATE TABLE `category` (
    `active` tinyint(4) DEFAULT NULL,
    `id` int(11) NOT NULL,
    `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `category` (`active`, `id`, `name`) VALUES
    (1, 1, 'Novel');

CREATE TABLE `product` (
    `active` tinyint(4) DEFAULT NULL,
    `category_id` int(11) DEFAULT NULL,
    `id` int(11) NOT NULL,
    `price` float DEFAULT NULL,
    `stock` int(11) DEFAULT NULL,
    `description` mediumtext DEFAULT NULL,
    `image` varchar(1000) DEFAULT NULL,
    `name` varchar(500) DEFAULT NULL,
    `sku` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `product` (`active`, `category_id`, `id`, `price`, `stock`, `description`, `image`, `name`, `sku`) VALUES
    (1, NULL, 1, 10, 20, 'Hard', 'imageHere', 'Book', 'Tester');

CREATE TABLE `user` (
    `id` int(11) NOT NULL,
    `is_admin` tinyint(4) DEFAULT NULL,
    `email` varchar(255) DEFAULT NULL,
    `pw` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `user` (`id`, `is_admin`, `email`, `pw`) VALUES
    (1, 1, 'admin@admin.com', '$2a$10$oytt5b3mOF35HUelaak3eeRCGE/7th1T2hxsEK38TnaNvGMdbM0zO'),
    (2, 0, 'user@user.com', '$2a$10$MoJlAFbARB.t0vKEOW9gy.9.PTIxJkqLkeVPlcKXBw9zLuhmMk7d2');

ALTER TABLE `category`
    ADD PRIMARY KEY (`id`);

ALTER TABLE `product`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`);

ALTER TABLE `user`
    ADD PRIMARY KEY (`id`);

ALTER TABLE `product`
    ADD CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
