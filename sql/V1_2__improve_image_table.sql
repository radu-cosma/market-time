--
-- Structure for `image_type` table.
--
DROP TABLE IF EXISTS `image_type`;
CREATE TABLE IF NOT EXISTS `image_type` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `image_type` (`type`) VALUES ('image/gif'), ('gif'), ('image/jpg'), ('jpeg'), ('image/jpeg'), ('jpg'), ('image/png'), ('png');

--
-- In `product_image`, change `title` to `name` and add a FK to `image_type`.
--
ALTER TABLE `product_image` 
    CHANGE COLUMN `title` `name` VARCHAR(255) NOT NULL,
    ADD COLUMN `weight` INT NOT NULL AFTER `url`,
    ADD COLUMN `image_type_id` BIGINT NOT NULL AFTER `weight`,
    ADD INDEX `fk_product_image_image_type_idx` (`image_type_id`),
    ADD CONSTRAINT `fk_product_image_image_type` FOREIGN KEY (`image_type_id`) REFERENCES `image_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
    