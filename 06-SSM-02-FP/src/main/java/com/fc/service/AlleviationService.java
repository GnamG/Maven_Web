package com.fc.service;

import com.fc.entity.Alleviation;
import com.fc.vo.ResultVo;
import org.apache.ibatis.annotations.Param;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

public interface AlleviationService {
   ResultVo getList(Long id, Integer pageNum, Integer pageSize);

   ResultVo add(Alleviation alleviation);

   ResultVo update(Alleviation alleviation);

   ResultVo delete(Long id);

    ResultVo click(Long id,  Date lastClickNum);
}
