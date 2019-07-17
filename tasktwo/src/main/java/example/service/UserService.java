package example.service;
import example.pojo.Student;
import java.util.List;

/**  首先编写一个接口类UserService，里面存放了我们抽象出来的登录方法login
 *
 * @author wangqing
 */
public interface UserService {
    List<Student> getAllUser();

    /**
     * @param username
     * @param password
     * @return
     */
     boolean login(String username, String password);

     int insertStudent(Student student);

     int updateStudent(Student student);

     int deleteStudent(int id);

     Student select(int id);
}