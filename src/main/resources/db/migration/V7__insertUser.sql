use `stock`;

TRUNCATE TABLE `user`;
INSERT INTO `user`(`name`, `username`, `password`, `create_time`, `update_time`) VALUES ('冷库', 'lengku', 'e10adc3949ba59abbe56e057f20f883e', unix_timestamp(now()), 0);
INSERT INTO `user`(`name`, `username`, `password`, `create_time`, `update_time`) VALUES ('市场', 'shichang', 'e10adc3949ba59abbe56e057f20f883e', unix_timestamp(now()), 0);
