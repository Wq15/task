package example.controller;

import example.pojo.Student;
import example.pojo.User;
import example.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author wangqing
 */
//Controller注解用于标示本类为web控制层组件
@Controller

@RequestMapping("/user")
//在默认情况下springmvc的实例都是单例模式,所以使用scope域将其注解为每次都创建一个新的实例
@Scope("prototype")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
    @Resource
    private UserService service;

    /**
     * 返回user对象信息给page1.jsp处理，然后在前端页面展示
     */
    @RequestMapping("/page")
    public ModelAndView getUser() {

        ModelAndView mav = new ModelAndView("page1");
        List<Student> users = service.getAllUser();

        mav.addObject("user", users);
        System.out.println("查询所有成功");
        return mav;
    }


    @Autowired
    UserService userService;

    //login业务的访问位置为/user/login
    @RequestMapping(value = "/login", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public String login(User user, HttpServletRequest request) {
        //调用login方法来验证是否是注册用户
        boolean loginType = userService.login(user.getUsername(), user.getPassword());
        if (loginType) {
            //如果验证通过,则将用户信息传到前台
            request.setAttribute("user", user);
            //并跳转到success.jsp页面
            return "dlcg";
        } else {
            //若不对,则将错误信息显示到错误页面
            request.setAttribute("message", "用户名密码错误");
            return "dlsb";
        }
    }


    @RequestMapping(value = "/insert", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public ModelAndView insert(Student student) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:page");
        mv.addObject("student", userService.insertStudent(student));
        System.out.println("插入成功");
        return mv;
    }

    @RequestMapping(value = "/add")
    public String inserStudent() {
        return "insert";
    }

    @RequestMapping("/updateone")
    public String updateStudent() {
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public ModelAndView updateStudent(Student student) {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("redirect:page");

        mv.addObject("student", userService.updateStudent(student));
        System.out.println("修改成功");
        return mv;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable(value = "id") int id) {
        userService.deleteStudent(id);
        System.out.println("删除成功");
        return "delete";

    }
}
