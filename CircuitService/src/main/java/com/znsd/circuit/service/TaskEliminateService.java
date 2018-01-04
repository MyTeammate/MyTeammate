package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import com.znsd.circuit.model.TaskEliminate;

public interface TaskEliminateService {
	/**
	 * 查询所有消缺记录
	 * @return
	 */
	public List<TaskEliminate> selectEliminate(Map<String, Object> map);
	
	/**
	 * 消缺记录总数
	 * @return
	 */
	public int selectElCount();
	
	/**
	 * 查询此消缺任务的编号
	 * @param coding
	 * @return
	 */
	public TaskEliminate selectElCoding(String tcoding);
	
	/**
	 *查询此条消缺线路下的杆塔
	 * @param map
	 * @return
	 */
	public List<TaskEliminate> selectElTower(Map<String, Object> map,String coding);
	
	/**
	 * 查询此条消缺线路下的杆塔总数
	 * @param coding
	 * @return
	 */
	public int getselTowerCount(String coding);
}
