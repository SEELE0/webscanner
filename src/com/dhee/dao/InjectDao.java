package com.dhee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dhee.entity.InjectEntity;
import com.dhee.entity.URLEntity;

public class InjectDao extends DBConnection {

	public List<InjectEntity> select() {
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<InjectEntity> list = new ArrayList<InjectEntity>();
		try {
			ps = con.prepareStatement("select * from SQLINJECT");
			rs = ps.executeQuery();
			while (rs.next()) {
				InjectEntity inject = new InjectEntity();
				inject.setId(rs.getString(1));  //取id
				inject.setSqlInject(rs.getString(2)); //取sql注入payload
				list.add(inject);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return list;
	}

	public List<URLEntity> selectByUrl(URLEntity urlEntity) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<URLEntity> list = new ArrayList<URLEntity>();
		try {
			ps = con
					.prepareStatement("SELECT * FROM URL WHERE USERID = ? AND URL=?");
			ps.setString(1, urlEntity.getUserId());
			ps.setString(2, urlEntity.getUrl());
			rs = ps.executeQuery();
			while (rs.next()) {
				URLEntity url = new URLEntity();
				url.setId(rs.getString(1));
				url.setUrl(rs.getString(2));
				url.setSql(rs.getString(3));
				url.setUserId(rs.getString(4));
				list.add(url);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return list;

	}

	public void updateUrl(URLEntity urlEntity) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		try {
			ps = con
					.prepareStatement("UPDATE  URL SET SQL= ? WHERE USERID = ? AND URL=?");
			ps.setString(1, urlEntity.getSql());
			ps.setString(2, urlEntity.getUserId());
			ps.setString(3, urlEntity.getUrl());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatement(ps);
			closeConnection(con);
		}
	}
	
	public void insertUrl(URLEntity urlEntity) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		try {
			ps = con
			.prepareStatement("INSERT INTO URL (ID,URL,SQL,USERID,XSS) VALUES (SYS_GUID(),?,?,?,'0')");
			ps.setString(1, urlEntity.getUrl());
			ps.setString(2, urlEntity.getSql());
			ps.setString(3, urlEntity.getUserId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatement(ps);
			closeConnection(con);
		}
	}
}
