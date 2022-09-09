package com.dhee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dhee.entity.URLEntity;
import com.dhee.entity.UserEntity;

public class UrlDao extends DBConnection {

	public List<URLEntity> selectByUserId(UserEntity userEntity) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<URLEntity> list = new ArrayList<URLEntity>();

		try {
			ps = con.prepareStatement("SELECT * FROM URL WHERE USERID = ?");
			ps.setString(1, userEntity.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
				URLEntity url = new URLEntity();
				url.setId(rs.getString(1));
				url.setUrl(rs.getString(2));
				url.setSql(rs.getString(3));
				url.setUserId(rs.getString(4));
				//
				url.setXss(rs.getString(5));
				//
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
	
	public void delUrl(String urlId){
		Connection con = getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("DELETE URL WHERE ID = ?");
			ps.setString(1, urlId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatement(ps);
			closeConnection(con);
		}
	}
	
	public List<URLEntity> selectURL(UserEntity userEntity){
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<URLEntity> list = new ArrayList<URLEntity>();

		try {
			ps = con.prepareStatement("SELECT * FROM URL WHERE USERID = ? AND NOT SQL ='0'");
			ps.setString(1, userEntity.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
				URLEntity url = new URLEntity();
				url.setId(rs.getString(1));
				url.setUrl(rs.getString(2));
				url.setSql(rs.getString(3));
				url.setUserId(rs.getString(4));
				//
				url.setXss(rs.getString(5));
				//

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

}
