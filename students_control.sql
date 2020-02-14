-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 14-02-2020 a las 15:57:02
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `students_control`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `id` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `ap_paterno` text NOT NULL,
  `ap_materno` text NOT NULL,
  `Puesto` text NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `password` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id`, `nombre`, `ap_paterno`, `ap_materno`, `Puesto`, `usuario`, `password`) VALUES
(1, 'Gustavo', 'Martinez', 'Licona', 'Administrador', 'licona', 'licona99');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `id` int(10) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidoP` text NOT NULL,
  `apellidoM` text NOT NULL,
  `Semestre` int(2) NOT NULL,
  `Carrera` text NOT NULL,
  `Grupo` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id`, `nombre`, `apellidoP`, `apellidoM`, `Semestre`, `Carrera`, `Grupo`) VALUES
(1, 'Gustavo', 'Licona', 'Martinez', 6, 'ingenieria en sistemas', 's1'),
(2, 'Diego', 'Santiago', 'Perez', 6, 'ingenieria en sistemas computcionales', 's1'),
(3, 'Gerardo', 'Del Angel', 'Facundo', 6, 'ingenieria en sistemas computacionales', 's1'),
(4, 'Hugo Dario', 'Cruz', 'Luna', 6, 'ingenieria en sistemas', 's1'),
(6, 'Ramon', 'Sanchez', 'Maza', 4, 'ingenieria en mecatronica', 'm2'),
(7, 'Fernado', 'morales', 'Del Angel', 6, 'ingenieria en sistemas computacionales', 's1');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
