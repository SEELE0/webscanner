package com.dhee.dao;

import java.sql.*;

public class test {
    public static void main(String[] args) throws ClassNotFoundException,SQLException{
        String driver = "oracle.jdbc.driver.OracleDriver";
        //2����������URL
        String url = "jdbc:oracle:thin:@192.168.78.100:1521:orcl";
        String username = "scott";//�û���
        String password = "123456";//����
        Connection conn=DriverManager.getConnection(url,username,password);
        System.out.println(conn);
        try {
            Class.forName(driver);
            System.out.println("���ӳɹ�");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("����ʧ��");
        }
    }
}