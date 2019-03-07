package com.ruiruisun.stock.bean;

import lombok.Data;

@Data
public class CartGoodsBean {
    private int id;
    private String name;
    private float price;
    private float amount;
    private float order_amount;
    private String unit;
    private int create_time;
    private int update_time;
}
