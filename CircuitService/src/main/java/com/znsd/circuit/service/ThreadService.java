package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.znsd.circuit.model.Threads;

public interface ThreadService {

	
	/**
	 * 分页列出指定路线下所以线路数据
	 * @param params
	 * @return
	 */
	public Map<String,Object> pageSelectThread(int page,int rows,Threads threads);
	
	
	/**
	 * 校验每条路线里的线路编号是否存在
	 * @param coding
	 * @return
	 */
	public Threads checkCoding(Threads threads);
	
	
	/**
	 * 插入线路数据
	 * @param threads
	 */
	public int insertThread(Threads threads);
	
	
	/**
	 * 根据线路ID获取线路对象
	 * @param id
	 * @return
	 */
	public Threads getThreadById(@Param("id")int id);
	
	
	/**
	 * 更新线路信息
	 * @param threads
	 */
	public void updateThread(Threads threads);
	
	/**
	 * 查询一个线路有多少个巡检任务
	 * @param id
	 * @return
	 */
	public List<Threads> findThreadTask(int id);
	
	
	/**
	 * 修改该线路的状态为删除
	 * @param id
	 */
	public void setDeleteFlag(int id);
	
	
	/**
	 * 修改该条线路的状态为禁用状态
	 * @param id
	 */
	public void setStateFlag(Threads threads);
	
	
	/**
	 * 根据ID查询一条路线有多少线路
	 * @param lineId
	 * @return
	 */
	public List<Threads> findThreadsByLineId(@Param("lineId")int lineId); 
}
