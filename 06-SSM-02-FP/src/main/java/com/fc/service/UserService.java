package com.fc.service;

import com.fc.entity.User;

import java.util.List;

public interface UserService {
    int add(User user);

    int del(String id);

    int up(User user);
    List<User> list(Integer id);

    long count();
}
