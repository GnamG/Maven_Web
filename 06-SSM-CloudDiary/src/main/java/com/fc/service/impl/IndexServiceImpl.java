package com.fc.service.impl;

import com.fc.dao.TbNoteMapper;
import com.fc.dao.TbUserMapper;
import com.fc.entity.TbNote;
import com.fc.entity.TbNoteExample;
import com.fc.entity.TbUser;
import com.fc.service.IndexService;

import com.fc.vo.Info;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private TbNoteMapper tbNoteMapper;
    @Override
    public ModelAndView page(HttpSession session, ModelAndView mv, HttpServletRequest req, Integer id, String title, String date, Integer pageNum, Integer pageSize) {
        TbUser user = (TbUser) req.getSession().getAttribute("user");
        PageHelper.startPage(pageNum,pageSize);
        List<TbNote> list;
        list = tbNoteMapper.getList(user.getId());
        List<Info> dateInfo = tbNoteMapper.dateInfo(user.getId());
        List<Info> typeInfo = tbNoteMapper.typeInfo(user.getId());
        TbNoteExample tbNoteExample = new TbNoteExample();
        TbNoteExample.Criteria criteria = tbNoteExample.createCriteria();

        if(title!=null&&!title.equals("")){
            // 不是自己的日记 缺少id判断
            criteria.andTitleLike("%"+title+"%");
            list = tbNoteMapper.selectByExample(tbNoteExample);
        } else if(id!=null){
            criteria.andTypeIdEqualTo(id);
            list = tbNoteMapper.selectByExample(tbNoteExample);
        } else if(date!=null&&!date.equals("")){

            list = tbNoteMapper.month(date,user.getId());
        }


        PageInfo<TbNote> pageInfo = new PageInfo<>(list);
        //mv.addObject("dateInfo",dateInfo);
        session.setAttribute("dateInfo",dateInfo);
        //mv.addObject("typeInfo",typeInfo);
        session.setAttribute("typeInfo",typeInfo);
        mv.addObject("page",pageInfo);
        mv.addObject("menu_page","index");
        mv.addObject("changePage","/note/list.jsp");
        mv.setViewName("/index.jsp");
        return mv;
    }

    @Override
    public ModelAndView searchTitle(ModelAndView mv, String title) {
        mv.addObject("title",title);
        mv.setViewName("/index/page");
        return mv;
    }

    @Override
    public ModelAndView searchDate(ModelAndView mv, String date) {
        mv.addObject("pubTime",date);
        mv.setViewName("/index/page");
        return mv;
    }

    @Override
    public ModelAndView searchType(ModelAndView mv, Integer id) {
        mv.addObject("id",id);
        mv.setViewName("/index/page");
        return mv;
    }
}
