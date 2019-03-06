package com.ruiruisun.stock.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.entity.Goods;
import com.ruiruisun.stock.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    public List<Goods> findAll() {
        List<Goods> goods = new ArrayList<>();
        goods = goodsMapper.findAll();
        return goods;
    }

    public List<Goods> findAllByName(String name, Integer id) {
        List<Goods> goods = new ArrayList<>();
        goods = goodsMapper.findAllByName(name, id);
        return goods;
    }

    public Goods findOne(int id) {
        Goods goods = goodsMapper.findOne(id);
        return goods;
    }

    public PageInfo<Goods> findPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Goods> goodsList = goodsMapper.findAll();
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        return pageInfo;
    }

    public int create(Goods goods) {
        goodsMapper.create(goods);
        int id = goods.getId();
        return id;
    }

    public int update(Goods goods) {
        int rows = goodsMapper.update(goods);
        return rows;
    }

    public int delete(Goods goods) {
        int rows = goodsMapper.delete(goods);
        return rows;
    }
}