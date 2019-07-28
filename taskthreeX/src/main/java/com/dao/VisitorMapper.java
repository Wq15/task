package com.dao;

import com.pojo.Visitor;

import java.util.List;

public interface VisitorMapper {
    int deleteByPrimaryKey(Integer visitId);

    int insert(Visitor record);

    int insertSelective(Visitor record);

    Visitor selectByPrimaryKey(Integer visitId);

    int updateByPrimaryKeySelective(Visitor record);

    int updateByPrimaryKey(Visitor record);

    List<Visitor> selectVisitor ();
}