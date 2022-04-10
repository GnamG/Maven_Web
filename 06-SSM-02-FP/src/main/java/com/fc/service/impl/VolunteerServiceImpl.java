package com.fc.service.impl;

import com.fc.dao.VolunteerRecruitmentMapper;
import com.fc.entity.Alleviation;
import com.fc.entity.VolunteerRecruitment;
import com.fc.service.VolunteerService;
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
public class VolunteerServiceImpl implements VolunteerService {
    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;
    @Override
    public ResultVo getList(Long id, Integer pageNum, Integer pageSize) {
        List<VolunteerRecruitment> list = new ArrayList<>();
        PageHelper.startPage(pageNum,pageSize);
        if (id==null) {
            list = volunteerRecruitmentMapper.selectByExample(null);
        } else {
            VolunteerRecruitment volunteerRecruitment = volunteerRecruitmentMapper.selectByPrimaryKey(id);
            if (volunteerRecruitment!=null){
                list.add(volunteerRecruitment);
                click(volunteerRecruitment.getId(),new Date());
            }
        }
        PageInfo<VolunteerRecruitment> pageInfo = new PageInfo<>(list);
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
    public ResultVo add(VolunteerRecruitment volunteerRecruitment) {
        if (volunteerRecruitment.getCreateTime() == null){
            volunteerRecruitment.setCreateTime(new Date());
        }
        volunteerRecruitment.setClickNum(0);
        volunteerRecruitment.setLastClickTime(null);
        int rows = volunteerRecruitmentMapper.insertSelective(volunteerRecruitment);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,volunteerRecruitment);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }

    @Override
    public ResultVo update(VolunteerRecruitment volunteerRecruitment) {
        int rows = volunteerRecruitmentMapper.updateByPrimaryKeySelective(volunteerRecruitment);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,volunteerRecruitment);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
        int rows = volunteerRecruitmentMapper.deleteByPrimaryKey(id);
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
        int rows = volunteerRecruitmentMapper.click(id, lastClickTime);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,null);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }
}
