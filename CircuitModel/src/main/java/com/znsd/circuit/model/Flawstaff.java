package com.znsd.circuit.model;

public class Flawstaff {
	private int id;
	private int eliminateId;//消缺任务id
	private int userId;//消缺员id
	private String isReceipter;//是否是回执录入人
	private int createdBy;//创建人
	private String createdDate;//创建时间
	private int updatedBy;//修改人
	private String updatedDate;//最近一次修改时间
	private String 	delete_flag;//是否删除
	private String remark;//备注
	public Flawstaff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flawstaff(int id, int eliminateId, int userId, String isReceipter, int createdBy, String createdDate,
			int updatedBy, String updatedDate, String delete_flag, String remark) {
		super();
		this.id = id;
		this.eliminateId = eliminateId;
		this.userId = userId;
		this.isReceipter = isReceipter;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.delete_flag = delete_flag;
		this.remark = remark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEliminateId() {
		return eliminateId;
	}
	public void setEliminateId(int eliminateId) {
		this.eliminateId = eliminateId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getIsReceipter() {
		return isReceipter;
	}
	public void setIsReceipter(String isReceipter) {
		this.isReceipter = isReceipter;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
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
	@Override
	public String toString() {
		return "Flawstaff [id=" + id + ", eliminateId=" + eliminateId + ", userId=" + userId + ", isReceipter="
				+ isReceipter + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", delete_flag=" + delete_flag + ", remark=" + remark + "]";
	}
	
}
