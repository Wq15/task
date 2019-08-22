package com.service.impl;

import com.dao.ProfessionMapper;
import com.pojo.Profession;
import com.pojo.User;
import com.service.ProfessionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ProfessionServiceImpl")
public class ProfessionServiceImpl implements ProfessionService {

    private static final Logger logger = Logger.getLogger(ProfessionServiceImpl.class);
    @Resource
    ProfessionMapper professionMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Profession record) {
        return 0;
    }

    @Override
    public int insertSelective(Profession record) {
        return 0;
    }

    @Override
    public Profession selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Profession record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Profession record) {
        return 0;
    }

    @Override
    public List<Profession> select() {
        return professionMapper.select();
    }


    @Autowired
    ProfessionMapper userDao;
    /**登录方法的实现,从jsp页面获取username与password
     */
    @Override
    public boolean login(String name, String pwd) {
        User user = userDao.selectByName(name);


        if (user != null) {
            logger.info("user的ID："+user);
            logger.info("名字："+name +"  密码："+pwd);
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
    public User selectByName(String name) {
        return userDao.selectByName(name);
    }


}
