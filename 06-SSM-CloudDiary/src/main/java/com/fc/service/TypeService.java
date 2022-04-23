package com.fc.service;

import com.fc.entity.TbNoteType;
import com.fc.vo.ResultInfo;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface TypeService {

    ModelAndView list(ModelAndView mv, HttpServletRequest req);

    ResultInfo addOrUpdate(HttpSession session,TbNoteType type);

    ResultInfo delete(Integer id);
}
