package com.ruiruisun.stock.mapper;

import com.ruiruisun.stock.entity.OrderGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderGoodsMapper {

    List<OrderGoods> findAll();

    List<OrderGoods> findAllByOrderId(Integer order_id);

    OrderGoods findOne(int id);

    int create(OrderGoods goods);

    int delete(OrderGoods goods);
}
