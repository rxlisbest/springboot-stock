package com.ruiruisun.stock.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.entity.GoodsCategory;
import com.ruiruisun.stock.service.GoodsCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
}
