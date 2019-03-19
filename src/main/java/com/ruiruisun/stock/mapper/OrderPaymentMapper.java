package com.ruiruisun.stock.mapper;

import com.ruiruisun.stock.entity.OrderPayment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderPaymentMapper {

    List<OrderPayment> all();

    OrderPayment findOne(int id);

}
