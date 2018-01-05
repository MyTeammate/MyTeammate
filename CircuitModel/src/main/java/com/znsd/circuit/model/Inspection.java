package com.znsd.circuit.model;

import java.util.List;

/**
 * @author LY
 *	
 *	巡检表
 */
public class Inspection {
	
	private int id; 
	private String coding; //任务编号
	private String name; //任务名称
	private String thread; //巡检线路
	private String startTower; //起始杆号
	private String endTower; //终止杆号
	private String creater; //下发人
	private String createDate; //下发时间
	private String state; //任务状态
	private String predictDate; //任务预计完成时间
	private String actualDate; //任务完成时间
	private String delete_flag; //任务是否取消
	private String remark; // 任务备注
	
	private List<User> inspectionUsers; // 被分配的巡检人员
	
	
	public String getPredictDate() {
		return predictDate;
	}

	public void setPredictDate(String predictDate) {
		this.predictDate = predictDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoding() {
		return coding;
	}

	public void setCoding(String coding) {
		this.coding = coding;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThread() {
		return thread;
	}

	public void setThread(String thread) {
		this.thread = thread;
	}

	public String getStartTower() {
		return startTower;
	}

	public void setStartTower(String startTower) {
		this.startTower = startTower;
	}

	public String getEndTower() {
		return endTower;
	}

	public void setEndTower(String endTower) {
		this.endTower = endTower;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getActualDate() {
		return actualDate;
	}

	public void setActualDate(String actualDate) {
		this.actualDate = actualDate;
	}

	public String getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}

	public List<User> getInspectionUsers() {
		return inspectionUsers;
	}

	public void setInspectionUsers(List<User> inspectionUsers) {
		this.inspectionUsers = inspectionUsers;
	}

	@Override
	public String toString() {
		return "Inspection [id=" + id + ", coding=" + coding + ", name=" + name + ", thread=" + thread + ", startTower="
				+ startTower + ", endTower=" + endTower + ", creater=" + creater + ", createDate=" + createDate
				+ ", state=" + state + ", actualDate=" + actualDate + ", delete_flag=" + delete_flag + ", remark="
				+ remark + ", inspectionUsers=" + inspectionUsers + "]";
	}

	
	
}
