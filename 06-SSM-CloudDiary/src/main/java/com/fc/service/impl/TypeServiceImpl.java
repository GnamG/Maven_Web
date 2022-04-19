package com.fc.service.impl;

import com.fc.dao.TbNoteTypeMapper;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbNoteTypeExample;
import com.fc.entity.TbUser;
import com.fc.service.TypeService;
import com.fc.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TbNoteTypeMapper tbNoteTypeMapper;
    @Override
    public ModelAndView list(ModelAndView mv, HttpServletRequest req) {
        TbUser user = (TbUser) req.getSession().getAttribute("user");
        TbNoteTypeExample tbNoteTypeExample = new TbNoteTypeExample();
        TbNoteTypeExample.Criteria criteria = tbNoteTypeExample.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        List<TbNoteType> list = tbNoteTypeMapper.selectByExample(tbNoteTypeExample);
        mv.addObject("list",list);
        mv.addObject("menu_page","type");
        mv.addObject("changePage","/type/list.jsp");
        mv.setViewName("/index.jsp");
        return mv;
    }

    @Override
    public ResultInfo addOrUpdate(TbNoteType type) {
        ResultInfo resultInfo ;
        int rows;
        if (type.getId()==null){
            rows = tbNoteTypeMapper.insertSelective(type);
        }else {
            rows = tbNoteTypeMapper.updateByPrimaryKeySelective(type);
        }
        if (rows>0){
            resultInfo = new ResultInfo(1,"添加或修改成功",null);
        }else {
            resultInfo = new ResultInfo(0,"添加或修改失败",null);
        }
        return resultInfo;
    }

    @Override
    public ResultInfo delete(Integer id) {
        ResultInfo resultInfo;
        int rows = tbNoteTypeMapper.IsCount(id);

        if(rows>0){
            // 失败
            resultInfo = new ResultInfo(0,"删除失败",null);
        }else {
            // 不存在值
            tbNoteTypeMapper.deleteByPrimaryKey(id);
            resultInfo = new ResultInfo(1,"删除成功",null);
        }
        return resultInfo;
    }
}
