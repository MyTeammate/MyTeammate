package com.znsd.circuit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Taskpolling;

@MapperScan
public interface TaskpollingDao {

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
