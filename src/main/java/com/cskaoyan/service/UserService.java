package com.cskaoyan.service;

import com.cskaoyan.bean.User;

public interface UserService {

    User findByUserId(int userid);
}
