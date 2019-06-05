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

            User user = new User ( );
            user.setId ( 2 );
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
            user.setName ( "王二" );
            user.setTypes_of_correction ( "pm工程师" );
            user.setAdmission_data ( "2019-1-3 " );
            user.setMentor_brother ( "人人" );
            user.setOath ( "必须学好" );
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
            user.setId ( 4 );
            user.setName ( "aYaa啊" );
            user.setTypes_of_correction ( "java工程师" );
            user.setAdmission_data ( "2019-1-5 " );
            user.setMentor_brother ( "刘飞" );
            user.setOath ( "必须学好，一个不少" );
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