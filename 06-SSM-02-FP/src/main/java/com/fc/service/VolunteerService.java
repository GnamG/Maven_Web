package com.fc.service;

import com.fc.entity.Alleviation;
import com.fc.entity.VolunteerRecruitment;
import com.fc.vo.ResultVo;

import java.util.Date;

public interface VolunteerService {
    ResultVo getList(Long id,Integer pageNum, Integer pageSize);

    ResultVo add(VolunteerRecruitment volunteerRecruitment);

    ResultVo update(VolunteerRecruitment volunteerRecruitment);

    ResultVo delete(Long id);

    ResultVo click(Long id, Date lastClickTime);
}
