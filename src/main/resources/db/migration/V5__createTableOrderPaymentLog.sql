use `stock`;

-- 订单支付方式日志表
CREATE TABLE IF NOT EXISTS `order_payment_log` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `payment_order_id` INT(11) NOT NULL DEFAULT 0 COMMENT '订单支付方式ID',
  `money` DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '金额',
  `payment_id` INT(11) NOT NULL DEFAULT 0 COMMENT '支付方式ID',
  `create_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '编辑时间',
  PRIMARY KEY (`id`),
  INDEX payment_order_id (payment_order_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=COMPACT COMMENT='订单支付方式表';
