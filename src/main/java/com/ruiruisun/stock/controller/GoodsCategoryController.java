package com.ruiruisun.stock.controller;

import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.bean.PaginationBean;
import com.ruiruisun.stock.entity.Goods;
import com.ruiruisun.stock.entity.GoodsCategory;
import com.ruiruisun.stock.exception.BadRequestException;
import com.ruiruisun.stock.exception.ForbiddenException;
import com.ruiruisun.stock.exception.NotFoundException;
import com.ruiruisun.stock.service.GoodsCategoryService;
import com.ruiruisun.stock.service.GoodsService;
import com.ruiruisun.stock.utils.LocaleMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ResponseBody
@RestController
@RequestMapping("goods_categories")
public class GoodsCategoryController {
    @Resource
    private GoodsCategoryService goodsCategoryService;

    @Resource
    private GoodsService goodsService;

    @Autowired
    PaginationBean paginationBean;

    @GetMapping("/index")
    public PageInfo<GoodsCategory> index(HttpServletRequest request, Integer page) throws Exception {
        if (page == null) {
            page = 1;
        }
        PageInfo<GoodsCategory> goodsCategoryList = goodsCategoryService.findPage(page, paginationBean.getPageSize());
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
    public int create(@RequestBody Goods request) throws Exception {
        String name = request.getName();
        if (name == null || name.length() == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("goods_category.name_empty"));
        }
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setName(name);
        int id = goodsCategoryService.create(goodsCategory);
        return id;
    }

    @PutMapping("/update/{id}")
    public int update(@RequestBody Goods request, @PathVariable int id) throws Exception {
        String name = request.getName();
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

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable int id) throws Exception {
        GoodsCategory goodsCategory = goodsCategoryService.findOne(id);
        if (goodsCategory == null) {
            throw new NotFoundException(LocaleMessageUtils.getMsg("goods_category.not_exists"));
        }
        List<Goods> goodsList = goodsService.findAllByGoodsCategoryId(id);
        if (goodsList.size() > 0) {
            throw new ForbiddenException(LocaleMessageUtils.getMsg("goods_category.has_goods_can_not_delete"));
        }

        int rows = goodsCategoryService.delete(goodsCategory);
        return rows;
    }

    @GetMapping("/all")
    public List<GoodsCategory> all() throws Exception {
        List<GoodsCategory> goodsCategoryList = goodsCategoryService.findAll();
        return goodsCategoryList;
    }

    @GetMapping("/repeat")
    public List<GoodsCategory> repeat(HttpServletRequest request, Integer id, String name) throws Exception {
        name = name != null ? name : "";
        id = id != null ? id : 0;
        List<GoodsCategory> goodsCategoryList = goodsCategoryService.findAllByName(name, id);
        return goodsCategoryList;
    }
}
