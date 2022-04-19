package com.fc.service;

import com.fc.entity.TbNoteType;
import com.fc.vo.ResultInfo;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface TypeService {

    ModelAndView list(ModelAndView mv, HttpServletRequest req);

    ResultInfo addOrUpdate(TbNoteType type);

    ResultInfo delete(Integer id);
}
