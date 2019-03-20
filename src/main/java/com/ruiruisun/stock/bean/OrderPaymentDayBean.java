package com.ruiruisun.stock.bean;

import lombok.Data;

@Data
public class OrderPaymentDayBean {
    private int user_id;
    private String name;
    private float money;
    private int payment_id;
}
