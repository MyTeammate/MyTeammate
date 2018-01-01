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
}
