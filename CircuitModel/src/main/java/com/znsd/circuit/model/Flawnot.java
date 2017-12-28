package com.znsd.circuit.model;

public class Flawnot {
	private int taskId;				//任务编号
	private int threadId;			//线路表的主键id
	private int towerId;			//杆塔表的主键id
	private int flawId;				//缺陷表的主键id
	private int inspectionstaffId;	//巡检表id
	private String isTrouble;		//有无故障
	private String discoverDate;	//发现时间
	private int userId;				//发布的巡检员
	private String flawDesc;		//缺陷描述
	private String serviceAbility;	//完好率
	private int flowGrade;			//缺陷等级
	private String remark;			//备注
	public Flawnot() {
		super();
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
	public int getTowerId() {
		return towerId;
	}
	public void setTowerId(int towerId) {
		this.towerId = towerId;
	}
	public int getFlawId() {
		return flawId;
	}
	public void setFlawId(int flawId) {
		this.flawId = flawId;
	}
	public int getInspectionstaffId() {
		return inspectionstaffId;
	}
	public void setInspectionstaffId(int inspectionstaffId) {
		this.inspectionstaffId = inspectionstaffId;
	}
	public String getIsTrouble() {
		return isTrouble;
	}
	public void setIsTrouble(String isTrouble) {
		this.isTrouble = isTrouble;
	}
	public String getDiscoverDate() {
		return discoverDate;
	}
	public void setDiscoverDate(String discoverDate) {
		this.discoverDate = discoverDate;
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
		return "Flawnot [taskId=" + taskId + ", threadId=" + threadId + ", towerId=" + towerId + ", flawId=" + flawId
				+ ", inspectionstaffId=" + inspectionstaffId + ", isTrouble=" + isTrouble + ", discoverDate="
				+ discoverDate + ", userId=" + userId + ", flawDesc=" + flawDesc + ", serviceAbility=" + serviceAbility
				+ ", flowGrade=" + flowGrade + ", remark=" + remark + "]";
	}
	public Flawnot(int taskId, int threadId, int towerId, int flawId, int inspectionstaffId, String isTrouble,
			String discoverDate, int userId, String flawDesc, String serviceAbility, int flowGrade, String remark) {
		super();
		this.taskId = taskId;
		this.threadId = threadId;
		this.towerId = towerId;
		this.flawId = flawId;
		this.inspectionstaffId = inspectionstaffId;
		this.isTrouble = isTrouble;
		this.discoverDate = discoverDate;
		this.userId = userId;
		this.flawDesc = flawDesc;
		this.serviceAbility = serviceAbility;
		this.flowGrade = flowGrade;
		this.remark = remark;
	}
	
	
}
