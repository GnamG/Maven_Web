package com.fc.service;

import com.fc.vo.ResultInfo;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface ReportService {

    ModelAndView info(ModelAndView mv);

    ResultInfo month(HttpServletRequest req);

    ResultInfo location(HttpServletRequest req);
}
