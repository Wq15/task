package com.zzw.test;

import com.zzw.mapper.UserMapper;
import com.zzw.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserTest {

    private  SqlSession sqlSession;

    @Before
    public void before(){

    }

    @Test
    public void test(){
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream("myBatis.xml"));
        sqlSession=sqlSessionFactory.openSession();

        UserMapper um=sqlSession.getMapper(UserMapper.class);


        //List <User> users=um.findAllUser();
        //for (User u : users) {
        //    System.out.println(u.getId() + "\t" + u.getName() + "\t" + u.getAge());
        //}



        //for(int x=0;x<10;x++){
        //User uu=new User();
        //uu.setName ( "asd" );
        //uu.setAge ( "12" );
        //um.addUser(uu); }

        //User user = new User ( );
        //
        //user.setUserName ( "e858qrrr" );
        //user.setUserEmail ( "yk" );
        //
        //session.update ( "com.elements.user.mapper.insert" , user );

        //session.commit ( );

       // ////修改
       // User u=new User();
       // u.setId ( 41 );
       // u.setName ( "张三" );
       // u.setAge ( "18" );
       //um.updateUserById ( u );
       // System.out.println("数据更改成功");

        ////删除
        //int i=um.deleteById(42);
        //System.out.println(i+"受影响");

        ////提交
        sqlSession.commit();


    }


}