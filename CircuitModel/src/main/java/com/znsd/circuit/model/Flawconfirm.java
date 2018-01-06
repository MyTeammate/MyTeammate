package com.znsd.circuit.model;

import java.util.Date;

//消缺确认表
public class Flawconfirm {

	private int id;//缺陷确认表主键自增id
	private String flawId;//缺陷表的主键id
	private int towerId;//杆塔表的主键id
	private int taskId;//任务表的主键id
	private int threadId;//线路表的主键id
	private int inspectionstaffId;//巡检人员分配表id
	private String discoverDate;//发现时间
	private String isTrouble;//有无故障
	private String flawType; //缺陷等级
	private int userId;//由谁来确认缺陷等级（发布这个巡检任务的人）
	private String flawDesc;//缺陷描述
	private String receiptMan;//回执录入人
	private String serviceAbility;//完好率
	private String flawGrade;//缺陷等级
	private String remark;//备注
	private String threadName; //线路名称
	private String towerCoding; //杆塔编号
	private int taskMan; //发布这个巡检任务的user

	public Flawconfirm() {
		super();
	}

	public Flawconfirm(int id, String flawId, int towerId, int taskId, int threadId, int inspectionstaffId,
			String discoverDate, String isTrouble, int userId, String flawDesc, String serviceAbility, String flawGrade,
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
		this.flawGrade = flawGrade;
		this.remark = remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlawId() {
		return flawId;
	}

	public void setFlawId(String flawId) {
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

	public String getDiscoverDate() {
		return discoverDate;
	}

	public void setDiscoverDate(String discoverDate) {
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

	public String getFlawGrade() {
		return flawGrade;
	}

	public void setFlawGrade(String flawGrade) {
		this.flawGrade = flawGrade;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public String getTowerCoding() {
		return towerCoding;
	}

	public void setTowerCoding(String towerCoding) {
		this.towerCoding = towerCoding;
	}

	public String getReceiptMan() {
		return receiptMan;
	}

	public void setReceiptMan(String receiptMan) {
		this.receiptMan = receiptMan;
	}

	public String getFlawType() {
		return flawType;
	}

	public void setFlawType(String flawType) {
		this.flawType = flawType;
	}
	

	

	public int getTaskMan() {
		return taskMan;
	}

	public void setTaskMan(int taskMan) {
		this.taskMan = taskMan;
	}

	@Override
	public String toString() {
		return "Flawconfirm [id=" + id + ", flawId=" + flawId + ", towerId=" + towerId + ", taskId=" + taskId
				+ ", threadId=" + threadId + ", inspectionstaffId=" + inspectionstaffId + ", discoverDate="
				+ discoverDate + ", isTrouble=" + isTrouble + ", userId=" + userId + ", flawDesc=" + flawDesc
				+ ", serviceAbility=" + serviceAbility + ", flawGrade=" + flawGrade + ", remark=" + remark + "]";
	}

}
