package com.znsd.circuit.model;

import java.util.Date;

/**
 * 待办任务
 * @author Administrator
 *
 */
public class Personalwork {

	private int id;
	private String type;//代办任务类型
	private String name;//代办任务名称
	private String backDate;//到达时间
	private int taskId;//相关的任务Id
	private int userId;//那个用户的代办任务
	private int isAccomplish;//是否完成
	private String operation;//操作
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBackDate() {
		return backDate;
	}
	public void setBackDate(String backDate) {
		this.backDate = backDate;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getIsAccomplish() {
		return isAccomplish;
	}
	public void setIsAccomplish(int isAccomplish) {
		this.isAccomplish = isAccomplish;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Personalwork [id=" + id + ", type=" + type + ", name=" + name + ", backDate=" + backDate + ", taskId="
				+ taskId + ", isAccomplish=" + isAccomplish + ", operation=" + operation + "]";
	}

	
}
