package com.ruiruisun.stock.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.bean.CartGoodsBean;
import com.ruiruisun.stock.bean.CreateOrderBean;
import com.ruiruisun.stock.entity.Goods;
import com.ruiruisun.stock.entity.Order;
import com.ruiruisun.stock.entity.OrderGoods;
import com.ruiruisun.stock.mapper.GoodsMapper;
import com.ruiruisun.stock.mapper.OrderGoodsMapper;
import com.ruiruisun.stock.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderGoodsMapper orderGoodsMapper;

    @Autowired
    GoodsMapper goodsMapper;

    public List<Order> findAll() {
        List<Order> Order = new ArrayList<>();
        Order = orderMapper.findAll();
        return Order;
    }

    public Order findOne(int id) {
        Order Order = orderMapper.findOne(id);
        return Order;
    }

    public PageInfo<Order> findPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Order> OrderList = orderMapper.findAll();
        PageInfo<Order> pageInfo = new PageInfo<>(OrderList);
        return pageInfo;
    }

    @Transactional
    public int create(CreateOrderBean data) {
        Order order = data.getOrder();
        orderMapper.create(order);
        int id = order.getId();
        List<CartGoodsBean> cartGoods = data.getCart();
        cartGoods.forEach(item -> {
            OrderGoods orderGoods = new OrderGoods();
            orderGoods.setGoods_id(item.getId());
            orderGoods.setName(item.getName());
            orderGoods.setOrder_id(id);
            orderGoods.setPrice(item.getPrice());
            orderGoods.setUnit(item.getUnit());
            orderGoods.setAmount(item.getOrder_amount());
            orderGoodsMapper.create(orderGoods);

            Goods goods = new Goods();
            goods.setAmount(item.getOrder_amount());
            goods.setId(item.getId());
            goodsMapper.updateAmount(goods);

        });
        return id;
    }

    @Transactional
    public int delete(Order Order) {
        int rows = orderMapper.delete(Order);
        List<OrderGoods> orderGoodsList =  orderGoodsMapper.findAllByOrderId(Order.getId());
        orderGoodsList.forEach(item -> {
            Goods goods = new Goods();
            goods.setId(item.getGoods_id());
            goods.setAmount(-item.getAmount());
            goodsMapper.updateAmount(goods);
            orderGoodsMapper.delete(item);
        });
        return rows;
    }
}