package com.service;

import com.pojo.Comment;

public interface CommentService {
    int deleteByPrimaryKey(Integer visitorId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer visitorId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    Comment selectByProductionId(Integer productionId);
}
