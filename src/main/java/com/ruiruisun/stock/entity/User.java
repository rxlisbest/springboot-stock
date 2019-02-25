package com.ruiruisun.stock.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + name + '\'' +
                ", passWord='" + username + '\'' +
                ", realName='" + password + '\'' +
                '}';
    }
}
