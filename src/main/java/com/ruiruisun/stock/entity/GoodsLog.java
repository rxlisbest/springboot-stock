package com.ruiruisun.stock.entity;

import lombok.Data;

@Data
public class GoodsLog {
    private int id;
    private String name;
    private int goods_id;
    private float price;
    private float amount;
    private int create_time;
    private int update_time;
}
