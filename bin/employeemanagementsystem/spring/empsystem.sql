-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 30, 2023 at 08:45 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

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
(6, '123', 'Clocked In.....', '2023-01-30', '16:57:06', 0),
(10, '123', 'Clocked Out.....', '2023-01-30', '22:01:37', 85),
(11, '123', 'Clocked In.....', '2023-01-31', '03:40:17', 0),
(12, '123', 'Clocked Out.....', '2023-01-31', '03:40:27', 0);

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
(1, '1111', 'v', '', 'vj@gmail.com', 'Intern', 1234321, 13, 0, '', '1111v'),
(9, '1234', 'j', 's', 'r', 'r', 4, 4, 0, '', '1234j'),
(13, '123', 'viim', 'k', 'v', 'tester', 12345, 10, 0, 'Completed', '123v'),
(14, '111', 'adam', 'lev', 'al@gmail.com', 'Accountant', 987654321, 15, 0, '', '111a'),
(15, '555', 'damon', 'lee', 'dl@gmail.com', 'Cashier', 13425678, 5, 0, '', '555d');

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
('viim', 'v', 1, 1, 1, 1, 1),
('viim', 'j', 1, 1, 1, 1, 1),
('viim', 'adam', 1, 1, 1, 11, 1),
('viim', 'damon', 1, 1, 1, 1, 1);

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
(18, '123', 'Paid Leave', 'csdvsihvlsifahbpsib', 3, '2023-01-30 05:29:32', 'Approved'),
(19, '123', 'Sick Leave', 'djvcsalkdvslaihgadlsigh', 2, '2023-01-30 05:30:49', 'Rejected'),
(20, '123', 'Paid Leave', 'fgsehesth', 1, '2023-01-30 19:40:57', 'In Review'),
(21, '123', 'Unpaid Leave', 'grerthrtjhreth', 3, '2023-01-30 19:41:02', 'In Review'),
(22, '123', 'Sick Leave', 'gargaehetheathet', 5, '2023-01-30 19:41:13', 'In Review');

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
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `holiday`
--
ALTER TABLE `holiday`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
