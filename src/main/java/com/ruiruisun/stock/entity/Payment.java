package com.ruiruisun.stock.entity;

import lombok.Data;

@Data
public class Payment {
    private int id;
    private String name;
    private int type;
    private int create_time;
    private int update_time;
}
