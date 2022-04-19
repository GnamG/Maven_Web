package com.fc.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface IndexService {
    ModelAndView page(ModelAndView mv, HttpServletRequest req, Integer id, String title, String date, Integer pageNum, Integer pageSize);
}
