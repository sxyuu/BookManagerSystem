package io.github.sxyuu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import io.github.sxyuu.model.User;

/**
 * 用户DAO类
 * @author Administrator
 *
 */


public class UserDao {
/**
 * 登录验证
 * @param con
 * @param user
 * @return
 * @throws Exception
 */
	public User login(Connection con,User user)throws Exception{
		User resultUser = null;
		String sql = "select * from t_user where userName =? and passWord = ?";
		PreparedStatement pstmt =con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassWord());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			resultUser = new User(rs.getInt("id"),rs.getString("userName"),rs.getString("passWord"));
			
		}
		
		
		return resultUser;
	}
	
}
