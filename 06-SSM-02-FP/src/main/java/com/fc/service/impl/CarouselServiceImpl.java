package com.fc.service.impl;

import com.fc.dao.CarouselMapper;
import com.fc.entity.Alleviation;
import com.fc.entity.Carousel;
import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
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
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public ResultVo getList(Integer id, Integer pageNum, Integer pageSize) {
        List<Carousel> list = new ArrayList<>();
        ResultVo resultVo;
        PageHelper.startPage(pageNum,pageSize);
        try {

            if (id == null){
                list = carouselMapper.selectByExample(null);
            }else {
                Carousel carousel = carouselMapper.selectByPrimaryKey(id);
                if (carousel!=null){
                    list.add(carousel);
                }else {
                    return new ResultVo("Fail",404,false,null);
                }

            }
            PageInfo<Carousel> pageInfo = new PageInfo<>(list);
            DataVo<Carousel> dataVo = new DataVo<>(pageInfo.getTotal(),list,pageNum,pageSize);
            resultVo = new ResultVo("OK",200,true,dataVo);
        } catch (Exception e){
            resultVo = new ResultVo("Fail",404,false,null);
        }
        return resultVo;
    }


    @Override
    public ResultVo add(Carousel carousel) {
        int rows = carouselMapper.insertSelective(carousel);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,carousel);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }

    @Override
    public ResultVo update(Carousel carousel) {
        int rows = carouselMapper.updateByPrimaryKeySelective(carousel);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,carousel);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }



    @Override
    public ResultVo delete(Integer id) {
        int rows = carouselMapper.deleteByPrimaryKey(id);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,null);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }
}
