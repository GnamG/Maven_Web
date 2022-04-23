package com.fc.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

public interface IndexService {
    ModelAndView page(HttpSession session,ModelAndView mv, HttpServletRequest req, Integer id, String title, String date, Integer pageNum, Integer pageSize);

    ModelAndView searchTitle(ModelAndView mv, String title);

    ModelAndView searchDate(ModelAndView mv, String date);

    ModelAndView searchType(ModelAndView mv, Integer id);
}
