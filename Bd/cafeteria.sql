-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-04-2022 a las 03:23:10
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cafeteria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `ID_PRODUC` int(20) NOT NULL,
  `NOMBRE_PRODUCTO` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `REFERENCIA` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `PRECIO` int(20) NOT NULL,
  `PESO` int(20) NOT NULL,
  `CATEGORIA` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `STOCK` int(11) NOT NULL,
  `FECHA_CREACION` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`ID_PRODUC`, `NOMBRE_PRODUCTO`, `REFERENCIA`, `PRECIO`, `PESO`, `CATEGORIA`, `STOCK`, `FECHA_CREACION`) VALUES
(10, 'PAN', '02', 5000, 10, 'carbohidrato', 25, '2022-04-01 00:00:00'),
(15, 'chocolate', '01', 2000, 50, 'liquidos', 45, '2022-03-04 00:00:00'),
(16, 'jugos naturales', '05', 10000, 50, 'liquidos', 13, '2022-03-04 00:00:00'),
(35, 'pan', '06', 5000, 10, 'solidos', 0, '2022-03-04 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta_producto`
--

CREATE TABLE `venta_producto` (
  `ID_VENTA` int(20) NOT NULL,
  `ID_PRODUC` int(11) NOT NULL,
  `CANTIDAD` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `venta_producto`
--

INSERT INTO `venta_producto` (`ID_VENTA`, `ID_PRODUC`, `CANTIDAD`) VALUES
(1, 15, 5),
(2, 35, 15),
(3, 16, 7);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`ID_PRODUC`);

--
-- Indices de la tabla `venta_producto`
--
ALTER TABLE `venta_producto`
  ADD PRIMARY KEY (`ID_VENTA`),
  ADD KEY `fk_id_producto` (`ID_PRODUC`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `ID_PRODUC` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT de la tabla `venta_producto`
--
ALTER TABLE `venta_producto`
  MODIFY `ID_VENTA` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `venta_producto`
--
ALTER TABLE `venta_producto`
  ADD CONSTRAINT `fk_id_producto` FOREIGN KEY (`ID_PRODUC`) REFERENCES `productos` (`ID_PRODUC`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
