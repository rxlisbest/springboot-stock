package com.ruiruisun.stock.bean;

import lombok.Data;

@Data
public class OrderPaymentBuyerBean {
    private String buyer_name;
    private String name;
    private float money;
    private int payment_id;
}
