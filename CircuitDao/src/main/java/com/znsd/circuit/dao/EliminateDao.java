package com.znsd.circuit.dao;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Eliminate;
import com.znsd.circuit.model.Flawstaff;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.model.Systemrole;
import com.znsd.circuit.model.Task;
import com.znsd.circuit.model.User;
import com.znsd.circuit.util.MyFlaw;
import com.znsd.circuit.util.SeeEliminate;

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
	public int getCount(Map map);
	
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
	public int insertTask(Map<String,Object> map);
	
	/**
	 * 新增消缺表中的数据
	 */
	public int insertEliminate(Eliminate eliminate);
	
	/**
	 * 新增消缺人员分配表的数据
	 */
	public int insertFlawStaff(Map<String,Object> map);
	
	/**
	 * 新增消缺缺陷记录表中的数据
	 */
	public int insertEliminateRecord(Map<String,Object> map);
	
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
	
	/**
	 * 通过任务id查询出每个任务所对应的缺陷
	 * @return
	 */
	public List<MyFlaw> seeEliminateBytaskId(int taskid);

	/**
	 * 消缺执行与回执的任务分页
	 * @param map
	 * @return
	 */
	public List<Eliminate> getAllTaskByCondition(Map<String,Object> map);
	
	/**
	 * 回执的总数计算
	 * @param map
	 * @return
	 */
	public int getCountByCondition(Map<String,Object> map);
	
	/**
	 * 通过id修改任务状态为执行中
	 */
	public int execu_updateTaskstatus(int id);
	
	/**
	 * 通userid和消缺id判断是否是回执录入人
	 * @param eliminateId
	 * @param userId
	 * @return
	 */
	public Flawstaff selectEliminateByUserId(int eliminateId,int userId);
	
	/**
	 * 通过用户id找到我要查询的角色对象
	 * @param id
	 * @return
	 */
	public Systemrole selectRoleByUserId(int id);
	
	/**
	 * 回执录入除下发人和负责人意见的其他三个信息
	 * @param map
	 * @return
	 */
	public int update_receipte(Map<String,Object> map);
	
	/**
	 * 通过id修改任务状态为审核中
	 */
	public int execu_updateTaskstatusAudit(int id);
	
	/**
	 * 判断是否是任务负责人
	 * @param eliminateId
	 * @param userId
	 * @return
	 */
	public Eliminate midflag(int eliminateId,int userId);
	
	/**
	 * 判断是否是任务下发人
	 * @param eliminateId
	 * @param userId
	 * @return
	 */
	public Task taskmanflag(int taskId,int userId);
	
	/**
	 * 负责人的意见
	 * @param map
	 * @return
	 */
	public int update_fuze(Map<String,Object> map) ;
	
	/**
	 * 通过id修改任务状态为已完成
	 */
	public int execu_updateTaskstatusSuccess(int id);
	/**
	 * 通过id修改任务状态为驳回
	 */
	public int execu_updateTaskstatusReturn(int id);
	
	/**
	 * 通过消缺id找到任务对象
	 * @param id
	 * @return
	 */
	public Task selectTaskByeliminateId(int id);
	
	/**
	 * 修改已完成时间
	 * @param task
	 * @return
	 */
	public int updateActualDate(Map<String,Object> map);
	
	/**
	 * 下发人的意见
	 * @param map
	 * @return
	 */
	public int update_xiafa(Map<String,Object> map);
	
	/**
	 * 下发人和负责人
	 * @param map
	 * @return
	 */
	public int update_all(Map<String,Object> map);
	
	

}






