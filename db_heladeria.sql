-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-11-2017 a las 02:08:02
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_heladeria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_cliente`
--

CREATE TABLE `tb_cliente` (
  `id_cliente` varchar(10) NOT NULL,
  `cedula` int(8) NOT NULL,
  `nombre` text NOT NULL,
  `apellido` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_preguntas`
--

CREATE TABLE `tb_preguntas` (
  `id_preg` int(11) NOT NULL,
  `pregunta` varchar(140) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tb_preguntas`
--

INSERT INTO `tb_preguntas` (`id_preg`, `pregunta`) VALUES
(1, '¿lugar de nacimiento?'),
(2, '¿super heroe de su infancia?'),
(3, '¿segundo apellido de su abuelo materno?'),
(4, '¿nombre de su perro?');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_respuestas`
--

CREATE TABLE `tb_respuestas` (
  `id_resp` int(10) NOT NULL,
  `respuestas` varchar(50) NOT NULL,
  `id_preg` int(10) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `tb_respuestas`
--

INSERT INTO `tb_respuestas` (`id_resp`, `respuestas`, `id_preg`, `id_user`) VALUES
(1, 'la victoria', 1, 1),
(2, 'superman', 2, 1),
(3, 'torres', 3, 1),
(4, 'gabriel', 4, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_user`
--

CREATE TABLE `tb_user` (
  `id_user` int(11) NOT NULL,
  `usuario` varchar(30) NOT NULL,
  `contraseña` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tb_user`
--

INSERT INTO `tb_user` (`id_user`, `usuario`, `contraseña`) VALUES
(1, 'administrador', '26588002'),
(2, 'gledymar', '12345678');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_preguntas`
--
ALTER TABLE `tb_preguntas`
  ADD PRIMARY KEY (`id_preg`);

--
-- Indices de la tabla `tb_respuestas`
--
ALTER TABLE `tb_respuestas`
  ADD PRIMARY KEY (`id_resp`),
  ADD KEY `id_preg` (`id_preg`),
  ADD KEY `id_user` (`id_user`);

--
-- Indices de la tabla `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_preguntas`
--
ALTER TABLE `tb_preguntas`
  MODIFY `id_preg` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tb_respuestas`
--
ALTER TABLE `tb_respuestas`
  ADD CONSTRAINT `tb_respuestas_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `tb_user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_respuestas_ibfk_2` FOREIGN KEY (`id_preg`) REFERENCES `tb_preguntas` (`id_preg`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
