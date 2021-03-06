package com.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.dao.ProfessionMapper;
import com.pojo.*;
import com.qiniu.util.Auth;
import com.service.ExcellentsStudentService;
import com.service.ProfessionService;
import com.service.UserService;
import com.sun.mail.util.MailSSLSocketFactory;
import net.rubyeye.xmemcached.MemcachedClient;
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
import tools.QiniuCloudUtil;


import javax.mail.*;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.Properties;

import static tools.Mail_java.createSimpleMail;

@Controller
public class UserHandler {
    private static final Logger logger = Logger.getLogger(UserHandler.class);

    private ApplicationContext app;
    @Autowired
    MemcachedClient memcachedClient;

    @Before
    public void init() {
        app = new ClassPathXmlApplicationContext("spring/app-context-xmemcached.xml");
        memcachedClient = (MemcachedClient) app.getBean("memcachedClient");
    }


    @Autowired
    UserService userService;

    @Autowired
    ProfessionMapper pp;
    @Autowired
    ProfessionService professionService;


    @RequestMapping("/register")
    @ResponseBody
    public ModelAndView register(
            HttpServletRequest request,
            String name,
            String pwd,
            String phoneNumber,
            String identifyingCode) {


        ModelAndView mv = new ModelAndView();

        if (phoneNumber.trim().length() != 11) {
            mv.addObject("message", "号码输入错误");
            mv.setViewName("wrong");
        } else if (identifyingCode.trim().length() != 6) {
            mv.addObject("message", "请输入正确六位验证码");

        }

        Object json = request.getSession().getAttribute("code");
        logger.info("我要看看json里面的值：  " + json);


        long startTime = System.currentTimeMillis();

        System.out.println("传进来验证码的值为：  " + identifyingCode);
        if (!String.valueOf(json).equals(identifyingCode)) {
            System.out.println("验证码错了");

            mv.setViewName("home");
            return mv;
        }

        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
        user.setPhoneNumber(phoneNumber);

        logger.info("user里面值  " + user);
        if ((System.currentTimeMillis() - startTime) > 1000 * 60 * 5) {
            mv.addObject("message", "验证码过期");
            mv.setViewName("wrong");
        }


        if (user == null) {
            mv.addObject("message", "注册信息不可为空");
            mv.setViewName("wrong");

            logger.info("23232323");
        } else if (user.getName().trim().length() < 3) {
            mv.addObject("message", "输入用户名长度不可小于3");
            mv.setViewName("wrong");
        } else if (user.getPwd().trim().length() < 3) {
            mv.addObject("message", "输入密码长度不可小于3");
            mv.setViewName("wrong");

        } else {

            logger.info("lalalaaaaaaaaaaaaa");
            User ss = userService.selectByName(name);

            logger.info("看一下ss里面的值为：  " + ss);
            if (ss != null) {
                mv.addObject("message", "用户名已存在");
                mv.setViewName("wrong");
            } else {

                String saltPwd = MD5Utils.generate(user.getPwd());
                logger.info("加盐后的密码：" + saltPwd + "加盐后的密码长度：" + saltPwd.length());
                user.setPwd(saltPwd);
                logger.info(user.getPwd());


                int rs = userService.insertUser(user);

                System.out.println(0);
                logger.info("注册到数据库里面的值为; " + rs);
            }
        }


        mv.setViewName("dlcg");
        return mv;
    }


    @RequestMapping(value = "/u/profession", method = RequestMethod.GET)
    public ModelAndView ps() {
        ModelAndView mv = new ModelAndView();
        List<Profession> lists;

        lists = professionService.select();

        mv.addObject("list", lists);

//        Profession p = pp.selectByPrimaryKey(1);
//        mv.addObject("map", p);

        mv.setViewName("profession");
        return mv;
    }

    @Autowired
    private ExcellentsStudentService es;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView select() {

        logger.info("查询所有信息");
        ModelAndView mav = new ModelAndView();

        List<ExcellentStudent> users;

        users = es.select();

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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView Login(String account, User user, HttpServletResponse response, String pwd) throws Exception {
        logger.info("user:" + user);
        logger.info("输入的account  值 " + account);
        //调用login方法来验证是否是注册用户
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