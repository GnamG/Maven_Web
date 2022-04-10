package com.fc.service;

import com.fc.entity.User;
import com.fc.vo.ResultVo;

import java.util.List;

public interface UserService {
    ResultVo add(User user);

    ResultVo del(Long id);

    ResultVo up(User user);

    ResultVo list(Long id, Integer pageNum , Integer pageSize);

    long count();
}
