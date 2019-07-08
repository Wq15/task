package example.service;
import example.dao.UserDao;
import example.pojo.Student;
import example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("userServiceImpl")
@Scope("prototype")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public List<Student> getAllUser() {

        return userDao.getAllUsers();
    }

    @Override
    public  int insertStudent(Student student) {

        return userDao.insertStudent(student);
    }

    @Override
    public  int deleteStudent(int id) {

        return userDao.deleteStudent(id);
    }

    @Override
    public int updateStudent(Student student) {
        return userDao.updateStudent(student);
    }

    //下面是实现登陆的服务层代码；
    //自动注入userdao 用于访问数据库
    @Autowired
    UserDao Mapper;
    //登录方法的实现,从jsp页面获取username与password
    @Override
    public boolean login(String username, String password) {
        User user = Mapper.selectByName(username);

        if (user != null) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
            }
        return false;
    }
}