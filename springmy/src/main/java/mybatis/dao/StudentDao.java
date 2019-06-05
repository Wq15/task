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
    List <Student> selectStudent ( );

    @Delete ( "delete from student where id=#{id}" )
    void deleteStudent ( int id );

    @Insert ( "insert into student (name,types_of_correction ,admission_data,mentor_brother,oath) values(#{name},#{types_of_correction},#{admission_data},#{mentor_brother},#{oath})" )
    void insertStudent ( Student student );

    @Update ( "update student set name=#{name},types_of_correction=#{types_of_correction},admission_data=#{admission_data},mentor_brother=#{mentor_brother},oath=#{oath} where id =#{id}" )
    void updateStudent ( Student student );


}