package com.fc.service.impl;

import com.fc.dao.PoorMapper;

import com.fc.entity.Poor;

import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
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
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;
    @Override
    public ResultVo getList(Long id, Integer pageNum, Integer pageSize) {
        List<Poor> list = new ArrayList<>();
        PageHelper.startPage(pageNum,pageSize);
        if (id==null) {
            list = poorMapper.selectByExample(null);
        } else {
            PoorWithBLOBs poor = poorMapper.selectByPrimaryKey(id);
            if (poor!=null){
                list.add(poor);
            }
        }
        PageInfo<Poor> pageInfo = new PageInfo<>(list);
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
    public ResultVo add(PoorWithBLOBs poor) {
        if (poor.getCreateTime() == null){
            poor.setCreateTime(new Date());
        }
        poor.setClickNum(0);
        poor.setLastClickTime(null);
        int rows = poorMapper.insertSelective(poor);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,poor);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }

    @Override
    public ResultVo update(PoorWithBLOBs poor) {
        int rows = poorMapper.updateByPrimaryKeySelective(poor);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,poor);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
        int rows = poorMapper.deleteByPrimaryKey(id);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,null);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }

    @Override
    public ResultVo click(Long id, Date lastClickTime) {
        int rows = poorMapper.click(id, lastClickTime);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,null);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }
}
