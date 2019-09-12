package com.ruiruisun.stock.controller;

import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.bean.*;
import com.ruiruisun.stock.entity.OrderPayment;
import com.ruiruisun.stock.service.OrderPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ResponseBody
@RestController
@RequestMapping(value = "order_payments")
public class OrderPaymentController {
    @Resource
    private OrderPaymentService orderPaymentService;

    @Autowired
    PaginationBean paginationBean;

    @GetMapping("/index")
    public PageInfo<OrderPaymentBuyerBean> index(String date, Integer page, Integer payment_id) throws Exception {
        if (date == null) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date today = new Date();
            date = format.format(today);
        }
        if (page == null) {
            page = 1;
        }
        if (payment_id == null) {
            payment_id = 0;
        }
        PageInfo<OrderPaymentBuyerBean> goodsList = orderPaymentService.findPageByCondition(date, payment_id, page, paginationBean.getPageSize());
        return goodsList;
    }

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

    @GetMapping("/user_day")
    public List<Map> userDay(String date) throws Exception {
        if (date == null) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date today = new Date();
            date = format.format(today);
        }
        List<Map> orderPaymentList = orderPaymentService.userDay(date);
        return orderPaymentList;
    }

    @GetMapping("/all")
    public List<OrderPaymentBean> all(Integer order_id) throws Exception {
        order_id = order_id != null ? order_id : 0;
        List<OrderPaymentBean> orderPaymentList = orderPaymentService.findAllByOrderId(order_id);
        return orderPaymentList;
    }

    @GetMapping("/buyer_debt")
    public PageInfo<BuyerDebtBean> buyerDebt(String name, Integer page) throws Exception {
        if (page == null) {
            page = 1;
        }
        name = name != null ? name : "";
        PageInfo<BuyerDebtBean> orderPaymentList = orderPaymentService.findBuyerDebt(name, page, paginationBean.getPageSize());
        return orderPaymentList;
    }
}
