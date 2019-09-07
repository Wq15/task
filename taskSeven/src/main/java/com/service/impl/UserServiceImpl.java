package com.service.impl;

import com.dao.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userDao;


    private static final Logger logger = Logger.getLogger(ProfessionServiceImpl.class);

    @Override
    public User selectById(Long id) {
        return userDao.selectById(id);
    }


    @Override
    public User selectByName(String name) {
        return userDao.selectByName(name);
    }



    /**
     * 登录方法的实现,从jsp页面获取username与password
     */
    @Override
    public boolean login(String name, String pwd) {
        User user = userDao.selectByName(name);


        if (user != null) {
            logger.info("user的ID：" + user);
            logger.info("名字：" + name + "  密码：" + pwd);
            if (user.getName().equals(name) && user.getPwd().equals(pwd)) {
                logger.info("登录信息正确");
                return true;
            }
        }
        return false;
    }

    @Override
    public int insertUser(User user) {

        return userDao.insertUser(user);

    }


    @Override
    public String getName(String name) {
        return userDao.getName(name);
    }

    @Override
    public int insertEmail(User user) {
        return userDao.insertEmail(user);
    }

    @Override
    public int insertUrl(String url) {
        return userDao.insertUrl(url);
    }

//    @Override
//    public int insertUser(String name, String pwd, String phoneNumber, String identifyingCode) {
//        return userDao.insertUser(name,pwd,phoneNumber,identifyingCode);
//    }

}