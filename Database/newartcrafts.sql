-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 28, 2026 at 12:00 PM
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
-- Database: `newartcrafts`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart1`
--

CREATE TABLE `cart1` (
  `id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `hmproduct_id` int(11) DEFAULT NULL,
  `hmuser_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cart1`
--

INSERT INTO `cart1` (`id`, `quantity`, `hmproduct_id`, `hmuser_id`) VALUES
(1552, 2, 252, 352),
(1553, 1, 302, 352);

-- --------------------------------------------------------

--
-- Table structure for table `cart1_seq`
--

CREATE TABLE `cart1_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cart1_seq`
--

INSERT INTO `cart1_seq` (`next_val`) VALUES
(1651);

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`id`, `email`, `message`, `name`) VALUES
(252, 'shukuryerole661@gmail.com', 'Hii', 'Shukur');

-- --------------------------------------------------------

--
-- Table structure for table `contact_seq`
--

CREATE TABLE `contact_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contact_seq`
--

INSERT INTO `contact_seq` (`next_val`) VALUES
(351);

-- --------------------------------------------------------

--
-- Table structure for table `hmproduct_info`
--

CREATE TABLE `hmproduct_info` (
  `id` int(11) NOT NULL,
  `artisan_name` varchar(60) DEFAULT NULL,
  `avil` bit(1) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `discount_price` double NOT NULL,
  `gi_tag_number` varchar(30) DEFAULT NULL,
  `giproduct` bit(1) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `is_eco_friendly` bit(1) NOT NULL,
  `is_handmade` bit(1) NOT NULL,
  `material` varchar(255) DEFAULT NULL,
  `origin_district` varchar(50) DEFAULT NULL,
  `origin_state` varchar(50) DEFAULT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `sku` varchar(20) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `updated_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hmproduct_info`
--

INSERT INTO `hmproduct_info` (`id`, `artisan_name`, `avil`, `category`, `color`, `created_at`, `description`, `discount_price`, `gi_tag_number`, `giproduct`, `image_url`, `is_eco_friendly`, `is_handmade`, `material`, `origin_district`, `origin_state`, `price`, `quantity`, `sku`, `title`, `updated_at`) VALUES
(252, 'Ramesh Leather Works', b'1', 'fashion', 'Brown', NULL, 'Authentic handmade Kolhapuri leather chappals', 949, 'GI-001', b'1', 'https://images.unsplash.com/photo-1765961999112-7aea89449b62?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8S29saGFwdXJpJTIwQ2hhcHBhbHxlbnwwfHwwfHx8MA%3D%3D', b'0', b'0', 'Leather', 'Kolhapur', 'maharashtra ', 1200, 48, 'FASH001', 'Kolhapuri Chappal', NULL),
(302, 'Jaipur Crafts', b'1', 'gifts', 'Wooden', NULL, 'Eco-friendly wooden gift box', 648, 'GI-0012', b'1', 'https://plus.unsplash.com/premium_photo-1723672913604-26ab001f72a8?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8SGFuZG1hZGUlMjBXb29kZW4lMjBHaWZ0JTIwQm94fGVufDB8fDB8fHww', b'0', b'0', 'Wood', 'Jaipur', 'Rajasthan', 800, 32, 'GIFT001', 'Handmade Wooden Gift Box', NULL),
(352, 'Ramesh ', b'1', 'Home Decor', 'Brown', NULL, 'Eco-friendly handmade bamboo basket', 400, '1234', b'1', 'https://images.unsplash.com/photo-1675081632939-5294f776dd75?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fEhhbmRtYWRlJTIwQmFtYm9vJTIwQmFza2V0fGVufDB8fDB8fHww', b'0', b'0', 'Bamboo', 'pune', 'maharashtra ', 500, 10, 'BB001', 'Handmade Bamboo Basket', NULL),
(353, 'Suresh', b'1', 'Kitchen', 'Red', NULL, 'Traditional clay pot', 248, '7890', b'1', 'https://images.unsplash.com/photo-1611013621183-cde811b6ddb4?q=80&w=892&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', b'0', b'0', 'Clay', 'Jaipur', 'Rajasthan', 300, 20, 'CP002', 'Handmade Clay Pot', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hmproduct_info_seq`
--

CREATE TABLE `hmproduct_info_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hmproduct_info_seq`
--

INSERT INTO `hmproduct_info_seq` (`next_val`) VALUES
(451);

-- --------------------------------------------------------

--
-- Table structure for table `hmuser_info`
--

CREATE TABLE `hmuser_info` (
  `id` int(11) NOT NULL,
  `otp` varchar(255) DEFAULT NULL,
  `otp_expiry` datetime(6) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('ROLE_ADMIN','ROLE_USER') NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `verified` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hmuser_info`
--

INSERT INTO `hmuser_info` (`id`, `otp`, `otp_expiry`, `password`, `role`, `username`, `verified`) VALUES
(1, NULL, '2026-03-14 09:46:15.000000', '$2a$10$lkDuMZaEufXg3tNdbwmpYeBGLbAf0Vo5EbQSfVEQLof7IXTXapBi2', 'ROLE_USER', 'shahid@gmail.com', b'1'),
(2, NULL, '2026-03-14 22:08:53.000000', '$2a$10$x2MUUezFZ5cPWqqOeIUQx.xG.IRAcEyCnEKThq3JjmifGSpujUrdy', 'ROLE_USER', 'shukur@gmail.com', b'1'),
(52, NULL, '2026-03-18 00:31:48.000000', '$2a$10$fXwWdAO7oywFDA3Ff1tPX.K9VGTdEI/dfWNaG3lwejTpcSeE.CHMm', 'ROLE_USER', 'mosin@gmail.com', b'1'),
(102, NULL, '2026-03-19 01:28:15.000000', '$2a$10$AP4yOUTd04CDcIPgXnm6beS1Aqr3HjenHiXKnR2BcNeiiQm3vz.I2', 'ROLE_ADMIN', 'aanu@gmail.com', b'1'),
(152, NULL, '2026-03-24 18:41:31.000000', '$2a$10$sDCwgSfbH5H0wy185cYaae0DRLeyxMS6dRPxkusFROv.WkFo6Jgwe', 'ROLE_USER', 'user@gmail.com', b'1'),
(153, NULL, '2026-03-24 18:44:17.000000', '$2a$10$0ReXltwiREL8VXbknar2jesklpPDoTM4Iru6Rb92xZmGC1YhvJc7u', 'ROLE_ADMIN', 'admin@gmail.com', b'1'),
(202, '314886', '2026-03-28 08:22:20.000000', '$2a$10$DlWDoBFjenDeya2EYYXReeaJibshUXf/aIYaE7cDfsOGpYZqFaQUK', 'ROLE_USER', '123', b'0'),
(203, NULL, '2026-03-28 08:23:35.000000', '$2a$10$V/8DoExwHMmrePzhxsTw4uNadEAYf3yVQfPBD3FlrlumIgll/B0MO', 'ROLE_USER', 'myuser@gmail.com', b'1'),
(252, '465538', '2026-05-04 05:15:57.000000', '$2a$10$j1Ip2mJAj4q2Vm0DlzkVGuxzh4SdGu2vmzz67Q9THqj83pwyA5X/i', 'ROLE_USER', 'newuser@gmail.com', b'0'),
(253, NULL, '2026-05-04 05:20:49.000000', '$2a$10$itZRm37T3fLXnxaJYEe7ceJw57NSNiKWQP3QxEJF3ZTcz4pYD.wsu', 'ROLE_USER', 'oneuser@gmail.com', b'1'),
(254, '179966', '2026-05-04 05:30:48.000000', '$2a$10$GUHGpwVLqgEaHjXdkA8yXeA/HH8X3X8ZJkNPzdHiPlbV5gc34eDV.', 'ROLE_USER', 'newone@gmail.com', b'0'),
(302, '675883', '2026-05-04 05:35:28.000000', '$2a$10$gz1EQDsHZX.e6YrheBCkNuMLv7zI3uxXtCNcln087MdDkQYoi6WoO', 'ROLE_USER', 'suriyansh@gmail.com', b'0'),
(303, NULL, '2026-05-04 05:37:46.000000', '$2a$10$zMa.FJTfXkFHTX1bheBKjOV9l3Hx1Ee9Sxt8ZG9pVZpaAjXuQl6BG', 'ROLE_USER', 'abcd@gmail.com', b'1'),
(304, NULL, '2026-05-04 05:41:18.000000', '$2a$10$/9aM8G0xlwEdN6lhte16F.nyxhQLWFQ9Lp0FEg7d9CbWE9zbuFh7G', 'ROLE_USER', 'myone@gmail.com', b'1'),
(305, '762365', '2026-05-04 06:19:49.000000', '$2a$10$j08HRxww8OIzmft9rnqo/eJdst.y2IX94kxa67TbOQPVy2z1vzW5W', 'ROLE_USER', 'Myabcd@gmail.com', b'0'),
(306, '560414', '2026-05-04 06:06:11.000000', '$2a$10$dSJWHJy/aP40nUrSXSf.C.CSDLiJyaDq24Z8VcKqTSR/AQUnTyCoC', 'ROLE_USER', 'sasasa@gmail.com', b'0'),
(307, NULL, '2026-05-04 06:07:59.000000', '$2a$10$fBFxM2XEF8KhmmZjLRh4ieeTgflD/mvcZDnj1tG/UluZ6adWXfipq', 'ROLE_USER', 'anpls@gmail.com', b'1'),
(352, NULL, '2026-09-09 09:50:50.000000', '$2a$10$h1xWFMENue201tTYXo8WweVc1QUQujzMyrP81nqHurhvSwfjQ72zm', 'ROLE_USER', 'ashu@gmail.com', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `hmuser_info_seq`
--

CREATE TABLE `hmuser_info_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hmuser_info_seq`
--

INSERT INTO `hmuser_info_seq` (`next_val`) VALUES
(451);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `order_date` datetime(6) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `shipping_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `order_date`, `total`, `user_id`, `shipping_id`) VALUES
(1, '2026-03-24 15:11:33.000000', 2400, 52, NULL),
(2, '2026-03-24 15:44:25.000000', 2400, 52, NULL),
(52, '2026-03-24 18:51:39.000000', 3600, 152, NULL),
(102, '2026-03-25 12:38:55.000000', 1200, 152, NULL),
(152, '2026-03-25 20:03:36.000000', 1200, 152, NULL),
(202, '2026-03-26 11:35:58.000000', 1200, 152, NULL),
(252, '2026-03-26 13:10:16.000000', 1200, 152, NULL),
(302, '2026-03-26 19:03:29.000000', 800, 152, NULL),
(303, '2026-03-26 19:07:10.000000', 600, 152, NULL),
(352, '2026-03-27 04:48:52.000000', 1200, 152, NULL),
(402, '2026-03-27 10:00:48.000000', 1200, 152, NULL),
(452, '2026-03-27 14:05:05.000000', 2400, 152, NULL),
(502, '2026-03-27 18:16:05.000000', 600, 152, NULL),
(552, '2026-03-27 18:35:43.000000', 100000, 152, NULL),
(553, '2026-03-27 18:44:41.000000', 100000, 152, NULL),
(554, '2026-03-27 18:46:10.000000', 100000, 152, NULL),
(555, '2026-03-27 18:47:37.000000', 100000, 152, NULL),
(556, '2026-03-27 18:51:19.000000', 100000, 152, NULL),
(602, '2026-04-22 09:48:43.000000', 100000, 203, NULL),
(652, '2026-05-01 07:12:00.000000', 100000, 203, NULL),
(702, '2026-05-01 19:18:58.000000', 100000, 203, NULL),
(703, '2026-05-01 19:25:35.000000', 100000, 152, NULL),
(752, '2026-05-04 05:18:17.000000', 100000, 253, NULL),
(802, '2026-05-04 05:38:46.000000', 100000, 304, NULL),
(803, '2026-05-04 06:05:13.000000', 100000, 307, NULL),
(852, '2026-07-20 08:25:49.000000', 100000, 307, NULL),
(853, '2026-07-20 08:27:27.000000', 100000, 307, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `orders_seq`
--

CREATE TABLE `orders_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders_seq`
--

INSERT INTO `orders_seq` (`next_val`) VALUES
(951);

-- --------------------------------------------------------

--
-- Table structure for table `shipping`
--

CREATE TABLE `shipping` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `pincode` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `shipping`
--

INSERT INTO `shipping` (`id`, `address`, `city`, `full_name`, `mobile`, `pincode`, `state`) VALUES
(1, 'At  Post AURAD SHAHAJANI ', 'Pune', 'Shukur Yerole', '9156707709', '413522', 'MAHARASHTRA'),
(2, 'At  Post AURAD SHAHAJANI ', 'Pune', 'Shukur Yerole', '9156707709', '413522', 'MAHARASHTRA'),
(3, 'At  Post AURAD SHAHAJANI ', 'Pune', 'Shukur Yerole', '9156707709', '413522', 'MAHARASHTRA'),
(4, 'At  Post AURAD SHAHAJANI ', 'Pune', 'Shukur Yerole', '9156707709', '413522', 'MAHARASHTRA'),
(5, 'At  Post AURAD SHAHAJANI ', 'Pune', 'Shukur Yerole', '9156707709', '413522', 'MAHARASHTRA'),
(52, 'At  Post AURAD SHAHAJANI ', 'Pune', 'Shukur Yerole', '9156707709', '413522', 'MAHARASHTRA'),
(102, 'At  Post AURAD SHAHAJANI ', 'Pune', 'Shukur Yerole', '9156707709', '413522', 'MAHARASHTRA'),
(152, 'At  Post AURAD SHAHAJANI ', 'Pune', 'Shukur Yerole', '9156707709', '413522', 'MAHARASHTRA'),
(153, 'At  Post AURAD SHAHAJANI ', 'Pune', 'Shukur Yerole', '9156707709', '413522', 'MAHARASHTRA'),
(202, 'At  Post AURAD SHAHAJANI ', 'Pune', 'Shukur Yerole', '9156707709', '413522', 'MAHARASHTRA'),
(252, 'At  Post AURAD SHAHAJANI ', 'Pune', 'Shukur Yerole', '9156707709', '413522', 'MAHARASHTRA'),
(253, 'At  Post AURAD SHAHAJANI ', 'Pune', 'Shukur Yerole', '9156707709', '413522', 'MAHARASHTRA'),
(302, 'At  Post AURAD SHAHAJANI ', 'Pune', 'Shukur Yerole', '9156707709', '123456', 'MAHARASHTRA'),
(303, 'At  Post AURAD SHAHAJANI ', 'Pune', 'Shukur Yerole', '9156707709', '1234', 'MAHARASHTRA'),
(352, 'At  Post AURAD SHAHAJANI ', 'Pune', 'Shukur Yerole', '9156707709', '413522', 'MAHARASHTRA');

-- --------------------------------------------------------

--
-- Table structure for table `shipping_seq`
--

CREATE TABLE `shipping_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `shipping_seq`
--

INSERT INTO `shipping_seq` (`next_val`) VALUES
(451);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart1`
--
ALTER TABLE `cart1`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKice7vhi3eyk4yem47sov447tu` (`hmproduct_id`),
  ADD KEY `FK4j1m25kp14p0kot55javbbipo` (`hmuser_id`);

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hmproduct_info`
--
ALTER TABLE `hmproduct_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hmuser_info`
--
ALTER TABLE `hmuser_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_g6qdabs0ppy3lg8o8c1wd7wxx` (`shipping_id`),
  ADD KEY `FKrvuwetl7n4rl2cktf39pfvjw9` (`user_id`);

--
-- Indexes for table `shipping`
--
ALTER TABLE `shipping`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart1`
--
ALTER TABLE `cart1`
  ADD CONSTRAINT `FK4j1m25kp14p0kot55javbbipo` FOREIGN KEY (`hmuser_id`) REFERENCES `hmuser_info` (`id`),
  ADD CONSTRAINT `FKice7vhi3eyk4yem47sov447tu` FOREIGN KEY (`hmproduct_id`) REFERENCES `hmproduct_info` (`id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FKrvuwetl7n4rl2cktf39pfvjw9` FOREIGN KEY (`user_id`) REFERENCES `hmuser_info` (`id`),
  ADD CONSTRAINT `FKsemahq4easllj6if07wtarony` FOREIGN KEY (`shipping_id`) REFERENCES `shipping` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
