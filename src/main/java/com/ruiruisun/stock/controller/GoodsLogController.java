package com.ruiruisun.stock.controller;

import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.bean.PaginationBean;
import com.ruiruisun.stock.entity.GoodsLog;
import com.ruiruisun.stock.exception.BadRequestException;
import com.ruiruisun.stock.exception.NotFoundException;
import com.ruiruisun.stock.service.GoodsLogService;
import com.ruiruisun.stock.utils.LocaleMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@ResponseBody
@RestController
@RequestMapping(value = "goods_logs")
public class GoodsLogController {
    @Resource
    private GoodsLogService goodsLogService;

    @Autowired
    PaginationBean paginationBean;

    @GetMapping("/index")
    public PageInfo<GoodsLog> index(HttpServletRequest request, Integer page, Integer goods_id) throws Exception {
        if (page == null) {
            page = 1;
        }
        if (goods_id == null) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods_log.goods_id_empty"));
        }
        PageInfo<GoodsLog> goodsLogList = goodsLogService.findPageByGoodsId(goods_id, page, paginationBean.getPageSize());
        return goodsLogList;
    }

    @PostMapping(value = "/create")
    public int create(@RequestBody GoodsLog request) throws Exception {
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
        GoodsLog goodsLog = request;
        int id = goodsLogService.create(goodsLog);
        return id;
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable int id) throws Exception {
        GoodsLog goodsLog = goodsLogService.findOne(id);
        if (goodsLog == null) {
            throw new NotFoundException(LocaleMessageUtils.getMsg("goods_log.not_exists"));
        }
        int rows = goodsLogService.delete(goodsLog);
        return rows;
    }
}
