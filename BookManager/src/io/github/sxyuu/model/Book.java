package io.github.sxyuu.model;

/**
 * ͼ��ʵ����
 * @author Administrator
 *
 */
public class Book {
	
	private int id=0;  //ͼ��id
	private String bookName;  //ͼ������
	private String author;  //����
	private String sex;  //�����Ա�
	private float price ;  //�۸�
	private String bookDesc;  //����
	private int booktypeid =-1;  //����id
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
