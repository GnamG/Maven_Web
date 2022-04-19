package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.util.JwtUtil;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("add")
    public ResultVo add(@RequestBody User user){
        return userService.add(user);
    }
    @GetMapping("delete")
    public ResultVo del(Long id){

        return userService.del(id);
    }
    @PostMapping("update")
    public ResultVo up(@RequestBody User user){

        return userService.up(user);
    }
    @GetMapping("getlist")
    public ResultVo list(User user, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize){

        return userService.list(user,pageNum,pageSize);
    }
    @PostMapping("login")
    public ResultVo login(String username, String password) {

        return userService.login(username,password);
    }
}
