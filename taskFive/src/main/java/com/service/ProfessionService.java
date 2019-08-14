package com.service;

import com.pojo.Profession;
import com.pojo.User;

import java.util.List;

public interface ProfessionService {
    int deleteByPrimaryKey(Integer id);

    int insert(Profession record);

    int insertSelective(Profession record);

    Profession selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Profession record);

    int updateByPrimaryKey(Profession record);

    List<Profession> select();

    boolean login(String name, String pwd);


     int insertUser(User user);


    String getName(String name);

    User selectByName(String name);



}
