package com.znsd.circuit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.EliminateDao;
import com.znsd.circuit.model.Eliminate;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.EliminateService;

@Service
public class EliminateServiceImpl implements EliminateService {
	
	@Autowired
	private EliminateDao eliminateDao;
	@Override
	public List<Eliminate> getAllTask(Map map) {
		
		return eliminateDao.getAllTask(map);
	}
	@Override
	public int getCount() {
		
		return eliminateDao.getCount();
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
	public List<User> getAlleliminateUser() {
		
		return eliminateDao.getAlleliminateUser();
	}
	@Override
	public User getAllUserEliminate(int id) {
		
		return eliminateDao.getAllUserEliminate(id);
	}
	@Override
	public int updateTaskstatus(int id) {
		
		return eliminateDao.updateTaskstatus(id);
	}
	
	

}
