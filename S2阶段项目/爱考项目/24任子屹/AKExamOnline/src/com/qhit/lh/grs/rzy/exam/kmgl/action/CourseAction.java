/**
 * 
 */
package com.qhit.lh.grs.rzy.exam.kmgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qhit.lh.grs.rzy.exam.kmgl.bean.Course;
import com.qhit.lh.grs.rzy.exam.kmgl.service.CourseService;
import com.qhit.lh.grs.rzy.exam.kmgl.service.CourseServiceImpl;

public class CourseAction {
	private static final long serialVersionUID = 5352074026213567264L;
	private CourseService courseService = new CourseServiceImpl();
	private List<Course> listCourses = new ArrayList<>();
	private Course course;
	
	public String getCourses2Json(){
		//璁剧疆鍙傛暟
		Map<String, Object> parameter = new HashMap<>();
		if(course != null){
			parameter.put("major", course.getMajor());
			parameter.put("stage", course.getStage());
		}
		//鏌ヨ鏁版嵁搴撶鐩垪琛�
		listCourses = courseService.getCourseList(parameter);
		System.out.println("寮傛璇锋眰:" + listCourses.size());
		
		return "listCourseJson";
	}
	
	/**
	 * @return the listCourses
	 */
	public List<Course> getListCourses() {
		return listCourses;
	}
	/**
	 * @param listCourses the listCourses to set
	 */
	public void setListCourses(List<Course> listCourses) {
		this.listCourses = listCourses;
	}
	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}
	
}
