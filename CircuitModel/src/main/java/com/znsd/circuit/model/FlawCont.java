package com.znsd.circuit.model;

public class FlawCont {
	private int id;
	private String taskcoding;			//任务编号
	private String threadcoding;		//线路编号
	private String towercoding;			//杆塔编号
	private String flawname;			//缺陷类型
	private String serviceAbility;		//完好率
	private String flawDesc;			//缺陷描述
	private String discoverDate;		//发现时间
	private String userId;					//发现人
	private String flawGrade;				//缺陷级别
	private int confirmstate;			//缺陷等级状态
	private int updatedBy;
	
	public FlawCont() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskcoding() {
		return taskcoding;
	}
	public void setTaskcoding(String taskcoding) {
		this.taskcoding = taskcoding;
	}
	public String getThreadcoding() {
		return threadcoding;
	}
	public void setThreadcoding(String threadcoding) {
		this.threadcoding = threadcoding;
	}
	public String getTowercoding() {
		return towercoding;
	}
	public void setTowercoding(String towercoding) {
		this.towercoding = towercoding;
	}
	public String getFlawname() {
		return flawname;
	}
	public void setFlawname(String flawname) {
		this.flawname = flawname;
	}
	public String getServiceAbility() {
		return serviceAbility;
	}
	public void setServiceAbility(String serviceAbility) {
		this.serviceAbility = serviceAbility;
	}
	public String getFlawDesc() {
		return flawDesc;
	}
	public void setFlawDesc(String flawDesc) {
		this.flawDesc = flawDesc;
	}
	public String getDiscoverDate() {
		return discoverDate;
	}
	public void setDiscoverDate(String discoverDate) {
		this.discoverDate = discoverDate;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFlawGrade() {
		return flawGrade;
	}

	public void setFlawGrade(String flawGrade) {
		this.flawGrade = flawGrade;
	}

	public int getConfirmstate() {
		return confirmstate;
	}
	public void setConfirmstate(int confirmstate) {
		this.confirmstate = confirmstate;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "FlawCont [id=" + id + ", taskcoding=" + taskcoding + ", threadcoding=" + threadcoding + ", towercoding="
				+ towercoding + ", flawname=" + flawname + ", serviceAbility=" + serviceAbility + ", flawDesc="
				+ flawDesc + ", discoverDate=" + discoverDate + ", userId=" + userId + ", flawGrade=" + flawGrade
				+ ", confirmstate=" + confirmstate + ", updatedBy=" + updatedBy + "]";
	}

	public FlawCont(int id, String taskcoding, String threadcoding, String towercoding, String flawname,
			String serviceAbility, String flawDesc, String discoverDate, String userId, String flawGrade, int confirmstate,
			int updatedBy) {
		super();
		this.id = id;
		this.taskcoding = taskcoding;
		this.threadcoding = threadcoding;
		this.towercoding = towercoding;
		this.flawname = flawname;
		this.serviceAbility = serviceAbility;
		this.flawDesc = flawDesc;
		this.discoverDate = discoverDate;
		this.userId = userId;
		this.flawGrade = flawGrade;
		this.confirmstate = confirmstate;
		this.updatedBy = updatedBy;
	}
			
	
}
