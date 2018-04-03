/**
 * 
 */
package com.qhit.lh.grs.rzy.exam.bjgl.action;

import java.util.List;

import com.qhit.lh.grs.rzy.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.grs.rzy.exam.bjgl.service.ClazzService;
import com.qhit.lh.grs.rzy.exam.bjgl.service.ClazzServiceImpl;


public class ClazzAction {
	private ClazzService clazzService = new ClazzServiceImpl();
	private List<ClassInfo> listClazz;
	
	public String getClazzList(){
		listClazz = clazzService.getClazzList();
		return "getClazzList";
	}
	
	/**
	 * @return the listClszz
	 */
	public List<ClassInfo> getListClazz() {
		return listClazz;
	}
	/**
	 * @param listClszz the listClszz to set
	 */
	public void setListClszz(List<ClassInfo> listClazz) {
		this.listClazz = listClazz;
	}
}
