package com.znsd.circuit.model;

import java.util.Date;

//消缺确认表
public class Flawconfirm {

	private int id;//缺陷确认表主键自增id
	private int flawId;//缺陷表的主键id
	private int towerId;//杆塔表的主键id
	private int taskId;//任务表的主键id
	private int threadId;//线路表的主键id
	private int inspectionstaffId;//巡检表id
	private Date discoverDate;//发现时间
	private String isTrouble;//有无故障
	private int userId;//由谁来确认缺陷等级（发布这个巡检任务的人）
	private String flawDesc;//缺陷描述
	private String serviceAbility;//完好率
	private int flowGrade;//缺陷等级
	private String remark;//备注

	public Flawconfirm() {
		super();
	}

	public Flawconfirm(int id, int flawId, int towerId, int taskId, int threadId, int inspectionstaffId,
			Date discoverDate, String isTrouble, int userId, String flawDesc, String serviceAbility, int flowGrade,
			String remark) {
		super();
		this.id = id;
		this.flawId = flawId;
		this.towerId = towerId;
		this.taskId = taskId;
		this.threadId = threadId;
		this.inspectionstaffId = inspectionstaffId;
		this.discoverDate = discoverDate;
		this.isTrouble = isTrouble;
		this.userId = userId;
		this.flawDesc = flawDesc;
		this.serviceAbility = serviceAbility;
		this.flowGrade = flowGrade;
		this.remark = remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlawId() {
		return flawId;
	}

	public void setFlawId(int flawId) {
		this.flawId = flawId;
	}

	public int getTowerId() {
		return towerId;
	}

	public void setTowerId(int towerId) {
		this.towerId = towerId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public int getInspectionstaffId() {
		return inspectionstaffId;
	}

	public void setInspectionstaffId(int inspectionstaffId) {
		this.inspectionstaffId = inspectionstaffId;
	}

	public Date getDiscoverDate() {
		return discoverDate;
	}

	public void setDiscoverDate(Date discoverDate) {
		this.discoverDate = discoverDate;
	}

	public String getIsTrouble() {
		return isTrouble;
	}

	public void setIsTrouble(String isTrouble) {
		this.isTrouble = isTrouble;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFlawDesc() {
		return flawDesc;
	}

	public void setFlawDesc(String flawDesc) {
		this.flawDesc = flawDesc;
	}

	public String getServiceAbility() {
		return serviceAbility;
	}

	public void setServiceAbility(String serviceAbility) {
		this.serviceAbility = serviceAbility;
	}

	public int getFlowGrade() {
		return flowGrade;
	}

	public void setFlowGrade(int flowGrade) {
		this.flowGrade = flowGrade;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Flawconfirm [id=" + id + ", flawId=" + flawId + ", towerId=" + towerId + ", taskId=" + taskId
				+ ", threadId=" + threadId + ", inspectionstaffId=" + inspectionstaffId + ", discoverDate="
				+ discoverDate + ", isTrouble=" + isTrouble + ", userId=" + userId + ", flawDesc=" + flawDesc
				+ ", serviceAbility=" + serviceAbility + ", flowGrade=" + flowGrade + ", remark=" + remark + "]";
	}

}
