package com.znsd.circuit.model;

/**
 * 消缺查询
 * 
 * @author Administrator
 *
 */
public class EliminateQuery {

	private int id;
	private String t_coding;// 任务编号
	private String t_type;// 任务状态
	private String t_bills;// 工作单据
	private String t_number;// 线路编号
	private String tower_coding;// 杆塔编号
	private String flaw_rank;// 缺陷级别
	private String flaw_type;// 缺陷类型
	private String finder;// 发现人
	private String find_time;// 发现时间
	private String issue;// 下发人
	private String issue_time;// 下发时间
	private String intact_rate;// 完好率
	private String flaw_describe;// 缺陷描述

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getT_coding() {
		return t_coding;
	}

	public void setT_coding(String t_coding) {
		this.t_coding = t_coding;
	}

	public String getT_type() {
		return t_type;
	}

	public void setT_type(String t_type) {
		this.t_type = t_type;
	}

	public String getT_bills() {
		return t_bills;
	}

	public void setT_bills(String t_bills) {
		this.t_bills = t_bills;
	}

	public String getT_number() {
		return t_number;
	}

	public void setT_number(String t_number) {
		this.t_number = t_number;
	}

	public String getTower_coding() {
		return tower_coding;
	}

	public void setTower_coding(String tower_coding) {
		this.tower_coding = tower_coding;
	}

	public String getFlaw_rank() {
		return flaw_rank;
	}

	public void setFlaw_rank(String flaw_rank) {
		this.flaw_rank = flaw_rank;
	}

	public String getFlaw_type() {
		return flaw_type;
	}

	public void setFlaw_type(String flaw_type) {
		this.flaw_type = flaw_type;
	}

	public String getFinder() {
		return finder;
	}

	public void setFinder(String finder) {
		this.finder = finder;
	}

	public String getFind_time() {
		return find_time;
	}

	public void setFind_time(String find_time) {
		this.find_time = find_time;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getIssue_time() {
		return issue_time;
	}

	public void setIssue_time(String issue_time) {
		this.issue_time = issue_time;
	}

	public String getIntact_rate() {
		return intact_rate;
	}

	public void setIntact_rate(String intact_rate) {
		this.intact_rate = intact_rate;
	}

	public String getFlaw_describe() {
		return flaw_describe;
	}

	public void setFlaw_describe(String flaw_describe) {
		this.flaw_describe = flaw_describe;
	}

	@Override
	public String toString() {
		return "EliminateQuery [id=" + id + ", t_coding=" + t_coding + ", t_type=" + t_type + ", t_bills=" + t_bills
				+ ", t_number=" + t_number + ", tower_coding=" + tower_coding + ", flaw_rank=" + flaw_rank
				+ ", flaw_type=" + flaw_type + ", finder=" + finder + ", find_time=" + find_time + ", issue=" + issue
				+ ", issue_time=" + issue_time + ", intact_rate=" + intact_rate + ", flaw_describe=" + flaw_describe
				+ "]";
	}

}
