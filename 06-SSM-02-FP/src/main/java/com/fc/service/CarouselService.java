package com.fc.service;

import com.fc.entity.Carousel;
import com.fc.vo.ResultVo;

import java.util.List;

public interface CarouselService {
    ResultVo getList(Integer id,Integer pageNum,Integer pageSize);


    ResultVo add(Carousel carousel);

    ResultVo update(Carousel carousel);

    ResultVo delete(Integer id);
}
