package com;

import java.sql.*;

public class JdbcTest {

    public static Connection getConnection ( ) {
        try {
            // 1.注意此时Driver是在com.mysql.jdbc包中
            Class.forName ( "com.mysql.cj.jdbc.Driver" );
            /**
             * 2.
             *
             * jdbc:mysql://：这是固定的写法，表示使用jdbc连接mysql数据库
             * localhost：ip地址，本地可以写成localhost。
             * 3306：mysql的端口号。
             * text：数据库的名字。
             * 第一个root：mysql的用户名
             * 第二个root：mysql的密码。
             */
            Connection connection = DriverManager.getConnection ( "jdbc:mysql://localhost:3306/text?serverTimezone=GMT" , "root" , "123456");
            return connection;
        } catch ( SQLException e ) {
            e.printStackTrace ( );
            return null;
        } catch ( ClassNotFoundException e ) {
            return null;
        }
    }
    public static boolean insertStudent ( ) {
        try {
            //1，得到Connection对象，
            Connection connection = getConnection ( );
            //2，通过Connection获取一个操作sql语句的对象Statement
            Statement statement = connection.createStatement ( );
            //3，获取需要传递的参数
            String name = "Tom";
            int age = 18;
            //4，写sql语句，参数使用？占位符
            String sql = "insert into student (name,age) VALUE (?,?)";
            //5，得到PreparedStatement对象
            PreparedStatement preparedStatement = connection.prepareStatement ( sql );
            //6，通过PreparedStatement对象设置参数
            preparedStatement.setString ( 1 , name );
            preparedStatement.setInt(2, age);
            //7，执行sql语句
            preparedStatement.execute ( );
            //8，释放资源
            statement.close ( );
            connection.close ( );
            return true;
        } catch ( SQLException e ) {
            e.printStackTrace ( );
            return false;
        }
    }

    public static void main ( String[] args ) {
        long a=System.currentTimeMillis();
        for ( int j = 0 ; j < 10 ; j++ ) {
            for ( int i = 0 ; i < 10; i++ ) {
                boolean rs = insertStudent ( );
                System.out.println (rs );
            }
        }
        System.out.println ( "\r<br> 执行耗时 : " + ( System.currentTimeMillis ( ) - a ) / 1000f + " 秒 " );
    }
}

