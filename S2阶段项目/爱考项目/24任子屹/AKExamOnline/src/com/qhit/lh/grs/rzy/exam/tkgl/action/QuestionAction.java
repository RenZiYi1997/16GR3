/**
 * 
 */
package com.qhit.lh.grs.rzy.exam.tkgl.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.grs.rzy.exam.common.bean.PageBean;
import com.qhit.lh.grs.rzy.exam.kmgl.bean.Course;
import com.qhit.lh.grs.rzy.exam.tkgl.bean.WrittenQuestion;
import com.qhit.lh.grs.rzy.exam.tkgl.service.QuestionService;
import com.qhit.lh.grs.rzy.exam.tkgl.service.QuestionServiceImpl;
import com.qhit.lh.grs.rzy.exam.tkgl.utils.PoiReaderExcel;


public class QuestionAction extends ActionSupport {
	
	private QuestionService questionService = new QuestionServiceImpl();
	
	private Course course; //璇剧▼
	private String major; //涓撲笟鏂瑰悜
	private String stage; //闃舵
	private WrittenQuestion writtenQuestion;//绗旇瘯棰樺璞�
	private List<Course> listCourses = new ArrayList<Course>(); //璇曢鍒楄〃
	private PageBean<WrittenQuestion> pageBean = new PageBean<WrittenQuestion>();//璇曢鍒楄〃鍒嗛〉鏁版嵁
	private int pageIndex = 1;//鎸囧畾椤碉紝鍒濆鍖�1
	private List<WrittenQuestion> listWQuestions = new ArrayList<WrittenQuestion>();//瀵煎叆璇曢闆嗗悎
	
	private File qusetionfile;//瀵煎叆鏂囦欢瀵硅薄
	
	private int radioEasyMax,radioNormalMax,radioDiffMax,cbEasyMax,cbNormalMax,cbDiffMax;
	
	/**
	 * 棰樺簱鍒楄〃
	 * @return
	 */
	public String getCourseInfo(){
		//璁剧疆鍙傛暟
		Map<String,String> parameter = new HashMap<String,String>();
		if(major != null && !"".equals(major)){
			System.out.println(major);
			parameter.put("major", major);
		}
		if(stage != null && !"".equals(stage)){
			parameter.put("stage", stage);
			System.out.println(stage);
		}
		//鏌ヨ棰樺簱鍒楄〃鏁版嵁
		listCourses = questionService.getCourseInfo(parameter);
		System.out.println("棰樺簱鏁版嵁闀垮害:" + listCourses.size());
		return "listCourse";
	}
	
	/**
	 * @return
	 * 鑾峰彇璇曢鏁伴噺
	 */
	public String getQuestionMax(){
		radioEasyMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "鍗曢��", "绠�鍗�");
		radioNormalMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "鍗曢��", "涓�鑸�");
		radioDiffMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "鍗曢��", "鍥伴毦");
		cbEasyMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "澶氶��", "绠�鍗�");
		cbNormalMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "澶氶��", "涓�鑸�");
		cbDiffMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "澶氶��", "鍥伴毦");
		
		return "getQuestionMax";
	}
	
	/**
	 * @return
	 * 鑾峰彇璇曢鍒楄〃
	 */
	public String getWrittenList(){
		questionService.getWrittenList(pageBean, course, pageIndex);
		System.out.println("鏁版嵁澶у皬"+pageBean.getItems().size());
		return "listWritten";
	}
	
	/**
	 * @return
	 * 娣诲姞璇曢
	 */
	public String addWrittenQuestion(){
		//璁剧疆璇剧▼鍏宠仈
		writtenQuestion.setCourse(course);
		
		questionService.addWrittenQuestion(writtenQuestion);
		return "addWrittenQuestion";
	}
	
	/**
	 * @return
	 * 鏍规嵁璇曢缂栧彿鏌ヨ璇曢瀵硅薄
	 */
	public String getWrittenQuestionById(){
		writtenQuestion = questionService.getWrittenQuestionById(writtenQuestion);
		
		return "getWrittenQuestionById";
	}
	
	/**
	 * @return
	 * 鏇存柊璇曢
	 */
	public String updateWrittenQuestion(){
		//璁剧疆鍏宠仈
		writtenQuestion.setCourse(course);
		
		questionService.updateWrittenQuestion(writtenQuestion);
		return "updateWrittenQuestion";
	}
	
	/**
	 * @return
	 * @throws FileNotFoundException
	 * 璇曢涓婁紶
	 */
	public String inportWrittenQuestions() throws FileNotFoundException{
		
		if(qusetionfile != null){
			//1,涓婁紶鍒版湇鍔″櫒锛坰truts2锛�(1,jsp琛ㄥ崟鎻愪氦鎺т欢2锛宎ction)
			FileInputStream fis = new FileInputStream(qusetionfile);
			//2锛岃鍙杄xcel鏂囦欢涓殑鏁版嵁锛岃幏鍙栬瘯棰樺璞￠泦鍚堬紙1锛孭OI:瀵煎寘銆�2,璇诲彇鏁版嵁娴佽幏鍙栨暟鎹泦鍚�)
			listWQuestions = PoiReaderExcel.readerExcel(fis, course);
			//3锛屾壒閲忔坊鍔犲埌璇曢鍒楄〃
			questionService.inprotWrittenQuestion(listWQuestions);
		}else{
			//涓婁紶澶辫触锛屾殏涓嶅仛
		}
		return "inportWrittenQuestions";
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
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * @return the stage
	 */
	public String getStage() {
		return stage;
	}
	/**
	 * @param stage the stage to set
	 */
	public void setStage(String stage) {
		this.stage = stage;
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
	 * @return the pageBean
	 */
	public PageBean<WrittenQuestion> getPageBean() {
		return pageBean;
	}

	/**
	 * @param pageBean the pageBean to set
	 */
	public void setPageBean(PageBean<WrittenQuestion> pageBean) {
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
	 * @return the listWQuestions
	 */
	public List<WrittenQuestion> getListWQuestions() {
		return listWQuestions;
	}

	/**
	 * @param listWQuestions the listWQuestions to set
	 */
	public void setListWQuestions(List<WrittenQuestion> listWQuestions) {
		this.listWQuestions = listWQuestions;
	}

	/**
	 * @return the qusetionfile
	 */
	public File getQusetionfile() {
		return qusetionfile;
	}

	/**
	 * @param qusetionfile the qusetionfile to set
	 */
	public void setQusetionfile(File qusetionfile) {
		this.qusetionfile = qusetionfile;
	}

	/**
	 * @return the writtenQuestion
	 */
	public WrittenQuestion getWrittenQuestion() {
		return writtenQuestion;
	}

	/**
	 * @param writtenQuestion the writtenQuestion to set
	 */
	public void setWrittenQuestion(WrittenQuestion writtenQuestion) {
		this.writtenQuestion = writtenQuestion;
	}

	/**
	 * @return the radioEasyMax
	 */
	public int getRadioEasyMax() {
		return radioEasyMax;
	}

	/**
	 * @param radioEasyMax the radioEasyMax to set
	 */
	public void setRadioEasyMax(int radioEasyMax) {
		this.radioEasyMax = radioEasyMax;
	}

	/**
	 * @return the radioNormalMax
	 */
	public int getRadioNormalMax() {
		return radioNormalMax;
	}

	/**
	 * @param radioNormalMax the radioNormalMax to set
	 */
	public void setRadioNormalMax(int radioNormalMax) {
		this.radioNormalMax = radioNormalMax;
	}

	/**
	 * @return the radioDiffMax
	 */
	public int getRadioDiffMax() {
		return radioDiffMax;
	}

	/**
	 * @param radioDiffMax the radioDiffMax to set
	 */
	public void setRadioDiffMax(int radioDiffMax) {
		this.radioDiffMax = radioDiffMax;
	}

	/**
	 * @return the cbEasyMax
	 */
	public int getCbEasyMax() {
		return cbEasyMax;
	}

	/**
	 * @param cbEasyMax the cbEasyMax to set
	 */
	public void setCbEasyMax(int cbEasyMax) {
		this.cbEasyMax = cbEasyMax;
	}

	/**
	 * @return the cbNormalMax
	 */
	public int getCbNormalMax() {
		return cbNormalMax;
	}

	/**
	 * @param cbNormalMax the cbNormalMax to set
	 */
	public void setCbNormalMax(int cbNormalMax) {
		this.cbNormalMax = cbNormalMax;
	}

	/**
	 * @return the cbDiffMax
	 */
	public int getCbDiffMax() {
		return cbDiffMax;
	}

	/**
	 * @param cbDiffMax the cbDiffMax to set
	 */
	public void setCbDiffMax(int cbDiffMax) {
		this.cbDiffMax = cbDiffMax;
	}
}
