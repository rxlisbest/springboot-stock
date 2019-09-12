use `stock`;

-- 欠款管理
INSERT INTO `api` (`id`, `uri`, `create_time`, `update_time`) VALUES (39, 'order_payments/buyer_debt', unix_timestamp(now()), 0);
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, 39, unix_timestamp(now()), 0);