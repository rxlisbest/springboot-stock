package com.ruiruisun.stock.mapper;

import com.ruiruisun.stock.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {

    List<Payment> all();

    Payment findOne(int id);

}
