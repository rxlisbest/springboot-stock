package com.ruiruisun.stock.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class User {

    private int id;
    private String name;
    private String username;
    private String password;
}
