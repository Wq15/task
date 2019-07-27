package com.service;

import com.pojo.Visitor;

import java.util.List;

public interface VisitorService {
    int deleteByPrimaryKey(Integer visitId);

    int insert(Visitor record);

    int insertSelective(Visitor record);

    Visitor selectByPrimaryKey(Integer visitId);

    int updateByPrimaryKeySelective(Visitor record);

    int updateByPrimaryKey(Visitor record);

    List<Visitor> selectVisitor ();
}
