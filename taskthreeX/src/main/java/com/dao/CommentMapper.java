package com.dao;

import com.pojo.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer visitorId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer visitorId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    Comment selectByProductionId(Integer productionId);
}