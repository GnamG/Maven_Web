package com.fc.service.impl;

import com.fc.dao.MessageBoardMapper;
import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;

import com.fc.service.MessageBoardService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class MessageBoardServiceImpl implements MessageBoardService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;

    @Override
    public ResultVo getList(Long id, Integer pageNum, Integer pageSize) {
        List<MessageBoard> list = new ArrayList<>();
        PageHelper.startPage(pageNum,pageSize);
        if (id==null) {
            list = messageBoardMapper.selectByExample(null);
        } else {
            MessageBoard messageBoard = messageBoardMapper.selectByPrimaryKey(id);
            if (messageBoard!=null){
                list.add(messageBoard);
            }
        }
        PageInfo<MessageBoard> pageInfo = new PageInfo<>(list);
        ResultVo resultVo;
        if (!list.isEmpty()){
            DataVo dataVo = new DataVo(pageInfo.getTotal(),list,pageNum,pageSize);
            resultVo = new ResultVo("Ok",200,true,dataVo);
        } else {
            resultVo = new ResultVo("Fail",404,false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo add(MessageBoardWithBLOBs messageBoardWithBLOBs) {
        if (messageBoardWithBLOBs.getCreateTime() == null){
            messageBoardWithBLOBs.setCreateTime(new Date());
        }
        int rows = messageBoardMapper.insertSelective(messageBoardWithBLOBs);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,messageBoardWithBLOBs);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }

    @Override
    public ResultVo update(MessageBoardWithBLOBs messageBoardWithBLOBs) {
        int rows = messageBoardMapper.updateByPrimaryKeySelective(messageBoardWithBLOBs);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,messageBoardWithBLOBs);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
        int rows = messageBoardMapper.deleteByPrimaryKey(id);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,null);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }
}
