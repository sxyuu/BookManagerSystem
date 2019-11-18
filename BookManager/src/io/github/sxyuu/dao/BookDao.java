package io.github.sxyuu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import io.github.sxyuu.Util.StringUtil;
import io.github.sxyuu.model.Book;
import io.github.sxyuu.model.BookType;

/**
 * ͼ�����ݿ����
 * @author Administrator
 *
 */
public class BookDao {

	/**
	 * ���ͼ��
	 * @return 
	 */
	public int addBook(Connection con , Book book)throws Exception {
		
		String sql = "insert into t_book value(null,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setInt(5, book.getBooktypeid());
		pstmt.setString(6, book.getBookDesc());
		return pstmt.executeUpdate();
		
	}
	
	/**
	 * ����ͼ��
	 */
	public ResultSet findbook(Connection con ,Book book)throws Exception {
		StringBuffer sql = new StringBuffer("select * from t_book b,t_booktype bt where b.booktypeid = bt.id ");
		if(!StringUtil.isEmpty(book.getBookName())) {
			sql.append("and b.bookname like '%" +book.getBookName() +"%' ");
		}
		if(!StringUtil.isEmpty(book.getAuthor())) {
			sql.append("and b.author like '%" +book.getAuthor()+ "%'");
		}
		if(book.getBooktypeid() !=-1) {
			sql.append("and b.booktypeid ="+book.getBooktypeid());
		}
		
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		return pstmt.executeQuery();
	}
	
	/**
	 * ͼ����Ϣ�޸�
	 */
	
	public int update(Connection con , Book book) throws Exception{
		
		String sql = "update t_book set bookname = ? ,author = ? ,sex = ? ,price = ? ,booktypeid = ? ,bookdesc = ? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setInt(5, book.getBooktypeid());
		pstmt.setString(6, book.getBookDesc());
		pstmt.setInt(7, book.getId());
		return pstmt.executeUpdate();
		
	}
	
	/**
	 * ɾ��ͼ��
	 */
	public int delet(Connection con ,String id) throws Exception{
		String sql = "delete from t_book where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		return pstmt.executeUpdate();
		
	}
	
}
