SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `introseDb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `introseDb` ;

-- -----------------------------------------------------
-- Table `introseDb`.`Item`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `introseDb`.`Item` (
  `brandName` VARCHAR(255) NOT NULL ,
  `name` VARCHAR(255) NOT NULL ,
  `unitPrice` DOUBLE NOT NULL ,
  `stock` INT NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`brandName`, `name`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `introseDb`.`Supplier`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `introseDb`.`Supplier` (
  `contactNo` VARCHAR(255) NOT NULL ,
  `name` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`name`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `introseDb`.`sTransaction`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `introseDb`.`sTransaction` (
  `terms` INT NOT NULL ,
  `date` DATE NOT NULL ,
  `deadline` DATE NOT NULL ,
  `total` DOUBLE NOT NULL ,
  `name` VARCHAR(255) NOT NULL ,
  `inVoice` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`inVoice`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `introseDb`.`Bundle`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `introseDb`.`Bundle` (
  `unit` VARCHAR(255) NOT NULL ,
  `measurement` INT NOT NULL DEFAULT 0 ,
  `packSellPrice` DOUBLE NOT NULL ,
  `stock` INT NOT NULL DEFAULT 0 ,
  `brandName` VARCHAR(255) NOT NULL ,
  `name` VARCHAR(255) NOT NULL ,
  `supplierName` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`brandName`, `name`, `unit`) ,
  UNIQUE INDEX `unit_UNIQUE` (`unit` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `introseDb`.`Office`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `introseDb`.`Office` (
  `name` VARCHAR(255) NOT NULL ,
  `contactNo` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`name`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `introseDb`.`WalkIn`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `introseDb`.`WalkIn` (
  `dateOfPurchase` INT NOT NULL ,
  `inVoice` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`inVoice`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `introseDb`.`oTransaction`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `introseDb`.`oTransaction` (
  `terms` INT NOT NULL ,
  `deadLine` DATE NOT NULL ,
  `total` DOUBLE NOT NULL ,
  `name` VARCHAR(255) NOT NULL ,
  `inVoice` VARCHAR(255) NOT NULL ,
  `date` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`inVoice`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `introseDb`.`WalkInTransaction`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `introseDb`.`WalkInTransaction` (
  `total` DOUBLE NOT NULL ,
  `dateOfPurchase` INT NOT NULL ,
  `inVoice` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`inVoice`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `introseDb`.`Prices`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `introseDb`.`Prices` (
  `supplierName` VARCHAR(255) NOT NULL ,
  `price` DOUBLE NOT NULL ,
  `brandName` VARCHAR(255) NOT NULL ,
  `name` VARCHAR(255) NOT NULL ,
  `unit` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`supplierName`) ,
  UNIQUE INDEX `brandName_UNIQUE` (`brandName` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `introseDb`.`ItemList`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `introseDb`.`ItemList` (
  `inVoice` VARCHAR(255) NOT NULL ,
  `quantity` INT NOT NULL DEFAULT 0 ,
  `price` DOUBLE NOT NULL ,
  `brandName` VARCHAR(255) NOT NULL ,
  `name` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`inVoice`, `brandName`, `name`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `introseDb`.`oItemList`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `introseDb`.`oItemList` (
  `Invoice` VARCHAR(255) NOT NULL ,
  `quantity` INT NOT NULL DEFAULT 0 ,
  `brandName` VARCHAR(255) NOT NULL ,
  `name` VARCHAR(255) NOT NULL ,
  `price` DOUBLE NOT NULL ,
  PRIMARY KEY (`Invoice`) ,
  INDEX `fk_ItemList_Item1_idx` (`brandName` ASC, `name` ASC) ,
  CONSTRAINT `fk_ItemList_Item10`
    FOREIGN KEY (`brandName` , `name` )
    REFERENCES `introseDb`.`Item` (`brandName` , `name` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `introseDb`.`sBundleList`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `introseDb`.`sBundleList` (
  `quantity` INT NOT NULL ,
  `packSellPrice` DOUBLE NOT NULL ,
  `measurement` VARCHAR(255) NOT NULL ,
  `brandName` VARCHAR(255) NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `inVoice` VARCHAR(255) NOT NULL ,
  `unit` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`brandName`, `name`, `unit`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `introseDb`.`oBundleList`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `introseDb`.`oBundleList` (
  `quantity` INT NOT NULL ,
  `packSellPrice` DOUBLE NOT NULL ,
  `measurement` VARCHAR(255) NOT NULL ,
  `brandName` VARCHAR(255) NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `inVoice` VARCHAR(255) NOT NULL ,
  `unit` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`brandName`, `name`, `unit`) )
ENGINE = InnoDB;

USE `introseDb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
