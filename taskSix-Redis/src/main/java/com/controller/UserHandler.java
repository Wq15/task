package com.controller;

import com.alibaba.fastjson.JSON;
import com.dao.ProfessionMapper;
import com.pojo.*;
import com.service.ExcellentsStudentService;
import com.service.ProfessionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tools.RedisUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class UserHandler {
    private static final Logger logger = Logger.getLogger(UserHandler.class);


    ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    RedisUtil redisUtil=(RedisUtil) context.getBean("redisUtil");

    @Autowired
    ProfessionMapper pp;
    @Autowired
    ProfessionService professionService;
    private Long timeStamp;


    @RequestMapping(value = "/u/profession", method = RequestMethod.GET)
    public ModelAndView ps() {
        ModelAndView mv = new ModelAndView();
        List<Profession> lists ;

        if(redisUtil.get("lists")==null) {
            lists = professionService.select();

            redisUtil.set("lists", lists);
            System.out.println("redis职业页面的的值： " + lists);
        }else{
            lists= (List<Profession>) redisUtil.get("lists");

            System.out.println("如果redis里面有值就从这里拿lists：   "+lists);
        }


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

        long startTime = System.currentTimeMillis();

        List<ExcellentStudent> users ;

        long endTime = System.currentTimeMillis();
        System.out.println("运行一个 List<ExcellentStudent> users需要：" + (endTime - startTime) + "毫秒");



        if (redisUtil.get("users")==null){


        users = es.select();

        redisUtil.set("users",users);

            System.out.println("redis里面的user值：  "+redisUtil.get("users"));
        }else {

            users = (List<ExcellentStudent>) redisUtil.get("users");

            System.out.println("如果redis里面有就是： "+redisUtil.get("users"));

        }

        logger.info("根据薪水查询的优秀学员：" + users);
        mav.addObject("user", users);

        mav.setViewName("home");
        List<ExcellentStudent> resylt = es.select();
        logger.info("resylt:" + resylt.size());



        return mav;
    }

    @Autowired
    ProfessionService userService;

    /**
     * login业务的访问位置为/user/login
     *
     * @return
     */

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView Login(User user, HttpServletResponse response) throws Exception {
        logger.info("user:" + user);
        //调用login方法来验证是否是注册用户
        boolean loginType = userService.login(user.getName(), MD5Utils.generate(user.getPwd()));

        System.out.println(loginType);
        ModelAndView mv = new ModelAndView();
        if (!loginType) {
            logger.info("登录失败");
            mv.setViewName("dlsb");
            return mv;
        }


        //生成Token
        String token =JwtTokenUtil.createToken(userService.selectByName(user.getName()).getId().toString(),user.getName());

        logger.info("生成加密后的Token：" + token + "Token的长度：" + token.length());

        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(24*60*60);
        //暂时设置cookie失效时间为0

        cookie.setPath("/");
        //设置cookie有效路径
        System.out.println("新生成的cookie和MaxAge："+cookie.getName()+"-->"+cookie.getMaxAge());
        //将生成的cookie装入response发送到申请页面

        logger.info("cookie:" + cookie);
        response.addCookie(cookie);
        String st = user.getName();
        mv.addObject("status", st);

        mv.setViewName("dlcg");

        return mv;
    }

    //退出登录时删除cookie
    @RequestMapping("/signout")
    public void logout(HttpServletRequest request, HttpServletResponse response){

        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
//                    cookie.setDomain(domain);
                    response.addCookie(cookie);
                    break;
                }
            }
            try {
                response.sendRedirect("/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView insert(User user) {
        user.setCreateTime(timeStamp);
        user.setCreateTime(timeStamp);
        logger.info(JSON.toJSONString(user));
        ModelAndView mv = new ModelAndView();

        if (user == null) {
            mv.setViewName("wrong");
        } else if (user.getName().trim().length() < 3) {
            mv.setViewName("wrong");
        } else if (user.getPwd().trim().length() < 3) {
            mv.setViewName("wrong");
        } else {
            //验证用户名是否存在
            User ss = userService.selectByName(user.getName());
            if (ss != null) {
                mv.addObject("message", "用户名已存在");
                mv.setViewName("wrong");
                return mv;
            } else {
                //加盐加密
                String saltPwd = MD5Utils.generate(user.getPwd());
                logger.info("加盐后的密码：" + saltPwd + "加盐后的密码长度：" + saltPwd.length());
                user.setPwd(saltPwd);
                logger.info(user.getPwd());

                int rs = userService.insertUser(user);
                mv.addObject("message", rs);

            }
        }
        return mv;
    }

    @RequestMapping(value = "/add")
    public String insertAll() {
        return "register";
    }
}