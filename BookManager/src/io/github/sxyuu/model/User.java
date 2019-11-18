package io.github.sxyuu.model;

/**
 * 用户实体
 * @author Administrator
 *
 */

public class User {

	private int id;
	private String userName;
	private String passWord;
	
	public User() {
		
	}
	
	public User(String u ,String p) {
		this.userName = u;
		this.passWord = p;
	}
	
	public User(int i ,String u ,String p) {
		this.id = i;
		this.userName = u;
		this.passWord = p;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}

	