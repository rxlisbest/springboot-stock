package com.ruiruisun.stock.entity;

import lombok.Data;

@Data
public class Goods {
    private int id;
    private String name;
    private int goods_category_id;
    private float price;
    private float discount_price;
    private float amount;
    private String unit;
    private int create_time;
    private int update_time;
}
