package com.ruiruisun.stock.mapper;

import com.ruiruisun.stock.bean.OrderMonthBean;
import com.ruiruisun.stock.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<Order> findAll();

    Order findOne(int id);

    int create(Order goods);

    int delete(Order goods);

    List<OrderMonthBean> month(String year);
}
