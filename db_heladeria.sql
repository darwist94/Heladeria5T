-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-11-2017 a las 19:08:59
-- Versión del servidor: 5.6.26
-- Versión de PHP: 5.6.12

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

CREATE TABLE IF NOT EXISTS `tb_cliente` (
  `id_cliente` varchar(10) NOT NULL,
  `cedula` int(8) NOT NULL,
  `nombre` text NOT NULL,
  `apellido` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_preguntas`
--

CREATE TABLE IF NOT EXISTS `tb_preguntas` (
  `id_preg` int(11) NOT NULL,
  `pregunta` varchar(140) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

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

CREATE TABLE IF NOT EXISTS `tb_respuestas` (
  `id_resp` int(11) NOT NULL,
  `respuestas` varchar(50) NOT NULL,
  `id_preg` int(10) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `tb_respuestas`
--

INSERT INTO `tb_respuestas` (`id_resp`, `respuestas`, `id_preg`, `id_user`) VALUES
(1, 'la victoria', 1, 1),
(2, 'superman', 2, 1),
(3, 'torres', 3, 1),
(4, 'gabriel', 4, 1),
(14, 'barquisimeto', 1, 2),
(15, 'kaneki ken', 2, 2),
(16, 'suarez', 3, 2),
(17, 'porky', 4, 2),
(22, 'caracas', 1, 3),
(23, 'fenomenoide', 2, 3),
(24, 'nose', 3, 3),
(25, 'chente', 4, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_tipousuario`
--

CREATE TABLE IF NOT EXISTS `tb_tipousuario` (
  `niv_usu` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tb_tipousuario`
--

INSERT INTO `tb_tipousuario` (`niv_usu`, `tipo`) VALUES
(1, 'Administrador'),
(2, 'Supervisor'),
(3, 'Usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_user`
--

CREATE TABLE IF NOT EXISTS `tb_user` (
  `id_user` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL,
  `niv_usu` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tb_user`
--

INSERT INTO `tb_user` (`id_user`, `usuario`, `contraseña`, `niv_usu`) VALUES
(1, 'administrador', '26588002', 1),
(2, 'vickgle23', '22202973', 2),
(3, 'gabriel1', '123456', 3),
(4, '123213asd', '1234', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_usuarior`
--

CREATE TABLE IF NOT EXISTS `tb_usuarior` (
  `id_registroU` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `cedula` int(9) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tb_usuarior`
--

INSERT INTO `tb_usuarior` (`id_registroU`, `nombre`, `apellido`, `cedula`, `id_user`) VALUES
(1, 'Darwist', 'Garcia', 28588002, 1),
(2, 'Gledymar', 'Perozo', 22202973, 2),
(3, 'Gabriel', 'Arangu', 20473962, 3);

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
-- Indices de la tabla `tb_tipousuario`
--
ALTER TABLE `tb_tipousuario`
  ADD PRIMARY KEY (`niv_usu`);

--
-- Indices de la tabla `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indices de la tabla `tb_usuarior`
--
ALTER TABLE `tb_usuarior`
  ADD PRIMARY KEY (`id_registroU`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_preguntas`
--
ALTER TABLE `tb_preguntas`
  MODIFY `id_preg` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `tb_respuestas`
--
ALTER TABLE `tb_respuestas`
  MODIFY `id_resp` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=38;
--
-- AUTO_INCREMENT de la tabla `tb_tipousuario`
--
ALTER TABLE `tb_tipousuario`
  MODIFY `niv_usu` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `tb_usuarior`
--
ALTER TABLE `tb_usuarior`
  MODIFY `id_registroU` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
