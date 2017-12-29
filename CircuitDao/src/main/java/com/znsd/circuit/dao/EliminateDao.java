package com.znsd.circuit.dao;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Eliminate;

@MapperScan
public interface EliminateDao {
	/**
	 * 查出所有的任务
	 * @return
	 */
	public List<Eliminate> getAllTask(Map map);
	
	/**
	 * 查询出任务的总数
	 * @return
	 */
	public int getCount();
}
