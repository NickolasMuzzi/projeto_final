CREATE TABLE `projeto_final`.`users` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(200) NOT NULL,
    `password` LONGTEXT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);
