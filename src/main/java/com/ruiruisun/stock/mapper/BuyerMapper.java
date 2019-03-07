package com.ruiruisun.stock.mapper;

import com.ruiruisun.stock.entity.Buyer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuyerMapper {

    List<Buyer> findAll();

    List<Buyer> findPageByName(String name);

    List<Buyer> findAllByName(String name, Integer id);

    Buyer findOne(int id);

    int create(Buyer buyer);

    int update(Buyer buyer);

    int delete(Buyer buyer);
}
