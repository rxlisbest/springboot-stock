package com.ruiruisun.stock.bean;

import lombok.Data;

@Data
public class BuyerDebtBean {
    private Integer id;
    private String name;
    private float money;
    private Integer count; // 欠款次数
    private Integer max_create_time; // 最近欠款时间
}
