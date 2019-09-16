package com.ruiruisun.stock.bean;

import lombok.Data;

@Data
public class OrderPaymentDebtBean {
    private int id;
    private int order_id;
    private String buyer_name;
    private String payment_name;
    private float init_money;
    private float money;
    private int type;
    private int create_time;
    private int update_time;
}
