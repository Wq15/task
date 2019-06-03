package com.elements.user;

import com.elements.user.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUser {



    @Test
    public void TestSelectAll ( ) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream ( resource );
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder ( ).build ( inputStream );

        SqlSession session = sqlSessionFactory.openSession ( );
        try {

            List < User > userlist = session.selectList ( "com.elements.user.mapper.getAllUser" );

            System.out.print ( userlist );

        } catch ( Exception e ) {
            System.out.print ( e );
        } finally {
            session.close ( );
        }

    }

    @Test
    public void TestSelect ( ) throws IOException {
        //
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream ( resource );
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder ( ).build ( inputStream );
        SqlSession session = sqlSessionFactory.openSession ( );
        try {

            User user = new User ();
            user.setUserId ( 1 );
            user.setUserName ("42");


                   user = session.selectOne ( "com.elements.user.mapper.getUserById" , user );

            System.out.print ( user );

        } finally {
            session.close ( );
        }

    }

    @Test
    public void TestInsert ( ) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream ( resource );
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder ( ).build ( inputStream );
        SqlSession session = sqlSessionFactory.openSession ( );
        try {
            User user = new User ( );
            user.setUserId ( 3 );
            user.setUserName ( "e85" );
            user.setUserAge ( "36" );
            session.update ( "com.elements.user.mapper.insert" , user );
            session.commit ( );

        } finally {

            session.close ( );
        }
    }

    @Test
    public void TestUpdate ( ) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream ( resource );
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder ( ).build ( inputStream );
        SqlSession session = sqlSessionFactory.openSession ( );
        try {
            User user = new User ( );
            user.setUserId ( 3 );
            user.setUserName ( "aYaa啊" );
            user.setUserAge ( "89" );
            int rs = session.update ( "com.elements.user.mapper.update" , user );
            System.out.println ( "执行结果：" + rs );
            session.commit ( );
        } finally {
            session.close ( );
        }
    }

    @Test
    public void Testdelete ( ) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream ( resource );
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder ( ).build ( inputStream );
        SqlSession session = sqlSessionFactory.openSession ( );

        try {

            session.delete ( "com.elements.user.mapper.delete" , 3 );
            session.commit ( );

        } finally {
            session.close ( );
        }

    }
}