package io.github.sxyuu.model;

public class BookType {
	
	private int id ;
	private String bookTypeName;
	private String typeDesc;
	
	public BookType(){
		
	}
	
	public BookType(String bktpn , String tdesc){
		
		this.bookTypeName = bktpn ;
		this.typeDesc = tdesc ;
		
	}
	
	public BookType(int id ,String bktpn , String tdesc){
		this.id = id;
		this.bookTypeName = bktpn ;
		this.typeDesc = tdesc ;
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	@Override
	public String toString() {
		return this.getBookTypeName();
	}
	
	

}
