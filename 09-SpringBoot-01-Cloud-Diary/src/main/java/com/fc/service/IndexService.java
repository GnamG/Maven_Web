package com.fc.service;

import com.fc.entity.TbNote;
import com.fc.vo.NoteVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IndexService {
    PageInfo<TbNote> page(Integer userId, Integer id, String title, String date, Integer pageNum, Integer pageSize);


    List<NoteVO> findDateInfo(Integer userId);

    List<NoteVO> findTypeInfo(Integer userId);
}
