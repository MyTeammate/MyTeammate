package com.znsd.circuit.util;

public class MyFlaw {
		private int id;//确认id
		private String threadCoding;//线路编号
		private String towerCoding;//杆塔编号
		private String flawGrade;//缺陷等级
		private String flawType;//缺陷类型
		private String flawDesc;//缺陷描述
		private String findUser;//发现人
		private String findDate;//发现时间
		public MyFlaw() {
			super();
			// TODO Auto-generated constructor stub
		}
		public MyFlaw(int id, String threadCoding, String towerCoding, String flawGrade, String flawType,
				String flawDesc, String findUser, String findDate) {
			super();
			this.id = id;
			this.threadCoding = threadCoding;
			this.towerCoding = towerCoding;
			this.flawGrade = flawGrade;
			this.flawType = flawType;
			this.flawDesc = flawDesc;
			this.findUser = findUser;
			this.findDate = findDate;
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
		 * @return the threadCoding
		 */
		public String getThreadCoding() {
			return threadCoding;
		}
		/**
		 * @param threadCoding the threadCoding to set
		 */
		public void setThreadCoding(String threadCoding) {
			this.threadCoding = threadCoding;
		}
		/**
		 * @return the towerCoding
		 */
		public String getTowerCoding() {
			return towerCoding;
		}
		/**
		 * @param towerCoding the towerCoding to set
		 */
		public void setTowerCoding(String towerCoding) {
			this.towerCoding = towerCoding;
		}
		/**
		 * @return the flawGrade
		 */
		public String getFlawGrade() {
			return flawGrade;
		}
		/**
		 * @param flawGrade the flawGrade to set
		 */
		public void setFlawGrade(String flawGrade) {
			this.flawGrade = flawGrade;
		}
		/**
		 * @return the flawType
		 */
		public String getFlawType() {
			return flawType;
		}
		/**
		 * @param flawType the flawType to set
		 */
		public void setFlawType(String flawType) {
			this.flawType = flawType;
		}
		/**
		 * @return the flawDesc
		 */
		public String getFlawDesc() {
			return flawDesc;
		}
		/**
		 * @param flawDesc the flawDesc to set
		 */
		public void setFlawDesc(String flawDesc) {
			this.flawDesc = flawDesc;
		}
		/**
		 * @return the findUser
		 */
		public String getFindUser() {
			return findUser;
		}
		/**
		 * @param findUser the findUser to set
		 */
		public void setFindUser(String findUser) {
			this.findUser = findUser;
		}
		/**
		 * @return the findDate
		 */
		public String getFindDate() {
			return findDate;
		}
		/**
		 * @param findDate the findDate to set
		 */
		public void setFindDate(String findDate) {
			this.findDate = findDate;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "MyFlaw [id=" + id + ", threadCoding=" + threadCoding + ", towerCoding=" + towerCoding
					+ ", flawGrade=" + flawGrade + ", flawType=" + flawType + ", flawDesc=" + flawDesc + ", findUser="
					+ findUser + ", findDate=" + findDate + "]";
		}		
		
}
