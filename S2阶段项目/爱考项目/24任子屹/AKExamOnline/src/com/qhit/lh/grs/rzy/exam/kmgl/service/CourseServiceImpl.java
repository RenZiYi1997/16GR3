/**
 * 
 */
package com.qhit.lh.grs.rzy.exam.kmgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.grs.rzy.exam.kmgl.bean.Course;
import com.qhit.lh.grs.rzy.exam.kmgl.dao.CourseDao;
import com.qhit.lh.grs.rzy.exam.kmgl.dao.CourseDaoImpl;


public class CourseServiceImpl implements CourseService {
	private CourseDao courseDao = new CourseDaoImpl();
	
	@Override
	public List<Course> getCourseList(Map<String, Object> parameter) {
		return courseDao.getCoursesList(parameter);
	}

}
