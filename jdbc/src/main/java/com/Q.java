package com;

import java.sql.*;

public class Q {

    //public static void main ( String[] args ) {


    /**
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection ( ) {
        try {
            Class.forName ( "com.mysql.cj.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace ( );
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection ( "jdbc:mysql://location:3306/text?" + "serverTime=GMT" , "root" , "123456" );
        } catch ( SQLException e ) {
            e.printStackTrace ( );
        }
        return connection;
    }

    public static void main ( String[] args ) throws SQLException {


    //public static void insertQ ( ) throws SQLException {


        Connection connection = getConnection ( );
        System.out.println (connection );
        Statement statement = connection.createStatement ( );

        String name = "alibab";
        int age = 9;
        String sql = "insert into ss(name,age) values(?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement ( sql );
        preparedStatement.setString ( 1 , name );
        preparedStatement.setInt ( 2 , age );
        preparedStatement.execute ( );
        statement.close ( );
        connection.close ( );
        System.out.println ( "插入成功" );

    }

}