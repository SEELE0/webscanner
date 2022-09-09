package com.dhee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dhee.entity.URLEntity;
import com.dhee.entity.XSSEntity;

public class XssDao extends DBConnection{
    public List<XSSEntity> select() {
        Connection con = getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<XSSEntity> list = new ArrayList<XSSEntity>();
        try {
            ps=con.prepareStatement("SELECT * FROM MYXSS");
            rs= ps.executeQuery();
            while(rs.next()){
                XSSEntity xss = new XSSEntity();
                xss.setId(rs.getString(1));
                xss.setXssPayload(rs.getString(2));
                list.add(xss);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            closeResultSet(rs);
            closeStatement(ps);
            closeConnection(con);
        }
        return list;
    }

    public List<URLEntity> selectByUrl(URLEntity urlEntity) {
        Connection con = getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<URLEntity> list = new ArrayList<URLEntity>();
        try {
            ps = con.prepareStatement("SELECT * FROM URL WHERE USERID = ? AND URL=?");
            ps.setString(1, urlEntity.getUserId());
            ps.setString(2, urlEntity.getUrl());
            rs=ps.executeQuery();
            while(rs.next()){
                URLEntity url = new URLEntity();
                url.setId(rs.getString(1));
                url.setUrl(rs.getString(2));
                url.setSql(rs.getString(3));
                url.setUserId(rs.getString(4));
                url.setXss(rs.getString(5));
                list.add(url);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            closeResultSet(rs);
            closeStatement(ps);
            closeConnection(con);
        }
        return list;
    }

    public void updateUrl(URLEntity urlEntity) {
        Connection con = getConnection();
        PreparedStatement ps=null;
        try {
            ps = con.prepareStatement("UPDATE URL SET XSS= ? WHERE USERID=? AND URL=?");
            ps.setString(1, urlEntity.getXss());
            ps.setString(2, urlEntity.getUserId());
            ps.setString(3, urlEntity.getUrl());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            closeStatement(ps);
            closeConnection(con);
        }

    }

    public void insertUrl(URLEntity urlEntity) {
        Connection con = getConnection();
        PreparedStatement ps=null;
        try {
            ps = con.prepareStatement("INSERT INTO URL(ID,URL,SQL,USERID,XSS) VALUES(SYS_GUID(),?,'0',?,?)");
            ps.setString(1, urlEntity.getUrl());

            ps.setString(2, urlEntity.getUserId());

            ps.setString(3, urlEntity.getXss());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            closeStatement(ps);
            closeConnection(con);
        }

    }



}
