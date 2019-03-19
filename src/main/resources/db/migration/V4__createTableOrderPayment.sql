use `stock`;

-- 支付方式表
CREATE TABLE IF NOT EXISTS `payment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '名称',
  `type` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '类型 0：支出 1：收入',
  `create_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=COMPACT COMMENT='支付方式表';

-- 订单支付方式表
CREATE TABLE IF NOT EXISTS `order_payment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `order_id` INT(11) NOT NULL DEFAULT 0 COMMENT '订单ID',
  `money` DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '金额',
  `payment_id` INT(11) NOT NULL DEFAULT 0 COMMENT '支付方式ID',
  `payment_type` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '类型 0：支出 1：收入',
  `create_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '编辑时间',
  PRIMARY KEY (`id`),
  INDEX order_id (order_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=COMPACT COMMENT='订单支付方式表';


INSERT INTO `payment` (`name`, `type`, `create_time`, `update_time`) VALUES ('现金', 1, unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO `payment` (`name`, `type`, `create_time`, `update_time`) VALUES ('微信', 1, unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO `payment` (`name`, `type`, `create_time`, `update_time`) VALUES ('支付宝', 1, unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO `payment` (`name`, `type`, `create_time`, `update_time`) VALUES ('银行卡', 1, unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO `payment` (`name`, `type`, `create_time`, `update_time`) VALUES ('欠款', 0, unix_timestamp(now()), unix_timestamp(now()));
INSERT INTO `payment` (`name`, `type`, `create_time`, `update_time`) VALUES ('抹零', 0, unix_timestamp(now()), unix_timestamp(now()));