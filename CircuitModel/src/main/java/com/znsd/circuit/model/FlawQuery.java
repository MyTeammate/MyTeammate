package com.znsd.circuit.model;

/**巡检任务管理 -- >缺陷查询
 * 
 * @author LY
 *
 */
public class FlawQuery {
	private String taskCoding; //任务编号
	private String threadCoding; //线路编号
	private String towerCoding; //杆塔编号
	private String flawGrade; //缺陷等级
	private String flawType; //缺陷类型
	private String receipter; //发现人
	private String discoverDate; //发现时间
	private String creater; //下发人
	private String date; //下发时间
	private String serviceAbility; //完好率
	private String flawDesc; //缺陷描述
	public String getTaskCoding() {
		return taskCoding;
	}
	public void setTaskCoding(String taskCoding) {
		this.taskCoding = taskCoding;
	}
	public String getThreadCoding() {
		return threadCoding;
	}
	public void setThreadCoding(String threadCoding) {
		this.threadCoding = threadCoding;
	}
	public String getTowerCoding() {
		return towerCoding;
	}
	public void setTowerCoding(String towerCoding) {
		this.towerCoding = towerCoding;
	}
	public String getFlawGrade() {
		return flawGrade;
	}
	public void setFlawGrade(String flawGrade) {
		this.flawGrade = flawGrade;
	}
	public String getFlawType() {
		return flawType;
	}
	public void setFlawType(String flawType) {
		this.flawType = flawType;
	}
	public String getReceipter() {
		return receipter;
	}
	public void setReceipter(String receipter) {
		this.receipter = receipter;
	}
	public String getDiscoverDate() {
		return discoverDate;
	}
	public void setDiscoverDate(String discoverDate) {
		this.discoverDate = discoverDate;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	
	
	
}
