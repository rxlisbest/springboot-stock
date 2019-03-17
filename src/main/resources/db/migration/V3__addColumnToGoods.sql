use `stock`;

ALTER TABLE `goods` ADD COLUMN `discount_price` DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '折扣价格';
ALTER TABLE `goods_log` ADD COLUMN `discount_price` DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '折扣价格';