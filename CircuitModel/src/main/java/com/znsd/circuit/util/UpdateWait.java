package com.znsd.circuit.util;

public class UpdateWait {
		private int id;//消缺id
		private int taskId;//任务id
		private int mid;//负责人id
		private String workbills;//任务单据
		private String coding;//任务编码
		private String name;//任务名称
		private String description;//任务描述
		private String remark;//任务备注
		private String fuzeName;//负责人姓名
		//private int yetid;//选择的缺陷id
		public UpdateWait() {
			super();
		}
		public UpdateWait(int id, int taskId, int mid, String workbills, String coding, String name, String description,
				String remark, String fuzeName) {
			super();
			this.id = id;
			this.taskId = taskId;
			this.mid = mid;
			this.workbills = workbills;
			this.coding = coding;
			this.name = name;
			this.description = description;
			this.remark = remark;
			this.fuzeName = fuzeName;
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
		 * @return the taskId
		 */
		public int getTaskId() {
			return taskId;
		}
		/**
		 * @param taskId the taskId to set
		 */
		public void setTaskId(int taskId) {
			this.taskId = taskId;
		}
		/**
		 * @return the mid
		 */
		public int getMid() {
			return mid;
		}
		/**
		 * @param mid the mid to set
		 */
		public void setMid(int mid) {
			this.mid = mid;
		}
		/**
		 * @return the workbills
		 */
		public String getWorkbills() {
			return workbills;
		}
		/**
		 * @param workbills the workbills to set
		 */
		public void setWorkbills(String workbills) {
			this.workbills = workbills;
		}
		/**
		 * @return the coding
		 */
		public String getCoding() {
			return coding;
		}
		/**
		 * @param coding the coding to set
		 */
		public void setCoding(String coding) {
			this.coding = coding;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}
		/**
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
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
		/**
		 * @return the fuzeName
		 */
		public String getFuzeName() {
			return fuzeName;
		}
		/**
		 * @param fuzeName the fuzeName to set
		 */
		public void setFuzeName(String fuzeName) {
			this.fuzeName = fuzeName;
		}
		/**
		 * @return the yetid
		 */
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "UpdateWait [id=" + id + ", taskId=" + taskId + ", mid=" + mid + ", workbills=" + workbills
					+ ", coding=" + coding + ", name=" + name + ", description=" + description + ", remark=" + remark
					+ ", fuzeName=" + fuzeName  + "]";
		}
		
		
}
