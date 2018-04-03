/**
 * 
 */
package com.qhit.lh.grs.rzy.exam.sjgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.grs.rzy.exam.common.bean.PageBean;
import com.qhit.lh.grs.rzy.exam.kmgl.bean.Course;
import com.qhit.lh.grs.rzy.exam.sjgl.bean.Paper;
import com.qhit.lh.grs.rzy.exam.sjgl.bean.PaperClass;
import com.qhit.lh.grs.rzy.exam.sjgl.service.PaperService;
import com.qhit.lh.grs.rzy.exam.sjgl.service.PaperServiceImpl;
import com.qhit.lh.grs.rzy.exam.tkgl.bean.WrittenQuestion;
import com.qhit.lh.grs.rzy.exam.tkgl.service.QuestionService;
import com.qhit.lh.grs.rzy.exam.tkgl.service.QuestionServiceImpl;
import com.qhit.lh.grs.rzy.exam.tkgl.utils.RandomQuestionsUtils;


public class PaperAction{
	private PaperService paperService = new PaperServiceImpl();
	private QuestionService questionService = new QuestionServiceImpl();
	private List<Course> liatCourses = new ArrayList();
	private List<Paper> liatPpaper = new ArrayList();
	//璇曢鍒楄〃鍒嗛〉鏁版嵁
	private PageBean<Paper> pageBean = new PageBean<>();
	private int pageIndex = 1; //鎸囧畾椤碉紝鍒濆鍖栦负1
	//鏉′欢鍙傛暟
	private Course course;
	private Paper paper;
	private int radioEasy,radioNormal,radioDiff,cbEasy,cbNormal,cbDiff;
	private List<WrittenQuestion> listRE,listRN,listRD,listCE,listCN,listCD;
	//寮�濮嬭�冭瘯锛岀彮绾ч泦鍚�
	private List<PaperClass> pcs = new ArrayList<>();
	
	/**
	 * 鑾峰彇璇曞嵎鍒楄〃
	 * @return
	 */
	public String getPaperList(){
		//璁剧疆鍙傛暟
		Map<String,Object> parameter = new HashMap<>();
		if(course != null){
			parameter.put("csId", course.getCsId());
		}
		if(paper != null){
			parameter.put("pType", paper.getPtype());
			parameter.put("pState", paper.getPstate());
		}
		//鏌ヨ棰樺簱鏁版嵁绫昏〃
		pageBean = paperService.getPaperList(pageBean, parameter, pageIndex);
		Paper p=pageBean.getItems().get(2);
		System.out.println("杈撳嚭1锛�");
		for(PaperClass pc:p.getPaperClasses()){
			System.out.println("杈撳嚭锛�"+pc.toString());
		}
		System.out.println(pageBean.getItems().size());
		return "listPaper";
	}
	
	/**
	 * 闅忔満缁勫嵎
	 * @return
	 */
	public String createByRandom(){
		System.out.println("杩涘叆锛坈reateByRandom锛塂AO");
		System.out.println("1,鏌ヨ鎵�鏈夌殑绫诲瀷鐨勮瘯棰�");
		//1锛屾煡璇㈡墍鏈夌殑绫诲瀷鐨勮瘯棰�
		listRE = questionService.getQuestionsByType(course.getCsId(), "鍗曢��", "绠�鍗�");
		listRN = questionService.getQuestionsByType(course.getCsId(), "鍗曢��", "涓�鑸�");
		listRD = questionService.getQuestionsByType(course.getCsId(), "鍗曢��", "鍥伴毦");
		listCE = questionService.getQuestionsByType(course.getCsId(), "澶氶��", "绠�鍗�");
		listCN = questionService.getQuestionsByType(course.getCsId(), "澶氶��", "涓�鑸�");
		listCD = questionService.getQuestionsByType(course.getCsId(), "澶氶��", "鍥伴毦");
		//2锛岄殢鏈鸿幏鍙栬瘯棰橀泦鍚�
		System.out.println("2,闅忔満鑾峰彇璇曢闆嗗悎");
		Set<WrittenQuestion> lisQuestions = RandomQuestionsUtils.randomAllQuestions(
				listRE, listRN, listRD, listCE, listCN, listCD, 
				radioEasy, radioNormal, radioDiff, cbEasy, cbNormal, cbDiff);
		System.out.println("璇曢鏁伴噺锛�" + lisQuestions.size());
		//3,璁剧疆璇曢鍜岃瘯鍗风殑鍏崇郴
		System.out.println("3,璁剧疆璇曢鍜岃瘯鍗风殑鍏崇郴");
		paper.setWrittenQuestions(lisQuestions);
		//4锛岃缃绋嬶紝娣诲姞鍏崇郴
		paper.setCsId(course.getCsId());
		paper.setCourse(course);
		//5锛屾坊鍔犺瘯鍗�
		System.out.println("娣诲姞璇曞嵎");
		paperService.createPaperRandom(paper);
		
		return "createRandom";
	}
	/**
	 * 缁撴潫鑰冭瘯
	 */
	public String endExam(){
		paperService.endExam(paper);
		return "endExam";
	}
	
	/**
	 * @return the liatCourses
	 */
	public List<Course> getLiatCourses() {
		return liatCourses;
	}
	/**
	 * @param liatCourses the liatCourses to set
	 */
	public void setLiatCourses(List<Course> liatCourses) {
		this.liatCourses = liatCourses;
	}
	/**
	 * @return the liatPpaper
	 */
	public List<Paper> getLiatPpaper() {
		return liatPpaper;
	}
	/**
	 * @param liatPpaper the liatPpaper to set
	 */
	public void setLiatPpaper(List<Paper> liatPpaper) {
		this.liatPpaper = liatPpaper;
	}
	/**
	 * @return the pageBean
	 */
	public PageBean<Paper> getPageBean() {
		return pageBean;
	}
	/**
	 * @param pageBean the pageBean to set
	 */
	public void setPageBean(PageBean<Paper> pageBean) {
		this.pageBean = pageBean;
	}
	/**
	 * @return the pageIndex
	 */
	public int getPageIndex() {
		return pageIndex;
	}
	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
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
	/**
	 * @return the paper
	 */
	public Paper getPaper() {
		return paper;
	}
	/**
	 * @param paper the paper to set
	 */
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	/**
	 * @return the radioEasy
	 */
	public int getRadioEasy() {
		return radioEasy;
	}
	/**
	 * @param radioEasy the radioEasy to set
	 */
	public void setRadioEasy(int radioEasy) {
		this.radioEasy = radioEasy;
	}
	/**
	 * @return the radioNormal
	 */
	public int getRadioNormal() {
		return radioNormal;
	}
	/**
	 * @param radioNormal the radioNormal to set
	 */
	public void setRadioNormal(int radioNormal) {
		this.radioNormal = radioNormal;
	}
	/**
	 * @return the radioDiff
	 */
	public int getRadioDiff() {
		return radioDiff;
	}
	/**
	 * @param radioDiff the radioDiff to set
	 */
	public void setRadioDiff(int radioDiff) {
		this.radioDiff = radioDiff;
	}
	/**
	 * @return the cbEasy
	 */
	public int getCbEasy() {
		return cbEasy;
	}
	/**
	 * @param cbEasy the cbEasy to set
	 */
	public void setCbEasy(int cbEasy) {
		this.cbEasy = cbEasy;
	}
	/**
	 * @return the cbNormal
	 */
	public int getCbNormal() {
		return cbNormal;
	}
	/**
	 * @param cbNormal the cbNormal to set
	 */
	public void setCbNormal(int cbNormal) {
		this.cbNormal = cbNormal;
	}
	/**
	 * @return the cbDiff
	 */
	public int getCbDiff() {
		return cbDiff;
	}
	/**
	 * @param cbDiff the cbDiff to set
	 */
	public void setCbDiff(int cbDiff) {
		this.cbDiff = cbDiff;
	}
	/**
	 * @return the listRE
	 */
	public List<WrittenQuestion> getListRE() {
		return listRE;
	}
	/**
	 * @param listRE the listRE to set
	 */
	public void setListRE(List<WrittenQuestion> listRE) {
		this.listRE = listRE;
	}
	/**
	 * @return the listRN
	 */
	public List<WrittenQuestion> getListRN() {
		return listRN;
	}
	/**
	 * @param listRN the listRN to set
	 */
	public void setListRN(List<WrittenQuestion> listRN) {
		this.listRN = listRN;
	}
	/**
	 * @return the listRD
	 */
	public List<WrittenQuestion> getListRD() {
		return listRD;
	}
	/**
	 * @param listRD the listRD to set
	 */
	public void setListRD(List<WrittenQuestion> listRD) {
		this.listRD = listRD;
	}
	/**
	 * @return the listCE
	 */
	public List<WrittenQuestion> getListCE() {
		return listCE;
	}
	/**
	 * @param listCE the listCE to set
	 */
	public void setListCE(List<WrittenQuestion> listCE) {
		this.listCE = listCE;
	}
	/**
	 * @return the listCN
	 */
	public List<WrittenQuestion> getListCN() {
		return listCN;
	}
	/**
	 * @param listCN the listCN to set
	 */
	public void setListCN(List<WrittenQuestion> listCN) {
		this.listCN = listCN;
	}
	/**
	 * @return the listCD
	 */
	public List<WrittenQuestion> getListCD() {
		return listCD;
	}
	/**
	 * @param listCD the listCD to set
	 */
	public void setListCD(List<WrittenQuestion> listCD) {
		this.listCD = listCD;
	}

	/**
	 * @return the pcs
	 */
	public List<PaperClass> getPcs() {
		return pcs;
	}

	/**
	 * @param pcs the pcs to set
	 */
	public void setPcs(List<PaperClass> pcs) {
		this.pcs = pcs;
	}
	
}
