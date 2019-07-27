package com.controller;



import com.pojo.Author;
import com.pojo.Studio;
import com.service.AuthorService;
import com.service.StudioService;
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
public class StudioController {
    private static final Logger logger = Logger.getLogger(BannerController.class);

    @Autowired
    StudioService studioService;
    @ResponseBody
    @RequestMapping(value = "/studio",method = RequestMethod.GET)
    public Map<String,Object> select(){
        Map<String,Object> map = new HashMap();
        List<Studio> studio = studioService.select();
        map.put("code",1);
        map.put("message","成功");
        map.put("data",studio);
        return map;

    }

    @Autowired
    AuthorService authorService;
    @ResponseBody
    @RequestMapping(value = "/author",method = RequestMethod.GET)
    public Map<String,Object> selectAll(){
        Map<String,Object> map =new HashMap<>();
        List<Author> authors =authorService.selectAll();
        map.put("code",1);
        map.put("message","成功");
        map.put("data",authors);
        return map;
    }
}
