package com.controller;

import com.dao.ProfessionMapper;
import com.pojo.ExcellentStudent;
import com.pojo.Profession;
import com.service.ExcellentsStudentService;
import com.service.ProfessionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserHandler {
    private static final Logger logger = Logger.getLogger(UserHandler.class);
    @Autowired
    private ExcellentsStudentService es;


    @Autowired
    ProfessionMapper pp;
    @RequestMapping(value="/h")
    public String tileHome(){
        System.out.println("首页查询成功");
        return "home";
    }

    @RequestMapping(value="/p")
    public String p(){
        System.out.println("首页查询成功");
        return "home";
    }

    @Autowired
    ProfessionService professionService;
    @RequestMapping(value = "/profession",method = RequestMethod.GET)
    public ModelAndView ps(){
        ModelAndView mv=new ModelAndView();
        List<Profession> lists =professionService.select();
        Profession p=pp.selectByPrimaryKey(1);
        mv.addObject("list",lists);
        mv.addObject("map",p);
        return mv;
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView select() {
        logger.info("查询所有信息");
        ModelAndView mav = new ModelAndView();
        List<ExcellentStudent> users = es.select();

        logger.info("根据薪水查询的优秀学员："+users);
        mav.addObject("user", users);

        List<ExcellentStudent> resylt=es.select();
        logger.info("resylt:"+resylt.size());
        return mav;
    }
}