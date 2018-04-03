/**
 * 
 */
package com.qhit.lh.grs.rzy.exam.common.dao;

import org.hibernate.Session;

import com.qhit.lh.grs.rzy.exam.common.utils.HibernateSessionFactory;


public class BaseDao {
	
	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
}
