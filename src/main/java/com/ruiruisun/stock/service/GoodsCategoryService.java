package com.ruiruisun.stock.service;

import com.ruiruisun.stock.entity.GoodsCategory;
import com.ruiruisun.stock.mapper.GoodsCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsCategoryService {
    @Autowired
    GoodsCategoryMapper goodsCategoryMapper;

    public GoodsCategory all(String username) {
        GoodsCategory goodsCategory = null;
        goodsCategory = goodsCategoryMapper.all();
        return goodsCategory;
    }
}