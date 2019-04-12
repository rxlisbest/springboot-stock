package com.ruiruisun.stock.mapper;

import com.ruiruisun.stock.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    List<UserRole> findUserApiRole(int user_id, String uri);
}
