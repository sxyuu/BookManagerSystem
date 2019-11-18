package io.github.sxyuu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.sxyuu.Util.StringUtil;
import io.github.sxyuu.model.BookType;

/**
 * ͼ��������ݿ����
 * @author Administrator
 *
 */
public class BookTypeDao {

	/**
	 * ���ͼ�����
	 */
	public int add(Connection con , BookType booktype)throws Exception {
		
		String sql = "insert into t_booktype value(null,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, booktype.getBookTypeName());
		pstmt.setString(2, booktype.getTypeDesc());
		return pstmt.executeUpdate();
		
	}
	
	/**
	 * ����ͼ�����
	 */
	
	public ResultSet find(Connection con ,BookType booktype)throws Exception {
		StringBuffer sql = new StringBuffer("select * from t_booktype ");
		if(!StringUtil.isEmpty(booktype.getBookTypeName())) {
			sql.append("where bookTypeName like '%"+booktype.getBookTypeName()+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		return pstmt.executeQuery();
	}
	
	/**
	 * ɾ��ͼ�����
	 */
	public int DeleteType (Connection con , String id) throws Exception{
		String sql = "delete from t_booktype where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		return pstmt.executeUpdate();
		
	}
	
	/**
	 * ����ͼ�����
	 */
	public int update(Connection con,BookType booktype)throws Exception {
		String sql = "update t_booktype set bookTypeName = ? ,bookTypeDesc = ? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, booktype.getBookTypeName());
		pstmt.setString(2, booktype.getTypeDesc());
		pstmt.setInt(3, booktype.getId());
		return pstmt.executeUpdate();
	}
	
}
