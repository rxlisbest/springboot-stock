package com.ruiruisun.stock.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.entity.GoodsCategory;
import com.ruiruisun.stock.mapper.GoodsCategoryMapper;
import com.ruiruisun.stock.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsCategoryService {
    @Autowired
    GoodsCategoryMapper goodsCategoryMapper;

    public List<GoodsCategory> findAll() {
        List<GoodsCategory> goodsCategory = new ArrayList<>();
        goodsCategory = goodsCategoryMapper.findAll();
        return goodsCategory;
    }

    public List<GoodsCategory> findAllByName(String name, Integer id) {
        List<GoodsCategory> goodsCategory = new ArrayList<>();
        goodsCategory = goodsCategoryMapper.findAllByName(name, id);
        return goodsCategory;
    }

    public GoodsCategory findOne(int id) {
        GoodsCategory goodsCategory = goodsCategoryMapper.findOne(id);
        return goodsCategory;
    }

    public PageInfo<GoodsCategory> findPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<GoodsCategory> goodsCategoryList = goodsCategoryMapper.findAll();
        PageInfo<GoodsCategory> pageInfo = new PageInfo<>(goodsCategoryList);
        return pageInfo;
    }

    public int create(GoodsCategory goodsCategory) {
        goodsCategoryMapper.create(goodsCategory);
        int id = goodsCategory.getId();
        return id;
    }

    public int update(GoodsCategory goodsCategory) {
        int rows = goodsCategoryMapper.update(goodsCategory);
        return rows;
    }

    public int delete(GoodsCategory goodsCategory) {
        int rows = goodsCategoryMapper.delete(goodsCategory);
        return rows;
    }
}