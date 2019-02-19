package com.ruiruisun.stock.mapper;

import com.ruiruisun.stock.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    User Sel(int id);
}
