package com.qhit.lh.grs.rzy.exam.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageBean<T> implements Serializable {
	private static final long serialVersionUID = 3509375972998939764L;
	public static String CURRENT_INDEX = "currentIndex";
	public static String PAGE_SIZE = "pageSize";
	public static String INDEX="index";
	/**
	 * 褰撳墠椤�
	 */
	private int currentIndex;
	
	/**
	 * 姣忛〉璁板綍鏁�
	 */
	private int pageSize;
	
	/**
	 * 鎬昏褰曟暟
	 */
	private int totalNumber;
	
	/**
	 * 鎬婚〉鏁�
	 */
	private int totalPage;
	
	/**
	 * 涓嬩竴椤�
	 */
	private int nextIndex;
	
	/**
	 * 涓婁竴椤�
	 */
	private int preIndex;
	
	/**
	 * 褰撳墠椤电殑鏁版嵁璁板綍
	 */
	private List<T> Items;
	
	
	/**
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param totalNumber
	 * @param currentIndex
	 * @param pageSize
	 * @param items
	 */
	public PageBean(int totalNumber,int currentIndex,int pageSize,List<T> items){
		this.totalNumber = totalNumber;
		this.currentIndex = currentIndex;
		this.pageSize = pageSize;
		this.Items = items;
	}
	
	public PageBean() {
		pageSize = 10;
		Items = new ArrayList<>();
	}
	

	/**
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return
	 */
	public int getCurrentIndex() {
		return currentIndex;
	}
	
	/**
	 * @param currentIndex
	 */
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	
	/**
	 * @return
	 */
	public int getTotalNumber() {
		return totalNumber;
	}
	
	/**
	 * @param totalNumber
	 */
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
		int size = this.totalNumber/this.pageSize;
		if(this.totalNumber%this.pageSize != 0){
			size = size + 1;
		}
		this.totalPage = size;
	}
	
	
	public int getTotalPage() {
		return this.totalPage;
	}

	
	public int getNextIndex() {
		
		if(this.currentIndex >= this.getTotalPage()){
			this.nextIndex = this.currentIndex;
		}else{
			this.nextIndex = this.currentIndex + 1;
		}
		return nextIndex;
	}

	
	public int getPreIndex() {
		
		if(this.currentIndex <= 1){
			this.preIndex = 1;
		}else{
			this.preIndex = this.currentIndex -1;
		}
		
		return preIndex;
	}

	/**
	 * @return
	 */
	public List<T> getItems() {
		return Items;
	}
	
	/**
	 * @param items
	 */
	public void setItems(List<T> items) {
		Items = items;
	}
}
