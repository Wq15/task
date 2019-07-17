package example.controller;

import example.pojo.Student;
import example.pojo.User;
import example.service.UserService;
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
 * 在默认情况下springmvc的实例都是单例模式,所以使用scope域将其注解为每次都创建一个新的实例
 * */
@Controller
@Scope("prototype")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
    @Resource
    private UserService service;

    /**
     * 返回user对象信息给page1.jsp处理，然后在前端页面展示
     */
    @RequestMapping("/user/page")
    public ModelAndView getUser() {
        logger.info("查询所有信息");
        ModelAndView mav = new ModelAndView("page1");
        List<Student> users = service.getAllUser();

        mav.addObject("user", users);

        List<Student> resylt=service.getAllUser();
        logger.info("resylt:"+resylt.size());
        return mav;
    }


    @Autowired
    UserService userService;

    /**
     * login业务的访问位置为/user/login
     */

    @RequestMapping(value = "/user/login", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public String login(User user, HttpServletRequest request) {
        logger.info("user:"+user);
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
            logger.info("loginType:"+loginType);
            return "dlsb";
        }
    }
    @RequestMapping(value = "/select",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    public ModelAndView select(@PathVariable(value = "id") int id){
        logger.info("id"+id);
         ModelAndView mav =new ModelAndView("selectone");

        List<Student> users = service.getAllUser();

        mav.addObject("user", users);

        logger.info("users"+users);
        return mav;
    }


    @RequestMapping(value = "/user/insert", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public ModelAndView insert(Student student) {
        logger.info("student:"+student);
        int result=userService.insertStudent(student);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:page");
        mv.addObject("student", userService.insertStudent(student));

        logger.info("插入成功"+result);
        return mv;
    }

    @RequestMapping(value = "/user/add")
    public String inserStudent() {
        return "insert";
    }

    @RequestMapping(value = "/user/updateone/{id}",method=RequestMethod.GET)
    public ModelAndView updateStudent(@PathVariable(value = "id") int id) {
        logger.info("id:"+id);
        ModelAndView mv=new ModelAndView();

        Student studentone =userService.select(id);
        mv.addObject("studentone",studentone);

        logger.info("studentone:"+studentone);
        mv.setViewName("update");
        return mv;
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public ModelAndView updateStudent(Student student) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:page");
        mv.addObject("student", userService.updateStudent(student));
        return mv;
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable(value = "id") int id) {
        userService.deleteStudent(id);

        logger.info("id:"+id);
        return "delete";

    }
}
