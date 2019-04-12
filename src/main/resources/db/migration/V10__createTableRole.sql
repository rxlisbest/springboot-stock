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

TRUNCATE TABLE `api`;
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
CREATE TABLE IF NOT EXISTS  `role_api` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `api_id` INT(11) NOT NULL DEFAULT 0 COMMENT '接口ID',
  `role_id` INT(11) NOT NULL DEFAULT 0 COMMENT '角色ID',
  `create_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=COMPACT COMMENT='接口角色表';

TRUNCATE TABLE `role_api`;
-- role_id = 1
-- buyers
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 1, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 2, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 3, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 4, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 5, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 6, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 7, unix_timestamp(now()), 0);
-- goods_categories
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 8, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 9, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 10, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 11, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 12, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 13, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 14, unix_timestamp(now()), 0);
-- goods
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 15, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 16, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 17, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 18, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 19, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 20, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 21, unix_timestamp(now()), 0);
-- goods_logs
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 22, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 23, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 24, unix_timestamp(now()), 0);
-- orders
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 25, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 26, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 27, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 28, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 29, unix_timestamp(now()), 0);
-- order_goods
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 30, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 31, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 32, unix_timestamp(now()), 0);
-- order_payments
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 33, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 34, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 35, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 36, unix_timestamp(now()), 0);
-- payments
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 37, unix_timestamp(now()), 0);
-- users
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 38, unix_timestamp(now()), 0);
-- role_id = 2
-- goods_categories
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 13, unix_timestamp(now()), 0);
-- goods
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 20, unix_timestamp(now()), 0);
-- buyers
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 1, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 2, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 3, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 4, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 5, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 6, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 7, unix_timestamp(now()), 0);
-- orders
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 25, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 26, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 27, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 28, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 29, unix_timestamp(now()), 0);
-- order_goods
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 30, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 31, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 32, unix_timestamp(now()), 0);
-- order_payments
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 33, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 34, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 35, unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 36, unix_timestamp(now()), 0);
-- payments
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 37, unix_timestamp(now()), 0);
-- users
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (2, 38, unix_timestamp(now()), 0);

-- 用户角色表
CREATE TABLE IF NOT EXISTS  `user_role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL DEFAULT 0 COMMENT '用户ID',
  `role_id` INT(11) NOT NULL DEFAULT 0 COMMENT '角色ID',
  `create_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=COMPACT COMMENT='用户角色表';

TRUNCATE TABLE `user_role`;
INSERT INTO `user_role` (`user_id`, `role_id`, `create_time`, `update_time`) VALUES (1, 1, unix_timestamp(now()), 0);
INSERT INTO `user_role` (`user_id`, `role_id`, `create_time`, `update_time`) VALUES (2, 2, unix_timestamp(now()), 0);

TRUNCATE TABLE `user`;
INSERT INTO `user`(`id`, `name`, `username`, `password`, `create_time`, `update_time`) VALUES (1, '冷库', 'lengku', 'e10adc3949ba59abbe56e057f20f883e', unix_timestamp(now()), 0);
INSERT INTO `user`(`id`, `name`, `username`, `password`, `create_time`, `update_time`) VALUES (2, '市场', 'shichang', 'e10adc3949ba59abbe56e057f20f883e', unix_timestamp(now()), 0);
