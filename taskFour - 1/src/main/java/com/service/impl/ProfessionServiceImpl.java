package com.service.impl;

import com.dao.ProfessionMapper;
import com.pojo.Profession;
import com.service.ProfessionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ProfessionServiceImpl")
public class ProfessionServiceImpl implements ProfessionService {
    @Resource
    ProfessionMapper professionMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Profession record) {
        return 0;
    }

    @Override
    public int insertSelective(Profession record) {
        return 0;
    }

    @Override
    public Profession selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Profession record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Profession record) {
        return 0;
    }

    @Override
    public List<Profession> select() {
        return professionMapper.select();
    }
}
