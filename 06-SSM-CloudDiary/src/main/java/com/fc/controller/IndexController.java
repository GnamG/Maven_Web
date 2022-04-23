package com.fc.controller;

import com.fc.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("index")
public class IndexController {
    @Autowired
    private IndexService indexService;

    @RequestMapping ("page")
    public ModelAndView page(HttpSession session,ModelAndView mv, HttpServletRequest req, Integer id, String title, String date,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "3") Integer pageSize){
        return indexService.page(session,mv,req,id,title,date,pageNum,pageSize);

    }
    @GetMapping("searchTitle")
    public ModelAndView searchTitle(ModelAndView mv,String title){
        return indexService.searchTitle(mv,title);
    }
    @GetMapping("searchDate")
    public ModelAndView searchDate(ModelAndView mv, String date){
        return indexService.searchDate(mv,date);
    }
    @GetMapping("searchType")
    public ModelAndView searchType(ModelAndView mv, Integer id){
        return indexService.searchType(mv,id);
    }
}
