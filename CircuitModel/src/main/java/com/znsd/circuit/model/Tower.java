package com.znsd.circuit.model;

public class Tower {

	private int id;
	private String coding;
	private int lineId;
	private String lineName;
	//private Line line;
	private int state;
	private String status;
	private String operation;
	private String createDate;
	private int createById;
	private String updateDate;
	private String deleteFlag;
	private String remark;
	
	
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
	public int getLineId() {
		return lineId;
	}
	public void setLineId(int lineId) {
		this.lineId = lineId;
	}
	/*public Line getLine() {
		return line;
	}
	public void setLine(Line line) {
		this.line = line;
	}*/
	
	
	public int getState() {
		return state;
	}
	
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
	public int getCreateById() {
		return createById;
	}
	public void setCreateById(int createById) {
		this.createById = createById;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Tower [id=" + id + ", coding=" + coding + ", lineId=" + lineId + ", line="  + ", state=" + state
				+ "]";
	}
	
	
	
	
	
}
