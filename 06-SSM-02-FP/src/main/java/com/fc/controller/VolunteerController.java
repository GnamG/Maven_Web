package com.fc.controller;

import com.fc.entity.Collection;
import com.fc.entity.VolunteerRecruitment;
import com.fc.service.VolunteerService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("volunteer")
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService;
    @GetMapping("getlist")
    public ResultVo getList(Long id, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize){
        return volunteerService.getList(id,pageNum,pageSize);
    }
    @PostMapping("add")
    public ResultVo add(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return volunteerService.add(volunteerRecruitment);
    }
    @PostMapping("update")
    public ResultVo update(@RequestBody VolunteerRecruitment volunteerRecruitment) {
        return volunteerService.update(volunteerRecruitment);
    }

    @GetMapping("del")
    public ResultVo delete(Long id) {
        return volunteerService.delete(id);
    }

    @PostMapping("click")
    public ResultVo click(Long id, Date lastClickTime){
        return volunteerService.click(id,lastClickTime);
    }
}
