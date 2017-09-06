package org.lanqiao.entity;

public class PageVo {
	Integer pageSize;
	Integer pageIndex;
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	@Override
	public String toString() {
		return "PageVo [pageSize=" + pageSize + ", pageIndex=" + pageIndex
				+ "]";
	}
	public PageVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageVo(Integer pageSize, Integer pageIndex) {
		super();
		this.pageSize = pageSize;
		this.pageIndex = pageIndex;
	}
	
	
}
