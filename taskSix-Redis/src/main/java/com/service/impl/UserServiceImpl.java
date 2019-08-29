package com.service.impl;

import com.dao.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userDao;

    @Override
    public User selectById(Long id) {
        return userDao.selectById(id);
    }

}