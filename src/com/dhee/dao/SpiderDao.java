package com.dhee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.dhee.entity.UserEntity;

public class SpiderDao extends DBConnection {

	public void insert(List<String> enableUrl, UserEntity user) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(
					"INSERT INTO URL (ID,URL,SQL,USERID,XSS) VALUES (SYS_GUID(),?,'0',?,'0')");
			for (String url : enableUrl) {
				ps.setString(1, url);
				ps.setString(2, user.getId());
				ps.addBatch();//addBatch()是把若干sql语句装载到一起，然后一次性传送到数据库执行，即是批量处理sql数据的。所以“冲突”得到解决，执行时间大大缩短。
			}
			ps.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatement(ps);
			closeConnection(con);
		}

	}

}
