package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Map<String, Object> add(User user){
        int rows = userService.add(user);
        Map<String, Object> map = new HashMap<>();
        if(rows>0){
            map.put("message","用户添加成功！");
            map.put("code",200);
            map.put("success",true);
            map.put("data",user);
        }else {
            map.put("message","用户添加失败！");
            map.put("code",400);
            map.put("success",false);
            map.put("data",map.put("errMsg","错误描述"));
        }
        return map;
    }
    @RequestMapping("del")
    public Map<String, Object> del(String id){

        int rows = userService.del(id);
        Map<String, Object> map = new HashMap<>();

        if(rows>0){
            map.put("message","删除成功！");
            map.put("code",200);
            map.put("success",true);
            map.put("data","");
        }else {
            map.put("message","删除失败！");
            map.put("code",400);
            map.put("success",false);
            map.put("data",map.put("errMsg","错误描述"));
        }
        return map;
    }
    @RequestMapping("update")
    public Map<String, Object> up(User user){
        Map<String, Object> map = new HashMap<>();
        int rows = userService.up(user);
        if(rows>0){
            map.put("message","用户修改！");
            map.put("code",200);
            map.put("success",true);
            map.put("data","");
        }else {
            map.put("message","用户修改！");
            map.put("code",404);
            map.put("success",false);
            map.put("data",map.put("errMsg","错误描述"));
        }

        return map;
    }
    @RequestMapping("list")
    public Map<String, Object> list(Integer id){

        List<User> list = userService.list(id);

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> pageMap = new HashMap<>();
        PageInfo<User> pageInfo = new PageInfo<>(list);

        if(!list.isEmpty()){
            map.put("message","用户获取成功！");
            map.put("code",200);
            map.put("success",true);
            pageMap.put("total",userService.count());
            pageMap.put("list",list);
            pageMap.put("pageNum",pageInfo.getPageNum());
            pageMap.put("pageSize",pageInfo.getPageSize());
            map.put("data",pageMap);
        }else {
            map.put("message","用户获取失败！");
            map.put("code",404);
            map.put("success",false);
            map.put("data",map.put("errMsg","错误描述"));
        }
        return map;
    }

}
