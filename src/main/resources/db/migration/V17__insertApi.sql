use `stock`;

-- 订单支付方式详情
set @api_id = 0;
INSERT INTO `api` (`uri`, `create_time`, `update_time`) VALUES ('order_payments/view', unix_timestamp(now()), 0);
SELECT @api_id := id FROM `api` WHERE `uri` =  'order_payments/view';
INSERT INTO `role_api` (`role_id`, `api_id`, `create_time`, `update_time`) VALUES (1, @api_id, unix_timestamp(now()), 0);