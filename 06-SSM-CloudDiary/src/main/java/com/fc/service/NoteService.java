package com.fc.service;

import com.fc.entity.TbNote;
import com.fc.vo.ResultInfo;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface NoteService {
    ModelAndView view(ModelAndView mv, Integer noteId, HttpServletRequest req);

    ModelAndView detail(ModelAndView mv, Integer id);

    ResultInfo delete(Integer id);

    ModelAndView addOrUpdate(TbNote tbNote);
}
