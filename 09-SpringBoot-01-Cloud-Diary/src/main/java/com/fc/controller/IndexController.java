package com.fc.controller;

import com.fc.entity.TbNote;
import com.fc.entity.TbUser;
import com.fc.service.IndexService;
import com.fc.vo.NoteVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("index")
public class IndexController {
    @Autowired
    private IndexService indexService;
    @RequestMapping(value ="page", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView page(Integer id,
                             String title,
                             String date,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "5") Integer pageSize,
                             HttpSession session,
                             ModelAndView mv){
        // 获取域对象
        TbUser user = (TbUser) session.getAttribute("user");

        Integer userId = user.getId();
// 所有的日记
        PageInfo<TbNote> pageInfo = indexService.page(userId,id,title,date,pageNum,pageSize);
        mv.addObject("page", pageInfo);

//        // 获取所有日记的日期分类
//        List<NoteVO> dateInfo = indexService.findDateInfo(userId);
//
//        session.setAttribute("dateInfo", dateInfo);
//
//        // 获取所有日记的类别
//        List<NoteVO> typeInfo = indexService.findTypeInfo(userId);
//        session.setAttribute("typeInfo", typeInfo);

        if (id != null) {
            mv.addObject("typeId", id);
        }

        if (title != null && !title.equals("")) {
            mv.addObject("title", title);
        }

        if (date != null && !date.equals("")) {
            mv.addObject("date", date);
        }

        mv.addObject("changePage", "/note/list.jsp");
        mv.addObject("menu_page", "index");

        mv.setViewName("forward:/index.jsp");

        return mv;
    }

}
