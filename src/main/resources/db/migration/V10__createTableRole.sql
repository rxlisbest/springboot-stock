use `stock`;

-- 角色表
CREATE TABLE IF NOT EXISTS  `role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '名称',
  `create_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=COMPACT COMMENT='角色表';

TRUNCATE TABLE `role`;
INSERT INTO `role` (`id`, `name`, `create_time`, `update_time`) VALUES (1, '管理员', unix_timestamp(now()), 0);
INSERT INTO `role` (`id`, `name`, `create_time`, `update_time`) VALUES (2, '出库', unix_timestamp(now()), 0);

-- 接口表
CREATE TABLE IF NOT EXISTS  `api` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `uri` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '接口地址',
  `create_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=COMPACT COMMENT='接口表';

-- buyers
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (1, 'buyers/index', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (2, 'buyers/view', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (3, 'buyers/create', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (4, 'buyers/update', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (5, 'buyers/delete', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (6, 'buyers/all', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (7, 'buyers/repeat', unix_timestamp(now()), 0);
-- goods_categories
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (8, 'goods_categories/index', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (9, 'goods_categories/view', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (10, 'goods_categories/create', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (11, 'goods_categories/update', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (12, 'goods_categories/delete', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (13, 'goods_categories/all', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (14, 'goods_categories/repeat', unix_timestamp(now()), 0);
-- goods
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (15, 'goods/index', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (16, 'goods/view', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (17, 'goods/create', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (18, 'goods/update', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (19, 'goods/delete', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (20, 'goods/all', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (21, 'goods/repeat', unix_timestamp(now()), 0);
-- goods_logs
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (22, 'goods_logs/index', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (23, 'goods_logs/create', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (24, 'goods_logs/delete', unix_timestamp(now()), 0);
-- orders
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (25, 'orders/index', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (26, 'orders/view', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (27, 'orders/create', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (28, 'orders/delete', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (29, 'orders/month', unix_timestamp(now()), 0);
-- order_goods
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (30, 'order_goods/all', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (31, 'order_goods/day', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (32, 'order_goods/create', unix_timestamp(now()), 0);
-- order_payments
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (33, 'order_payments/index', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (34, 'order_payments/day', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (35, 'order_payments/user_day', unix_timestamp(now()), 0);
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (36, 'order_payments/all', unix_timestamp(now()), 0);
-- payments
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (37, 'payments/all', unix_timestamp(now()), 0);
-- users
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (38, 'users/change_password', unix_timestamp(now()), 0);

-- 接口角色表
CREATE TABLE IF NOT EXISTS  `user_role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `api_id` INT(11) NOT NULL DEFAULT 0 COMMENT '接口ID',
  `role_id` INT(11) NOT NULL DEFAULT 0 COMMENT '角色ID',
  `create_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=COMPACT COMMENT='接口角色表';

-- 用户角色表
CREATE TABLE IF NOT EXISTS  `user_role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL DEFAULT 0 COMMENT '用户ID',
  `role_id` INT(11) NOT NULL DEFAULT 0 COMMENT '角色ID',
  `create_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=COMPACT COMMENT='用户角色表';
