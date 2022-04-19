package com.fc.service.impl;

import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.entity.TbUserExample;
import com.fc.service.UserService;
import com.fc.vo.ResultInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper tbUserMapper;
    @Override
    public ModelAndView login(HttpServletRequest req, HttpServletResponse resp) {
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        criteria.andUsernameEqualTo(req.getParameter("username"));
        criteria.andPasswordEqualTo(req.getParameter("password"));
        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
        ModelAndView mv = new ModelAndView();
        ResultInfo resultInfo;
        Map<String,String> map = new HashMap<>();
        HttpSession session = req.getSession();
        Cookie cookie = new Cookie("JSESSIONID","");
        if (req.getParameter("remember")==null){
            cookie.setMaxAge(0);
        }else {
            map.put("username",req.getParameter("username"));
            map.put("password",req.getParameter("password"));

            cookie = new Cookie("JSESSIONID",session.getId());
            cookie.setMaxAge(60*30);
            resp.addCookie(cookie);
        }
        if(!tbUsers.isEmpty()){

            session.setAttribute("user",tbUsers.get(0));
            //  mv.addObject("user",tbUsers.get(0));

            resultInfo = new ResultInfo(200,"登录成功",map);
            mv.addObject("resultInfo",resultInfo);
            mv.setViewName("forward:/index/page");
        }else {
            resultInfo = new ResultInfo(0,"登录失败，用户名或密码错误",map);
            mv.addObject("resultInfo",resultInfo);
            mv.setViewName("/login.jsp");
        }
        return mv;
    }

    @Override
    public ModelAndView logout(HttpServletRequest req, HttpServletResponse resp) {
        ModelAndView mv = new ModelAndView("redirect:/login.jsp");
        HttpSession session = req.getSession(false);
        session.removeAttribute("user");
        Cookie cookie = new Cookie("JSESSIONID", "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        return mv;
    }

    @Override
    public ModelAndView userCenter(HttpServletRequest req, HttpServletResponse resp) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("menu_page","user");
        mv.addObject("changePage","/user/info.jsp");
        mv.setViewName("/index.jsp");
        return mv;
    }

    @Override
    public ModelAndView updateUser(MultipartFile img , HttpServletRequest req, TbUser user) {
        ModelAndView mv = new ModelAndView("redirect:/user/userCenter");
        HttpSession session = req.getSession();
        if(img.getSize()>0){
            String path = "D:/idea_code/06-SSM-CloudDiary/src/main/webapp/WEB-INF/upload";

            File file = new File(path);

            String fileName = img.getOriginalFilename();

            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSS");

            String formatDate = format.format(new Date());

            String suffix = null;
            if (fileName != null) {
                suffix = fileName.substring(fileName.lastIndexOf("."));
            }

            fileName = formatDate + suffix;

            try {
                img.transferTo(new File(file,fileName));

                user.setHead(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //  更新
        tbUserMapper.updateByPrimaryKeySelective(user);
        // 根据id获取用户
        TbUser tbUser = tbUserMapper.selectByPrimaryKey(user.getId());
        // 重新放到Session
        session.setAttribute("user",tbUser);

        return mv;
    }

    @Override
    public String checkNick(String nick) {
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        criteria.andNickEqualTo(nick);
        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
        String Json;
        if (!tbUsers.isEmpty()){
            Json = "0";
        }else {
            Json = "1";         //"{\"code\":\"1\"}";
        }
        return Json;
    }
}
