-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-10-2015 a las 16:00:52
-- Versión del servidor: 5.6.20
-- Versión de PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `safetaxi`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `taxis`
--

CREATE TABLE IF NOT EXISTS `taxis` (
`taxi_id` int(11) NOT NULL,
  `placa_id` int(11) NOT NULL,
  `modelo` text NOT NULL,
  `marca` text NOT NULL,
  `rating_avg` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `taxis`
--

INSERT INTO `taxis` (`taxi_id`, `placa_id`, `modelo`, `marca`, `rating_avg`) VALUES
(1, 111615333, 'Renault', 'Clio', 4),
(2, 111615332, 'spark', 'chevrolet', 1),
(3, 111615331, 'impreza', 'subaru', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `taxis`
--
ALTER TABLE `taxis`
 ADD PRIMARY KEY (`taxi_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `taxis`
--
ALTER TABLE `taxis`
MODIFY `taxi_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
