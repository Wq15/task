package mybatis.dao;
import mybatis.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface StudentDao {
    //@Select("select * from student where id = #{id}")
    //Student selectStudent( int id);
    @Select ( "select * from student" )
    List<Student>  selectStudent ( Student student );

    @Delete ( "delete from student where id=#{id}" )
    void deleteStudent ( int id );

    @Insert ( "insert into student (name,age) values(#{name},#{age})" )
    void insertStudent ( Student student );

    @Update ( "update student set name=#{name},age=#{age} where id =#{id}" )
    void updateStudent ( Student student );


}