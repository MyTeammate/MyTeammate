package com.znsd.circuit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.TaskEliminateDao;
import com.znsd.circuit.model.TaskEliminate;
import com.znsd.circuit.service.TaskEliminateService;

@Service("taskEliminateService")
public class TaskEliminateServiceImpl implements TaskEliminateService{
	
	@Autowired
	private TaskEliminateDao taskEliminateDao;

	@Override
	public List<TaskEliminate> selectEliminate(Map<String, Object> map) {		
		return taskEliminateDao.selectEliminate(map);
	}

	@Override
	public int selectElCount() {
		return taskEliminateDao.selectElCount();
	}

	@Override
	public TaskEliminate selectElCoding(String coding) {
		return taskEliminateDao.selectElCoding(coding);
	}

	@Override
	public List<TaskEliminate> selectElTower(Map<String, Object> map, String coding) {
		map.put("tcoding", coding);
		return taskEliminateDao.selectElTower(map);
	}

	@Override
	public int getselTowerCount(String coding) {
		return taskEliminateDao.getselTowerCount(coding);
	}

}
