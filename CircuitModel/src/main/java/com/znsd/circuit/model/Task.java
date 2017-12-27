package com.znsd.circuit.model;

public class Task {
	private int id;
	private String name;//任务名称
	private int taskMan;//下发人的id
	private String type;//任务类型
	private String coding;//任务编号
	private String state;//任务状态
	private String date;//任务下发日期
	private String actualDate;//实际完成时间
	private String predictDate;//预计完成时间
	private String description;//任务描述
	private int createdBy;//创建人
	private String createdDate;//创建时间
	private int updatedBy;//修改人
	private String updatedDate;//最近一次修改时间
	private String 	delete_flag;//是否删除
	private String remark;//备注
	public Task() {
		super();
		
	}
	public Task(int id, String name, int taskMan, String type, String coding, String state, String date,
			String actualDate, String predictDate, String description, int createdBy, String createdDate, int updatedBy,
			String updatedDate, String delete_flag, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.taskMan = taskMan;
		this.type = type;
		this.coding = coding;
		this.state = state;
		this.date = date;
		this.actualDate = actualDate;
		this.predictDate = predictDate;
		this.description = description;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.delete_flag = delete_flag;
		this.remark = remark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTaskMan() {
		return taskMan;
	}
	public void setTaskMan(int taskMan) {
		this.taskMan = taskMan;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCoding() {
		return coding;
	}
	public void setCoding(String coding) {
		this.coding = coding;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getActualDate() {
		return actualDate;
	}
	public void setActualDate(String actualDate) {
		this.actualDate = actualDate;
	}
	public String getPredictDate() {
		return predictDate;
	}
	public void setPredictDate(String predictDate) {
		this.predictDate = predictDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
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
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", taskMan=" + taskMan + ", type=" + type + ", coding=" + coding
				+ ", state=" + state + ", date=" + date + ", actualDate=" + actualDate + ", predictDate=" + predictDate
				+ ", description=" + description + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", delete_flag=" + delete_flag
				+ ", remark=" + remark + "]";
	}
	
	
	
}
