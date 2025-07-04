-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Aluno` (
  `id_aluno` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  PRIMARY KEY (`id_aluno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Livro` (
  `id_livro` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_livro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Emprestimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Emprestimo` (
  `id_emprestimo` INT NOT NULL AUTO_INCREMENT,
  `Aluno_id_aluno` INT NOT NULL,
  `Livro_id_livro` INT NOT NULL,
  PRIMARY KEY (`id_emprestimo`, `Aluno_id_aluno`, `Livro_id_livro`),
  INDEX `fk_Aluno_has_Livro_Livro1_idx` (`Livro_id_livro` ASC) VISIBLE,
  INDEX `fk_Aluno_has_Livro_Aluno_idx` (`Aluno_id_aluno` ASC) VISIBLE,
  CONSTRAINT `fk_Aluno_has_Livro_Aluno`
    FOREIGN KEY (`Aluno_id_aluno`)
    REFERENCES `mydb`.`Aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aluno_has_Livro_Livro1`
    FOREIGN KEY (`Livro_id_livro`)
    REFERENCES `mydb`.`Livro` (`id_livro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydb`.`Aluno`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Aluno` (`id_aluno`, `nome`, `idade`) VALUES (1, 'Bruno', 23);
INSERT INTO `mydb`.`Aluno` (`id_aluno`, `nome`, `idade`) VALUES (2, 'José', 75);
INSERT INTO `mydb`.`Aluno` (`id_aluno`, `nome`, `idade`) VALUES (3, 'Larissa', 29);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Livro`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Livro` (`id_livro`, `titulo`, `autor`) VALUES (1, 'Não Tenho Boca Mas Preciso Gritar', 'Harlan Ellison');
INSERT INTO `mydb`.`Livro` (`id_livro`, `titulo`, `autor`) VALUES (2, 'The Witcher 3', 'Andrzej Sapkowski');
INSERT INTO `mydb`.`Livro` (`id_livro`, `titulo`, `autor`) VALUES (3, 'Bruxos e Bruxas', 'James Petterson');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Emprestimo`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Emprestimo` (`id_emprestimo`, `Aluno_id_aluno`, `Livro_id_livro`) VALUES (1, 2, 3);
INSERT INTO `mydb`.`Emprestimo` (`id_emprestimo`, `Aluno_id_aluno`, `Livro_id_livro`) VALUES (2, 1, 2);
INSERT INTO `mydb`.`Emprestimo` (`id_emprestimo`, `Aluno_id_aluno`, `Livro_id_livro`) VALUES (3, 3, 1);

COMMIT;

