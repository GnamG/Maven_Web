package com.fc.controller;

import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.entity.User;
import com.fc.service.MessageBoardService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msgboard")
public class MessageBoardController {
    @Autowired
    private MessageBoardService messageBoardService;

    @RequestMapping("add")
    public ResultVo add(@RequestBody MessageBoardWithBLOBs messageBoardWithBLOBs){
        return messageBoardService.add(messageBoardWithBLOBs);
    }
    @RequestMapping("del")
    public ResultVo del(Long id){

        return messageBoardService.delete(id);
    }
    @RequestMapping("update")
    public ResultVo up(@RequestBody MessageBoardWithBLOBs messageBoardWithBLOBs){

        return messageBoardService.update(messageBoardWithBLOBs);
    }
    @RequestMapping("getlist")
    public ResultVo list(Long id, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize){

        return messageBoardService.getList(id,pageNum,pageSize);
    }
}
