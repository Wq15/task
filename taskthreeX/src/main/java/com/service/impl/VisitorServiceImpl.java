package com.service.impl;

import com.dao.VisitorMapper;
import com.pojo.Visitor;
import com.service.VisitorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("VisitorServiceImpl")
public class VisitorServiceImpl implements VisitorService {

    @Resource
    VisitorMapper visitorMapper;
    @Override
    public int deleteByPrimaryKey(Integer visitId) {
        return 0;
    }

    @Override
    public int insert(Visitor record) {
        return 0;
    }

    @Override
    public int insertSelective(Visitor record) {
        return 0;
    }

    @Override
    public Visitor selectByPrimaryKey(Integer visitId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Visitor record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Visitor record) {
        return 0;
    }

    @Override
    public List<Visitor> selectVisitor() {
        return visitorMapper.selectVisitor();
    }
}
