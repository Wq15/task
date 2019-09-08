package com.dao;

import com.pojo.User;

public interface UserMapper {


    int insert(User record);


    User selectById(Long Id);


    int insertUser(User user);

    String getName(String name);


    int insertEmail(User user);

    int insertUrl(String url);

    User selectByName(String name);

    User selectByMail(String email);

    User selectByPhone (String phoneNumber);



    User selectByPwd(String pwd);
}