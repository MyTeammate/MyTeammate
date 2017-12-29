package com.znsd.circuit.model;

public class Systemsetting {
	private int id;//配置id
	private String coding;//配置编码
	private String name;//配置名称
	private String state;//状态
	private int createBy;//创建人
	private String createDate;//创建日期
	private String updateDate;//修改日期
	private String delete_flag;//是否删除
	private String remark;//备注
	public Systemsetting() {
		super();

	}
	public Systemsetting(int id, String coding, String name, String state, int createBy, String createDate,
			String updateDate, String delete_flag, String remark) {
		super();
		this.id = id;
		this.coding = coding;
		this.name = name;
		this.state = state;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.delete_flag = delete_flag;
		this.remark = remark;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getCreateBy() {
		return createBy;
	}

	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Systemsetting [id=" + id + ", coding=" + coding + ", name=" + name + ", state=" + state + ", createBy="
				+ createBy + ", createDate=" + createDate + ", updateDate=" + updateDate + ", delete_flag="
				+ delete_flag + ", remark=" + remark + "]";
	}

}
