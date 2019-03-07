package com.ruiruisun.stock.bean;

import lombok.Data;

@Data
public class ChangePasswordUserBean {
    private String oldPassword;
    private String password;
    private String confirmPassword;
}
