/**
 * 
 */
package com.qhit.lh.grs.rzy.exam.tkgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.grs.rzy.exam.common.bean.PageBean;
import com.qhit.lh.grs.rzy.exam.kmgl.bean.Course;
import com.qhit.lh.grs.rzy.exam.tkgl.bean.WrittenQuestion;
import com.qhit.lh.grs.rzy.exam.tkgl.dao.QuestionDao;
import com.qhit.lh.grs.rzy.exam.tkgl.dao.QuestionDaoImpl;

public class QuestionServiceImpl implements QuestionService {
	private QuestionDao questionDao = new QuestionDaoImpl();
	
	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.rzy.exam.tkgl.service.QuestionService#getCourseInfo(java.util.Map)
	 */
	public List<Course> getCourseInfo(Map parameter) {
		return questionDao.getCourseInfo(parameter);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.rzy.exam.tkgl.service.QuestionService#getWrittenList(com.qhit.lh.grs.wjk.exam.common.bean.PageBean, com.qhit.lh.grs.wjk.exam.kmgl.bean.Course, int)
	 */
	@Override
	public PageBean<WrittenQuestion> getWrittenList(PageBean<WrittenQuestion> pageBean, Course course, int pageIndex) {
		// TODO Auto-generated method stub
		return questionDao.getWrittenList(pageBean, course, pageIndex);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.rzy.exam.tkgl.service.QuestionService#addWrittenQuestion(com.qhit.lh.grs.wjk.exam.tkgl.bean.WrittenQuestion)
	 */
	@Override
	public void addWrittenQuestion(WrittenQuestion writtenQuestion) {
		// TODO Auto-generated method stub
		questionDao.addWrittenQuestion(writtenQuestion);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.rzy.exam.tkgl.service.QuestionService#getWrittenQuestionById(com.qhit.lh.grs.wjk.exam.tkgl.bean.WrittenQuestion)
	 */
	@Override
	public WrittenQuestion getWrittenQuestionById(WrittenQuestion writtenQuestion) {
		// TODO Auto-generated method stub
		return questionDao.getWrittenQuestionById(writtenQuestion);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.rzy.exam.tkgl.service.QuestionService#updateWrittenQuestion(com.qhit.lh.grs.wjk.exam.tkgl.bean.WrittenQuestion)
	 */
	@Override
	public void updateWrittenQuestion(WrittenQuestion writtenQuestion) {
		// TODO Auto-generated method stub
		questionDao.updateWrittenQuestion(writtenQuestion);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.rzy.exam.tkgl.service.QuestionService#inprotWrittenQuestion(java.util.List)
	 */
	@Override
	public void inprotWrittenQuestion(List<WrittenQuestion> listwritten) {
		// TODO Auto-generated method stub
		questionDao.inprotWrittenQuestion(listwritten);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.rzy.exam.tkgl.service.QuestionService#getQuestionsMax(int, java.lang.String, java.lang.String)
	 */
	@Override
	public int getQuestionsMax(int csId, String type, String degree) {
		// TODO Auto-generated method stub
		return questionDao.getQuestionsMax(csId, type, degree);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.rzy.exam.tkgl.service.QuestionService#getQuestionsByType(int, java.lang.String, java.lang.String)
	 */
	@Override
	public List<WrittenQuestion> getQuestionsByType(int csId, String qtype, String degree) {
		// TODO Auto-generated method stub
		return questionDao.getQuestionsByType(csId, qtype, degree);
	}

}
