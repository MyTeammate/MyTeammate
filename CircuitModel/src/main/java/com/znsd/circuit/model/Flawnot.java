package com.znsd.circuit.model;

public class Flawnot {
	private int id;
	private int tasknumber;				//任务编号
	private int threadcoding;			//线路表的主键id
	private int towercoding;			//杆塔表的主键id
	private int flawname;				//缺陷表的主键id
	private String flawConfirmdiscoverDate;	//发现时间
	private int inspectionstaffuserId;				//发布的巡检员
	private String flawConfirmflawDesc;		//缺陷描述
	private String flawConfirmserviceAbility;	//完好率
	private int flawConfirmflowGrade;			//缺陷等级
	public Flawnot() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTasknumber() {
		return tasknumber;
	}
	public void setTasknumber(int tasknumber) {
		this.tasknumber = tasknumber;
	}
	public int getThreadcoding() {
		return threadcoding;
	}
	public void setThreadcoding(int threadcoding) {
		this.threadcoding = threadcoding;
	}
	public int getTowercoding() {
		return towercoding;
	}
	public void setTowercoding(int towercoding) {
		this.towercoding = towercoding;
	}
	public int getFlawname() {
		return flawname;
	}
	public void setFlawname(int flawname) {
		this.flawname = flawname;
	}
	public String getFlawConfirmdiscoverDate() {
		return flawConfirmdiscoverDate;
	}
	public void setFlawConfirmdiscoverDate(String flawConfirmdiscoverDate) {
		this.flawConfirmdiscoverDate = flawConfirmdiscoverDate;
	}
	public int getInspectionstaffuserId() {
		return inspectionstaffuserId;
	}
	public void setInspectionstaffuserId(int inspectionstaffuserId) {
		this.inspectionstaffuserId = inspectionstaffuserId;
	}
	public String getFlawConfirmflawDesc() {
		return flawConfirmflawDesc;
	}
	public void setFlawConfirmflawDesc(String flawConfirmflawDesc) {
		this.flawConfirmflawDesc = flawConfirmflawDesc;
	}
	public String getFlawConfirmserviceAbility() {
		return flawConfirmserviceAbility;
	}
	public void setFlawConfirmserviceAbility(String flawConfirmserviceAbility) {
		this.flawConfirmserviceAbility = flawConfirmserviceAbility;
	}
	public int getFlawConfirmflowGrade() {
		return flawConfirmflowGrade;
	}
	public void setFlawConfirmflowGrade(int flawConfirmflowGrade) {
		this.flawConfirmflowGrade = flawConfirmflowGrade;
	}

	public Flawnot(int id, int tasknumber, int threadcoding, int towercoding, int flawname,
			String flawConfirmdiscoverDate, int inspectionstaffuserId, String flawConfirmflawDesc,
			String flawConfirmserviceAbility, int flawConfirmflowGrade) {
		super();
		this.id = id;
		this.tasknumber = tasknumber;
		this.threadcoding = threadcoding;
		this.towercoding = towercoding;
		this.flawname = flawname;
		this.flawConfirmdiscoverDate = flawConfirmdiscoverDate;
		this.inspectionstaffuserId = inspectionstaffuserId;
		this.flawConfirmflawDesc = flawConfirmflawDesc;
		this.flawConfirmserviceAbility = flawConfirmserviceAbility;
		this.flawConfirmflowGrade = flawConfirmflowGrade;
	}

	@Override
	public String toString() {
		return "Flawnot [id=" + id + ", tasknumber=" + tasknumber + ", threadcoding=" + threadcoding + ", towercoding="
				+ towercoding + ", flawname=" + flawname + ", flawConfirmdiscoverDate=" + flawConfirmdiscoverDate
				+ ", inspectionstaffuserId=" + inspectionstaffuserId + ", flawConfirmflawDesc=" + flawConfirmflawDesc
				+ ", flawConfirmserviceAbility=" + flawConfirmserviceAbility + ", flawConfirmflowGrade="
				+ flawConfirmflowGrade + "]";
	}
	
	
}
