--
-- Structure for `product` table.
--
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
	`id` BIGINT NOT NULL AUTO_INCREMENT, 
	`name` VARCHAR(30) NOT NULL,
	`description` VARCHAR(1000) NOT NULL,
	`shipping` VARCHAR(10) NOT NULL,
	`shipping_time` VARCHAR(5) DEFAULT NULL, 
	`color` VARCHAR(20) DEFAULT NULL,
	`size` VARCHAR(10) DEFAULT NULL,
	`inventory` INT NOT NULL,
	`price` INT NOT NULL,
	`brand` VARCHAR(30) DEFAULT NULL,
	`presentation_page_url` VARCHAR(50) DEFAULT NULL,
	`upc` VARCHAR(12) DEFAULT NULL,
	`user_id` BIGINT NOT NULL,
	PRIMARY KEY (`id`),
	KEY `fk_product_user_idx` (`user_id`),
  	CONSTRAINT `fk_product_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure for `product_tag` table.
--
DROP TABLE IF EXISTS `product_tag`;
CREATE TABLE IF NOT EXISTS `product_tag` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
  	`name` VARCHAR(20) NOT NULL,
  	`product_id` BIGINT NOT NULL,
  	PRIMARY KEY (`id`),
	KEY `fk_product_tag_product_idx` (`product_id`),
  	CONSTRAINT `fk_product_tag_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure for `product_image` table.
--
DROP TABLE IF EXISTS `product_image`;
CREATE TABLE IF NOT EXISTS `product_image` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(30) NOT NULL,
  	`url` VARCHAR(255) NOT NULL,
  	`product_id` BIGINT NOT NULL,
  	PRIMARY KEY (`id`),
	KEY `fk_product_image_product_idx` (`product_id`),
  	CONSTRAINT `fk_product_image_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;