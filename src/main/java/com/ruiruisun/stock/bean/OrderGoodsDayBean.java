package com.ruiruisun.stock.bean;

import lombok.Data;

@Data
public class OrderGoodsDayBean {
    String goods_name;
    int goods_id;
    Float total;
    Float amount;
}
