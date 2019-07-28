package com.service;

import com.pojo.Author;

import java.util.List;

public interface AuthorService {
    int deleteByPrimaryKey(Integer auhorId);

    int insert(Author record);

    int insertSelective(Author record);

    Author selectByPrimaryKey(Integer auhorId);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);

    List<Author> selectAll();
}
