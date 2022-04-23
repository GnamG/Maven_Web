package com.fc.controller;

import com.fc.entity.TbNote;
import com.fc.service.NoteService;
import com.fc.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("note")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @RequestMapping("view")
    public ModelAndView view(ModelAndView mv, Integer id, HttpServletRequest req){
        return noteService.view(mv,id,req);
    }

    @GetMapping("detail")
    public ModelAndView detail(ModelAndView mv,Integer id){
        return noteService.detail(mv,id);
    }
    @GetMapping("delete")
    public ResultInfo delete(Integer id){
        return noteService.delete(id);
    }


    @PostMapping("addOrUpdate")
    public ModelAndView addOrUpdate(TbNote tbNote){
        return noteService.addOrUpdate(tbNote);
    }

}
