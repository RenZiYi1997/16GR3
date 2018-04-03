/**
 * 
 */
package com.qhit.lh.grs.rzy.exam.common.dao;

import java.util.List;

import org.hibernate.Query;

import com.qhit.lh.grs.rzy.exam.common.bean.User;



public class UserDaoImpl extends BaseDao implements UserDao {

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.rzy.common.dao.UserDao#login(com.qhit.lh.grs.rzy.common.bean.User)
	 * 
	 */
	public User login(User user) {
		// TODO Auto-generated method stub
		String hql = "select user from User user where user.name = ? and user.pwd = ? and user.role = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, user.getName());
		query.setString(1, user.getPwd());
		query.setInteger(2, user.getRole());
		
		List<User> list = (List<User>)query.list();
		
		if(list != null && list.size() == 1){
			//登录成功
			return list.get(0);
		}
		return null;
	}

}
