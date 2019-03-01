package com.ruiruisun.stock.mapper;

import com.ruiruisun.stock.entity.GoodsCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsCategoryMapper {

    List<GoodsCategory> findAll();

    GoodsCategory findOne(int id);

    int create(GoodsCategory goodsCategory);

    int update(GoodsCategory goodsCategory);

    int delete(GoodsCategory goodsCategory);
}
