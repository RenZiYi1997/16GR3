/**
 * 
 */
package com.qhit.lh.grs.rzy.exam.sjgl.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.qhit.lh.grs.rzy.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.grs.rzy.exam.common.bean.PageBean;
import com.qhit.lh.grs.rzy.exam.common.dao.BaseDao;
import com.qhit.lh.grs.rzy.exam.sjgl.bean.Paper;
import com.qhit.lh.grs.rzy.exam.sjgl.bean.PaperClass;


public class PaperDaoImpl extends BaseDao implements PaperDao {

	@Override
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex) {
		//寮�鍚簨鍔�
		getSession().clear();
		//HQL璇彞
		StringBuffer hql = new StringBuffer();
		hql.append("select paper from Paper paper where 1 = 1 ");
		//鎷兼帴HQL
		if(parameter.get("csId") != null && (Integer)parameter.get("csId") > 0){
			hql.append(" and paper.csId = :csId");
		}
		if(parameter.get("pType") != null && !"".equals(parameter.get("pType"))){
			hql.append(" and paper.ptype = :pType");
		}
		if(parameter.get("pState") != null && !"".equals(parameter.get("pState"))){
			hql.append(" and paper.pstate = :pState");
		}
		//鑾峰彇鏌ヨ鍣�
		Query query = getSession().createQuery(hql.toString());
		//璁剧疆鍙傛暟
		if(parameter.get("csId") != null && (Integer)parameter.get("csId") > 0){
			query.setInteger("csId", (Integer)parameter.get("csId"));
		}
		if(parameter.get("pType") != null && !"".equals(parameter.get("pType"))){
			query.setString("pType", (String)parameter.get("pType"));
		}
		if(parameter.get("pState") != null && !"".equals(parameter.get("pState"))){
			query.setString("pState",(String)parameter.get("pState"));
		}
		//鎬昏褰曟暟
		int count = query.list().size();
		pageBean.setTotalNumber(count);
		pageBean.setCurrentIndex(pageIndex);
		//褰撳墠椤垫暟鎹�
		List<Paper> items = query.setFirstResult((pageBean.getCurrentIndex()-1)*pageBean.getPageSize())
				.setMaxResults(pageBean.getPageSize())
				.list();
		//璁剧疆pageBean鐨勬暟鎹泦鍚�
		pageBean.setItems(items);
		//鎵ц鏌ヨ
		return pageBean;
	}

	@Override
	public void startExam(List<PaperClass> paperClasses) {
		// TODO Auto-generated method stub
		Transaction ts = getSession().beginTransaction();
		for(PaperClass paperClass : paperClasses){
			//璁剧疆n-1鐨勫叧绯�
			Paper paper = (Paper) getSession().get(Paper.class, paperClass.getPid());
			ClassInfo classInfo = (ClassInfo) getSession().get(ClassInfo.class, paperClass.getCcode());
			paperClass.setPaper(paper);
			paperClass.setClassInfo(classInfo);
			//淇濆瓨鏁版嵁
			getSession().save(paperClass);
		}
		ts.commit();
	}

	@Override
	public void updateExam(Paper paper, String state) {
		//寮�鍚簨鍔�
		Transaction ts = getSession().beginTransaction();
		//HQL璇彞
		String hql = "update Paper paper set paper.pstate = ? where paper.pid = ? ";
		Query queryUpdate = getSession().createQuery(hql);
		queryUpdate.setString(0, state);
		queryUpdate.setInteger(1, paper.getPid());
		//鎵цHQL璇彞鐨勬坊鍔犮�佷慨鏀广�佸垹闄ゃ�佽皟鐢ㄧ殑鏄痚xecuteUpdate鏂规硶
		queryUpdate.executeUpdate();
		ts.commit();
	}

	@Override
	public void createPaperRandom(Paper paper) {
		//寮�鍚簨鍔�
		Transaction ts = getSession().beginTransaction();
		getSession().save(paper);
		ts.commit();
	}

}
