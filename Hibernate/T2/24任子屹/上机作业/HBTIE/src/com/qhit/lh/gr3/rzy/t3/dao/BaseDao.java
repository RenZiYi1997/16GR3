package com.qhit.lh.gr3.rzy.t3.dao;

import java.util.List;

public interface BaseDao {
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
}
