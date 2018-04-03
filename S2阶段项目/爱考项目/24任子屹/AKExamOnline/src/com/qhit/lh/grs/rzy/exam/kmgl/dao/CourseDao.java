/**
 * 
 */
package com.qhit.lh.grs.rzy.exam.kmgl.dao;

import java.util.List;
import java.util.Map;

import com.qhit.lh.grs.rzy.exam.kmgl.bean.Course;


public interface CourseDao {
	
	/**
	 * @param parameter
	 * @return
	 */
	public List<Course> getCoursesList(Map<String, Object> parameter);
}
