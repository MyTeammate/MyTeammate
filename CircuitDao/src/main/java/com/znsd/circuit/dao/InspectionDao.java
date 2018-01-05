package com.znsd.circuit.dao;

import java.util.List;
import java.util.Map;

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
	public int getInspectionPageCount(Map<String,Object> map);
	
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
	
	
	/* start 回执录入 */
	
	/**判断是否已保存过该杆塔缺陷
	 * @param fconfirm
	 * @return
	 */
	public int checkFlawRecord(Flawconfirm fconfirm); //taskId towerId
	
	/**第一次保存某任务下的杆塔缺陷
	 * @param fconfirm
	 * @return
	 */
	public int saveFlawConfirm(Flawconfirm fconfirm);
	
	/**增加巡检记录
	 * @param fconfirm
	 */
	public void saveFlawRecord(Flawconfirm fconfirm); //taskId flawconfirmId userId
	
	/**修改（再次保存）
	 * @param fconfirm
	 */
	public void updateFlawConfirm(Flawconfirm fconfirm);
	
	/**通过杆塔和编号得到杆塔缺陷
	 * @param fconfirm
	 * @return
	 */
	public Flawconfirm getTowerFlaw(Flawconfirm fconfirm);  //towerId taskId
	
	/**巡检任务上传回执（修改状态）
	 * @param taskId
	 */
	public void updateFlawRecord(int taskId);
	
	/**判断是否是回执录入人
	 * @param map
	 * @return
	 */
	public int checkInspectionReceipter(Map<String, Object> map);
	 
	/*  end 回执录入   */
	
	/**得到任务的状态
	 * @param taskId
	 * @return
	 */
	public String getTaskState(int taskId);
	
	/**已分配状态下的取消操作
	 * @param taskId
	 */
	public void deleteInspectionStaff(int taskId);
}
