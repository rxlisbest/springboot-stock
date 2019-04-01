use `stock`;

ALTER TABLE `order_payment` ADD COLUMN `buyer_id` INT NOT NULL DEFAULT 0 COMMENT '客户ID';
ALTER TABLE `order_payment` ADD INDEX `buyer_id` (`buyer_id`);
UPDATE `order_payment` op LEFT JOIN `order` o ON o.id = op.order_id SET op.buyer_id = o.buyer_id