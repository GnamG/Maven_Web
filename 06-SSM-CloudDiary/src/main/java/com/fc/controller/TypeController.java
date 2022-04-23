package com.fc.controller;

import com.fc.entity.TbNoteType;
import com.fc.service.TypeService;
import com.fc.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("type")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @GetMapping("list")
    public ModelAndView list(ModelAndView mv, HttpServletRequest req){
        return typeService.list(mv,req);
    }
    @PostMapping("addOrUpdate")
    public ResultInfo addOrUpdate(HttpSession session, TbNoteType type){
        return typeService.addOrUpdate(session,type);
    }
    @GetMapping("delete")
    public ResultInfo delete(Integer id){
        return typeService.delete(id);
    }
}
