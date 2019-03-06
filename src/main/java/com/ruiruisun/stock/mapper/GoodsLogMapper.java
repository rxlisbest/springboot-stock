package com.ruiruisun.stock.mapper;

import com.ruiruisun.stock.entity.GoodsLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsLogMapper {

    List<GoodsLog> findAll();

    List<GoodsLog> findAllByGoodsId(int goods_id);

    GoodsLog findOne(int id);

    int create(GoodsLog goods);

    int update(GoodsLog goods);

    int delete(GoodsLog goods);
}
