package com.znsd.circuit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Flawconfirm;
import com.znsd.circuit.model.Personalwork;
import com.znsd.circuit.model.Task;
import com.znsd.circuit.model.Threads;

@MapperScan
public interface PersonalworkDao {
    
	/**
	 * 到达一条代办任务
	 * @param personalwork
	 */
	public void  arriveWork(@Param("personalwork")Personalwork personalwork);
	
	
	
	/**
	 * 查询出某个用户代办任务
	 * @param personalwork
	 * @return
	 */
	public List<Personalwork> selectMyWork(Map<String,Object> map);
	
	
	/**
	 * 查询一个巡检任务下的每个杆塔的缺陷信息
	 * 
	 * @param taskId
	 * @return
	 */
	public List<Flawconfirm> getTaskTowerFlawInfo(int taskId);
	
	
	/**
	 * 获取总数
	 * @param map
	 * @return
	 */
	public int getWorkTotal(Map<String,Object> map);
	
	/**
	 * 根据任务ID获取线路
	 * @param taskId
	 * @return
	 */
	public Threads getThreadBytaskId(@Param("taskId")int taskId);
	
	
	/**
	 * 根据ID获取Flawconfirm对象
	 * @param id
	 * @return
	 */
	public Flawconfirm getFlawconfirmById(@Param("id")int id);
	
	
	/**
	 * 修改代办任务状态为完成
	 * @param personalwork
	 */
	public void setAccomplish(@Param("personalwork")Personalwork personalwork);
	
	/**
	 * 根据任务ID获取任务对象
	 * @param taskId
	 * @return
	 */
	public Task getTaskById(int taskId);
}
