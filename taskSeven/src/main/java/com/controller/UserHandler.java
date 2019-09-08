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



    //发短信的调用
    @RequestMapping(value = "/sendSms",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public ModelAndView sendIdentifyingCode(ServletRequest servletRequest,String phoneNumber) {
        final HttpServletRequest request =(HttpServletRequest) servletRequest;
        ModelAndView mv=new ModelAndView();
//        int state=-1;

        if(phoneNumber.trim().length()!=11){
            mv.addObject("message","号码长度不符合注册要求");
            mv.setViewName("wrong");
        }

        try {


            // 验证码生成发送
            int identifyingCode = AliyunMessageUtil.getIdentifyingCode();

            SendSmsResponse sendSmsResponse = AliyunMessageUtil.sendIdentifyingCode(phoneNumber,identifyingCode);
            // ok代表的是接口发送成功的状态码

            System.out.println(777);
            if (sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")) {
               // state=1;
                System.out.println(898);
                logger.info("发送的验证码为：   " +identifyingCode);

                //TimerTask实现5分钟后从session中删除checkCode



              request.getSession().setAttribute("code",identifyingCode);
                                      System.out.println(111);
              Object dept=request.getSession().getAttribute("code");
                                      System.out.println(222);
                                System.out.println("session 会话里 dept 的值：  "+ dept);


                final Timer timer=new Timer();
              //  final String phoneNum=phoneNumber;
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        request.removeAttribute("code");
                        System.out.println("验证码删除成功");
                        timer.cancel();
                    }
                },5*60*1000);
               // resultMap.put("state", state);
               // resultMap.put("msg", "发送成功");
            } else {
              //  resultMap.put("state", state);
               // resultMap.put("msg", "发送失败,请重新发送");
            }
        } catch (ClientException e) {
            e.printStackTrace();
           // resultMap.put("state", state);
          //  resultMap.put("msg", "发送失败,请重新发送");
        }
        return mv;
    }






    @RequestMapping("/register")
    @ResponseBody
    public ModelAndView register(
            HttpServletRequest request,
            String name,
            String pwd,
            String phoneNumber,
            String identifyingCode) {


        ModelAndView mv = new ModelAndView();

        if(phoneNumber.trim().length()!=11){
            mv.addObject("message","号码输入错误");
            mv.setViewName("wrong");
        }else if(identifyingCode.trim().length()!=6){
            mv.addObject("message","请输入正确六位验证码");

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

        logger.info("user里面值  "+user);
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

            logger.info("看一下ss里面的值为：  "+ss);
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













    @RequestMapping(value = "/add")
    public String insertAll() {

        return "/register";
    }

    @RequestMapping(value = "/addMail")
    public String insertmail(){

        return "/registerMail";
    }



    @RequestMapping(value = "/sendMail")
    public ModelAndView sendCode(ServletRequest servletRequest,String email) throws Exception {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;


        ModelAndView mv=new ModelAndView();
        if(email.trim().length()<8){
           mv.addObject("message","请输入正确邮箱地址");
           mv.setViewName("wrong");
        }


        Properties prop = new Properties();
        // 开启debug调试，以便在控制台查看
        prop.setProperty("mail.debug", "true");
        // 设置邮件服务器主机名
        prop.setProperty("mail.host", "smtp.qq.com");
        // 发送服务器需要身份验证
        prop.setProperty("mail.smtp.auth", "true");
        // 发送邮件协议名称
        prop.setProperty("mail.transport.protocol", "smtp");
        // 开启SSL加密，否则会失败
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);
        // 创建session
        Session session = Session.getInstance(prop);
        // 通过session得到transport对象
        Transport ts = session.getTransport();
        // 连接邮件服务器：邮箱类型，帐号，POP3/SMTP协议授权码 163使用：smtp.163.com
        ts.connect("smtp.qq.com", "412767624", "ylosjiyyjqdjcaci");
        // 创建邮件
        Message message = createSimpleMail(request,session,email);
        // 发送邮件
        System.out.println(13);
        ts.sendMessage(message, message.getAllRecipients());
        System.out.println(14);

        ts.close();


        return mv;

    }






    @RequestMapping(value = "/regMail")
    @ResponseBody
    public ModelAndView registerMail(
            HttpServletRequest request,
            String name,
            String pwd,
            String email,
            String identifyingCode) {


        Object dept=request.getSession().getAttribute("stringBuilder");

        System.out.println("session 会话里 dept 的值：  "+ dept);
        ModelAndView mv = new ModelAndView();

        Object json = request.getSession().getAttribute("stringBuilder");
        logger.info("我要看看json里面的值：  " + json);


        long startTime = System.currentTimeMillis();

        System.out.println("传进来验证码的值为：  " + identifyingCode);

        if (!String.valueOf(json).equals(identifyingCode)) {
            System.out.println("验证码错了");

            mv.addObject("message","验证码错误");
            mv.setViewName("wrong");
            return mv;
        }

        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
        user.setEmail(email);

        logger.info("user里面值  "+user);
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

            logger.info("看一下ss里面的值为：  "+ss);
            if (ss != null) {
                mv.addObject("message", "用户名已存在");
                mv.setViewName("wrong");
            } else {

                String saltPwd = MD5Utils.generate(user.getPwd());
                logger.info("加盐后的密码：" + saltPwd + "加盐后的密码长度：" + saltPwd.length());
                user.setPwd(saltPwd);
                logger.info(user.getPwd());


                int rs = userService.insertEmail(user);

                System.out.println(0);
                logger.info("注册到数据库里面的值为; " + rs);
            }
        }


        mv.setViewName("index");
        return mv;
    }










    @RequestMapping(value = "/upload")
    public String upload(){
        System.out.println("跳转图片上传");
        return "/upload";
    }






    @Controller
    public class QiniuUpload {
        // ******的内容需要查看七牛云账号的相关信息
        private static final String accessKey = "U2Cp7u7UEhUzHbVmwkfRjVZRNOb3USJNodyJQP3t";
        //访问秘钥
        private static final String secretKey = "e9iKoci_M5i8smZ_I5PrSQ3WqcumvL0l-X0Rhl1V";
        //授权秘钥
        private static final String bucket = "20190905";
        //存储空间名称
        private static final String domain = "pxcioqbaj.bkt.clouddn.com";
        //外链域名


        /**
         * 七牛云上传生成凭证
         *
         * @throws Exception
         */
        @RequestMapping("/QiniuUpToken")
        @ResponseBody
        public Map<String, Object> QiniuUpToken(@RequestParam String suffix) throws Exception{
            Map<String, Object> result = new HashMap<String, Object>();
            System.out.println(222);
            try {
                //验证七牛云身份是否通过
                Auth auth = Auth.create(accessKey, secretKey);
                //生成凭证
                String upToken = auth.uploadToken(bucket);
                result.put("token", upToken);
                //存入外链默认域名，用于拼接完整的资源外链路径
                result.put("domain", domain);



                //生成实际路径名
                String randomFileName = UUID.randomUUID().toString() + suffix;

                result.put("imgUrl", randomFileName);

                result.put("success", 1);

                logger.info("上传图片随机名为： "+randomFileName);

                String u="http://pxcioqbaj.bkt.clouddn.com/";
                String url=u+randomFileName;

                System.out.println("生成图片的网址"+url);


                int uu=userService.insertUrl(url);


                logger.info("插入数据库的图片网址是：  "+uu);

            } catch (Exception e) {
                result.put("message", "获取凭证失败，"+e.getMessage());
                result.put("success", 0);
            } finally {
                return result;
            }
        }
    }








    @ResponseBody
    @RequestMapping(value="/uploadImg", method=RequestMethod.POST)
    public ModelAndView uploadImg(@RequestParam MultipartFile image, HttpServletRequest request) {
        ModelAndView mv =  new ModelAndView();

        System.out.println(111);
        if (image.isEmpty()) {
            mv.addObject("message", "用户名已存在");
            mv.setViewName("wrong");

        }

        try {
            byte[] bytes = image.getBytes();
            String imageName = UUID.randomUUID().toString();
            try {
                //使用base64方式上传到七牛云
                String url = QiniuCloudUtil.put64image(bytes, imageName);

                mv.setViewName("wrong");
                mv.addObject("message",url);
                System.out.println(2345);
                System.out.println(url);
            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            mv.addObject("message", "用户名已存在");
            mv.setViewName("wrong");
        } finally {
            return mv;
        }
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
    public ModelAndView Login(String account, User user, HttpServletResponse response,String pwd) throws Exception {
        logger.info("user:" + user);
        logger.info("输入的account  值 "+account);
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


        User user1=userService.selectByPwd(MD5Utils.generate(user.getPwd()));

        System.out.println(user1);

        String token = JwtTokenUtil.createToken(userService.selectByName(user1.getName()).getId().toString(), user1.getName());

        logger.info("生成加密后的Token：" + token + "Token的长度：" + token.length());

        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(24 * 60 * 60);
        //暂时设置cookie失效时间为0

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



    //退出登录时删除cookie
    @RequestMapping("/signout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {

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



}