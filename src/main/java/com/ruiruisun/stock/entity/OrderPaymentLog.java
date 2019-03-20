package com.ruiruisun.stock.entity;

import lombok.Data;

@Data
public class OrderPaymentLog {
    private int id;
    private int user_id;
    private int payment_order_id;
    private float money;
    private int payment_id;
    private int create_time;
    private int update_time;
}
