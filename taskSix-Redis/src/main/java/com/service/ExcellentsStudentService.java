package com.service;

import com.pojo.ExcellentStudent;

import java.util.List;

public interface ExcellentsStudentService {
    int deleteByPrimaryKey(Integer id);

    int insert(ExcellentStudent record);

    int insertSelective(ExcellentStudent record);

    ExcellentStudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExcellentStudent record);

    int updateByPrimaryKey(ExcellentStudent record);

    List<ExcellentStudent> select();
}
