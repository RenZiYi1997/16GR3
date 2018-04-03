/**
 * 
 */
package com.qhit.lh.grs.rzy.exam.sjgl.dao;

import java.util.List;
import java.util.Map;

import com.qhit.lh.grs.rzy.exam.common.bean.PageBean;
import com.qhit.lh.grs.rzy.exam.sjgl.bean.Paper;
import com.qhit.lh.grs.rzy.exam.sjgl.bean.PaperClass;


public interface PaperDao {
	
	/**
	 * @param paperClasses
	 */
	public void startExam(List<PaperClass> paperClasses);
	
	/**
	 * @param paper
	 * @param state
	 * 结束考试
	 */
	public void updateExam(Paper paper,String state);
	
	/**
	 * @param paper
	 * 随机组卷
	 */
	public void createPaperRandom(Paper paper);
	
	/**
	 * @param pageBean
	 * @param parameter
	 * @param pageIndex
	 * @return
	 * 查询试卷列表
	 */
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean,Map<String,Object> parameter,int pageIndex);
}
