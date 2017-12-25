package com.qhit.lh.gr3.rzy.t6.bean;

import java.util.HashSet;
import java.util.Set;

public class Role {
	private int roleId;
	private String roleName;
	private String memo;
	
	private Set<User> user1 = new HashSet<>();

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int roleId, String roleName, String memo, Set<User> user1) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.memo = memo;
		this.user1 = user1;
	}
	

	public Role(int roleId, String roleName, String memo) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", memo=" + memo
				+ ", user1=" + user1 + "]";
	}

	public int getId() {
		return roleId;
	}

	public void setId(int roleId) {
		this.roleId= roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Set<User> getUser1() {
		return user1;
	}

	public void setUser1(Set<User> user1) {
		this.user1 = user1;
	}
	

}
