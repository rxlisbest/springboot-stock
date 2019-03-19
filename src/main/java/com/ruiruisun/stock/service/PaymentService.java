package com.ruiruisun.stock.service;

import com.ruiruisun.stock.entity.Payment;
import com.ruiruisun.stock.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    PaymentMapper paymentMapper;

    public List<Payment> findAll() {
        List<Payment> paymentList = paymentMapper.findAll();
        return paymentList;
    }

    public Payment findOne(int id) {
        Payment payment = paymentMapper.findOne(id);
        return payment;
    }
}