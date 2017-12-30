package com.znsd.circuit.model;

public class Eliminate {
	private int id;//主键自增ID
	private int taskId;//任务id
	private String workBills;//任务单据
	private int mId;//任务负责人
	private String remark;//消缺备注
	//private Flawstaff flawstaff;//消缺人员分配对象
	private Task task;//任务
	private String taskcoding;
	private String taskName;
	private String xiafaMan;
	private String xiafaDate;
	private String taskStatus;
	private String flag;
	private String wancdate;
	//private String operation;//操作
	public Eliminate() {
		super();
		
	}
	public Eliminate(int id, int taskId, String workBills, int mId, String remark, Task task, String taskcoding,
			String taskName, String xiafaMan, String xiafaDate, String taskStatus, String flag, String wancdate) {
		super();
		this.id = id;
		this.taskId = taskId;
		this.workBills = workBills;
		this.mId = mId;
		this.remark = remark;
		this.task = task;
		this.taskcoding = taskcoding;
		this.taskName = taskName;
		this.xiafaMan = xiafaMan;
		this.xiafaDate = xiafaDate;
		this.taskStatus = taskStatus;
		this.flag = flag;
		this.wancdate = wancdate;
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
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public String getTaskcoding() {
		return taskcoding;
	}
	public void setTaskcoding(String taskcoding) {
		this.taskcoding = taskcoding;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getXiafaMan() {
		return xiafaMan;
	}
	public void setXiafaMan(String xiafaMan) {
		this.xiafaMan = xiafaMan;
	}
	public String getXiafaDate() {
		return xiafaDate;
	}
	public void setXiafaDate(String xiafaDate) {
		this.xiafaDate = xiafaDate;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getWancdate() {
		return wancdate;
	}
	public void setWancdate(String wancdate) {
		this.wancdate = wancdate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Eliminate [id=" + id + ", taskId=" + taskId + ", workBills=" + workBills + ", mId=" + mId + ", remark="
				+ remark + ", task=" + task + ", taskcoding=" + taskcoding + ", taskName=" + taskName + ", xiafaMan="
				+ xiafaMan + ", xiafaDate=" + xiafaDate + ", taskStatus=" + taskStatus + ", flag=" + flag
				+ ", wancdate=" + wancdate + "]";
	}
	
	
	
	
	
}
