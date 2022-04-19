package com.fc.controller;

import com.fc.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("index")
public class IndexController {
    @Autowired
    private IndexService indexService;

    @RequestMapping ("page")
    public ModelAndView page(ModelAndView mv,HttpServletRequest req, Integer id, String title, String date,
                             @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize){
        return indexService.page(mv,req,id,title,date,pageNum,pageSize);

    }

}
