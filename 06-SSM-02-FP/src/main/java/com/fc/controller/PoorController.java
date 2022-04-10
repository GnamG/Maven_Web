package com.fc.controller;

import com.fc.dao.PoorMapper;
import com.fc.entity.MessageBoard;
import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("poor")
public class PoorController {
    @Autowired
    private PoorService poorService;

    @PostMapping("add")
    public ResultVo add(@RequestBody PoorWithBLOBs poor){
        return poorService.add(poor);
    }
    @GetMapping("del")
    public ResultVo del(Long id){

        return poorService.delete(id);
    }
    @PostMapping("update")
    public ResultVo up(@RequestBody PoorWithBLOBs poor){

        return poorService.update(poor);
    }
    @GetMapping("getlist")
    public ResultVo list(Long id, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize){

        return poorService.getList(id,pageNum,pageSize);
    }
    @PostMapping("click")
    public ResultVo click(Long id , Date lastClickTime) {
        return poorService.click(id,lastClickTime);

    }
}
