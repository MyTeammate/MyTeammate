package com.znsd.circuit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.EliminateDao;
import com.znsd.circuit.model.Eliminate;
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
	
	

}
