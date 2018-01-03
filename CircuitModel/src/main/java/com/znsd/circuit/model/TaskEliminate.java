package com.znsd.circuit.model;

/**
 * 消缺记录统计
 * 
 * @author Administrator
 *
 */
public class TaskEliminate {

	private String tcoding;// 任务编号
	private String tename;// 任务名称
	private String ethreadCoding;// 线路编号
	private String estartTower;// 起始杆号
	private String tendTower;// 终止杆号
	private String etowerCoding;// 杆塔编号
	private String eisTrouble;// 有无故障
	private String esettingName;// 缺陷级别
	private String eflawTname;// 缺陷类型
	private String eactualDate;// 消缺时间
	private String ediscoverDate;// 发现时间
	private String eflawDesc;// 缺陷描述

	private String edescription;

	public String getTcoding() {
		return tcoding;
	}

	public void setTcoding(String tcoding) {
		this.tcoding = tcoding;
	}

	public String getTename() {
		return tename;
	}

	public void setTename(String tename) {
		this.tename = tename;
	}

	public String getEthreadCoding() {
		return ethreadCoding;
	}

	public void setEthreadCoding(String ethreadCoding) {
		this.ethreadCoding = ethreadCoding;
	}

	public String getEstartTower() {
		return estartTower;
	}

	public void setEstartTower(String estartTower) {
		this.estartTower = estartTower;
	}

	public String getTendTower() {
		return tendTower;
	}

	public void setTendTower(String tendTower) {
		this.tendTower = tendTower;
	}

	public String getEtowerCoding() {
		return etowerCoding;
	}

	public void setEtowerCoding(String etowerCoding) {
		this.etowerCoding = etowerCoding;
	}

	public String getEisTrouble() {
		return eisTrouble;
	}

	public void setEisTrouble(String eisTrouble) {
		this.eisTrouble = eisTrouble;
	}

	public String getEsettingName() {
		return esettingName;
	}

	public void setEsettingName(String esettingName) {
		this.esettingName = esettingName;
	}

	public String getEflawTname() {
		return eflawTname;
	}

	public void setEflawTname(String eflawTname) {
		this.eflawTname = eflawTname;
	}

	public String getEactualDate() {
		return eactualDate;
	}

	public void setEactualDate(String eactualDate) {
		this.eactualDate = eactualDate;
	}

	public String getEdiscoverDate() {
		return ediscoverDate;
	}

	public void setEdiscoverDate(String ediscoverDate) {
		this.ediscoverDate = ediscoverDate;
	}

	public String getEflawDesc() {
		return eflawDesc;
	}

	public void setEflawDesc(String eflawDesc) {
		this.eflawDesc = eflawDesc;
	}

	public String getEdescription() {
		return edescription;
	}

	public void setEdescription(String edescription) {
		this.edescription = edescription;
	}

	@Override
	public String toString() {
		return "TaskEliminate [tcoding=" + tcoding + ", tename=" + tename + ", ethreadCoding=" + ethreadCoding
				+ ", estartTower=" + estartTower + ", tendTower=" + tendTower + ", etowerCoding=" + etowerCoding
				+ ", eisTrouble=" + eisTrouble + ", esettingName=" + esettingName + ", eflawTname=" + eflawTname
				+ ", eactualDate=" + eactualDate + ", ediscoverDate=" + ediscoverDate + ", eflawDesc=" + eflawDesc
				+ "]";
	}

}
