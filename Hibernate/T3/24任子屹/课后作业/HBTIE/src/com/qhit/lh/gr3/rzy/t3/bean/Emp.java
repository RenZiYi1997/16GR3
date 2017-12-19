package com.qhit.lh.gr3.rzy.t3.bean;

public class Emp {
	private int empId;
	private String empName;
	private String empSex;
	private String phone;
	private String address;
	//所属用户id
	private int deptId;
	//一对一关联对象（与用户）
	private User user;
	//多对一
	private Dept dept;
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(int empId, String empName, String empSex, String phone,
			String address, int deptId, User user, Dept dept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSex = empSex;
		this.phone = phone;
		this.address = address;
		this.deptId = deptId;
		this.user = user;
		this.dept = dept;
	}
	public Emp(int empId, String empName, String empSex, String phone,
			String address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSex = empSex;
		this.phone = phone;
		this.address = address;
		
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSex() {
		return empSex;
	}
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", empSex="
				+ empSex + ", phone=" + phone + ", address=" + address
				+ ", deptId=" + deptId + ", user=" + user + ", dept=" + dept
				+ "]";
	}
}