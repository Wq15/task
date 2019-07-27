package com.service.impl;

import com.dao.StudioMapper;
import com.pojo.Studio;
import com.service.StudioService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("StudioServiceImpl")
public class StudioServiceImpl implements StudioService {
    @Resource
    StudioMapper studioMapper;
    @Override
    public int deleteByPrimaryKey(Integer studioId) {
        return 0;
    }

    @Override
    public int insert(Studio record) {
        return 0;
    }

    @Override
    public int insertSelective(Studio record) {
        return 0;
    }

    @Override
    public Studio selectByPrimaryKey(Integer studioId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Studio record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Studio record) {
        return 0;
    }

    @Override
    public List<Studio> select() {
        return studioMapper.select();
    }
}
