CREATE SCHEMA `test` DEFAULT CHARACTER SET utf8;

CREATE TABLE `test`.`users` (
`ID` INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`NAME` VARCHAR(25) NOT NULL,
`AGE` INT NOT NULL,
`IS_ADMIN` BIT(1) NOT NULL DEFAULT false,
`CREATED_DATE` TIMESTAMP DEFAULT CURRENT_TIMESTAMP);

INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Kola', '21');
INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Vasa', '23');
INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Dande', '56');
INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Kola', '44');
INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Vasa', '27');
INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Dande', '68');
INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Kola', '21');
INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Vasa1', '28');
INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Dande1', '96');
INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Kola1', '211');
INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Vasa4', '24');
INSERT INTO `test`.`users` (`NAME`, `AGE`) VALUES ('Dande5', '16');
