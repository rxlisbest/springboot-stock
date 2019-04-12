package com.ruiruisun.stock.entity;

import lombok.Data;

@Data
public class UserRole {
    private int id;
    private int user_id;
    private int role_id;
    private int create_time;
    private int update_time;
}
