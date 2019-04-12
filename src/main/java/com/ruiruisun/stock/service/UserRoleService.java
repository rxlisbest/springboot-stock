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

    public List<UserRole> findUserApiRole(Integer user_id, String uri) {
        List<UserRole> userRoleList = userRoleMapper.findUserApiRole(user_id, uri);
        return userRoleList;
    }

    public List<UserRole> findAllByUserId(Integer user_id) {
        List<UserRole> userRoleList = userRoleMapper.findAllByUserId(user_id);
        return userRoleList;
    }
}