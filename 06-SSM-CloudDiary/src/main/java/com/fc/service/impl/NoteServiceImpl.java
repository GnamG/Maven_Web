package com.fc.service.impl;

import com.fc.dao.TbNoteMapper;
import com.fc.entity.TbNote;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbUser;
import com.fc.service.NoteService;
import com.fc.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private TbNoteMapper tbNoteMapper;

    @Override
    public ModelAndView view(ModelAndView mv, Integer noteId, HttpServletRequest req) {

        if (noteId!=null){
            TbNote tbNote = tbNoteMapper.selectByPrimaryKey(noteId);
            mv.addObject("noteInfo",tbNote);

        }
        HttpSession session = req.getSession();
        TbUser user = (TbUser) session.getAttribute("user");
        List<TbNoteType> type = tbNoteMapper.type(user.getId());
        mv.addObject("typeList",type);
        mv.addObject("changePage","/note/view.jsp");
        mv.setViewName("/index.jsp");
        return mv;
    }

    @Override
    public ModelAndView detail(ModelAndView mv, Integer id) {
        TbNote tbNote = tbNoteMapper.selectByPrimaryKey(id);
        tbNote.setTypeName(tbNoteMapper.typeName(id));
        mv.addObject("note",tbNote);
        mv.addObject("changePage","/note/detail.jsp");
        mv.setViewName("/index.jsp");
        return mv;
    }

    @Override
    public ResultInfo delete(Integer id) {
        ResultInfo resultInfo;
        int rows = tbNoteMapper.deleteByPrimaryKey(id);
        if (rows>0){
            resultInfo = new ResultInfo(1,"删除成功",null);
        } else {
            resultInfo = new ResultInfo(0,"删除成功",null);
        }
        return resultInfo;
    }

    @Override
    public ModelAndView addOrUpdate(TbNote tbNote) {
        ModelAndView mv = new ModelAndView("redirect:/index/page");
        int rows = 0;

        // 有id修改
        if(tbNote.getId() != null){
            rows = tbNoteMapper.updateByPrimaryKeySelective(tbNote);

            // 添加
        }else {
            tbNote.setPubTime(new Date());
            rows = tbNoteMapper.insertSelective(tbNote);
        }

       if(rows==0){
        ResultInfo resultInfo = new ResultInfo(404,"失败",tbNote);
        mv.addObject("resultInfo",resultInfo);
        mv.addObject("id",tbNote.getId());
        mv.setViewName("/note/view");
       }
        return mv;
    }
}
