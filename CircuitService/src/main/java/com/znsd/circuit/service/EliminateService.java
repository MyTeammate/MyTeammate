package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import com.znsd.circuit.model.Eliminate;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.model.User;

public interface EliminateService {
	/**
	 * 查出所有的任务
	 * 
	 * @return
	 */
	public List<Eliminate> getAllTask(Map map);
	
	/**
	 * 查询出任务的总数
	 * @return
	 */
	public int getCount();
	
	/**
	 * 查询出消缺任务的单据
	 */
	public List<Systemparam> getAllBills(String bills);
	
	/**
	 * 查询出所有的线路管理员
	 * @return
	 */
	public List<User> getAllLineUser();
	
	/**
	 * 查询出所有的消缺员
	 * @return
	 */
	public List<User> getAlleliminateUser();
	
	/**
	 * 通过id查到消缺员
	 */
	public User getAllUserEliminate(int id);
	
	/**
	 * 通过id修改任务状态
	 */
	public int updateTaskstatus(int id);
}
