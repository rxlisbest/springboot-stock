package com.ruiruisun.stock.service;

import com.ruiruisun.stock.entity.User;
import com.ruiruisun.stock.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User findByUsername(String username) {
        User User = null;
        User = userMapper.findByUsername(username);
        return User;
    }
}