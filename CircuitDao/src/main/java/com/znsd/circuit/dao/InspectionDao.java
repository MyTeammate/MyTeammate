package com.znsd.circuit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Flaw;
import com.znsd.circuit.model.Flawconfirm;
import com.znsd.circuit.model.Inspection;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.model.Threads;
import com.znsd.circuit.model.Tower;
import com.znsd.circuit.model.User;

@MapperScan
public interface InspectionDao {
	
	/**获取启用状态下的所有任务状态
	 * @return
	 */
	public List<Systemparam> getSystemParam(String coding);
	
	/**获取启用状态下的所有线路
	 * @return
	 */
	public List<Threads> getAllThread();
	
	/**得到线路的所属杆塔
	 * @return
	 */
	public Threads getThreadTower(int id);
	
	/**获取启用状态下的所有巡检员
	 * @param coding
	 * @return
	 */
	public List<User> getInspectionStaff(String coding);
	
	/**通过tast表的主键得到inspection表的主键
	 * @param taskId
	 * @return
	 */
	public int getInspectionId(int taskId);
	
	/**通过巡检task的id获取inspection的threadId
	 * @param taskId
	 * @return
	 */
	public Threads getThreaddByTask(int taskId);
	
	/**通过线路id得到下面所有杆塔，包括禁用的
	 * @param threadId
	 * @return
	 */
	public List<Tower> getTowerByThread(int threadId);
	
	/**所有启用状态下的缺陷
	 * @return
	 */
	public List<Flaw> getAllFlaw();
	
	/**得到分页的总条数
	 * @return
	 */
	public int getInspectionPageCount();
	
	/**分页查询
	 * @param map
	 * @return
	 */
	public List<Inspection> getInspectionPage(Map<String,Object> map);
	
	/**制定巡检任务
	 * 
	 * @param inspection
	 * @return
	 */
	public int addTask(Inspection inspection);
	public void addInspection(Inspection ins);
	public void addInspectionStaff(Map<String, Object> map);
	
	/**修改巡检任务状态
	 * @param coding 数据字典编码
	 * @param taskId 任务主键
	 * @param state 要修改成的状态
	 */
	public void updateInspectionState(Map<String, Object> map);
	
	/**修改 最后一次修改时间，修改人
	 * @param taskId
	 * @param updatedBy
	 */
	public void updateInspectionDate(Map<String, Object> map);
	
	
	/**
	 * 根据巡检任务id来获取这条巡检任务的详细信息
	 * @param id
	 * @return
	 */
	public Inspection getInspectionTaskById(@Param("id")int id);
	
	
	/**
	 * 根据ID获取某个杆塔的缺陷信息
	 * @param towerId
	 * @return
	 */
	public Flawconfirm getFlawInfoByTowerId(int towerId,int taskId);
	
	/**
	 * 获取一条巡检任务执行的巡检员
	 * @param taskId
	 * @return
	 */
	public List<User> getInspectionTackStaff(@Param("taskId")int taskId);
	
}
