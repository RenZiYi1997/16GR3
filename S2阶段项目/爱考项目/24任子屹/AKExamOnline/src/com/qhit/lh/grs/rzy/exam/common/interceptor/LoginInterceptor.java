/**
 * 
 */
package com.qhit.lh.grs.rzy.exam.common.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.qhit.lh.grs.rzy.exam.common.bean.User;
import com.qhit.lh.grs.rzy.exam.common.utils.Constans;


public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		System.out.println("鐧诲綍鏍￠獙鎷︽埅鍣ㄦ墽琛�");
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user == null){
			//鏈櫥褰�
			return Constans.VIEW_LOGIN;
		}
		return arg0.invoke();
	}

}
