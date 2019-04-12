package com.cskaoyan.service;

import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUserId(int userid) {

        User user = userMapper.findByUserId(userid);
        return user;
    }

    @Override
    public User findByUserName(String username) {
        User user = userMapper.findByUserName(username);
        return user;
    }

    @Override
    public int insertUser(String username, String password) {
        int i = userMapper.insertUser(username, password);
        return i;
    }
}
