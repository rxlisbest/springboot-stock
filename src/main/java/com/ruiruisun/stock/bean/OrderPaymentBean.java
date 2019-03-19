package com.ruiruisun.stock.bean;

import lombok.Data;

@Data
public class OrderPaymentBean {
    private int id;
    private String name;
    private float money;
    private int type;
    private int create_time;
    private int update_time;
}
