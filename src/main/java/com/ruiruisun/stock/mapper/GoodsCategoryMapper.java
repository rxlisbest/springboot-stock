package com.ruiruisun.stock.mapper;

import com.ruiruisun.stock.entity.GoodsCategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsCategoryMapper {
    GoodsCategory all();
}
