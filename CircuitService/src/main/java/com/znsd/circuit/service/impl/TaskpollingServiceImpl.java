package com.znsd.circuit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.TaskpollingDao;
import com.znsd.circuit.model.Taskpolling;
import com.znsd.circuit.service.TaskpollingService;

@Service("taskpollingService")
public class TaskpollingServiceImpl implements TaskpollingService {
	
	@Autowired
	private TaskpollingDao taskpollingDao;

	@Override
	public List<Taskpolling> selelectTaskPoll(Map<String, Object> map) {
		return taskpollingDao.selelectTaskPoll(map);
	}

	@Override
	public int getTsakCount() {
		return taskpollingDao.getTsakCount();
	}

}
