-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 02, 2023 at 07:43 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `empsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `id` int(100) NOT NULL,
  `employeeId` varchar(100) NOT NULL,
  `activity` varchar(50) NOT NULL,
  `attDate` date NOT NULL DEFAULT current_timestamp(),
  `attTime` time NOT NULL DEFAULT current_timestamp(),
  `salaryPerDay` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`id`, `employeeId`, `activity`, `attDate`, `attTime`, `salaryPerDay`) VALUES
(13, '111', 'Clocked In.....', '2023-01-31', '13:23:57', 0),
(15, '555', 'Clocked In.....', '2023-01-31', '15:13:52', 0),
(16, '111', 'Clocked Out.....', '2023-01-31', '15:17:11', 15),
(17, '111', 'Clocked In.....', '2023-02-02', '16:09:25', 0),
(20, '111', 'Clocked Out.....', '2023-02-02', '16:15:46', 0),
(21, '111', 'Clocked In.....', '2023-02-02', '16:16:29', 0);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `emp_id` varchar(20) NOT NULL,
  `f_name` varchar(50) NOT NULL,
  `l_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `position` varchar(50) NOT NULL,
  `contact_num` int(20) NOT NULL,
  `salary` int(20) NOT NULL,
  `totalSalary` int(100) NOT NULL,
  `evaluation` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `emp_id`, `f_name`, `l_name`, `email`, `position`, `contact_num`, `salary`, `totalSalary`, `evaluation`, `password`) VALUES
(14, '111', 'adam', 'levs', 'al@gmail.com', 'Accountant', 987654321, 15, 15, 'Completed', '111a'),
(15, '555', 'damon', 'lee', 'dl@gmail.com', 'Cashier', 13425678, 5, 0, 'Completed', '555d');

-- --------------------------------------------------------

--
-- Table structure for table `employee_rating`
--

CREATE TABLE `employee_rating` (
  `EvaluatedBy` varchar(20) NOT NULL,
  `First Name` varchar(30) NOT NULL,
  `Teamwork` int(1) NOT NULL,
  `Leadership` int(1) NOT NULL,
  `Communication` int(1) NOT NULL,
  `Productivity` int(1) NOT NULL,
  `Integrity` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee_rating`
--

INSERT INTO `employee_rating` (`EvaluatedBy`, `First Name`, `Teamwork`, `Leadership`, `Communication`, `Productivity`, `Integrity`) VALUES
('adam', 'damon', 4, 5, 4, 5, 4);

-- --------------------------------------------------------

--
-- Table structure for table `holiday`
--

CREATE TABLE `holiday` (
  `id` int(100) NOT NULL,
  `employeeId` varchar(100) NOT NULL,
  `leaveType` varchar(100) NOT NULL,
  `reasonOrProof` varchar(500) NOT NULL,
  `numberOfDays` int(50) NOT NULL,
  `timeStamp` timestamp NOT NULL DEFAULT current_timestamp(),
  `applicationStatus` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `holiday`
--

INSERT INTO `holiday` (`id`, `employeeId`, `leaveType`, `reasonOrProof`, `numberOfDays`, `timeStamp`, `applicationStatus`) VALUES
(23, '111', 'Paid Leave', 'gwththwrtjyrhg', 6, '2023-01-31 05:18:59', 'Approved'),
(24, '111', 'Unpaid Leave', 'httehrthfghrthrt', 1, '2023-01-31 05:19:06', 'In Review'),
(25, '111', 'Sick Leave', 'gghtrhrtgregegrge', 1, '2023-01-31 05:19:14', 'Approved'),
(26, '555', 'Paid Leave', 'ghethetjey', 2, '2023-01-31 07:14:20', 'In Review'),
(27, '555', 'Unpaid Leave', 'fefgdfhdth', 3, '2023-01-31 07:14:27', 'Rejected'),
(28, '555', 'Sick Leave', 'fsggrhtrh', 2, '2023-01-31 07:14:32', 'In Review'),
(29, '111', 'Paid Leave', 'I am planning a vacation.', 5, '2023-02-02 09:24:41', 'In Review');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `username`, `password`) VALUES
(1, 'man', 'man');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `holiday`
--
ALTER TABLE `holiday`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `holiday`
--
ALTER TABLE `holiday`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
