package com.ruiruisun.stock.controller;

import com.ruiruisun.stock.bean.OrderPaymentDayBean;
import com.ruiruisun.stock.entity.OrderPayment;
import com.ruiruisun.stock.service.OrderPaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ResponseBody
@RestController
@RequestMapping(value = "order_payments")
public class OrderPaymentController {
    @Resource
    private OrderPaymentService orderPaymentService;

    @GetMapping("/day")
    public List<OrderPaymentDayBean> day(String date) throws Exception {
        if (date == null) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date today = new Date();
            date = format.format(today);
        }
        List<OrderPaymentDayBean> orderPaymentList = orderPaymentService.day(date);
        return orderPaymentList;
    }
}
