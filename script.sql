CREATE TABLE `proy_progra4`.`estudiante` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `apellidos` VARCHAR(100) NOT NULL,
  `identificacion` VARCHAR(50) NOT NULL,
  `contraseña` VARCHAR(100) NOT NULL,
  `tiene_grupo` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `proy_progra4`.`grupo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC));

CREATE TABLE `proy_progra4`.`integrantes_de_grupo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_estudiante` INT NOT NULL,
  `id_grupo` INT NOT NULL,
  PRIMARY KEY (`id`));
