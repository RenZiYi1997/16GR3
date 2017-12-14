package com.qhit.lh.gr3.rzy.t3.bean;
/**
 * 
 * @author S01
 *
 */
public class User {
	private int userId;
	private String userName;
	private String password;
	//与员工对象关联
	private Emp emp;
	//无参
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	//全参
	public User(int userId, String userName, String password, Emp emp) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.emp = emp;
	}
	//除Emp全部参数
	public User(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", emp=" + emp + "]";
	}
	
	

}
