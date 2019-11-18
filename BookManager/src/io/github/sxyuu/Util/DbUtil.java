package io.github.sxyuu.Util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ���ݿ⹤����
 * @author Administrator
 *
 */

public class DbUtil {

	private String dbUrl = "jdbc:mysql://localhost:3306/db-book?serverTimezone=GMT"; //���ڰ汾���£�����ְ汾�����ݣ�Ӧ����?serverTimezone=GMT
	private String dbUser = "root";//�û���
	private String dbPassword = "root";//����
	private String jdbcName = "com.mysql.cj.jdbc.Driver";//��������
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		return con ;
		
	}
	
	/**
	 * �ر����ݿ�����
	 * @param con
	 * @throws Exception
	 */
	public void closeCon (Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	
	
	
	/**
	 * �������ݿ��ܷ�����
	 */
	/*
	public static void main(String[] args) {
		DbUtil dbutil = new DbUtil();
		try {
			Connection c = dbutil.getCon();
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
		
	}
	*/
}
