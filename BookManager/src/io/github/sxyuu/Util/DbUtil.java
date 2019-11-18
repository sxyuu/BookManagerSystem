package io.github.sxyuu.Util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类
 * @author Administrator
 *
 */

public class DbUtil {

	private String dbUrl = "jdbc:mysql://localhost:3306/db-book?serverTimezone=GMT"; //由于版本更新，与出现版本不兼容，应加上?serverTimezone=GMT
	private String dbUser = "root";//用户名
	private String dbPassword = "root";//密码
	private String jdbcName = "com.mysql.cj.jdbc.Driver";//驱动名称
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		return con ;
		
	}
	
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public void closeCon (Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	
	
	
	/**
	 * 测试数据库能否连接
	 */
	/*
	public static void main(String[] args) {
		DbUtil dbutil = new DbUtil();
		try {
			Connection c = dbutil.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		
	}
	*/
}
