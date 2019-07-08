package com;
import java.sql.*;
public class Test {
    public static void main(String[] args) {
        int a = 4, b = 6, c = a * b;
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/text?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true", "root", "123456");
            conn.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println ("捕获异常===-----------=" );
        }
        String sql = "INSERT INTO usertwo(name,address) VALUES (?,?)";
        long startTime = System.currentTimeMillis();

        try {
            StringBuilder sqls = new StringBuilder();

            conn.setAutoCommit(false);

            PreparedStatement pst = conn.prepareStatement(sql);

            for (int x = 1; x <= a; x++) {
                for (int y = 1; y <= b; y++) {
                    pst.setString(1, "王五");
                    pst.setString(2, "强强");

                    pst.addBatch();
                }
                pst.executeBatch();
                conn.commit();
            }
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println ("捕获异常====" );
        }

        long endTime = System.currentTimeMillis();
        System.out.println("插入" + c + "条数据, " + "运行时间：" + (endTime - startTime)/1000 + "秒");
    }
}

