package com.qhit.lh.grs.rzy.exam.tkgl.bean;

import com.qhit.lh.grs.rzy.exam.kmgl.bean.Course;

/**
 * WrittenTest entity. @author MyEclipse Persistence Tools
 */

public class WrittenQuestion implements java.io.Serializable {

	// Fields

	private Integer qid;
	private String qtype;
	private String qtitle;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String answer;
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
	 * @param qid the qid to set
	 */
	public void setQid(Integer qid) {
		this.qid = qid;
	}

	/**
	 * @return the qtype
	 */
	public String getQtype() {
		return qtype;
	}

	/**
	 * @param qtype the qtype to set
	 */
	public void setQtype(String qtype) {
		this.qtype = qtype;
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
	 * @return the optionA
	 */
	public String getOptionA() {
		return optionA;
	}

	/**
	 * @param optionA the optionA to set
	 */
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	/**
	 * @return the optionB
	 */
	public String getOptionB() {
		return optionB;
	}

	/**
	 * @param optionB the optionB to set
	 */
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	/**
	 * @return the optionC
	 */
	public String getOptionC() {
		return optionC;
	}

	/**
	 * @param optionC the optionC to set
	 */
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	/**
	 * @return the optionD
	 */
	public String getOptionD() {
		return optionD;
	}

	/**
	 * @param optionD the optionD to set
	 */
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
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