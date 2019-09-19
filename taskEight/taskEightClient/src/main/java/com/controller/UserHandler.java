package com.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.dao.ProfessionMapper;
import com.pojo.*;
import com.qiniu.util.Auth;
import com.rmi.RmiChooseManager;
import com.service.ExcellentsStudentService;
import com.service.ProfessionService;
import com.service.UserService;
import com.sun.mail.util.MailSSLSocketFactory;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import tools.AliyunMessageUtil;
import tools.QiniuCloudUtil;


import javax.mail.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import static tools.Mail_java.createSimpleMail;

@Controller
public class UserHandler {
    private static final Logger logger = Logger.getLogger(UserHandler.class);


    @Autowired
    RmiChooseManager rmiChooseManager;

    @RequestMapping(value = "/u/profession", method = RequestMethod.GET)
    public ModelAndView ps() {
        ProfessionService professionService = rmiChooseManager.chooseProfessionService();
        ModelAndView mv = new ModelAndView();
        List<Profession> lists;

        lists = professionService.select();

        mv.addObject("list", lists);


        mv.setViewName("profession");
        return mv;
    }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView select() {

        //调用随机webService
        ExcellentsStudentService excellentsStudentService = rmiChooseManager.chooseExcellentsStudentService();
        logger.info("查询所有信息--------------" + excellentsStudentService);
        ModelAndView mav = new ModelAndView();

        List<ExcellentStudent> users;

        users = excellentsStudentService.select();

        logger.info("根据薪水查询的优秀学员：" + users);
        mav.addObject("user", users);

        mav.setViewName("home");

        return mav;
    }


    /**
     * login业务的访问位置为/user/login
     *
     * @return
     */
    //  UserService userService =  applicationContext.getBean("userClient",UserService.class);

    //随机调用Uservice
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView Login(String account, User user, HttpServletResponse response, String pwd) throws Exception {
        UserService userService = rmiChooseManager.chooseUserService();

        logger.info("user:" + user);
        logger.info("输入的account  值 " + account);
        //调用login方法来验证是否是注册用户
        logger.info("w卧槽 看这里  " + userService);
        boolean loginType = userService.login(account, MD5Utils.generate(user.getPwd()));

        System.out.println(loginType);
        ModelAndView mv = new ModelAndView();
        if (!loginType) {
            logger.info("登录失败");
            mv.setViewName("dlsb");
            return mv;
        }

        logger.info("这里631");
        //生成Token

        User user1 = userService.selectByPwd(MD5Utils.generate(user.getPwd()));

        System.out.println(user1);

        String token = JwtTokenUtil.createToken(userService.selectByName(user1.getName()).getId(), user1.getName());

        logger.info("生成加密后的Token：" + token + "Token的长度：" + token.length());

        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(24 * 60 * 60);


        cookie.setPath("/");
        //设置cookie有效路径
        System.out.println("新生成的cookie和MaxAge：" + cookie.getName() + "-->" + cookie.getMaxAge());
        //将生成的cookie装入response发送到申请页面

        logger.info("cookie:" + cookie);
        response.addCookie(cookie);
        String st = user1.getName();
        mv.addObject("status", st);

        mv.setViewName("dlcg");

        return mv;
    }


}