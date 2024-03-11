-- MySQL Script generated by MySQL Workbench
-- Sun Mar 10 19:47:33 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bdprestamo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bdprestamo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdprestamo` DEFAULT CHARACTER SET utf8 ;
USE `bdprestamo` ;

-- -----------------------------------------------------
-- Table `bdprestamo`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdprestamo`.`persona` (
  `id_individuo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `numeroidentificacion` VARCHAR(45) NULL,
  `fechanacimiento` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `correo` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`id_individuo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdprestamo`.`prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdprestamo`.`prestamo` (
  `idprestamo` INT NOT NULL,
  `montosolicitado` VARCHAR(45) NULL,
  `plazo` VARCHAR(45) NULL,
  `cuotamensual` VARCHAR(45) NULL,
  `fechapago` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `detalle` VARCHAR(45) NULL,
  `fechafinalpago` VARCHAR(45) NULL,
  `persona_id_individuo` INT NOT NULL,
  PRIMARY KEY (`idprestamo`, `persona_id_individuo`),
  INDEX `fk_prestamo_persona_idx` (`persona_id_individuo` ASC) VISIBLE,
  CONSTRAINT `fk_prestamo_persona`
    FOREIGN KEY (`persona_id_individuo`)
    REFERENCES `bdprestamo`.`persona` (`id_individuo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdprestamo`.`pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdprestamo`.`pago` (
  `idpago` INT NOT NULL,
  `cuota` VARCHAR(45) NULL,
  `saldo` VARCHAR(45) NULL,
  `estadoprestamo` VARCHAR(45) NULL,
  `prestamo_idprestamo` INT NOT NULL,
  `prestamo_persona_id_individuo` INT NOT NULL,
  PRIMARY KEY (`idpago`, `prestamo_idprestamo`, `prestamo_persona_id_individuo`),
  INDEX `fk_pago_prestamo1_idx` (`prestamo_idprestamo` ASC, `prestamo_persona_id_individuo` ASC) VISIBLE,
  CONSTRAINT `fk_pago_prestamo1`
    FOREIGN KEY (`prestamo_idprestamo` , `prestamo_persona_id_individuo`)
    REFERENCES `bdprestamo`.`prestamo` (`idprestamo` , `persona_id_individuo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
