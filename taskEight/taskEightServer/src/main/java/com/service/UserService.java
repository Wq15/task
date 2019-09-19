package com.service;

import com.pojo.User;

public interface UserService {

    User selectById(Integer Id);

    User selectByName(String name);

    boolean login(String account, String pwd);

    int insertUser(User user);

    String getName(String name);

    int insertEmail(User user);

    int insertUrl(String url);

    User selectByMail(String email);

    User selectByPhone(String phoneNumber);


    User selectByPwd(String pwd);
}
