package com.service.impl;

import com.dao.CommentMapper;
import com.pojo.Comment;
import com.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("CommentServiceImpl")
public class CommentServiceImpl implements CommentService {

    @Resource
    CommentMapper commentMapper;
    @Override
    public int deleteByPrimaryKey(Integer visitorId) {
        return 0;
    }

    @Override
    public int insert(Comment record) {
        return 0;
    }

    @Override
    public int insertSelective(Comment record) {
        return commentMapper.insertSelective(record);
    }

    @Override
    public Comment selectByPrimaryKey(Integer visitorId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Comment record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Comment record) {
        return 0;
    }

    @Override
    public Comment selectByProductionId(Integer productionId) {
        return commentMapper.selectByProductionId(productionId);
    }
}
