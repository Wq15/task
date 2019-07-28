package com.service.impl;

import com.dao.MenuMapper;
import com.pojo.Menu;
import com.service.MenuService;

import javax.annotation.Resource;
import java.util.List;

public class MenuServiceImpl implements MenuService {

    @Resource
    MenuMapper menuMapper;
    @Override
    public int deleteByPrimaryKey(Integer menuId) {
        return 0;
    }

    @Override
    public int insert(Menu record) {
        return 0;
    }

    @Override
    public int insertSelective(Menu record) {
        return 0;
    }

    @Override
    public Menu selectByPrimaryKey(Integer menuId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return 0;
    }

    @Override
    public List<Menu> select() {
        return menuMapper.select();
    }
}
