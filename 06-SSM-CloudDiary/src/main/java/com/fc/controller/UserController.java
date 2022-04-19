package com.fc.controller;

import com.fc.entity.TbUser;
import com.fc.service.UserService;
import com.fc.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("login")
    public ModelAndView login(HttpServletRequest req, HttpServletResponse resp){
       return userService.login(req,resp);
    }
    @GetMapping("logout")
    public ModelAndView logout(HttpServletRequest req,HttpServletResponse resp){
        return userService.logout(req,resp);
    }

    @GetMapping("userCenter")
    public ModelAndView userCenter(HttpServletRequest req, HttpServletResponse resp){
        return userService.userCenter(req,resp);
    }

    @PostMapping("update")
    public ModelAndView updateUser(MultipartFile img, HttpServletRequest req, TbUser user){
        return userService.updateUser(img,req,user);
    }



    @GetMapping(value = "checkNick",produces = "application/json;charset = UTF-8")
    @ResponseBody
    public String checkNick(String nick){
        return userService.checkNick(nick);

    }

}
