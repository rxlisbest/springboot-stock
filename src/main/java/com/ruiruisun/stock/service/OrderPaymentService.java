package com.ruiruisun.stock.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.bean.OrderGoodsDayBean;
import com.ruiruisun.stock.bean.OrderPaymentDayBean;
import com.ruiruisun.stock.entity.OrderGoods;
import com.ruiruisun.stock.entity.OrderPayment;
import com.ruiruisun.stock.entity.Payment;
import com.ruiruisun.stock.mapper.OrderGoodsMapper;
import com.ruiruisun.stock.mapper.OrderPaymentMapper;
import com.ruiruisun.stock.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderPaymentService {
    @Autowired
    OrderPaymentMapper orderPaymentMapper;

    @Autowired
    PaymentMapper paymentMapper;

    public List<OrderPaymentDayBean> day(String date) {
        List<Payment> paymentList = paymentMapper.findAll();
        Map<Integer, OrderPaymentDayBean> dayData = new LinkedHashMap<Integer, OrderPaymentDayBean>();
        paymentList.forEach(item -> {
            OrderPaymentDayBean orderPaymentDayBean = new OrderPaymentDayBean();
            orderPaymentDayBean.setMoney(0);
            orderPaymentDayBean.setName(item.getName());
            orderPaymentDayBean.setPayment_id(item.getId());
            dayData.put(item.getId(), orderPaymentDayBean);
        });

        List<OrderPaymentDayBean> orderPaymentDayList = orderPaymentMapper.day(date);
        orderPaymentDayList.forEach(item -> {
            OrderPaymentDayBean orderPaymentDayBean = dayData.get(item.getPayment_id());
            orderPaymentDayBean.setMoney(item.getMoney());
            dayData.put(item.getPayment_id(), orderPaymentDayBean);
        });
        List<OrderPaymentDayBean> data = new ArrayList<>();
        dayData.forEach((k, v) -> {
            data.add(v);
        });
        return data;
    }
}