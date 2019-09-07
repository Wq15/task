package com.service;

import com.pojo.User;

public interface UserService {

    User selectById(Long Id);

    User selectByName(String name);

    boolean login(String name, String pwd);

   int insertUser(User user);

    String getName(String name);

    int insertEmail(User user);

    int insertUrl(String url);
}
