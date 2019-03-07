package com.ruiruisun.stock.entity;

import lombok.Data;

@Data
public class Order {
    private int id;
    private int buyer_id;
    private float total;
    private int create_time;
    private int update_time;
}
