package com.ruiruisun.stock.mapper;

import com.ruiruisun.stock.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findByUsername(String username);

    User findOne(int id);

    int update(User user);
}
