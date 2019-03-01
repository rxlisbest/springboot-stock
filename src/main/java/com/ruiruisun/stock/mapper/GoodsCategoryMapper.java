package com.ruiruisun.stock.mapper;

import com.ruiruisun.stock.entity.GoodsCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsCategoryMapper {

    List<GoodsCategory> all();

    int create(GoodsCategory goodsCategory);
}
