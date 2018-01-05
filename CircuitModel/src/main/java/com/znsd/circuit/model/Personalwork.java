package com.znsd.circuit.model;

import java.util.Date;

/**
 * 待办任务
 * @author Administrator
 *
 */
public class Personalwork {

	private int id;
	private String to_doTasks;//代办任务类型
	private String task_agents;//代办任务名称
	private Date arrive_time;//到达时间
	private String operation;//操作

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTo_doTasks() {
		return to_doTasks;
	}

	public void setTo_doTasks(String to_doTasks) {
		this.to_doTasks = to_doTasks;
	}

	public String getTask_agents() {
		return task_agents;
	}

	public void setTask_agents(String task_agents) {
		this.task_agents = task_agents;
	}

	public Date getArrive_time() {
		return arrive_time;
	}

	public void setArrive_time(Date arrive_time) {
		this.arrive_time = arrive_time;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "Personalwork [id=" + id + ", to_doTasks=" + to_doTasks + ", task_agents=" + task_agents
				+ ", arrive_time=" + arrive_time + ", operation=" + operation + "]";
	}

}
