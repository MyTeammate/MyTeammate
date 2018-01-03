package com.znsd.circuit.model;

public class Flaw {
	private int id;
	private String name;
	private int state;
	private int createdBy;
	private String createdDate;
	private int updatedBy;
	private String updatedDate;
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
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
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
	public String getupdatedDate() {
		return updatedDate;
	}
	public void setupdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
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
	public Flaw(int id, String name, int state, int createdBy, String createdDate, int updatedBy, String updatedDate,
			String delete_flag, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.delete_flag = delete_flag;
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Flaw [id=" + id + ", name=" + name + ", state=" + state + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", delete_flag=" + delete_flag + ", remark=" + remark + "]";
	}
	
}
