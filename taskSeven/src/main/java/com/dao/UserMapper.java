package com.dao;

import com.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectById(Long Id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByName(String name);

    int insertUser(User user);

    String getName(String name);

    //int insertUser(String name, String pwd, String phoneNumber, String identifyingCode);
    int insertEmail(User user);

    int insertUrl(String url);
}