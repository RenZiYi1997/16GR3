package com.qhit.lh.gr3.rzy.t4.bean;

import java.util.HashSet;
import java.util.Set;

public class Dept {
	private int deptId;
	private String address;
	private String deptName;
	private Set<Dept> emps;
	
	
   //yiduiduo
	//private Set<Dept> emps = new HashSet<>();
	
	
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

	

	public Set<Dept> getEmps() {
		return getEmps();
	}

	public void setEmps(Set<Dept> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", address=" + address
				+ ", deptName=" + deptName + ", ]";
	}

}
