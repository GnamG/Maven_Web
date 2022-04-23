package com.fc.controller;

import com.fc.service.ReportService;
import com.fc.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("report")
public class reportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("info")
    public ModelAndView info(ModelAndView mv){
        return reportService.info(mv);
    }

    @GetMapping("month")
    public ResultInfo month(HttpServletRequest req){
        return reportService.month(req);
    }

    @GetMapping("location")
    public ResultInfo location(HttpServletRequest req){
       return reportService.location(req);
    }

}
