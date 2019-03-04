package com.ruiruisun.stock.controller;

import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.bean.PaginationBean;
import com.ruiruisun.stock.entity.Goods;
import com.ruiruisun.stock.exception.BadRequestException;
import com.ruiruisun.stock.exception.NotFoundException;
import com.ruiruisun.stock.service.GoodsService;
import com.ruiruisun.stock.utils.LocaleMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@ResponseBody
@RestController
@RequestMapping(value = "goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @Autowired
    PaginationBean paginationBean;

    @GetMapping("/index")
    public PageInfo<Goods> index(HttpServletRequest request, Integer page) throws Exception {
        if (page == null) {
            page = 1;
        }
        PageInfo<Goods> goodsList = goodsService.findPage(page, paginationBean.getPageSize());
        return goodsList;
    }

    @GetMapping("/view/{id}")
    public Goods view(@PathVariable int id) throws Exception {
        Goods goods = goodsService.findOne(id);
        if (goods == null) {
            throw new NotFoundException(LocaleMessageUtils.getMsg("goods.not_exists"));
        }
        return goods;
    }

    @PostMapping(value = "/create")
    public int create(@RequestBody Goods request) throws Exception {
        int goodsCategoryId = request.getGoods_category_id();
        String name = request.getName();
        String unit = request.getUnit();
        if (name == null || name.length() == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods.name_empty"));
        }
        if (unit == null || unit.length() == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods.unit_empty"));
        }
        Goods goods = request;
        int id = goodsService.create(goods);
        return id;
    }

    @PutMapping("/update/{id}")
    public int update(@RequestBody Goods request, @PathVariable int id) throws Exception {
        String name = request.getName();
        String unit = request.getUnit();
        if (name == null || name.length() == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods.name_empty"));
        }
        if (unit == null || unit.length() == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods.unit_empty"));
        }
        Goods goods = goodsService.findOne(id);
        if (goods == null) {
            throw new NotFoundException(LocaleMessageUtils.getMsg("goods.not_exists"));
        }
        goods.setName(request.getName());
        goods.setGoods_category_id(request.getGoods_category_id());
        goods.setAmount(request.getAmount());
        goods.setPrice(request.getPrice());
        goods.setUnit(request.getUnit());
        int rows = goodsService.update(goods);
        return rows;
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable int id) throws Exception {
        Goods goods = goodsService.findOne(id);
        if (goods == null) {
            throw new NotFoundException(LocaleMessageUtils.getMsg("goods.not_exists"));
        }
        int rows = goodsService.delete(goods);
        return rows;
    }
}
