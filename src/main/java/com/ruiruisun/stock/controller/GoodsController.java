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
import java.util.List;

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
        String name = request.getParameter("name");
        name = name != null ? name : "";
        if (page == null) {
            page = 1;
        }
        PageInfo<Goods> goodsList = goodsService.findPageByName(name, page, paginationBean.getPageSize());
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
        String name = request.getName();
        Integer goodsCategoryId = request.getGoods_category_id();
        Float price = request.getPrice();
        Float discountPrice = request.getDiscount_price();
        Float amount = request.getAmount();
        String unit = request.getUnit();
        if (name == null || name.length() == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods.name_empty"));
        }
        if (goodsCategoryId == null || goodsCategoryId == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods.goods_category_id_empty"));
        }
        if (price == null) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods.price_empty"));
        }
        if (discountPrice == null) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods.discount_price_empty"));
        }
        if (amount == null) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods.amount_empty"));
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
        Integer goodsCategoryId = request.getGoods_category_id();
        Float price = request.getPrice();
        Float discountPrice = request.getDiscount_price();
        Float amount = request.getAmount();
        String unit = request.getUnit();
        if (name == null || name.length() == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods.name_empty"));
        }
        if (goodsCategoryId == null || goodsCategoryId == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods.goods_category_id_empty"));
        }
        if (price == null || price == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods.price_empty"));
        }
        if (discountPrice == null || discountPrice == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods.discount_price_empty"));
        }
        if (amount == null || amount == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods.amount_empty"));
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
        goods.setDiscount_price(request.getDiscount_price());
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

    @GetMapping("/repeat")
    public List<Goods> repeat(Integer id, String name) throws Exception {
        name = name != null ? name : "";
        id = id != null ? id : 0;
        List<Goods> goodsList = goodsService.findAllByName(name, id);
        return goodsList;
    }

    @GetMapping("/all")
    public List<Goods> all(Integer goods_category_id) throws Exception {
        goods_category_id = goods_category_id != null ? goods_category_id : 0;
        List<Goods> goodsList = goodsService.findAllByGoodsCategoryId(goods_category_id);
        return goodsList;
    }
}
