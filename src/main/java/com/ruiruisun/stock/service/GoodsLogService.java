package com.ruiruisun.stock.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.bean.GoodsLogDayBean;
import com.ruiruisun.stock.bean.OrderGoodsDayBean;
import com.ruiruisun.stock.entity.Goods;
import com.ruiruisun.stock.entity.GoodsLog;
import com.ruiruisun.stock.mapper.GoodsLogMapper;
import com.ruiruisun.stock.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsLogService {
    @Autowired
    GoodsLogMapper goodsLogMapper;

    @Autowired
    GoodsMapper goodsMapper;

    public List<GoodsLog> findAll() {
        List<GoodsLog> goodsLog = new ArrayList<>();
        goodsLog = goodsLogMapper.findAll();
        return goodsLog;
    }

    public GoodsLog findOne(int id) {
        GoodsLog goodsLog = goodsLogMapper.findOne(id);
        return goodsLog;
    }

    public PageInfo<GoodsLog> findPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<GoodsLog> goodsLogList = goodsLogMapper.findAll();
        PageInfo<GoodsLog> pageInfo = new PageInfo<>(goodsLogList);
        return pageInfo;
    }

    public PageInfo<GoodsLog> findPageByGoodsId(int goods_id, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<GoodsLog> goodsLogList = goodsLogMapper.findAllByGoodsId(goods_id);
        PageInfo<GoodsLog> pageInfo = new PageInfo<>(goodsLogList);
        return pageInfo;
    }

    @Transactional
    public int create(GoodsLog goodsLog) {
        Goods goods = new Goods();
        goods.setId(goodsLog.getGoods_id());
//        goods.setPrice(goodsLog.getPrice());
        goods.setAmount(goodsLog.getAmount());
        goodsMapper.updateAmountAndPrice(goods);

        goodsLogMapper.create(goodsLog);
        int id = goodsLog.getId();
        return id;
    }

    public int update(GoodsLog goodsLog) {
        int rows = goodsLogMapper.update(goodsLog);
        return rows;
    }

    public int delete(GoodsLog goodsLog) {
        Goods goods = new Goods();
        goods.setId(goodsLog.getGoods_id());
        goods.setAmount(goodsLog.getAmount());
        goodsMapper.updateAmount(goods);

        int rows = goodsLogMapper.delete(goodsLog);
        return rows;
    }

    public PageInfo<GoodsLogDayBean> day(String date, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<GoodsLogDayBean> goodsLogDayList = new ArrayList<>();
        goodsLogDayList = goodsLogMapper.day(date);
        PageInfo<GoodsLogDayBean> pageInfo = new PageInfo<>(goodsLogDayList);
        return pageInfo;
    }
}