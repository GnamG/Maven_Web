package com.fc.service.impl;

import com.fc.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDaoImpl implements UserService {
    @Override
    public void add() {
        System.out.println("添加一个用户");
    }

    @Override
    public void update() {
        System.out.println("更新用户信息");
    }
}
