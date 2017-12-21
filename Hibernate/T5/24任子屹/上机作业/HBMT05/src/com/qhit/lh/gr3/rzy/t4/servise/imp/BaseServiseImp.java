package com.qhit.lh.gr3.rzy.t4.servise.imp;

import java.util.List;

import com.qhit.lh.gr3.rzy.t4.dao.BaseDao;
import com.qhit.lh.gr3.rzy.t4.dao.imp.BaseDaoImp;
import com.qhit.lh.gr3.rzy.t4.servise.BaseServise;








public class BaseServiseImp implements BaseServise {
	private BaseDao baseDao = new BaseDaoImp();

	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		baseDao.add(obj);
		
	}

	@Override
	public void delect(Object obj) {
		// TODO Auto-generated method stub
		baseDao.delect(obj);
		
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		baseDao.update(obj);
		
	}

	@Override
	public List<Object> getAll(String fromObject) {
		// TODO Auto-generated method stub
		return baseDao.getAll(fromObject);
	}

	@Override
	public Object getObjectById(Object obj, int id) {
		// TODO Auto-generated method stub
		return baseDao.getObjectById(obj, id);
	}

	
}
