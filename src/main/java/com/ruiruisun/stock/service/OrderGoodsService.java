package com.ruiruisun.stock.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.bean.OrderGoodsDayBean;
import com.ruiruisun.stock.entity.OrderGoods;
import com.ruiruisun.stock.mapper.OrderGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderGoodsService {
    @Autowired
    OrderGoodsMapper orderGoodsMapper;

    public List<OrderGoods> findAll() {
        List<OrderGoods> orderGoods = new ArrayList<>();
        orderGoods = orderGoodsMapper.findAll();
        return orderGoods;
    }

    public List<OrderGoods> findAllByOrderId(Integer order_id) {
        List<OrderGoods> orderGoods = new ArrayList<>();
        orderGoods = orderGoodsMapper.findAllByOrderId(order_id);
        return orderGoods;
    }

    public PageInfo<OrderGoodsDayBean> day(String date, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<OrderGoodsDayBean> orderGoodsDayList = new ArrayList<>();
        orderGoodsDayList = orderGoodsMapper.day(date);
        PageInfo<OrderGoodsDayBean> pageInfo = new PageInfo<>(orderGoodsDayList);
        return pageInfo;
    }

    public OrderGoods findOne(int id) {
        OrderGoods orderGoods = orderGoodsMapper.findOne(id);
        return orderGoods;
    }

    public PageInfo<OrderGoods> findPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<OrderGoods> orderGoodsList = orderGoodsMapper.findAll();
        PageInfo<OrderGoods> pageInfo = new PageInfo<>(orderGoodsList);
        return pageInfo;
    }

    public int create(OrderGoods orderGoods) {
        orderGoodsMapper.create(orderGoods);
        int id = orderGoods.getId();
        return id;
    }

    public int delete(OrderGoods orderGoods) {
        int rows = orderGoodsMapper.delete(orderGoods);
        return rows;
    }
}