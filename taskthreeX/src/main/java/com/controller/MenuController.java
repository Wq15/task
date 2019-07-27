package com.controller;

import com.dao.MenuMapper;
import com.pojo.Menu;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenuController {

    private static final Logger logger = Logger.getLogger(com.controller.MenuController.class);

    @Autowired
    MenuMapper menuMapper;

    @ResponseBody
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public Map<String, Object> select() {
        logger.info("查询menu");

        Map<String, Object> map = new HashMap<String, Object>();
        List<Menu> menus = menuMapper.select();

        logger.info("2");

        map.put("code", 1);
        map.put("message", "成功");
        map.put("data", menus);
        return map;
    }
}
