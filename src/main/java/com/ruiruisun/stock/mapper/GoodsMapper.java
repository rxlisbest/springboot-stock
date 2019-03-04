package com.ruiruisun.stock.mapper;

import com.ruiruisun.stock.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {

    List<Goods> findAll();

    Goods findOne(int id);

    int create(Goods goods);

    int update(Goods goods);

    int delete(Goods goods);
}
