package com.znsd.circuit.model;

public class Power {
    private int id;
    private String text;
    private String state;
    private String url;
    private String iconCls;
    private int nid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	@Override
	public String toString() {
		return "Power [id=" + id + ", text=" + text + ", state=" + state + ", url=" + url + ", iconCls=" + iconCls
				+ ", nid=" + nid + "]";
	}
    
}
