package com.fc.controller;

import com.fc.entity.Alleviation;
import com.fc.entity.Carousel;
import com.fc.entity.User;
import com.fc.service.AlleviationService;
import com.fc.service.CarouselService;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;
    @GetMapping("getlist")
    public ResultVo getList(Integer id, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,@RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize){
        return carouselService.getList(id,pageNum,pageSize);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody Carousel carousel){
        return carouselService.add(carousel);
    }
    @PostMapping("update")
    public ResultVo update(@RequestBody Carousel carousel) {
        return carouselService.update(carousel);
    }

    @GetMapping("del")
    public ResultVo delete(Integer id) {
        return carouselService.delete(id);
    }
}
