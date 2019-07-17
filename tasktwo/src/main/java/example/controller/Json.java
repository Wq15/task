package example.controller;

        import example.pojo.Student;
        import example.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.ResponseBody;
        import java.util.List;

@Controller
public class Json {

    @Autowired
    UserService userService;
    @ResponseBody
    @RequestMapping(value ="/list",method = RequestMethod.GET)
    public List<Student> getUser(){

        List<Student> students=userService.getAllUser();
        System.out.println(1234567946);
        return students;
    }
}
