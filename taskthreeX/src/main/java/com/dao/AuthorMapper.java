package com.dao;

import com.pojo.Author;

import java.util.List;

public interface AuthorMapper {
    int deleteByPrimaryKey(Integer auhorId);

    int insert(Author record);

    int insertSelective(Author record);

    Author selectByPrimaryKey(Integer auhorId);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);

    List<Author> selectAll();
}