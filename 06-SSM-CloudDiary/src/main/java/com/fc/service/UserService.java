package com.fc.service;

import com.fc.entity.TbUser;
import com.fc.vo.ResultInfo;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    ModelAndView login(HttpServletRequest req, HttpServletResponse resp);

    ModelAndView logout(HttpServletRequest req, HttpServletResponse resp);

    ModelAndView userCenter(HttpServletRequest req, HttpServletResponse resp);

    ModelAndView updateUser(MultipartFile img ,HttpServletRequest req, TbUser user);

    String checkNick(String nick);
}
