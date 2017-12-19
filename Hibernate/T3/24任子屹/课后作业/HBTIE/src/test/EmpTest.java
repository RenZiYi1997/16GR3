package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;





import com.qhit.lh.gr3.rzy.t3.bean.Dept;
import com.qhit.lh.gr3.rzy.t3.bean.Emp;
import com.qhit.lh.gr3.rzy.t3.bean.User;
import com.qhit.lh.gr3.rzy.t3.servise.BaseServise;
import com.qhit.lh.gr3.rzy.t3.servise.imp.BaseServiseImp;

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
	

}
