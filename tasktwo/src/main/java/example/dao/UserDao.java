package example.dao;

import example.pojo.Student;
import example.pojo.User;


import java.util.List;

/**
 * @author wangqing
 */
public interface UserDao {
    List<Student> getAllUsers();

    /**这里以接口形式定义了数据库操作方法,我们只需在Mybatis映射文件中对其进行映射就可以直接使用
    */
    User selectByName(String username);

    int insertStudent(Student student);
    
    int updateStudent(Student student);

    int deleteStudent(int id);

    Student select(int id);

}