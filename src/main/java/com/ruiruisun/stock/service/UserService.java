package com.ruiruisun.stock.service;

import com.ruiruisun.stock.entity.User;
import com.ruiruisun.stock.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User Sel(int id) {
        User t = null;
        t = userMapper.Sel(id);
        return t;
    }
}