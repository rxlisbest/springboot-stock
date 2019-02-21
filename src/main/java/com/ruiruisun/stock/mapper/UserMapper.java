package com.ruiruisun.stock.mapper;

import com.ruiruisun.stock.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User Sel(int id);
}
