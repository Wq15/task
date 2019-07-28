package com.service.impl;

import com.dao.ReplyMapper;
import com.pojo.Reply;
import com.service.ReplyService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Service("ReplyServiceImpl")
public class ReplyServiceImpl implements ReplyService {
    @Resource
    ReplyMapper replyMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Reply record) {
        return 0;
    }

    @Override
    public int insertSelective(Reply record) {
        return replyMapper.insertSelective(record);
    }

    @Override
    public Reply selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Reply record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Reply record) {
        return 0;
    }

    @Override
    public Reply selectReply(Integer productionId) {
        return replyMapper.selectReply(productionId);
    }
}
