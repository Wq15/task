package com.controller;


import com.pojo.Comment;
import com.pojo.Reply;
import com.pojo.Visitor;
import com.service.CommentService;
import com.service.ReplyService;
import com.service.VisitorService;
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
public class CommentController {

    private static final Logger logger = Logger.getLogger(com.controller.MenuController.class);

    @Autowired
    CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Map<String, Object> insertSelective(Comment record) {
        Map<String, Object> map = new HashMap<>();
        logger.info("评论入参："+record);
        int rs = commentService.insertSelective(record);
        map.put("code", 1);
        map.put("messqge", "评论成功");
        map.put("data", rs);
        logger.info("结果："+rs);
        return map;

    }

    @ResponseBody
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public Map<String, Object> selectByProductionId(int productionId) {
        Map<String, Object> map = new HashMap<>();
        Comment comments = commentService.selectByProductionId(productionId);
        map.put("code", 1);
        map.put("message", "成功");
        map.put("data", comments);
        return map;
    }

    @Autowired
    ReplyService replyService;

    @ResponseBody
    @RequestMapping(value = "/reply", method = RequestMethod.POST)

    public Map<String, Object> insertSelective(Reply record) {
        Map<String, Object> map = new HashMap<>();
        int replies = replyService.insertSelective(record);
        map.put("code",1);
        map.put("message","回复成功");
        map.put("data",replies);
        return map;

    }

    @ResponseBody
    @RequestMapping(value = "reply/select",method = RequestMethod.GET)
    public Map<String,Object> selectReply(Integer productionId){
        Map<String,Object> map =new HashMap<>();
        Reply reply =replyService.selectReply(productionId);
        map.put("code",1);
        map.put("message","展示回复");
        map.put("data",reply);
        return map;
    }



    @Autowired
    VisitorService visitorService;
    @ResponseBody
    @RequestMapping(value = "/visitor",method = RequestMethod.GET)
    public Map<String,Object> selectVisitor(){
        Map<String,Object> map =new HashMap<>();
        List< Visitor > visitors =visitorService.selectVisitor();
        map.put("code",1);
        map.put("message","回复成功");
        map.put("data",visitors);
        return map;
    }
}
