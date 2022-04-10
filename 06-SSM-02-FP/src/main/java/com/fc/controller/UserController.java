package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("add")
    public ResultVo add(@RequestBody User user){
        return userService.add(user);
    }
    @RequestMapping("del")
    public ResultVo del(Long id){

        return userService.del(id);
    }
    @RequestMapping("update")
    public ResultVo up(@RequestBody User user){

        return userService.up(user);
    }
    @RequestMapping("getlist")
    public ResultVo list(Long id, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize){

        return userService.list(id,pageNum,pageSize);
    }

}
