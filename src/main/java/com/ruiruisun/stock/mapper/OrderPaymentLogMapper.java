package com.ruiruisun.stock.mapper;

import com.ruiruisun.stock.entity.OrderPaymentLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderPaymentLogMapper {

    List<OrderPaymentLog> findAll();

    OrderPaymentLog findOne(int id);

}
