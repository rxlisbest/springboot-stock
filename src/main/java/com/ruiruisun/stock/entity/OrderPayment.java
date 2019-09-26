package com.ruiruisun.stock.entity;

import lombok.Data;

@Data
public class OrderPayment {
    private int id;
    private int buyer_id;
    private int user_id;
    private int order_id;
    private float money;
    private float init_money;
    private int payment_id;
    private int payment_type;
    private int create_time;
    private int update_time;
}
