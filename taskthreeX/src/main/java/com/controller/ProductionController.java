package com.controller;

import com.pojo.Production;
import com.service.ProductionService;
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
public class ProductionController {
    private static final Logger logger = Logger.getLogger(com.controller.MenuController.class);

    @Autowired
    ProductionService productionService;

    @ResponseBody
    @RequestMapping(value = "/submenu", method = RequestMethod.GET)
    public Map<String, Object> select(String submenuName) {
        logger.info("查询二级菜单");

        Map<String, Object> map = new HashMap<String, Object>();
        logger.info(submenuName);
        List<Production> production = productionService.select(submenuName);

        logger.info("作品个数："+production.size());

        map.put("code", 1);
        map.put("message", "成功");
        map.put("data", production);
        return map;

    }


    @ResponseBody
    @RequestMapping(value = "/keyword", method = RequestMethod.GET)
    public Map<String, Object> selectByKeyword(String keyword) {
        logger.info("keyword"+keyword);
        Map<String, Object> map = new HashMap<>();
        List<Production> productions = productionService.selectByKeyword(keyword);
        logger.info("productions"+productions);
        map.put("code", 1);
        map.put("message", "成功");
        map.put("data", productions);
        return map;
    }


    @ResponseBody
    @RequestMapping(value = "/production", method = RequestMethod.GET)
    public Production selectByPrimaryKey(Integer productionId) {

        logger.info("productionId"+productionId);
        Production product = productionService.selectByPrimaryKey(productionId);

        logger.info("product"+product);
        return product;
    }
}