package com.ruiruisun.stock.service;

import com.ruiruisun.stock.entity.UserRole;
import com.ruiruisun.stock.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;

    public List<UserRole> findUserApiRole(int user_id, String uri) {
        List<UserRole> userRole = userRoleMapper.findUserApiRole(user_id, uri);
        return userRole;
    }
}