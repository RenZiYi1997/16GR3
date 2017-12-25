package com.qhit.lh.gr3.rzy.t6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;




import com.qhit.lh.gr3.rzy.t6.dao.BaseDao;
import com.qhit.lh.gr3.rzy.t6.dao.imp.BaseDaoImp;
import com.qhit.lh.gr3.rzy.t6.servise.BaseServise;
import com.qhit.lh.gr3.rzy.t6.servise.imp.BaseServiseImp;
import com.qhit.lh.gr3.rzy.t6.bean.Dept;
import com.qhit.lh.gr3.rzy.t6.bean.Emp;
import com.qhit.lh.gr3.rzy.t6.bean.User;

public class DeptTest {
private	BaseServise base = new BaseServiseImp();

	@Test
	public void add() {
		//声明并实例化对象
		Dept dept = new Dept();
		//添加数据
		dept.setAddress("河南");
		dept.setDeptName("大国大厦");
		
		Emp emp = new Emp();
		emp.setEmpName("曾小贤");
		emp.setEmpSex("F");
		emp.setPhone("15089274561");
		emp.setAddress("爱情公寓");
		
		User user = new User();
		user.setUserName("周星驰");
		user.setPassword("123456");
		//一对一
		emp.setUser(user);
		user.setEmp(emp);
		//一对多
		dept.getEmps().add(emp);
		emp.setDept(dept);
		
	//执行
		base.add(emp);
		
		
		
		
	}
	@Test
	public void delete() {
		Emp emp = new Emp();
		emp = (Emp)base.getObjectById(emp, 1);
		base.delect(emp);
		
	}
	@Test
	public void update() {
		Emp emp = new Emp();
		emp.setEmpId(1);
		emp.setEmpName("吕子乔");
		emp.setEmpSex("F");
		emp.setPhone("15222890214");
		emp.setAddress("河南-周口");
		//分配一个账户
		User user = new User();
		user.setUserId(1);
		user.setUserName("jack");
		user.setPassword("666666");
		//建立一对一关系
		emp.setUser(user);
		user.setEmp(emp);
		//级联操作
		base.update(emp);
		
		
		
	}
	@Test
	public void getAll() {
		List<Object> list = base.getAll("from Emp");
		for(Object object : list ){
			Emp emp = (Emp) object;
			System.out.println(emp.toString());
		
	}

	}
	}
