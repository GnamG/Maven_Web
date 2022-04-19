package com.fc.service.impl;

import com.fc.dao.TbUserMapper;
import com.fc.entity.TbNote;
import com.fc.entity.TbUser;
import com.fc.service.IndexService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private TbUserMapper tbUserMapper;
    @Override
    public ModelAndView page(ModelAndView mv, HttpServletRequest req, Integer id, String title, String date, Integer pageNum, Integer pageSize) {
        TbUser user = (TbUser) req.getSession().getAttribute("user");
        PageHelper.startPage(pageNum,pageSize);
        List<TbNote> list = tbUserMapper.getList(user.getId());
        PageInfo<TbNote> pageInfo = new PageInfo<>(list);
//        HashMap<String, Object> dateInfo = new HashMap<>();
//
//        List<Integer> noteCount = tbUserMapper.noteCount(user.getId());
//        dateInfo.put("noteCount",noteCount);
//        dateInfo.put("groupName","02");
//        mv.addObject("dateInfo",dateInfo);
        mv.addObject("page",pageInfo);
        mv.addObject("menu_page","index");
        mv.addObject("changePage","/note/list.jsp");
        mv.setViewName("/index.jsp");
        return mv;
    }
}
