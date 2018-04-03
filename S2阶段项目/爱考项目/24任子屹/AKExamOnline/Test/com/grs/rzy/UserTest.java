/**
 * 
 */
package com.grs.rzy;

import org.junit.Test;

import com.qhit.lh.grs.rzy.exam.common.action.UserAction;
import com.qhit.lh.grs.rzy.exam.common.bean.User;
import com.qhit.lh.grs.rzy.exam.tkgl.action.QuestionAction;


public class UserTest {
	
	@Test
	public void login(){
		UserAction userAction = new UserAction();
		User user = new User();
		user.setName("admin");
		user.setPwd("123456");
		user.setRole(4);
		
		userAction.setUser(user);
		
		System.out.println(userAction.login());
	}
}
