package com.znsd.circuit.model;

public class Eliminate {
	private int id;//主键自增ID
	private int taskId;//任务id
	private String workBills;//任务单据
	private int mId;//任务负责人
	private String remark;//消缺备注
	public Eliminate() {
		super();
		
	}
	public Eliminate(int id, int taskId, String workBills, int mId, String remark) {
		super();
		this.id = id;
		this.taskId = taskId;
		this.workBills = workBills;
		this.mId = mId;
		this.remark = remark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getWorkBills() {
		return workBills;
	}
	public void setWorkBills(String workBills) {
		this.workBills = workBills;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Eliminate [id=" + id + ", taskId=" + taskId + ", workBills=" + workBills + ", mId=" + mId + ", remark="
				+ remark + "]";
	}
	
}
