package com.service.impl;

import com.dao.AuthorMapper;
import com.pojo.Author;
import com.service.AuthorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("AuthorServiceImpl")
public class AuthorServiceImpl implements AuthorService {
    @Resource
    AuthorMapper authorMapper;
    @Override
    public int deleteByPrimaryKey(Integer auhorId) {
        return 0;
    }

    @Override
    public int insert(Author record) {
        return 0;
    }

    @Override
    public int insertSelective(Author record) {
        return 0;
    }

    @Override
    public Author selectByPrimaryKey(Integer auhorId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Author record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Author record) {
        return 0;
    }

    @Override
    public List<Author> selectAll() {
        return authorMapper.selectAll();
    }
}
