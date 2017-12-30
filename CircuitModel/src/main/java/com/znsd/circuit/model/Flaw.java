package com.znsd.circuit.model;

public class Flaw {
	private int id;
	private String flawname;
	private int state;
	private int createdBy;
	private String createdDate;
	private int updatedBy;
	private String updateDate;
	private String delete_flag;
	private String remark;
	
	
	public Flaw() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlawname() {
		return flawname;
	}
	public void setFlawname(String flawname) {
		this.flawname = flawname;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getDelete_flag() {
		return delete_flag;
	}
	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Flaw(int id, String flawname, int state, int createdBy, String createdDate, int updatedBy, String updateDate,
			String delete_flag, String remark) {
		super();
		this.id = id;
		this.flawname = flawname;
		this.state = state;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updateDate = updateDate;
		this.delete_flag = delete_flag;
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Flaw [id=" + id + ", flawname=" + flawname + ", state=" + state + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updateDate=" + updateDate
				+ ", delete_flag=" + delete_flag + ", remark=" + remark + "]";
	}
	
}
