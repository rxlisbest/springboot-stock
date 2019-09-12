use `stock`;

ALTER TABLE `order_payment_log` change `payment_order_id` `order_payment_id` INT(11) NOT NULL DEFAULT 0 COMMENT '订单支付方式ID';
