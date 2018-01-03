package com.znsd.circuit.util;

public class SeeEliminate {
		private int id;//消缺确认id
		private String taskCoding;//任务编码
		private String taskName;//任务名称
		private String taskStatus;//任务状态
		private String taskBills;//任务单据
		private String taskxiafaUser;//任务下发人
		private String taskxiafaDate;//任务下发时间
		private int taskfuzeId;//任务负责人id
		private String taskfuzeUser;//任务负责人
		private String taskDesc;//任务描述
		private String taskxiaoqueUser;//消缺员
		private String taskfinishDate;//任务完成时间
		private String taskfuzeUserIdea;//任务负责人意见
		private String taskxiafaUserIdea;//任务下发人意见
		private String taskCompletionDesc;//任务完成情况描述
		private int  taskPassed;//通过是否通过
		private String extensionRecord;//工作延期记载
		private String finalReport;//工作终结报告
		public SeeEliminate() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public SeeEliminate(int id, String taskCoding, String taskName, String taskStatus, String taskBills,
				String taskxiafaUser, String taskxiafaDate, int taskfuzeId, String taskfuzeUser, String taskDesc,
				String taskxiaoqueUser, String taskfinishDate, String taskfuzeUserIdea, String taskxiafaUserIdea,
				String taskCompletionDesc, int taskPassed, String extensionRecord, String finalReport) {
			super();
			this.id = id;
			this.taskCoding = taskCoding;
			this.taskName = taskName;
			this.taskStatus = taskStatus;
			this.taskBills = taskBills;
			this.taskxiafaUser = taskxiafaUser;
			this.taskxiafaDate = taskxiafaDate;
			this.taskfuzeId = taskfuzeId;
			this.taskfuzeUser = taskfuzeUser;
			this.taskDesc = taskDesc;
			this.taskxiaoqueUser = taskxiaoqueUser;
			this.taskfinishDate = taskfinishDate;
			this.taskfuzeUserIdea = taskfuzeUserIdea;
			this.taskxiafaUserIdea = taskxiafaUserIdea;
			this.taskCompletionDesc = taskCompletionDesc;
			this.taskPassed = taskPassed;
			this.extensionRecord = extensionRecord;
			this.finalReport = finalReport;
		}
		
		/**
		 * @return the taskfuzeId
		 */
		public int getTaskfuzeId() {
			return taskfuzeId;
		}

		/**
		 * @param taskfuzeId the taskfuzeId to set
		 */
		public void setTaskfuzeId(int taskfuzeId) {
			this.taskfuzeId = taskfuzeId;
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
		 * @return the taskCoding
		 */
		public String getTaskCoding() {
			return taskCoding;
		}
		/**
		 * @param taskCoding the taskCoding to set
		 */
		public void setTaskCoding(String taskCoding) {
			this.taskCoding = taskCoding;
		}
		/**
		 * @return the taskName
		 */
		public String getTaskName() {
			return taskName;
		}
		/**
		 * @param taskName the taskName to set
		 */
		public void setTaskName(String taskName) {
			this.taskName = taskName;
		}
		/**
		 * @return the taskStatus
		 */
		public String getTaskStatus() {
			return taskStatus;
		}
		/**
		 * @param taskStatus the taskStatus to set
		 */
		public void setTaskStatus(String taskStatus) {
			this.taskStatus = taskStatus;
		}
		/**
		 * @return the taskBills
		 */
		public String getTaskBills() {
			return taskBills;
		}
		/**
		 * @param taskBills the taskBills to set
		 */
		public void setTaskBills(String taskBills) {
			this.taskBills = taskBills;
		}
		/**
		 * @return the taskxiafaUser
		 */
		public String getTaskxiafaUser() {
			return taskxiafaUser;
		}
		/**
		 * @param taskxiafaUser the taskxiafaUser to set
		 */
		public void setTaskxiafaUser(String taskxiafaUser) {
			this.taskxiafaUser = taskxiafaUser;
		}
		/**
		 * @return the taskxiafaDate
		 */
		public String getTaskxiafaDate() {
			return taskxiafaDate;
		}
		/**
		 * @param taskxiafaDate the taskxiafaDate to set
		 */
		public void setTaskxiafaDate(String taskxiafaDate) {
			this.taskxiafaDate = taskxiafaDate;
		}
		/**
		 * @return the taskfuzeUser
		 */
		public String getTaskfuzeUser() {
			return taskfuzeUser;
		}
		/**
		 * @param taskfuzeUser the taskfuzeUser to set
		 */
		public void setTaskfuzeUser(String taskfuzeUser) {
			this.taskfuzeUser = taskfuzeUser;
		}
		/**
		 * @return the taskDesc
		 */
		public String getTaskDesc() {
			return taskDesc;
		}
		/**
		 * @param taskDesc the taskDesc to set
		 */
		public void setTaskDesc(String taskDesc) {
			this.taskDesc = taskDesc;
		}
		/**
		 * @return the taskxiaoqueUser
		 */
		public String getTaskxiaoqueUser() {
			return taskxiaoqueUser;
		}
		/**
		 * @param taskxiaoqueUser the taskxiaoqueUser to set
		 */
		public void setTaskxiaoqueUser(String taskxiaoqueUser) {
			this.taskxiaoqueUser = taskxiaoqueUser;
		}
		/**
		 * @return the taskfinishDate
		 */
		public String getTaskfinishDate() {
			return taskfinishDate;
		}
		/**
		 * @param taskfinishDate the taskfinishDate to set
		 */
		public void setTaskfinishDate(String taskfinishDate) {
			this.taskfinishDate = taskfinishDate;
		}
		/**
		 * @return the taskfuzeUserIdea
		 */
		public String getTaskfuzeUserIdea() {
			return taskfuzeUserIdea;
		}
		/**
		 * @param taskfuzeUserIdea the taskfuzeUserIdea to set
		 */
		public void setTaskfuzeUserIdea(String taskfuzeUserIdea) {
			this.taskfuzeUserIdea = taskfuzeUserIdea;
		}
		/**
		 * @return the taskxiafaUserIdea
		 */
		public String getTaskxiafaUserIdea() {
			return taskxiafaUserIdea;
		}
		/**
		 * @param taskxiafaUserIdea the taskxiafaUserIdea to set
		 */
		public void setTaskxiafaUserIdea(String taskxiafaUserIdea) {
			this.taskxiafaUserIdea = taskxiafaUserIdea;
		}
		/**
		 * @return the taskCompletionDesc
		 */
		public String getTaskCompletionDesc() {
			return taskCompletionDesc;
		}
		/**
		 * @param taskCompletionDesc the taskCompletionDesc to set
		 */
		public void setTaskCompletionDesc(String taskCompletionDesc) {
			this.taskCompletionDesc = taskCompletionDesc;
		}
		/**
		 * @return the taskPassed
		 */
		public int getTaskPassed() {
			return taskPassed;
		}
		/**
		 * @param taskPassed the taskPassed to set
		 */
		public void setTaskPassed(int taskPassed) {
			this.taskPassed = taskPassed;
		}
		/**
		 * @return the extensionRecord
		 */
		public String getExtensionRecord() {
			return extensionRecord;
		}
		/**
		 * @param extensionRecord the extensionRecord to set
		 */
		public void setExtensionRecord(String extensionRecord) {
			this.extensionRecord = extensionRecord;
		}
		/**
		 * @return the finalReport
		 */
		public String getFinalReport() {
			return finalReport;
		}
		/**
		 * @param finalReport the finalReport to set
		 */
		public void setFinalReport(String finalReport) {
			this.finalReport = finalReport;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "SeeEliminate [id=" + id + ", taskCoding=" + taskCoding + ", taskName=" + taskName + ", taskStatus="
					+ taskStatus + ", taskBills=" + taskBills + ", taskxiafaUser=" + taskxiafaUser + ", taskxiafaDate="
					+ taskxiafaDate + ", taskfuzeId=" + taskfuzeId + ", taskfuzeUser=" + taskfuzeUser + ", taskDesc="
					+ taskDesc + ", taskxiaoqueUser=" + taskxiaoqueUser + ", taskfinishDate=" + taskfinishDate
					+ ", taskfuzeUserIdea=" + taskfuzeUserIdea + ", taskxiafaUserIdea=" + taskxiafaUserIdea
					+ ", taskCompletionDesc=" + taskCompletionDesc + ", taskPassed=" + taskPassed + ", extensionRecord="
					+ extensionRecord + ", finalReport=" + finalReport + "]";
		}
		
}
