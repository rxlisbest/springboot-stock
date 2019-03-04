package com.ruiruisun.stock.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.entity.Buyer;
import com.ruiruisun.stock.mapper.BuyerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuyerService {
    @Autowired
    BuyerMapper buyerMapper;

    public List<Buyer> findAll() {
        List<Buyer> buyer = new ArrayList<>();
        buyer = buyerMapper.findAll();
        return buyer;
    }

    public Buyer findOne(int id) {
        Buyer buyer = buyerMapper.findOne(id);
        return buyer;
    }

    public PageInfo<Buyer> findPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Buyer> buyerList = buyerMapper.findAll();
        PageInfo<Buyer> pageInfo = new PageInfo<>(buyerList);
        return pageInfo;
    }

    public int create(Buyer buyer) {
        buyerMapper.create(buyer);
        int id = buyer.getId();
        return id;
    }

    public int update(Buyer buyer) {
        int rows = buyerMapper.update(buyer);
        return rows;
    }

    public int delete(Buyer buyer) {
        int rows = buyerMapper.delete(buyer);
        return rows;
    }
}