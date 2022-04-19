package com.fc.service.impl;

import com.fc.dao.TbNoteMapper;
import com.fc.entity.TbNote;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbUser;
import com.fc.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
}
