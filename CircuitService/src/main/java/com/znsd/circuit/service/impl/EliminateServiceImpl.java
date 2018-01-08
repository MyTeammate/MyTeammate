package com.znsd.circuit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.EliminateDao;
import com.znsd.circuit.model.Eliminate;
import com.znsd.circuit.model.Flawstaff;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.model.Systemrole;
import com.znsd.circuit.model.Task;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.EliminateService;
import com.znsd.circuit.util.MyFlaw;
import com.znsd.circuit.util.SeeEliminate;
import com.znsd.circuit.util.UpdateWait;

@Service
public class EliminateServiceImpl implements EliminateService {
	
	@Autowired
	private EliminateDao eliminateDao;
	@Override
	public List<Eliminate> getAllTask(Map map) {
		
		return eliminateDao.getAllTask(map);
	}
	@Override
	public int getCount(Map map) {
		
		return eliminateDao.getCount(map);
	}
	@Override
	public List<Systemparam> getAllBills(String bills) {
		
		return eliminateDao.getAllBills(bills);
	}
	@Override
	public List<User> getAllLineUser() {
		
		return eliminateDao.getAllLineUser();
	}
	@Override
	public List<User> getAlleliminateUser(String coding) {
		
		return eliminateDao.getAlleliminateUser(coding);
	}
	@Override
	public User getAllUserEliminate(int id) {
		
		return eliminateDao.getAllUserEliminate(id);
	}
	@Override
	public int updateTaskstatus(int id) {
		
		return eliminateDao.updateTaskstatus(id);
	}
	@Override
	public List<MyFlaw> getAllMyFlaw(Map map) {
		
		return eliminateDao.getAllMyFlaw(map);
	}
	@Override
	public int getCountByEliminate() {
		return eliminateDao.getCountByEliminate();
	}
	@Override
	public MyFlaw getAllMyFlawById(int id) {
		
		return eliminateDao.getAllMyFlawById(id);
	}
	@Override
	public int insertTask(Map<String, Object> map) {
		
		return eliminateDao.insertTask(map);
	}
	@Override
	public int insertEliminate(Eliminate eliminate) {
		
		return eliminateDao.insertEliminate(eliminate);
	}
	@Override
	public int insertFlawStaff(Map<String, Object> map) {
		
		return eliminateDao.insertFlawStaff(map);
	}
	@Override
	public int insertEliminateRecord(Map<String, Object> map) {
		
		return eliminateDao.insertEliminateRecord(map);
	}
	@Override
	public Task selectTaskById(String coding) {
		
		return eliminateDao.selectTaskById(coding);
	}
	@Override
	public int deleteFlawStaff(int eliminateId) {
		
		return eliminateDao.deleteFlawStaff(eliminateId);
	}
	@Override
	public int insertintoFlawStaff(Flawstaff flawStaff) {
		
		return eliminateDao.insertintoFlawStaff(flawStaff);
	}
	@Override
	public SeeEliminate seeEliminateById(int eliminateId) {
		return eliminateDao.seeEliminateById(eliminateId);
	}
	@Override
	public List<User> getAllUserId(int eliminateId) {
		
		return eliminateDao.getAllUserId(eliminateId);
	}
	@Override
	public List<MyFlaw> seeEliminateBytaskId(int taskid) {
		
		return eliminateDao.seeEliminateBytaskId(taskid);
	}
	@Override
	public List<Eliminate> getAllTaskByCondition(Map<String, Object> map) {
		
		return eliminateDao.getAllTaskByCondition(map);
	}
	@Override
	public int getCountByCondition(Map<String, Object> map) {
		
		return eliminateDao.getCountByCondition(map);
	}
	@Override
	public int execu_updateTaskstatus(int id) {
		
		return eliminateDao.execu_updateTaskstatus(id);
	}
	@Override
	public Flawstaff selectEliminateByUserId(int eliminateId, int userId) {
		
		return eliminateDao.selectEliminateByUserId(eliminateId, userId);
	}
	@Override
	public Systemrole selectRoleByUserId(int id) {
		
		return eliminateDao.selectRoleByUserId(id);
	}
	@Override
	public int update_receipte(Map<String, Object> map) {
		
		return eliminateDao.update_receipte(map);
	}
	@Override
	public int execu_updateTaskstatusAudit(int id) {
		
		return eliminateDao.execu_updateTaskstatusAudit(id);
	}
	@Override
	public Eliminate midflag(int eliminateId, int userId) {
		
		return eliminateDao.midflag(eliminateId, userId);
	}
	@Override
	public Task taskmanflag(int taskId, int userId) {
		
		return eliminateDao.taskmanflag(taskId, userId);
	}
	@Override
	public int update_fuze(Map<String, Object> map) {
		
		return eliminateDao.update_fuze(map);
	}
	@Override
	public int execu_updateTaskstatusSuccess(int id) {
		
		return eliminateDao.execu_updateTaskstatusSuccess(id);
	}
	@Override
	public int execu_updateTaskstatusReturn(int id) {
		
		return eliminateDao.execu_updateTaskstatusReturn(id);
	}
	@Override
	public Task selectTaskByeliminateId(int id) {
		
		return eliminateDao.selectTaskByeliminateId(id);
	}
	@Override
	public int updateActualDate(Map<String, Object> map) {
		
		return eliminateDao.updateActualDate(map);
	}
	@Override
	public int update_xiafa(Map<String, Object> map) {
		
		return eliminateDao.update_xiafa(map);
	}
	@Override
	public int update_all(Map<String, Object> map) {
		
		return eliminateDao.update_all(map);
	}
	@Override
	public int update_allocated(int eliminate) {
		
		return eliminateDao.update_allocated(eliminate);
	}
	@Override
	public List<User> existUserById(int id) {
		
		return eliminateDao.existUserById(id);
	}
	@Override
	public int removethis(Map<String,Object> map) {
		
		return eliminateDao.removethis(map);
	}
	@Override
	public UpdateWait select_update_wait(int id) {
		
		return eliminateDao.select_update_wait(id);
	}
	@Override
	public int delete_record(Integer id) {
		
		return eliminateDao.delete_record(id);
	}
	@Override
	public List<MyFlaw> update_EliminateBytaskId(int taskid) {
		
		return eliminateDao.update_EliminateBytaskId(taskid);
	}
	@Override
	public int insertintoRecord(int taskId, int yetid) {
		
		return eliminateDao.insertintoRecord(taskId, yetid);
	}
	@Override
	public int updateEliminate(Map<String, Object> map) {
		
		return eliminateDao.updateEliminate(map);
	}
	@Override
	public int updateTask(Map<String, Object> map) {
		
		return eliminateDao.updateTask(map);
	}
	@Override
	public Eliminate getTaskByEliminateId(int eliminateId) {
		return eliminateDao.getTaskByEliminateId(eliminateId);
	}
	
	
	

}
