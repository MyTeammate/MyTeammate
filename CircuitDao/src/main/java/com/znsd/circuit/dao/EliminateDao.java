package com.znsd.circuit.dao;
import java.security.PublicKey;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Eliminate;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.model.User;

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
	
	/**
	 * 查询出缺陷确认表中的数据
	 */
	//public List<Flaw>
}
