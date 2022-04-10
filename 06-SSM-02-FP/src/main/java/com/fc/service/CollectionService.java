package com.fc.service;

import com.fc.entity.Carousel;
import com.fc.entity.Collection;
import com.fc.vo.ResultVo;

public interface CollectionService {
    ResultVo getList(Long id, Integer pageNum, Integer pageSize);

    ResultVo add(Collection collection);

    ResultVo update(Collection collection);

    ResultVo delete(Long id);
}
