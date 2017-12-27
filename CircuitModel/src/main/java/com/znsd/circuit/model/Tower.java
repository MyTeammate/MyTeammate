package com.znsd.circuit.model;

public class Tower {

	private int id;
	private String coding;
	private int lineId;
	private Line line;
	private String state;
	private int status;
	
	
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
	public Line getLine() {
		return line;
	}
	public void setLine(Line line) {
		this.line = line;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Tower [id=" + id + ", coding=" + coding + ", lineId=" + lineId + ", line=" + line + ", state=" + state
				+ "]";
	}
	
	
	
	
	
}
