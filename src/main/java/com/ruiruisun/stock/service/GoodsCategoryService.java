package com.ruiruisun.stock.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.entity.GoodsCategory;
import com.ruiruisun.stock.mapper.GoodsCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsCategoryService {
    @Autowired
    GoodsCategoryMapper goodsCategoryMapper;

    public List<GoodsCategory> all() {
        List<GoodsCategory> goodsCategory = new ArrayList<>();
        goodsCategory = goodsCategoryMapper.all();
        return goodsCategory;
    }

    public PageInfo<GoodsCategory> findPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<GoodsCategory> goodsCategoryList = goodsCategoryMapper.all();
        PageInfo<GoodsCategory> pageInfo = new PageInfo<>(goodsCategoryList);
        return pageInfo;
    }
}