package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public ResultVo add(User user) {
        if (user.getCreateTime()== null){
            user.setCreateTime(new Date());
        }


            int rows = userMapper.insertSelective(user);

        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("OK",200,true,user);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo del(Long id) {
        int rows = userMapper.deleteByPrimaryKey(id);
        ResultVo resultVo;
        if (rows > 0){
            resultVo = new ResultVo("OK",200,true,null);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo up(User user) {
        int rows = userMapper.updateByPrimaryKeySelective(user);
        ResultVo resultVo;
        if (rows>0) {
            User result = userMapper.selectByPrimaryKey(user.getId());
            resultVo = new ResultVo("OK",200,true,result);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);
        }

        return resultVo;
    }



    @Override
    public ResultVo list(Long id,Integer pageNum , Integer pageSize) {

        List<User> list = new ArrayList<>();
        PageHelper.startPage(pageNum,pageSize);
        ResultVo resultVo ;
        try {
            if (id==null){
                list = userMapper.selectByExample(null);
            } else {
                User user = userMapper.selectByPrimaryKey(id);
                if (user!=null) {
                    list.add(user);
                } else {
                    return new ResultVo("fail",404,false,null);
                }
            }
            PageInfo<User> pageInfo = new PageInfo<>(list);
            DataVo<User> dataVo = new DataVo<>(pageInfo.getTotal(),list,pageNum,pageSize);
            resultVo = new ResultVo("OK",200,true,dataVo);
        } catch (Exception e) {
            resultVo = new ResultVo("fail",404,false,null);
        }


        return resultVo;
    }

    @Override
    public long count() {
        return userMapper.countByExample(null);
    }

}
