-- MySQL Script generated by MySQL Workbench
-- Tue Oct 11 22:20:51 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET
@OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET
@OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET
@OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema custom_resource_manager
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema custom_resource_manager
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `custom_resource_manager` DEFAULT CHARACTER SET utf8;
USE
`custom_resource_manager` ;

-- -----------------------------------------------------
-- Table `custom_resource_manager`.`account_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `custom_resource_manager`.`account_role`
(
    `id`
    INT
    NOT
    NULL,
    `account_id`
    INT
    NULL,
    `role_id`
    INT
    NULL,
    PRIMARY
    KEY
(
    `id`
))
    ENGINE = InnoDB
    COMMENT = '账号和角色关联表';


-- -----------------------------------------------------
-- Table `custom_resource_manager`.`account_company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `custom_resource_manager`.`account_company`
(
    `id`
    INT
    NOT
    NULL,
    `company_id`
    INT
    NULL,
    `account_id`
    INT
    NULL,
    PRIMARY
    KEY
(
    `id`
))
    ENGINE = InnoDB
    COMMENT = '客户公司和账号关联表';


-- -----------------------------------------------------
-- Table `custom_resource_manager`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `custom_resource_manager`.`account`
(
    `id`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `username`
    VARCHAR
(
    32
) NOT NULL COMMENT '用户名',
    `account` VARCHAR
(
    32
) NOT NULL COMMENT '账号',
    `password` VARCHAR
(
    64
) NOT NULL COMMENT '密码',
    `email` VARCHAR
(
    32
) NULL COMMENT '邮箱',
    `state` TINYINT NOT NULL COMMENT '状态',
    `created_time` DATETIME NULL,
    `created_by` INT NULL,
    `updated_by` INT NULL,
    `updated_time` DATETIME NULL,
    PRIMARY KEY
(
    `id`
),
    UNIQUE INDEX `id_UNIQUE`
(
    `id` ASC
) INVISIBLE)
    ENGINE = InnoDB
    COMMENT = '账号表';


-- -----------------------------------------------------
-- Table `custom_resource_manager`.`role_permissions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `custom_resource_manager`.`role_permissions`
(
    `id`
    INT
    NOT
    NULL,
    `permissions_id`
    INT
    NULL,
    `role_id`
    INT
    NULL,
    PRIMARY
    KEY
(
    `id`
))
    ENGINE = InnoDB
    COMMENT = '角色和权限关联表';


-- -----------------------------------------------------
-- Table `custom_resource_manager`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `custom_resource_manager`.`role`
(
    `id`
    INT
    NOT
    NULL,
    `role`
    VARCHAR
(
    32
) NOT NULL,
    `role_name` VARCHAR
(
    32
) NOT NULL COMMENT '角色名',
    `state` TINYINT NULL,
    `created_by` INT NULL,
    `created_time` DATETIME NULL,
    `updated_by` INT NULL,
    `updated_time` DATETIME NULL,
    PRIMARY KEY
(
    `id`
))
    ENGINE = InnoDB
    COMMENT = '角色表';


-- -----------------------------------------------------
-- Table `custom_resource_manager`.`permissions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `custom_resource_manager`.`permissions`
(
    `id`
    INT
    NOT
    NULL,
    `resource_name`
    VARCHAR
(
    45
) NULL COMMENT '资源名称',
    `resource_permissions` VARCHAR
(
    45
) NULL COMMENT '资源权限',
    `state` TINYINT NULL COMMENT '状态',
    `created_by` INT NULL,
    `created_time` DATETIME NULL,
    `updated_by` INT NULL,
    `updated_time` DATETIME NULL,
    PRIMARY KEY
(
    `id`
))
    ENGINE = InnoDB
    COMMENT = '权限表';


-- -----------------------------------------------------
-- Table `custom_resource_manager`.`company_person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `custom_resource_manager`.`company_person`
(
    `id`
    INT
    NOT
    NULL,
    `company_id`
    INT
    NULL,
    `person_id`
    INT
    NULL,
    PRIMARY
    KEY
(
    `id`
))
    ENGINE = InnoDB
    COMMENT = '客户公司和客户关联表';


-- -----------------------------------------------------
-- Table `custom_resource_manager`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `custom_resource_manager`.`company`
(
    `id`
    INT
    NOT
    NULL,
    `company_id`
    VARCHAR
(
    32
) NOT NULL,
    `company_name` VARCHAR
(
    64
) NOT NULL,
    `address` VARCHAR
(
    64
) NULL,
    `state` TINYINT NULL,
    `created_by` INT NULL,
    `created_time` DATETIME NULL,
    `updated_time` DATETIME NULL,
    `updated_by` INT NULL,
    PRIMARY KEY
(
    `id`
))
    ENGINE = InnoDB
    COMMENT = '客户公司表';


-- -----------------------------------------------------
-- Table `custom_resource_manager`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `custom_resource_manager`.`person`
(
    `id`
    INT
    NOT
    NULL,
    `name`
    VARCHAR
(
    32
) NOT NULL,
    `phone_number` VARCHAR
(
    11
) NOT NULL,
    `position` VARCHAR
(
    32
) NULL COMMENT '职位',
    `department` VARCHAR
(
    32
) NULL COMMENT '部门',
    `state` TINYINT NULL,
    `created_by` INT NULL,
    `created_time` DATETIME NULL,
    `updated_time` DATETIME NULL,
    `updated_by` INT NULL,
    PRIMARY KEY
(
    `id`
))
    ENGINE = InnoDB
    COMMENT = '客户表';

USE
`custom_resource_manager` ;

-- -----------------------------------------------------
-- Placeholder table for view `custom_resource_manager`.`view1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `custom_resource_manager`.`view1`
(
    `id` INT
);

-- -----------------------------------------------------
-- View `custom_resource_manager`.`view1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `custom_resource_manager`.`view1`;
USE
`custom_resource_manager`;


SET
SQL_MODE=@OLD_SQL_MODE;
SET
FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET
UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- 设置公司唯一键 保障数据不重复
ALTER TABLE `custom_resource_manager`.`company`
    ADD UNIQUE INDEX `unique_company_id_name` (`company_id` ASC, `company_name` ASC) VISIBLE;
;

