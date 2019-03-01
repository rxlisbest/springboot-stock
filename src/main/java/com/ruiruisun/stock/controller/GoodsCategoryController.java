package com.ruiruisun.stock.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.entity.GoodsCategory;
import com.ruiruisun.stock.exception.BadRequestException;
import com.ruiruisun.stock.exception.NotFoundException;
import com.ruiruisun.stock.service.GoodsCategoryService;
import com.ruiruisun.stock.utils.LocaleMessageUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("goods_category")
public class GoodsCategoryController {
    @Resource
    private GoodsCategoryService goodsCategoryService;

    @GetMapping("/index")
    public PageInfo<GoodsCategory> index(HttpServletRequest request) throws Exception {
        PageInfo<GoodsCategory> goodsCategoryList = goodsCategoryService.findPage(1, 2);
        return goodsCategoryList;
    }

    @GetMapping("/view/{id}")
    public GoodsCategory view(HttpServletRequest request, @PathVariable int id) throws Exception {
        GoodsCategory goodsCategory = goodsCategoryService.findOne(id);
        if (goodsCategory == null) {
            throw new NotFoundException(LocaleMessageUtils.getMsg("goods_category.not_exists"));
        }
        return goodsCategory;
    }

    @PostMapping("/create")
    public int create(HttpServletRequest request) throws Exception {
        String name = request.getParameter("name");
        if (name == null || name.length() == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods_category.name_empty"));
        }
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setName(name);
        int id = goodsCategoryService.create(goodsCategory);
        return id;
    }

    @PutMapping("/update/{id}")
    public int update(HttpServletRequest request, @PathVariable int id) throws Exception {
        String name = request.getParameter("name");
        if (name == null || name.length() == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods_category.name_empty"));
        }
        GoodsCategory goodsCategory = goodsCategoryService.findOne(id);
        if (goodsCategory == null) {
            throw new NotFoundException(LocaleMessageUtils.getMsg("goods_category.not_exists"));
        }
        goodsCategory.setName(name);
        int rows = goodsCategoryService.update(goodsCategory);
        return rows;
    }
}
