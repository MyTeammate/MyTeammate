package com.znsd.circuit.model;

public class Systemparam {
	private int id;//参数id
	private int settingId;//配置的id
	private String settingName;//参数名称
	private int createBy;//创建人
	private String createDate;//创建日期
	private String updateDate;//修改日期
	private String delete_flag;//是否删除
	private String remark;//备注
	public Systemparam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Systemparam(int id, int settingId, String settingName, int createBy, String createDate, String updateDate,
			String delete_flag, String remark) {
		super();
		this.id = id;
		this.settingId = settingId;
		this.settingName = settingName;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.delete_flag = delete_flag;
		this.remark = remark;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the settingId
	 */
	public int getSettingId() {
		return settingId;
	}
	/**
	 * @param settingId the settingId to set
	 */
	public void setSettingId(int settingId) {
		this.settingId = settingId;
	}
	/**
	 * @return the settingName
	 */
	public String getSettingName() {
		return settingName;
	}
	/**
	 * @param settingName the settingName to set
	 */
	public void setSettingName(String settingName) {
		this.settingName = settingName;
	}
	/**
	 * @return the createBy
	 */
	public int getCreateBy() {
		return createBy;
	}
	/**
	 * @param createBy the createBy to set
	 */
	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}
	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the updateDate
	 */
	public String getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * @return the delete_flag
	 */
	public String getDelete_flag() {
		return delete_flag;
	}
	/**
	 * @param delete_flag the delete_flag to set
	 */
	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Systemparam [id=" + id + ", settingId=" + settingId + ", settingName=" + settingName + ", createBy="
				+ createBy + ", createDate=" + createDate + ", updateDate=" + updateDate + ", delete_flag="
				+ delete_flag + ", remark=" + remark + "]";
	}
	
}
