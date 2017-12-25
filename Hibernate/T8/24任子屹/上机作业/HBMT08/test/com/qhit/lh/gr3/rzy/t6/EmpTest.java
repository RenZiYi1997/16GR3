package com.qhit.lh.gr3.rzy.t6;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;












import com.qhit.lh.gr3.rzy.t6.servise.BaseServise;
import com.qhit.lh.gr3.rzy.t6.servise.imp.BaseServiseImp;
import com.qhit.lh.gr3.rzy.t6.utils.HibernateSessionFactory;
import com.qhit.lh.gr3.rzy.t6.bean.Dept;
import com.qhit.lh.gr3.rzy.t6.bean.Emp;
import com.qhit.lh.gr3.rzy.t6.bean.User;

public class EmpTest {
private BaseServise base = new BaseServiseImp();

	@Test
	public void add() {
		
		Emp emp = new Emp();
		emp.setEmpName("小明");;
		emp.setEmpSex("男");
		emp.setPhone("15083154215");
		emp.setAddress("河南-周口");
		
		
		User user = new User();
		user.setUserName("tom");
		user.setPassword("123456");
		//所属部门
		Dept dept = (Dept) base.getObjectById(emp, 2);
		//一对一
		emp.setUser(user);
		user.setEmp(emp);
		//多对一
		emp.setDept(dept);
		//
		base.add(emp);
		
	}
	@Test
	public void delete() {
		Emp emp = new Emp();
		emp = (Emp) base.getObjectById(emp, 1);
		base.delect(emp);
	}
	@Test
	public void update() {
		Emp emp = new Emp();
		emp.setEmpId(1);
		emp.setEmpName("小风");
		emp.setEmpSex("女");
		emp.setPhone("15225890216");
		emp.setAddress("河南-漯河");
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
		List<Object> list = base.getAll("fromObject");
		for(Object object : list ){
			Emp emp = (Emp) object;
			System.out.println(emp.toString());
		}
		
	}
	/**
	 * 按员工姓名进行模糊查询
	 */
	@Test
	public void getEmpByName(){
		List<Emp> list = base.getEmpByName("%刘%");
		
		for(Emp emp : list){
			System.out.println(emp.getEmpId()+":"+emp.getEmpName());
		}
	}
	/**
	 * 根据名字模糊查询
	 */
       @Test
       public void getEmpLikeName(){
    	 //1,获取session对象
    	   Session session = HibernateSessionFactory.getSession();
    	 //2,通过session对象创建criteria条件查询器
    	  Criteria criteria = session.createCriteria(Emp.class)
    			  .add(Restrictions.like("empName","刘%"));
    	  //3,通过criteria条件查询器进行查询
    	  List<Emp> list = criteria.list();
    	  for(Emp emp : list){
    		  System.out.println(emp.getEmpId()+":"+emp.getEmpName());
    	  }
    	 
       }
}
