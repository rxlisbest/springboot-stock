package com.ruiruisun.stock.controller;

import com.ruiruisun.stock.entity.Payment;
import com.ruiruisun.stock.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@ResponseBody
@RestController
@RequestMapping(value = "payments")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/all")
    public List<Payment> all() throws Exception {
        List<Payment> paymentList = paymentService.findAll();
        return paymentList;
    }
}
