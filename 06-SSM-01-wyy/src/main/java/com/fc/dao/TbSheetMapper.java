package com.fc.dao;

import com.fc.entity.TbMusic;
import com.fc.entity.TbSheet;
import com.fc.entity.TbSheetExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbSheetMapper {
    List<TbMusic> findSongsBySheet(@Param("sheetName") String sheetName);

    long countByExample(TbSheetExample example);

    int deleteByExample(TbSheetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSheet row);

    int insertSelective(TbSheet row);

    List<TbSheet> selectByExample(TbSheetExample example);

    TbSheet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TbSheet row, @Param("example") TbSheetExample example);

    int updateByExample(@Param("row") TbSheet row, @Param("example") TbSheetExample example);

    int updateByPrimaryKeySelective(TbSheet row);

    int updateByPrimaryKey(TbSheet row);
}