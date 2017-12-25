package com.qhit.lh.gr3.rzy.t6.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.gr3.rzy.t6.bean.Emp;
import com.qhit.lh.gr3.rzy.t6.dao.BaseDao;
import com.qhit.lh.gr3.rzy.t6.utils.HibernateSessionFactory;

public class BaseDaoImp implements BaseDao {

	@Override
	public void add(Object obj) {
		//1，获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2,开启事务
		Transaction  ts = session.beginTransaction();
		//执行
		session.save(obj);
		//提交事务
		ts.commit();
		//释放资源
		HibernateSessionFactory.closeSession();

	}

	@Override
	public void delect(Object obj) {
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2，开启事务
		Transaction ts = session.beginTransaction();
		//3，执行
		session.delete(obj);
		//4,提交
		ts.commit();
		//释放资源
		HibernateSessionFactory.closeSession();
		
		
	}

	@Override
	public void update(Object obj) {
		//!,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2，开启事务
		Transaction ts = session.beginTransaction();
		//3,执行
		session.update(obj);
		//4,提交
		ts.commit();
		//5,释放资源
		HibernateSessionFactory.closeSession();
		
	}

	@Override
	public List<Object> getAll(String fromObject) {
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2,开启事务
		Transaction ts = session.beginTransaction();
		//3，获取查询对象
		Query query = session.createQuery(fromObject);
		List<Object> list = query.list();
		//4,提交事务
		ts.commit();
		//5,释放资源
		HibernateSessionFactory.closeSession();
		return list;
	}

	@Override
	public Object getObjectById(Object obj, int id) {
		//1，获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2,开启事务
		Transaction ts = session.beginTransaction();
		//3，获取查询对象
		obj = session.get(obj.getClass(), id);
		//4,提交事务
		ts.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();
		return obj;
	}

	@Override
	public List<Emp> getEmpByName(String name) {
		String hql = "select e from Emp e where e.ename like : name";
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2,开启事物
		Transaction ts = session.beginTransaction();
		//3,获取查询对象
		Query query = session.createQuery(hql);
		query.setString("name", name);
		List<Emp> list = query.list();
		//4,提交事务
		ts.commit();
		//5,释放资源
		HibernateSessionFactory.closeSession();
		return list;
	}

}
