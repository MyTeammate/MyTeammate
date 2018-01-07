package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import com.znsd.circuit.model.Taskpolling;

public interface TaskpollingService {
	/**
	 * 查询巡检记录
	 * @param map
	 * @return
	 */
	public List<Taskpolling> selelectTaskPoll(Map<String, Object> map);
	
	/**
	 * 查询巡检任务的总数
	 * @return
	 */
	public int getTsakCount();
	
	/**
	 * 查询此条线路的编号
	 * @param coding
	 * @return
	 */
	public Taskpolling selectTaskTower(String coding);
	
	/**
	 * 查询此条线路下的杆塔
	 * @param task
	 * @return
	 */
	public List<Taskpolling> selectTower(Map<String, Object> map,String t);
	
	/**
	 * 查询这个任务编号的杆塔总数
	 * @param coding
	 * @return
	 */
	public int getselTaskCount(String coding);
	
	/**
	 * 导出巡检记录
	 * @param coding
	 * @return
	 */
	public List<Taskpolling> eSelelectTaskPoll();
}
