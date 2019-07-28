package com.dao;

import com.pojo.Production;

import java.util.List;

public interface ProductionMapper {
    int deleteByPrimaryKey(Integer productionId);

    int insert(Production record);

    int insertSelective(Production record);

    Production selectByPrimaryKey(Integer productionId);

    int updateByPrimaryKeySelective(Production record);

    int updateByPrimaryKey(Production record);

    List<Production> select(String submenuName);

    List<Production> selectByKeyword(String keyword);

}