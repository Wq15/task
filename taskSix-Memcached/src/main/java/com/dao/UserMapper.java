package com.dao;

import com.pojo.User;

public interface UserMapper {

    User selectById (Long id);
}
