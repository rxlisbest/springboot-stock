package com.ruiruisun.stock.bean;

import com.ruiruisun.stock.entity.Order;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderBean {
    Order order;
    List<CartGoodsBean> cart;
    List<OrderPaymentBean> payments;
}
