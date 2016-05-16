CREATE TABLE `User`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `age` INT(3) NOT NULL,
  `status` TINYINT(1) NOT NULL,
  `date` BIGINT(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
)
  ENGINE=MyISAM DEFAULT CHARSET=latin1;
