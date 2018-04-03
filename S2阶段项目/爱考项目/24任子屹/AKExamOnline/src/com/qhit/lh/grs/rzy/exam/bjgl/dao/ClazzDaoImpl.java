/**
 * 
 */
package com.qhit.lh.grs.rzy.exam.bjgl.dao;

import java.util.List;

import com.qhit.lh.grs.rzy.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.grs.rzy.exam.common.dao.BaseDao;

public class ClazzDaoImpl extends BaseDao implements ClazzDao {

	@Override
	public List<ClassInfo> getClazzList() {
		return getSession().createQuery("from ClassInfo").list();
	}

}
