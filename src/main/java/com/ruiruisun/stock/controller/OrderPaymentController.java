package com.ruiruisun.stock.controller;

import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.bean.*;
import com.ruiruisun.stock.entity.Order;
import com.ruiruisun.stock.entity.OrderPayment;
import com.ruiruisun.stock.exception.BadRequestException;
import com.ruiruisun.stock.exception.NotFoundException;
import com.ruiruisun.stock.service.OrderPaymentService;
import com.ruiruisun.stock.utils.LocaleMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
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

    private BigDecimal total;

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

    @GetMapping("/view/{id}")
    public OrderPayment view(@PathVariable int id) throws Exception {
        OrderPayment orderPayment = orderPaymentService.findOne(id);
        if (orderPayment == null) {
            throw new NotFoundException(LocaleMessageUtils.getMsg("goods.not_exists"));
        }
        return orderPayment;
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

    @GetMapping("/buyer_debt_detail")
    public PageInfo<OrderPaymentDebtBean> buyerDebtDetail(Integer buyer_id, Integer page) throws Exception {
        if (page == null) {
            page = 1;
        }
        PageInfo<OrderPaymentDebtBean> orderPaymentList = orderPaymentService.findBuyerDebtByBuyerId(buyer_id, page, paginationBean.getPageSize());
        return orderPaymentList;
    }

    @PostMapping(value = "/repay")
    public int repay(HttpServletRequest httpServletRequest, @RequestBody OrderPaymentRepayBean request) throws Exception {
        OrderPayment orderPayment = orderPaymentService.findOne(request.getOrderPaymentId());
        List<OrderPaymentBean> orderPaymentList = request.getPayments();
        total = new BigDecimal("0");
        orderPaymentList.forEach(item -> {
            BigDecimal money = new BigDecimal(Float.toString(item.getMoney()));
            total = total.add(money);
        });
        BigDecimal jsTotal = new BigDecimal(Float.toString(orderPayment.getMoney()));
        int result = jsTotal.compareTo(total);
        if (result == -1) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("order_payment.total_exceed_error"));
        }
        int id = orderPaymentService.repay(orderPayment, request);
        return id;
    }
}
