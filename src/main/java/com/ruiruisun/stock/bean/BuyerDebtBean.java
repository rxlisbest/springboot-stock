package com.ruiruisun.stock.bean;

import lombok.Data;

@Data
public class BuyerDebtBean {
    private String name;
    private float money;
    private Integer max_create_time; // 最近欠款时间
}
