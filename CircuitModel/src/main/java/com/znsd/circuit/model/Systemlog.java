package com.znsd.circuit.model;

public class Systemlog {
    private int id;
    private int userId;
    private String userName;
    private String logMessage;
    private String createDate;
    private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLogMessage() {
		return logMessage;
	}
	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Systemlog [id=" + id + ", userId=" + userId + ", userName=" + userName + ", logMessage=" + logMessage
				+ ", createDate=" + createDate + ", remark=" + remark + "]";
	}
	
	
    
}
