package com.znsd.circuit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.TaskEliminate;

/**
 * 消缺记录
 * @author Administrator
 *
 */
@MapperScan
public interface TaskEliminateDao {

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
	public TaskEliminate selectElCoding(String coding);
	
	/**
	 *查询此条消缺线路下的杆塔
	 * @param map
	 * @return
	 */
	public List<TaskEliminate> selectElTower(Map<String, Object> map );
	
	/**
	 * 查询此条消缺线路下的杆塔总数
	 * @param coding
	 * @return
	 */
	public int getselTowerCount(String coding);
	
	/**
	 * 导出消缺记录
	 * @param coding
	 * @return
	 */
	public List<TaskEliminate> eSelectEliminate();
}
