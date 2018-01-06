package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import com.znsd.circuit.model.Eliminate;
import com.znsd.circuit.model.Flawstaff;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.model.Task;
import com.znsd.circuit.model.User;
import com.znsd.circuit.util.MyFlaw;
import com.znsd.circuit.util.SeeEliminate;

public interface EliminateService {
	/**
	 * 查出所有的任务
	 * 
	 * @return
	 */
	public List<Eliminate> getAllTask(Map map);

	/**
	 * 查询出任务的总数
	 * 
	 * @return
	 */
	public int getCount(Map map);

	/**
	 * 查询出消缺任务的单据
	 */
	public List<Systemparam> getAllBills(String bills);

	/**
	 * 查询出所有的线路管理员
	 * 
	 * @return
	 */
	public List<User> getAllLineUser();

	/**
	 * 查询出所有的消缺员
	 * 
	 * @return
	 */
	public List<User> getAlleliminateUser(String coding);

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
	public List<MyFlaw> getAllMyFlaw(Map map);

	/**
	 * 统计缺陷确认的总条数
	 */
	public int getCountByEliminate();

	/**
	 * 查询出缺陷确认表中的数据通过所选的id进行查找
	 */
	public MyFlaw getAllMyFlawById(int id);

	/**
	 * 新增任务表中的任务
	 */
	public int insertTask(Map<String, Object> map);

	/**
	 * 新增消缺表中的数据
	 */
	public int insertEliminate(Eliminate eliminate);

	/**
	 * 新增消缺人员分配表的数据
	 */
	public int insertFlawStaff(Map<String, Object> map);

	/**
	 * 新增消缺缺陷记录表中的数据
	 */
	public int insertEliminateRecord(Map<String, Object> map);
	
	/**
	 * 通过任务编码拿到即时插入的id
	 */
	public Task selectTaskById(String coding);
	
	/**
	  * 先删除已有的消缺员
	  * @param eliminateId
	  * @return
	  */
	public int deleteFlawStaff(int eliminateId);
	/**
	 * 再插入数据
	 * @param eliminateId
	 * @param userId
	 * @return
	 */
	public int insertintoFlawStaff(Flawstaff flawStaff);
	
	/**
	 * 通过id查看消缺任务
	 * @param eliminateId
	 * @return
	 */
	public SeeEliminate seeEliminateById(int eliminateId);
	
	/**
	 * 通过消缺id查到所有的用户
	 * @param eliminateId
	 * @return
	 */
	public List<User> getAllUserId(int eliminateId);
}
