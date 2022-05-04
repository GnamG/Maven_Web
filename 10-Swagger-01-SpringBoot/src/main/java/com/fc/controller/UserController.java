package com.fc.controller;

import com.fc.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
@Api(value = "user controller",description = "用户相关的所有操作")
public class UserController {
    @GetMapping("findAll")
    @ApiOperation("查询所有的用户")
    public Map<String, Object> findAll(){
        Map<String, Object>map = new HashMap<>();

        map.put("code",200);
        map.put("message","查询成功");
        map.put("success",true);
        map.put("data",new User(1,"易烊千玺","123456"));
        return map;
    }


    @DeleteMapping("delete")
    @ApiOperation("删除学生")
    public String delete(@ApiParam(name = "id" ,value = "用户编号"
    ,defaultValue = "默认值为100，能够查询id为100的用户",
    example = "100"
    ,allowableValues = "range[1,100]") @RequestParam("id") Integer id){
        System.out.println("delete user:" + id);

        return "delete user:" + id;
    }
    @PutMapping("update")
    @ApiOperation("修改学生")
    public String update(){
        return "update user";
    }


    @PostMapping("add")
    @ApiOperation("添加学生")
    public String add(){
        return "add user";
    }

    @GetMapping("getUser")
    @ApiOperation("获取学生")
    public User getUser(){
        return new User(1,"易烊千玺","123456");
    }
}
