package com.qhit.lh.gr3.rzy.t6.servise;

import java.util.List;

import com.qhit.lh.gr3.rzy.t6.bean.Emp;

public interface BaseServise {
	/**
	 * 增
	 */
public void add(Object obj);
/**
 * 删
 */
public void delect(Object obj);
/**
 * 改
 */
public void update(Object obj);
/**
 * 查
 */
public List<Object> getAll(String fromObject);
/**
 * 根据ID去查
 */
public Object getObjectById(Object obj, int id);
/**
 * 
 * @return
 * 根据名字模糊查询
 */
public List<Emp> getEmpByName(String name);

}
