package com.ruiruisun.stock.entity;

import lombok.Data;

@Data
public class OrderGoods {
    private int id;
    private String name;
    private int goods_id;
    private int order_id;
    private float price;
    private float amount;
    private String unit;
    private int create_time;
    private int update_time;
}
