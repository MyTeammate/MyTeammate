package com.znsd.circuit.model;

//巡检记录统计字段
public class Taskpolling {

	private int id;
	private String coding;// 记录任务编号
	private String tanem;// 记录任务名称
	private String threadCoding;// 记录线路编号
	private String startTower;// 起始杆塔
	private String engTower;// 终止杆塔
	private String description;// 操作

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	/*
	 * @Override public String toString() { return "Taskpolling [id=" + id +
	 * ", coding=" + coding + ", tanem=" + tanem + ", threadCoding=" +
	 * threadCoding + ", startTower=" + startTower + ", engTower=" + engTower +
	 * "]"; }
	 */

	private String towerCoding;// 杆塔编号
	private String settingName;// 缺陷级别
	private String flawtype;// 缺陷类型
	private String discoverDate;// 发现时间
	private String flawDesc;// 缺陷描述

	public String getTowerCoding() {
		return towerCoding;
	}

	public void setTowerCoding(String towerCoding) {
		this.towerCoding = towerCoding;
	}

	public String getSettingName() {
		return settingName;
	}

	public void setSettingName(String settingName) {
		this.settingName = settingName;
	}

	public String getFlawtype() {
		return flawtype;
	}

	public void setFlawtype(String flawtype) {
		this.flawtype = flawtype;
	}

	public String getDiscoverDate() {
		return discoverDate;
	}

	public void setDiscoverDate(String discoverDate) {
		this.discoverDate = discoverDate;
	}

	public String getFlawDesc() {
		return flawDesc;
	}

	public void setFlawDesc(String flawDesc) {
		this.flawDesc = flawDesc;
	}

	@Override
	public String toString() {
		return "Taskpolling [id=" + id + ", coding=" + coding + ", tanem=" + tanem + ", threadCoding=" + threadCoding
				+ ", startTower=" + startTower + ", engTower=" + engTower + ", description=" + description
				+ ", towerCoding=" + towerCoding + ", settingName=" + settingName + ", flawtype=" + flawtype
				+ ", discoverDate=" + discoverDate + ", flawDesc=" + flawDesc + "]";
	}

}
