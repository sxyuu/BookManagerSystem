package io.github.sxyuu.model;

/**
 * 图书实体类
 * @author Administrator
 *
 */
public class Book {
	
	private int id=0;  //图书id
	private String bookName;  //图书名称
	private String author;  //作者
	private String sex;  //作者性别
	private float price ;  //价格
	private String bookDesc;  //描述
	private int booktypeid =-1;  //类型id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	public int getBooktypeid() {
		return booktypeid;
	}
	public void setBooktypeid(int booktypeid) {
		this.booktypeid = booktypeid;
	}
	@Override
	public String toString() {
		return this.getBookName();
	}
	
	
	

}
