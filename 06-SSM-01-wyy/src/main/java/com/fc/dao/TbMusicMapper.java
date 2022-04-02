package com.fc.dao;

import com.fc.entity.TbMusic;
import com.fc.entity.TbMusicExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TbMusicMapper {

    Integer findMaxId();

    Integer findMinId();
    long countByExample(TbMusicExample example);

    int deleteByExample(TbMusicExample example);

    int deleteByPrimaryKey(Integer musicId);

    int insert(TbMusic row);

    int insertSelective(TbMusic row);

    List<TbMusic> selectByExample(TbMusicExample example);

    TbMusic selectByPrimaryKey(Integer musicId);

    int updateByExampleSelective(@Param("row") TbMusic row, @Param("example") TbMusicExample example);

    int updateByExample(@Param("row") TbMusic row, @Param("example") TbMusicExample example);

    int updateByPrimaryKeySelective(TbMusic row);

    int updateByPrimaryKey(TbMusic row);
}