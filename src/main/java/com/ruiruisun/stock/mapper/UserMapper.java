package com.ruiruisun.stock.mapper;

import com.ruiruisun.stock.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAll();

    User findByUsername(String username);

    User findOne(int id);

    int update(User user);
}
