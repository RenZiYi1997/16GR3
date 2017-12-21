package com.qhit.lh.gr3.rzy.t4.bean;

import java.util.HashSet;
import java.util.Set;

public class Dept {
	private int deptId;
	private String address;
	private String deptName;
	
   //yiduiduo
	private Set<Emp> emps = new HashSet<>();
	
	
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dept(int deptId, String address, String deptName, User user) {
		super();
		this.deptId = deptId;
		this.address = address;
		this.deptName = deptName;
	
	}

	public Dept(int deptId, String address, String deptName) {
		super();
		this.deptId = deptId;
		this.address = address;
		this.deptName = deptName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	



	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", address=" + address
				+ ", deptName=" + deptName + ", ]";
	}

}
