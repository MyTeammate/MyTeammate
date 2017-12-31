package com.znsd.circuit.model;

//巡检记录统计字段
public class Taskpolling {

	private int id;
	private String coding;// 记录任务编号
	private String tanem;// 记录任务名称
	private String threadCoding;// 记录线路编号
	private String startTower;// 起始杆塔
	private String engTower;// 终止杆塔
	private String description;//操作

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCoding() {
		return coding;
	}

	public void setCoding(String coding) {
		this.coding = coding;
	}

	public String getTanem() {
		return tanem;
	}

	public void setTanem(String tanem) {
		this.tanem = tanem;
	}

	public String getThreadCoding() {
		return threadCoding;
	}

	public void setThreadCoding(String threadCoding) {
		this.threadCoding = threadCoding;
	}

	public String getStartTower() {
		return startTower;
	}

	public void setStartTower(String startTower) {
		this.startTower = startTower;
	}

	public String getEngTower() {
		return engTower;
	}

	public void setEngTower(String engTower) {
		this.engTower = engTower;
	}



	@Override
	public String toString() {
		return "Taskpolling [id=" + id + ", coding=" + coding + ", tanem=" + tanem + ", threadCoding=" + threadCoding
				+ ", startTower=" + startTower + ", engTower=" + engTower + "]";
	}

}
