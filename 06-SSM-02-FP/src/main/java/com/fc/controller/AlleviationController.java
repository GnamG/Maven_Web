package com.fc.controller;

import com.fc.entity.Alleviation;
import com.fc.entity.Carousel;
import com.fc.service.AlleviationService;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.*;

@RestController
@RequestMapping("alleviation")
public class AlleviationController {
    @Autowired
    private AlleviationService alleviationService;
    @RequestMapping("getlist")
    public ResultVo getList(Long id, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,@RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize){
        return alleviationService.getList(id,pageNum,pageSize);
    }

    @RequestMapping("add")
    public ResultVo add(@RequestBody Alleviation alleviation){
        return alleviationService.add(alleviation);
    }
    @RequestMapping("update")
    public ResultVo update(@RequestBody Alleviation alleviation) {
        return alleviationService.update(alleviation);
    }

    @RequestMapping("del")
    public ResultVo delete(Long id) {
        return alleviationService.delete(id);
    }

    @PostMapping("click")
    public ResultVo click(Long id, Date lastClickNum){
        return alleviationService.click(id,lastClickNum);
    }

}
