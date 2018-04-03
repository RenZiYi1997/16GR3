package com.qhit.lh.grs.rzy.exam.tkgl.bean;

import com.qhit.lh.grs.rzy.exam.kmgl.bean.Course;

/**
 * MachineTest entity. @author MyEclipse Persistence Tools
 */

public class MachineQuestion implements java.io.Serializable {

	// Fields

	private Integer qid;
	private String qtitle;
	private String degree;
	private Integer csId;
	private String chapter;
	
	//n-1
	private Course course;
	
	// Constructors
	
	/**
	 * @return the qid
	 */
	public Integer getQid() {
		return qid;
	}

	/**
	 * 
	 */
	public MachineQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param qid
	 * @param qtitle
	 * @param degree
	 * @param csId
	 * @param chapter
	 */
	public MachineQuestion(Integer qid, String qtitle, String degree, Integer csId, String chapter) {
		super();
		this.qid = qid;
		this.qtitle = qtitle;
		this.degree = degree;
		this.csId = csId;
		this.chapter = chapter;
	}

	/**
	 * @param qid the qid to set
	 */
	public void setQid(Integer qid) {
		this.qid = qid;
	}

	/**
	 * @return the qtitle
	 */
	public String getQtitle() {
		return qtitle;
	}

	/**
	 * @param qtitle the qtitle to set
	 */
	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}

	/**
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * @return the csId
	 */
	public Integer getCsId() {
		return csId;
	}

	/**
	 * @param csId the csId to set
	 */
	public void setCsId(Integer csId) {
		this.csId = csId;
	}

	/**
	 * @return the chapter
	 */
	public String getChapter() {
		return chapter;
	}

	/**
	 * @param chapter the chapter to set
	 */
	public void setChapter(String chapter) {
		this.chapter = chapter;
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