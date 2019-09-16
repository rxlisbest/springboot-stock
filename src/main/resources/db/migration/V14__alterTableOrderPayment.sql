use `stock`;

ALTER TABLE `order_payment` ADD COLUMN `init_money` DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '初始金额';
UPDATE `order_payment` SET `init_money` = `money`;
