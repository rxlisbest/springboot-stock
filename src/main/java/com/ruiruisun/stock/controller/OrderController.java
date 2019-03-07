package com.ruiruisun.stock.controller;

import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.bean.CreateOrderBean;
import com.ruiruisun.stock.bean.OrderMonthBean;
import com.ruiruisun.stock.bean.PaginationBean;
import com.ruiruisun.stock.entity.Order;
import com.ruiruisun.stock.exception.NotFoundException;
import com.ruiruisun.stock.service.OrderService;
import com.ruiruisun.stock.utils.LocaleMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@ResponseBody
@RestController
@RequestMapping(value = "orders")
public class OrderController {
    @Resource
    private OrderService orderService;

    @Autowired
    PaginationBean paginationBean;

    @GetMapping("/index")
    public PageInfo<Order> index(Integer page) throws Exception {
        if (page == null) {
            page = 1;
        }
        PageInfo<Order> orderList = orderService.findPage(page, paginationBean.getPageSize());
        return orderList;
    }

    @GetMapping("/view/{id}")
    public Order view(@PathVariable int id) throws Exception {
        Order goodsCategory = orderService.findOne(id);
        if (goodsCategory == null) {
            throw new NotFoundException(LocaleMessageUtils.getMsg("order.not_exists"));
        }
        return goodsCategory;
    }

    @PostMapping(value = "/create")
    public int create(@RequestBody CreateOrderBean request) throws Exception {
        int id = orderService.create(request);
        return id;
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable int id) throws Exception {
        Order order = orderService.findOne(id);
        if (order == null) {
            throw new NotFoundException(LocaleMessageUtils.getMsg("order.not_exists"));
        }
        int rows = orderService.delete(order);
        return rows;
    }

    @GetMapping("/month")
    public List<OrderMonthBean> month(String year) {
        if (year == null) {
            DateFormat format = new SimpleDateFormat("yyyy");
            Date today = new Date();
            year = format.format(today);
        }
        Map<String, Float> yearData = new LinkedHashMap<String, Float>();
        for (int i = 1; i <= 12; i++) {
            String month = String.format("%s-%02d", year, i);
            yearData.put(month, (float) 0);
        }
        System.out.println(yearData);
        List<OrderMonthBean> orderMonthList = orderService.month(year);
        orderMonthList.forEach(item -> {
            yearData.put(item.getMonth(), item.getTotal());
        });
        List<OrderMonthBean> data = new ArrayList<OrderMonthBean>();
        yearData.forEach((k, v) -> {
            OrderMonthBean orderMonthBean = new OrderMonthBean();
            orderMonthBean.setMonth(k);
            orderMonthBean.setTotal(v);
            data.add(orderMonthBean);
        });
        return data;
    }
}
