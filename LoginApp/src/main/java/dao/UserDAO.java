package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbcutils.DBUtils;
import models.UserModels;

public class UserDAO {
	public static UserDAO getInstance() {
		return new UserDAO();
	}
	
	public UserModels checkAccount(String username, String password) throws SQLException {
		Connection con = DBUtils.getConnection();
		
		String url = "SELECT * FROM user_pass WHERE username = ? AND pass = ?";
		
		PreparedStatement statement = con.prepareStatement(url); 		
		
		statement.setString(1, username);
		statement.setString(2, password);
		
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			Long id = rs.getLong("id");
			String rsUser = rs.getString("username");
			String rsPass = rs.getString("pass");
			
			UserModels account = new UserModels(id, rsUser, rsPass);
			
			return account;
		}
		
		con.close();
		
		return null;
	}
}
