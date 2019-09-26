package com.ruiruisun.stock.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.bean.*;
import com.ruiruisun.stock.entity.OrderGoods;
import com.ruiruisun.stock.entity.OrderPayment;
import com.ruiruisun.stock.entity.Payment;
import com.ruiruisun.stock.entity.User;
import com.ruiruisun.stock.mapper.OrderGoodsMapper;
import com.ruiruisun.stock.mapper.OrderPaymentMapper;
import com.ruiruisun.stock.mapper.PaymentMapper;
import com.ruiruisun.stock.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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

    @Autowired
    UserMapper userMapper;

    private BigDecimal total;


    public PageInfo<OrderPaymentBuyerBean> findPageByCondition(String date, Integer payment_id, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<OrderPaymentBuyerBean> orderPaymentBuyerList = orderPaymentMapper.findPageByCondition(date, payment_id);
        PageInfo<OrderPaymentBuyerBean> pageInfo = new PageInfo<>(orderPaymentBuyerList);
        return pageInfo;
    }


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

    public List<Map> userDay(String date) {
        Map<String, Float> userDayData = new LinkedHashMap<String, Float>();
        List<OrderPaymentDayBean> userOrderPaymentDayList = orderPaymentMapper.userDay(date);
        userOrderPaymentDayList.forEach(item -> {
            userDayData.put(item.getUser_id() + "-" + item.getPayment_id(), item.getMoney());
        });

        List<Payment> paymentList = paymentMapper.findAll();

        List<User> userList = userMapper.findAll();
        List<Map> data = new ArrayList<>();
        userList.forEach(v -> {
            Map<String, Object> rowData = new LinkedHashMap<String, Object>();
            rowData.put("name", v.getName());
            paymentList.forEach(vv -> {
                if (userDayData.get(v.getId() + "-" + vv.getId()) != null) {
                    rowData.put(String.valueOf(vv.getId()), userDayData.get(v.getId() + "-" + vv.getId()));
                } else {
                    rowData.put(String.valueOf(vv.getId()), (float) 0);
                }
            });
            data.add(rowData);
        });
        return data;
    }

    public List<OrderPaymentBean> findAllByOrderId(Integer order_id) {
        List<OrderPaymentBean> orderPaymentList = orderPaymentMapper.findAllByOrderId(order_id);
        return orderPaymentList;
    }

    public PageInfo<BuyerDebtBean> findBuyerDebt(String name, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<BuyerDebtBean> orderPaymentList = orderPaymentMapper.findBuyerDebt(name);
        PageInfo<BuyerDebtBean> pageInfo = new PageInfo<>(orderPaymentList);
        return pageInfo;
    }

    public PageInfo<OrderPaymentDebtBean> findBuyerDebtByBuyerId(Integer buyer_id, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<OrderPaymentDebtBean> orderPaymentList = orderPaymentMapper.findBuyerDebtByBuyerId(buyer_id);
        PageInfo<OrderPaymentDebtBean> pageInfo = new PageInfo<>(orderPaymentList);
        return pageInfo;
    }

    @Transactional
    public int repay(OrderPayment orderPaymentOne, OrderPaymentRepayBean orderPaymentRepay) {
        List<OrderPaymentBean> payments = orderPaymentRepay.getPayments();

        total = new BigDecimal("0");
        payments.forEach(item -> {
            if (item.getMoney() > 0) {
                OrderPayment orderPayment = new OrderPayment();
                orderPayment.setBuyer_id(orderPaymentOne.getBuyer_id());
                orderPayment.setUser_id(orderPaymentOne.getUser_id());
                orderPayment.setOrder_id(orderPaymentOne.getOrder_id());
                orderPayment.setMoney(item.getMoney());
                orderPayment.setInit_money(item.getMoney());
                orderPayment.setPayment_id(item.getId());
                orderPayment.setPayment_type(item.getType());
                orderPaymentMapper.create(orderPayment);

                BigDecimal money = new BigDecimal(Float.toString(item.getMoney()));
                total = total.add(money);
            }
        });
        BigDecimal money = new BigDecimal(Float.toString(orderPaymentOne.getMoney()));
        orderPaymentOne.setMoney(Float.valueOf(String.valueOf(money.subtract(total))));
        orderPaymentMapper.update(orderPaymentOne);
        return orderPaymentOne.getId();
    }

    public OrderPayment findOne(int id) {
        OrderPayment orderPayment = orderPaymentMapper.findOne(id);
        return orderPayment;
    }
}