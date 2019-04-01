package com.ruiruisun.stock.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.bean.OrderGoodsDayBean;
import com.ruiruisun.stock.bean.OrderPaymentBean;
import com.ruiruisun.stock.bean.OrderPaymentBuyerBean;
import com.ruiruisun.stock.bean.OrderPaymentDayBean;
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
}