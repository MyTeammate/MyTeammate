package com.znsd.circuit.model;

public class Systemrole{
    private int id;            //id	
    private String coding;	   //角色编号
    private String name;	   //角色名称
    private int createBy;      //创建人
    private String createName;    //创建人姓名
    private String createDate; //创建时间
    private int updateBy;      //修改人
    private String updatedDate;//修改时间
    private String state;	   //状态
    private String remark;     //备注
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCreateBy() {
		return createBy;
	}
	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(int updateBy) {
		this.updateBy = updateBy;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Systemrole [id=" + id + ", coding=" + coding + ", name=" + name + ", createBy=" + createBy
				+ ", createName=" + createName + ", createDate=" + createDate + ", updateBy=" + updateBy
				+ ", updatedDate=" + updatedDate + ", state=" + state + ", remark=" + remark + "]";
	}
	
    
}
