package com.znsd.circuit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.EliminateDao;
import com.znsd.circuit.model.Eliminate;
import com.znsd.circuit.model.Flawstaff;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.model.Task;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.EliminateService;
import com.znsd.circuit.util.MyFlaw;

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
	
	

}
