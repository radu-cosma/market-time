--
-- Structure for `company` table.
--
DROP TABLE IF EXISTS `company`;
CREATE TABLE IF NOT EXISTS `company` (
  	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  	`name` VARCHAR(30) NOT NULL,
  	`address` VARCHAR(100) NOT NULL,
  	`phone` VARCHAR(15) NOT NULL,
  	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure for `user` table.
--
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  	`first_name` VARCHAR(30) NOT NULL,
  	`last_name` VARCHAR(30) NOT NULL,
  	`email` VARCHAR(127) NOT NULL,
  	`password` VARCHAR(63) NOT NULL,
  	`company_id` BIGINT(20) NOT NULL,
  	PRIMARY KEY (`id`),
  	UNIQUE KEY `email_unique` (`email`),
  	KEY `user_company_id_idx` (`company_id`),
  	CONSTRAINT `user_company_id_fk` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure for `session` table.
--
DROP TABLE IF EXISTS `user_session`;
CREATE TABLE IF NOT EXISTS `user_session` (
  	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  	`user_id` BIGINT(20) NOT NULL,
  	`uuid` VARCHAR(36) NOT NULL,
  	`active` TINYINT(1) NOT NULL,
  	`creation_time` DATETIME NOT NULL,
  	`last_access` DATETIME NOT NULL,
  	PRIMARY KEY (`id`),
  	UNIQUE KEY `user_session_uuid_unique` (`uuid`),
  	KEY `user_session_user_id_idx` (`user_id`),
  	CONSTRAINT `user_session_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
