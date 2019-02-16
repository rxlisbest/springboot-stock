package com.ruiruisun.stock.dao;

import lombok.Data;

@Data
public class UserBean {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }
}
