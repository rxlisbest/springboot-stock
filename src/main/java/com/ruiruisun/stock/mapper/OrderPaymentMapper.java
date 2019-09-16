package com.ruiruisun.stock.mapper;

import com.ruiruisun.stock.bean.*;
import com.ruiruisun.stock.entity.OrderPayment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderPaymentMapper {

    List<OrderPayment> findAll();

    List<OrderPaymentBean> findAllByOrderId(int order_id);

    List<OrderPaymentBuyerBean> findPageByCondition(String date, Integer payment_id);

    OrderPayment findOne(int id);

    int create(OrderPayment orderPayment);

    List<OrderPaymentDayBean> day(String date);

    List<OrderPaymentDayBean> userDay(String date);

    List<BuyerDebtBean> findBuyerDebt(String name);

    List<OrderPaymentDebtBean> findBuyerDebtByBuyerId(Integer buyer_id);
}
