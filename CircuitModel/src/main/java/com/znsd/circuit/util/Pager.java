package com.znsd.circuit.util;

import java.util.List;

public class Pager<T> {
	private int pageIndex; // 当前页
	private int pageSize; // 要显示的条数
	private int sumPage; // 总页数
	private int sumSize; // 总条数
	
	private boolean isFirst;
	private boolean isLast;

	public boolean getIsFirst() {
		return this.pageIndex>1;
	}

	public boolean getIsLast() {
		return this.pageIndex<this.sumPage;
	}

	private List<T> data;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex=pageIndex<1?1:pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSumSize() {
		return sumSize;
	}

	public int getSumPage() {
		return sumPage;
	}
	public void setSumSize(int sumSize) {
		this.sumSize = sumSize;
		this.sumPage = this.sumSize % this.pageSize == 0 ? this.sumSize / this.pageSize
				: this.sumSize / this.pageSize + 1;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
	
}

