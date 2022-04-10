package com.fc.service.impl;

import com.fc.dao.AlleviationMapper;
import com.fc.entity.Alleviation;
import com.fc.service.AlleviationService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class AlleviationServiceImpl implements AlleviationService {
    @Autowired
    private AlleviationMapper alleviationMapper;

    @Override
    public ResultVo getList(Long id, Integer pageNum, Integer pageSize) {
        List<Alleviation> list = new ArrayList<>();
        ResultVo resultVo;
        PageHelper.startPage(pageNum,pageSize);
        try {

            if (id == null){
                list = alleviationMapper.selectByExample(null);
            }else {
                Alleviation alleviation = alleviationMapper.selectByPrimaryKey(id);

                if (alleviation!=null){

                    list.add(alleviation);
                    click(alleviation.getId(),null);
                }else {
                    return new ResultVo("Fail",404,false,null);
                }

            }
            PageInfo<Alleviation> pageInfo = new PageInfo<>(list);
            DataVo<Alleviation> dataVo = new DataVo<>(pageInfo.getTotal(),list,pageNum,pageSize);
            resultVo = new ResultVo("OK",200,true,dataVo);
        } catch (Exception e){
            resultVo = new ResultVo("Fail",404,false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo add(Alleviation alleviation) {
        if (alleviation.getReleaseTime()==null){
            alleviation.setReleaseTime(new Date());
        }
        if (alleviation.getCreateTime() == null) {
            alleviation.setCreateTime(new Date());
        }

        // 刚出炉的政策
        alleviation.setClickNum(0);
        alleviation.setLastClickTime(null);

        int rows = alleviationMapper.insertSelective(alleviation);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,alleviation);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }

    @Override
    public ResultVo update(Alleviation alleviation) {
        int rows = alleviationMapper.updateByPrimaryKeySelective(alleviation);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,alleviation);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
        int rows = alleviationMapper.deleteByPrimaryKey(id);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,null);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }

    @Override
    public ResultVo click(Long id,Date lastClickTime) {
        int rows = alleviationMapper.click(id, new Date());
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,null);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }

}
