package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user) {
      return userMapper.insertSelective(user);
    }

    @Override
    public int del(String id) {
        long userId = Long.parseLong(id);

        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int up(User user) {

        return userMapper.updateByPrimaryKey(user);
    }



    @Override
    public List<User> list(Integer id) {
        List<User> list = new ArrayList<>();
        PageHelper.startPage(1,3);
        if (id==null){
            list = userMapper.selectByExample(null);
        } else {
            Long ids = id.longValue();
            User user = userMapper.selectByPrimaryKey(ids);
            if (user!=null){
                list.add(user);
            }
        }

        return list;
    }

    @Override
    public long count() {

        return userMapper.countByExample(null);
    }

}
