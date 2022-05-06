package com.fc.dao;

import com.fc.entity.TbNoteType;
import com.fc.entity.TbNoteTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbNoteTypeMapper {
    int IsCount(@Param("id") Integer id);
    long countByExample(TbNoteTypeExample example);

    int deleteByExample(TbNoteTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbNoteType record);

    int insertSelective(TbNoteType record);

    List<TbNoteType> selectByExample(TbNoteTypeExample example);

    TbNoteType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbNoteType record, @Param("example") TbNoteTypeExample example);

    int updateByExample(@Param("record") TbNoteType record, @Param("example") TbNoteTypeExample example);

    int updateByPrimaryKeySelective(TbNoteType record);

    int updateByPrimaryKey(TbNoteType record);
}