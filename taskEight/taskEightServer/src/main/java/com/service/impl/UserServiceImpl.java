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
    public User selectById(Integer id) {
        return userDao.selectById(id);
    }


    @Override
    public User selectByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public User selectByPhone(String phoneNumber) {
        return userDao.selectByPhone(phoneNumber);
    }

    @Override
    public User selectByPwd(String pwd) {
        return userDao.selectByPwd(pwd);
    }


    /**
     * 登录方法的实现,从jsp页面获取username与password
     */
    @Override
    public boolean login(String account, String pwd) {

        User user = userDao.selectByName(account);
        logger.info("实现层的user值为  " + user);

        if (user != null) {
            logger.info("user的ID：" + user);
            logger.info("输入的账号是名称  ：" + account + " 输入的密码：" + pwd);
            if (user.getName().equals(account) && user.getPwd().equals(pwd)) {
                logger.info("登录信息正确");
                return true;
            }
        } else {
            User userMail = userDao.selectByMail(account);
            if (userMail != null) {
                logger.info("输入的邮箱昵称为 " + account);

                logger.info("邮箱这里的值有么：  ");
                if (userMail.getEmail().equals(account) && userMail.getPwd().equals(pwd)) {
                    logger.info("邮箱登录信息正确");
                    return true;
                }
            } else {
                String phoneNumber = account;
                User userPhone = userDao.selectByPhone(phoneNumber);
                if (userPhone != null) {
                    logger.info("userPhone里面的值   ：" + userPhone.getPwd());
                    System.out.println("sdsdd       " + pwd);
                    if (userPhone.getPhoneNumber().equals(account) && userPhone.getPwd().equals(pwd)) {
                        logger.info("输入的号码登录正确");
                        return true;
                    }
                } else {
                    logger.info("账号输入有误，请重新输入");
                    return false;
                }
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

    @Override
    public User selectByMail(String email) {
        return userDao.selectByMail(email);
    }


}