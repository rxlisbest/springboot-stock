package com.ruiruisun.stock.controller;

import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.bean.OrderGoodsDayBean;
import com.ruiruisun.stock.bean.PaginationBean;
import com.ruiruisun.stock.entity.OrderGoods;
import com.ruiruisun.stock.exception.BadRequestException;
import com.ruiruisun.stock.service.OrderGoodsService;
import com.ruiruisun.stock.utils.LocaleMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ResponseBody
@RestController
@RequestMapping(value = "order_goods")
public class OrderGoodsController {
    @Resource
    private OrderGoodsService orderGoodsService;

    @Autowired
    PaginationBean paginationBean;

    @GetMapping("/all")
    public List<OrderGoods> all(Integer order_id) throws Exception {
        if (order_id == null) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("order_goods.order_id_empty"));
        }
        List<OrderGoods> orderGoodsList = orderGoodsService.findAllByOrderId(order_id);
        return orderGoodsList;
    }

    @GetMapping("/day")
    public PageInfo<OrderGoodsDayBean> day(String date, Integer page) throws Exception {
        if (page == null) {
            page = 1;
        }
        if (date == null) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date today = new Date();
            date = format.format(today);
        }
        PageInfo<OrderGoodsDayBean> orderGoodsDayList = orderGoodsService.day(date, page, paginationBean.getPageSize());
        return orderGoodsDayList;
    }

    @PostMapping(value = "/create")
    public int create(@RequestBody OrderGoods request) throws Exception {
        String name = request.getName();
        Integer goodsId = request.getGoods_id();
        Float price = request.getPrice();
        Float amount = request.getAmount();
        if (name == null || name.length() == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods.name_empty"));
        }
        if (goodsId == null || goodsId == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods_log.goods_id_empty"));
        }
        if (price == null) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods.price_empty"));
        }
        if (amount == null) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods.amount_empty"));
        }
        OrderGoods orderGoods = request;
        int id = orderGoodsService.create(orderGoods);
        return id;
    }
}
