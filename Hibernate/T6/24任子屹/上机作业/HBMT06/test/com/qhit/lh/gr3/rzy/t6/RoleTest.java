package com.qhit.lh.gr3.rzy.t6;

import org.junit.Test;

import com.qhit.lh.gr3.rzy.t6.bean.Role;
import com.qhit.lh.gr3.rzy.t6.bean.User;
import com.qhit.lh.gr3.rzy.t6.servise.BaseServise;
import com.qhit.lh.gr3.rzy.t6.servise.imp.BaseServiseImp;


public class RoleTest {
	private BaseServise base = new BaseServiseImp(); 
		

	@Test
	public void add(){
		Role role = new Role();
		role.setRoleName("刘德华");
		User user = (User) base.getObjectById(User.class, 1);
		role.getUser1().add(user);
		base.add(role);

		
	}
	public void delect(){
		Role role = (Role) base.getObjectById(Role.class, 2);
		base.delect(role);

	}
	public void update(){
		Role role = new Role();
		role.setRoleName("刘杰");
		User user = (User) base.getObjectById(User.class, 3);
		role.getUser1().add(user);
		base.add(role);
	}
	public void getAll(){
		Role role = (Role) base.getObjectById(Role.class, 4);
		for (User user : role.getUser1()) {
			System.out.println(user.getUserName()+":"+user.getUserId());
			}
	}
	

	}
