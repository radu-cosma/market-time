--
-- Structure for `product_tag` table.
--
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
  	`role` VARCHAR(20) NOT NULL,
  	PRIMARY KEY (`id`),
  	UNIQUE KEY `user_role_role_unique` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user_role` (`role`) VALUES ('ADMIN'), ('REGULAR_USER');

--
-- Add a foreign key from `user` to `user_role`.
--
ALTER TABLE `user`    
    ADD COLUMN `user_role_id` BIGINT NOT NULL AFTER `company_id`,
    ADD INDEX `fk_user_user_role_idx` (`user_role_id`),
    ADD CONSTRAINT `fk_user_user_role` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
    
--
-- Create a company for the admin user and the admin user itself.
--
INSERT INTO `company` (`name`, `address`, `phone`) VALUES ('Market Time', '', '');
INSERT INTO `user` (`first_name`, `last_name`, `email`, `password`, `company_id`, `user_role_id`) VALUES ('admin', 'admin', 'admin', 'admin', 1, 1);
    