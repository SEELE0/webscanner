package com.dhee.dao;

import java.sql.*;

public class test {
    public static void main(String[] args) throws ClassNotFoundException,SQLException{
        String driver = "oracle.jdbc.driver.OracleDriver";
        //2、定义连接URL
        String url = "jdbc:oracle:thin:@192.168.78.100:1521:orcl";
        String username = "scott";//用户名
        String password = "123456";//密码
        Connection conn=DriverManager.getConnection(url,username,password);
        System.out.println(conn);
        try {
            Class.forName(driver);
            System.out.println("连接成功");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("连接失败");
        }
    }
}