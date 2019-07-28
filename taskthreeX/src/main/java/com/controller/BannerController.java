package com.controller;


import com.pojo.Banner;
import com.service.BannerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class BannerController {
    private static final Logger logger = Logger.getLogger(BannerController.class);

    @Autowired
    BannerService bannerService;
    @ResponseBody
    @RequestMapping(value = "/banner",method = RequestMethod.GET)
   public Map<String,Object> selectByDynamic(){
        logger.info("查询信息");

        Map<String,Object> map=new HashMap<String, Object>();
        List<Banner> banner=bannerService.selectByDynamic();

        logger.info("1");

            map.put("code",1);
            map.put("message","成功");
            map.put("data",banner);
            return map;

        }

    }


