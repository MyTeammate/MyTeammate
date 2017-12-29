package com.znsd.circuit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.SystemDataDao;
import com.znsd.circuit.model.Systemsetting;
import com.znsd.circuit.service.SystemDataService;

@Service("sytemDataService")
public class SystemDataServiceImpl implements SystemDataService{
	@Autowired
    private SystemDataDao systemDataDao;

	@Override
	public List<Systemsetting> listSystemsetting(Map<String, Object> map) {
		return systemDataDao.listSystemsetting(map);
	}

	@Override
	public int systemsettingCount() {
		return systemDataDao.systemsettingCount();
	}

	@Override
	public int addSystemsetting(Systemsetting system) {
		return systemDataDao.addSystemsetting(system);
	}
	
	
}
