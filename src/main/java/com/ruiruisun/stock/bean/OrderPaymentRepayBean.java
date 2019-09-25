package com.ruiruisun.stock.bean;

import lombok.Data;

import java.util.List;

@Data
public class OrderPaymentRepayBean {
    Integer orderPaymentId;
    List<OrderPaymentBean> payments;
}
