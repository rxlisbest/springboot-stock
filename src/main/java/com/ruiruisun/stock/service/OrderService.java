package com.ruiruisun.stock.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.bean.CartGoodsBean;
import com.ruiruisun.stock.bean.CreateOrderBean;
import com.ruiruisun.stock.bean.OrderMonthBean;
import com.ruiruisun.stock.bean.OrderPaymentBean;
import com.ruiruisun.stock.entity.Goods;
import com.ruiruisun.stock.entity.Order;
import com.ruiruisun.stock.entity.OrderGoods;
import com.ruiruisun.stock.entity.OrderPayment;
import com.ruiruisun.stock.mapper.GoodsMapper;
import com.ruiruisun.stock.mapper.OrderGoodsMapper;
import com.ruiruisun.stock.mapper.OrderMapper;
import com.ruiruisun.stock.mapper.OrderPaymentMapper;
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

    @Autowired
    OrderPaymentMapper orderPaymentMapper;

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
    public int create(int userId, CreateOrderBean data) {
        Order order = data.getOrder();
        order.setUser_id(userId);
        orderMapper.create(order);
        int id = order.getId();
        List<CartGoodsBean> cartGoods = data.getCart();
        List<OrderPaymentBean> payments = data.getPayments();
        cartGoods.forEach(item -> {
            OrderGoods orderGoods = new OrderGoods();
            orderGoods.setUser_id(userId);
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

        payments.forEach(item -> {
            if (item.getMoney() > 0) {
                OrderPayment orderPayment = new OrderPayment();
                orderPayment.setBuyer_id(order.getBuyer_id());
                orderPayment.setUser_id(userId);
                orderPayment.setOrder_id(id);
                orderPayment.setMoney(item.getMoney());
                orderPayment.setPayment_id(item.getId());
                orderPayment.setPayment_type(item.getType());
                orderPaymentMapper.create(orderPayment);
            }
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

    public List<OrderMonthBean> month(String year) {
        List<OrderMonthBean> orderList = new ArrayList<>();
        orderList = orderMapper.month(year);
        return orderList;
    }
}