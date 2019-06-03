package com.zzw.mapper;

import com.zzw.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    //注解式开发

    //查询所有信息
    @Select("select * from student")
    @Results({
                     @Result(property = "id",column = "id",id=true),
                     @Result(property = "name",column = "name"),
                     @Result(property = "age",column = "age")
             })
    public List<User> findAllUser();


    //增加
    @Insert("insert into student (name,age)values(#{name},#{age})")
    @Results({
                     @Result(property = "id" ,column = "id",id=true),
                     @Result(property = "name" ),
                     @Result(property = "age")
             })
    public void addUser(User u);


    //修改
    @Update("update student set name = #{name},age=#{age} where id=#{id}")
    public int updateUserById(User user);

    //删除
    @Delete("delete from student where id=#{id}")
    public int deleteById(int id);

}