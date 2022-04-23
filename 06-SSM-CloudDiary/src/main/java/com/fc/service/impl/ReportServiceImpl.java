package com.fc.service.impl;

import com.fc.dao.TbNoteMapper;
import com.fc.entity.TbNote;
import com.fc.entity.TbUser;
import com.fc.service.ReportService;
import com.fc.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private TbNoteMapper tbNoteMapper;

    @Override
    public ModelAndView info(ModelAndView mv) {
        mv.addObject("menu_page","report");
        mv.addObject("changePage","/report/info.jsp");
        mv.setViewName("/index.jsp");
        return mv;
    }

    @Override
    public ResultInfo month(HttpServletRequest req) {
        ResultInfo resultInfo;
        TbUser user = (TbUser) req.getSession().getAttribute("user");
        if (user!=null){
            List<String> months = tbNoteMapper.months(user.getId());
            List<Integer> dataArrays = tbNoteMapper.arr(user.getId());
            Map<String, Object> map = new HashMap<>();
            map.put("monthArray",months);
            map.put("dataArray",dataArrays);
            resultInfo = new ResultInfo(1,"查询成功",map);
        }else {
            resultInfo = new ResultInfo(0,"查询失败",null);
        }


        return resultInfo;
    }

    @Override
    public ResultInfo location(HttpServletRequest req) {
        ResultInfo resultInfo;
        TbUser user = (TbUser) req.getSession().getAttribute("user");
        if (user!=null){
            List<TbNote> list = tbNoteMapper.location(user.getId());
            resultInfo = new ResultInfo(1,"成功",list);
        }else {
            resultInfo = new ResultInfo(0,"查询失败",null);

        }

        return resultInfo;
    }
}
