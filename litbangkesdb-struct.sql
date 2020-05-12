-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 12, 2020 at 10:43 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `litbangkesdb-struct`
--

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `id_item` int(11) NOT NULL,
  `item_code` varchar(64) DEFAULT NULL,
  `item_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `item_brand` varchar(48) DEFAULT NULL,
  `item_kemasan` varchar(24) DEFAULT NULL,
  `item_pieces_kemasan` int(11) DEFAULT NULL,
  `item_metrics_pieces` varchar(24) DEFAULT NULL,
  `id_category` int(11) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `shown` int(11) NOT NULL DEFAULT 1,
  `created_by` int(11) NOT NULL DEFAULT 1,
  `id_brand` int(11) DEFAULT NULL,
  `id_sub_cat` int(11) DEFAULT NULL,
  `id_distributor` int(11) DEFAULT NULL,
  `id_metrics` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item_brand`
--

CREATE TABLE `item_brand` (
  `id_brand` int(11) NOT NULL,
  `code_brand` varchar(3) NOT NULL,
  `nama_brand` varchar(64) NOT NULL,
  `shown` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item_category`
--

CREATE TABLE `item_category` (
  `id_category` int(11) NOT NULL,
  `nama_category` varchar(64) NOT NULL,
  `code_category` varchar(2) NOT NULL,
  `shown` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item_distributor`
--

CREATE TABLE `item_distributor` (
  `id_distributor` int(11) NOT NULL,
  `nama_distributor` varchar(64) NOT NULL,
  `kode_distributor` varchar(8) NOT NULL,
  `shown` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item_metrics`
--

CREATE TABLE `item_metrics` (
  `id_metrics` int(11) NOT NULL,
  `id_sub_cat` int(11) NOT NULL,
  `code_sub_cat` varchar(3) NOT NULL,
  `metric_name` varchar(16) NOT NULL,
  `metric_size` float NOT NULL,
  `metric_code` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item_source`
--

CREATE TABLE `item_source` (
  `id` int(11) NOT NULL,
  `source_name` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item_sub_cat`
--

CREATE TABLE `item_sub_cat` (
  `id_sub_cat` int(11) NOT NULL,
  `id_cat` int(11) NOT NULL,
  `nama_sub_cat` varchar(64) NOT NULL,
  `code_sub_cat` varchar(5) NOT NULL,
  `shown` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `labs`
--

CREATE TABLE `labs` (
  `id_lab` int(11) NOT NULL,
  `code_lab` varchar(12) NOT NULL,
  `password` varchar(32) DEFAULT NULL,
  `nama_lab` varchar(128) NOT NULL,
  `alamat_lab` varchar(256) DEFAULT NULL,
  `pic_lab` varchar(128) DEFAULT NULL,
  `mail_lab` varchar(100) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` int(11) DEFAULT NULL,
  `shown` int(11) NOT NULL DEFAULT 1,
  `contact_lab` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `lab_pcr`
--

CREATE TABLE `lab_pcr` (
  `id_pcr` int(11) NOT NULL,
  `id_lab` int(11) NOT NULL,
  `brand` varchar(64) NOT NULL,
  `capacity` int(11) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE `registration` (
  `id` int(11) NOT NULL,
  `fullname` varchar(128) NOT NULL,
  `mail` varchar(128) NOT NULL,
  `password` varchar(32) NOT NULL,
  `id_lab` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stock_details`
--

CREATE TABLE `stock_details` (
  `id_transaction` int(11) NOT NULL,
  `id_sto` int(11) NOT NULL,
  `id_sto_ref` int(11) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  `amount` int(11) NOT NULL,
  `id_item` int(11) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `shown` int(11) NOT NULL DEFAULT 1,
  `created_by` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stock_order`
--

CREATE TABLE `stock_order` (
  `id_sto` int(11) NOT NULL,
  `transaction_type` int(11) NOT NULL,
  `sto_send_time` datetime NOT NULL,
  `sto_arrive_time` datetime NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `shown` int(11) NOT NULL DEFAULT 1,
  `delete_reason` varchar(64) DEFAULT NULL,
  `sto_source` int(11) NOT NULL,
  `sto_source_desc` varchar(64) DEFAULT NULL,
  `id_batch` varchar(32) DEFAULT NULL,
  `receipt` varchar(128) DEFAULT NULL,
  `source_point` int(11) DEFAULT NULL,
  `end_point` int(11) DEFAULT NULL,
  `description` varchar(256) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  `id_ref` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stock_source`
--

CREATE TABLE `stock_source` (
  `id` int(11) NOT NULL,
  `sumber` varchar(32) NOT NULL,
  `sub_sumber` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaction_type`
--

CREATE TABLE `transaction_type` (
  `id_type` int(11) NOT NULL,
  `tx_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `transaction_types`
--

CREATE TABLE `transaction_types` (
  `id_type` int(11) NOT NULL,
  `tx_name` varchar(28) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) UNSIGNED NOT NULL,
  `mail` varchar(50) NOT NULL,
  `fullname` varchar(150) NOT NULL,
  `password` varchar(64) NOT NULL,
  `user_type` int(11) NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `last_ip` varchar(20) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `mail`, `fullname`, `password`, `user_type`, `last_login`, `last_ip`, `status`, `created_at`, `updated_at`) VALUES
(7, 'admin@mail.com', 'Administrator', '$2a$10$yv4e8OvslgZmXXpqtUppyOmVSNh0FwVyBlyDQ.ukw/G6Jb2p8SXM2', 1, '2020-05-10 12:33:04', '0:0:0:0:0:0:0:1', 1, '2020-05-10 12:34:28', '2020-05-12 12:36:31'),
(8, 'andi@mail.com', 'Andi', '$2a$10$F/kMncDLu0ZdCYTAu4xGiO.G/eizeJGYq5hK/hOn5D1ueMqeRetwS', 2, '2020-05-12 12:54:01', '0:0:0:0:0:0:0:1', 1, '2020-05-12 12:54:01', '2020-05-12 12:54:14');

-- --------------------------------------------------------

--
-- Table structure for table `user_type`
--

CREATE TABLE `user_type` (
  `id` int(11) NOT NULL,
  `type_name` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_type`
--

INSERT INTO `user_type` (`id`, `type_name`) VALUES
(1, 'ADMIN'),
(4, 'BNPB'),
(2, 'KEMENKES'),
(3, 'LAB');

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_distro`
-- (See below for the actual view)
--
CREATE TABLE `view_distro` (
`id_sto` int(11)
,`sumber` varchar(32)
,`sub_sumber` varchar(32)
,`sto_send_time` datetime
,`sto_arrive_time` datetime
,`nama_lab` varchar(128)
,`id_item` int(11)
,`id_batch` int(11)
,`amount` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_items_batch`
-- (See below for the actual view)
--
CREATE TABLE `v_items_batch` (
`id_transaction` int(11)
,`id_sto` int(11)
,`id_item` int(11)
,`item_name` varchar(255)
,`jumlah` decimal(32,0)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_items_batch_usage`
-- (See below for the actual view)
--
CREATE TABLE `v_items_batch_usage` (
`id_sto` int(11)
,`id_item` int(11)
,`item_name` varchar(255)
,`totaldist` decimal(32,0)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_items_brandcat`
-- (See below for the actual view)
--
CREATE TABLE `v_items_brandcat` (
`id_item` int(11)
,`item_code` varchar(64)
,`item_name` varchar(255)
,`item_brand` varchar(48)
,`item_kemasan` varchar(24)
,`item_pieces_kemasan` int(11)
,`item_metrics_pieces` varchar(24)
,`id_category` int(11)
,`created_at` datetime
,`updated_at` datetime
,`shown` int(11)
,`created_by` int(11)
,`id_brand` int(11)
,`id_sub_cat` int(11)
,`id_distributor` int(11)
,`id_metrics` int(11)
,`nama_brand` varchar(64)
,`nama_category` varchar(64)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_items_stock`
-- (See below for the actual view)
--
CREATE TABLE `v_items_stock` (
`id_item` int(11)
,`item_name` varchar(255)
,`jumlah` decimal(32,0)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_items_stock_usage`
-- (See below for the actual view)
--
CREATE TABLE `v_items_stock_usage` (
`id_item` int(11)
,`item_name` varchar(255)
,`dist` decimal(32,0)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_users_registered`
-- (See below for the actual view)
--
CREATE TABLE `v_users_registered` (
`id` int(11) unsigned
,`fullname` varchar(150)
,`mail` varchar(50)
,`password` varchar(64)
,`type_name` varchar(16)
,`last_login` datetime
,`last_ip` varchar(20)
,`status` int(11)
,`created_at` datetime
,`updated_at` datetime
);

-- --------------------------------------------------------

--
-- Structure for view `view_distro`
--
DROP TABLE IF EXISTS `view_distro`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_distro`  AS  select `stock_order`.`id_sto` AS `id_sto`,`stock_source`.`sumber` AS `sumber`,`stock_source`.`sumber` AS `sub_sumber`,`stock_order`.`sto_send_time` AS `sto_send_time`,`stock_order`.`sto_arrive_time` AS `sto_arrive_time`,`labs`.`nama_lab` AS `nama_lab`,`stock_details`.`id_item` AS `id_item`,`stock_details`.`id_sto` AS `id_batch`,`stock_details`.`amount` AS `amount` from (((`stock_order` join `labs` on(`labs`.`id_lab` = `stock_order`.`end_point`)) join `stock_details` on(`stock_details`.`id_sto_ref` = `stock_order`.`id_sto`)) join `stock_source` on(`stock_order`.`sto_source` = `stock_source`.`id`)) where `stock_order`.`transaction_type` = 2 and `stock_order`.`shown` = 1 and `stock_details`.`shown` = 1 ;

-- --------------------------------------------------------

--
-- Structure for view `v_items_batch`
--
DROP TABLE IF EXISTS `v_items_batch`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_items_batch`  AS  select `stock_details`.`id_transaction` AS `id_transaction`,`stock_details`.`id_sto` AS `id_sto`,`items`.`id_item` AS `id_item`,`items`.`item_name` AS `item_name`,sum(`stock_details`.`amount`) AS `jumlah` from (`stock_details` join `items` on(`items`.`id_item` = `stock_details`.`id_item`)) where `stock_details`.`id_sto_ref` is null group by `stock_details`.`id_sto`,`items`.`id_item` ;

-- --------------------------------------------------------

--
-- Structure for view `v_items_batch_usage`
--
DROP TABLE IF EXISTS `v_items_batch_usage`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_items_batch_usage`  AS  select `stock_details`.`id_sto` AS `id_sto`,`items`.`id_item` AS `id_item`,`items`.`item_name` AS `item_name`,sum(`stock_details`.`amount`) AS `totaldist` from (`stock_details` join `items` on(`items`.`id_item` = `stock_details`.`id_item`)) where `stock_details`.`id_sto_ref` > 0 group by `stock_details`.`id_sto`,`items`.`id_item` ;

-- --------------------------------------------------------

--
-- Structure for view `v_items_brandcat`
--
DROP TABLE IF EXISTS `v_items_brandcat`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_items_brandcat`  AS  select `items`.`id_item` AS `id_item`,`items`.`item_code` AS `item_code`,`items`.`item_name` AS `item_name`,`items`.`item_brand` AS `item_brand`,`items`.`item_kemasan` AS `item_kemasan`,`items`.`item_pieces_kemasan` AS `item_pieces_kemasan`,`items`.`item_metrics_pieces` AS `item_metrics_pieces`,`items`.`id_category` AS `id_category`,`items`.`created_at` AS `created_at`,`items`.`updated_at` AS `updated_at`,`items`.`shown` AS `shown`,`items`.`created_by` AS `created_by`,`items`.`id_brand` AS `id_brand`,`items`.`id_sub_cat` AS `id_sub_cat`,`items`.`id_distributor` AS `id_distributor`,`items`.`id_metrics` AS `id_metrics`,`item_brand`.`nama_brand` AS `nama_brand`,`item_category`.`nama_category` AS `nama_category` from ((`items` join `item_brand` on(`item_brand`.`id_brand` = `items`.`id_brand`)) join `item_category` on(`items`.`id_category` = `item_category`.`id_category`)) where `items`.`shown` = 1 ;

-- --------------------------------------------------------

--
-- Structure for view `v_items_stock`
--
DROP TABLE IF EXISTS `v_items_stock`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_items_stock`  AS  select `stock_details`.`id_item` AS `id_item`,`items`.`item_name` AS `item_name`,sum(`stock_details`.`amount`) AS `jumlah` from (`stock_details` join `items` on(`items`.`id_item` = `stock_details`.`id_item`)) where `stock_details`.`id_sto_ref` is null and `stock_details`.`shown` = 1 group by `stock_details`.`id_item` ;

-- --------------------------------------------------------

--
-- Structure for view `v_items_stock_usage`
--
DROP TABLE IF EXISTS `v_items_stock_usage`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_items_stock_usage`  AS  select `stock_details`.`id_item` AS `id_item`,`items`.`item_name` AS `item_name`,sum(`stock_details`.`amount`) AS `dist` from (`stock_details` join `items` on(`items`.`id_item` = `stock_details`.`id_item`)) where `stock_details`.`id_sto_ref` > 0 and `stock_details`.`shown` = 1 group by `stock_details`.`id_item` ;

-- --------------------------------------------------------

--
-- Structure for view `v_users_registered`
--
DROP TABLE IF EXISTS `v_users_registered`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_users_registered`  AS  select `u`.`id` AS `id`,`u`.`fullname` AS `fullname`,`u`.`mail` AS `mail`,`u`.`password` AS `password`,`ut`.`type_name` AS `type_name`,`u`.`last_login` AS `last_login`,`u`.`last_ip` AS `last_ip`,`u`.`status` AS `status`,`u`.`created_at` AS `created_at`,`u`.`updated_at` AS `updated_at` from (`user` `u` join `user_type` `ut` on(`u`.`user_type` = `ut`.`id`)) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id_item`);

--
-- Indexes for table `item_brand`
--
ALTER TABLE `item_brand`
  ADD PRIMARY KEY (`id_brand`);

--
-- Indexes for table `item_category`
--
ALTER TABLE `item_category`
  ADD PRIMARY KEY (`id_category`);

--
-- Indexes for table `item_distributor`
--
ALTER TABLE `item_distributor`
  ADD PRIMARY KEY (`id_distributor`);

--
-- Indexes for table `item_metrics`
--
ALTER TABLE `item_metrics`
  ADD PRIMARY KEY (`id_metrics`),
  ADD UNIQUE KEY `code_sub_cat` (`code_sub_cat`,`metric_code`);

--
-- Indexes for table `item_source`
--
ALTER TABLE `item_source`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item_sub_cat`
--
ALTER TABLE `item_sub_cat`
  ADD PRIMARY KEY (`id_sub_cat`),
  ADD UNIQUE KEY `id_cat` (`id_cat`,`code_sub_cat`);

--
-- Indexes for table `labs`
--
ALTER TABLE `labs`
  ADD PRIMARY KEY (`id_lab`);

--
-- Indexes for table `lab_pcr`
--
ALTER TABLE `lab_pcr`
  ADD PRIMARY KEY (`id_pcr`);

--
-- Indexes for table `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stock_details`
--
ALTER TABLE `stock_details`
  ADD PRIMARY KEY (`id_transaction`);

--
-- Indexes for table `stock_order`
--
ALTER TABLE `stock_order`
  ADD PRIMARY KEY (`id_sto`);

--
-- Indexes for table `stock_source`
--
ALTER TABLE `stock_source`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction_type`
--
ALTER TABLE `transaction_type`
  ADD PRIMARY KEY (`id_type`);

--
-- Indexes for table `transaction_types`
--
ALTER TABLE `transaction_types`
  ADD PRIMARY KEY (`id_type`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_type`
--
ALTER TABLE `user_type`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_drromwhnkfo2647mw0dmog7ob` (`type_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `id_item` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=154;

--
-- AUTO_INCREMENT for table `item_brand`
--
ALTER TABLE `item_brand`
  MODIFY `id_brand` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `item_category`
--
ALTER TABLE `item_category`
  MODIFY `id_category` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `item_distributor`
--
ALTER TABLE `item_distributor`
  MODIFY `id_distributor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `item_metrics`
--
ALTER TABLE `item_metrics`
  MODIFY `id_metrics` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=128;

--
-- AUTO_INCREMENT for table `item_source`
--
ALTER TABLE `item_source`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `item_sub_cat`
--
ALTER TABLE `item_sub_cat`
  MODIFY `id_sub_cat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=304;

--
-- AUTO_INCREMENT for table `labs`
--
ALTER TABLE `labs`
  MODIFY `id_lab` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

--
-- AUTO_INCREMENT for table `lab_pcr`
--
ALTER TABLE `lab_pcr`
  MODIFY `id_pcr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `registration`
--
ALTER TABLE `registration`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `stock_details`
--
ALTER TABLE `stock_details`
  MODIFY `id_transaction` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=268;

--
-- AUTO_INCREMENT for table `stock_order`
--
ALTER TABLE `stock_order`
  MODIFY `id_sto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=131;

--
-- AUTO_INCREMENT for table `stock_source`
--
ALTER TABLE `stock_source`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `transaction_type`
--
ALTER TABLE `transaction_type`
  MODIFY `id_type` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `transaction_types`
--
ALTER TABLE `transaction_types`
  MODIFY `id_type` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user_type`
--
ALTER TABLE `user_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
