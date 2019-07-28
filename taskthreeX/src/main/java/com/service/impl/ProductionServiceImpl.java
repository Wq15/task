package com.service.impl;

import com.dao.ProductionMapper;
import com.pojo.Production;
import com.service.ProductionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("ProductionServiceImpl")
public class ProductionServiceImpl implements ProductionService {

    @Resource
    ProductionMapper productionMapper;
    @Override
    public int deleteByPrimaryKey(Integer productionId) {
        return 0;
    }

    @Override
    public int insert(Production record) {
        return 0;
    }

    @Override
    public int insertSelective(Production record) {
        return 0;
    }

    @Override
    public Production selectByPrimaryKey(Integer productionId) {
        return productionMapper.selectByPrimaryKey(productionId);
    }

    @Override
    public int updateByPrimaryKeySelective(Production record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Production record) {
        return 0;
    }

    @Override
    public List<Production> select(String submenuName) {
        return productionMapper.select(submenuName);
    }

    @Override
    public List<Production> selectByKeyword(String keyword) {
        return productionMapper.selectByKeyword(keyword);
    }
}
