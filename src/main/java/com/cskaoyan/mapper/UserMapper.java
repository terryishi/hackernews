package com.cskaoyan.mapper;

import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findByUserId(int userid);

    User findByUserName(String username);

    int insertUser(String username, String password);
}
