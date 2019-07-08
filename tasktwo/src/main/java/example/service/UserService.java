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
    public boolean login(String username, String password);

    public int insertStudent(Student student);

    public int updateStudent(Student student);

    public int deleteStudent(int id);
}