package service.serviceImpl;

import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import service.StudentDAO;

import java.util.List;
import java.util.Map;

/**
 * @author Cage Yang
 * @ClassName StudentDAOSpringImpl
 * @description
 */
@Service
public class StudentDAOImpl implements StudentDAO {

    
    public boolean addStu ( Student student ) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext ( "applicationContext.xml" );
        JdbcTemplate jdbcTemplate = ( JdbcTemplate ) applicationContext.getBean ( "jdbcTemplate" );

        String sql = "insert into student(name,age) values(?,?)";

        System.out.println ( jdbcTemplate == null );

        jdbcTemplate.update ( sql , student.getName ( ) , student.getAge ( ) );

        return false;
    }

    public boolean delStu ( Student stu ) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext ( "applicationContext.xml" );
        JdbcTemplate jdbcTemplate=(JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        String sql ="delete from student where id =?";
        jdbcTemplate.update ( sql, 3);
        return true;
    }

    public boolean updateStu ( Student stu ) {

        ApplicationContext   applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        String sql="update student set name=?,age=? where id=?";


     jdbcTemplate.update(sql,28,58,1);


     return false;
    }

    public boolean queryStu ( Student stu ) {
        ApplicationContext   applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        String sql="select id,name,age from student where id=?";

        RowMapper<Student> rowMapper=new BeanPropertyRowMapper<Student>(Student.class);
        Student student= jdbcTemplate.queryForObject(sql, rowMapper,1);
        System.out.println(student);
        return false;
    }
    public void selectStu ( Student stu){
        ApplicationContext   applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        String sql="select *  from student ";

        RowMapper<Student> rowMapper=new BeanPropertyRowMapper<Student>(Student.class);
         List<Student> users= jdbcTemplate.query(sql, rowMapper);
        for (Student user : users) {
            System.out.println ( user );

        }

    }
}
