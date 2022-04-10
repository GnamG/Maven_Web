package com.fc.service.impl;

import com.fc.dao.CollectionMapper;
import com.fc.entity.Alleviation;
import com.fc.entity.Collection;
import com.fc.service.CollectionService;
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
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public ResultVo getList(Long id, Integer pageNum, Integer pageSize) {
        List<Collection> list = new ArrayList<>();
        PageHelper.startPage(pageNum,pageSize);
        if (id==null) {
            list = collectionMapper.selectByExample(null);
        } else {
            Collection collection = collectionMapper.selectByPrimaryKey(id);
            if (collection!=null){
                list.add(collection);
            }
        }
        PageInfo<Collection> pageInfo = new PageInfo<>(list);
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
    public ResultVo add(Collection collection) {
        if (collection.getCreateTime() == null){
            collection.setCreateTime(new Date());
        }
        int rows = collectionMapper.insertSelective(collection);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,collection);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }

    @Override
    public ResultVo update(Collection collection) {
        int rows = collectionMapper.updateByPrimaryKeySelective(collection);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,collection);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
        int rows = collectionMapper.deleteByPrimaryKey(id);
        ResultVo resultVo;
        if (rows>0){
            resultVo = new ResultVo("Ok",200,true,null);
        }else {
            resultVo = new ResultVo("Fail",404,false,null);

        }
        return resultVo;
    }
}
