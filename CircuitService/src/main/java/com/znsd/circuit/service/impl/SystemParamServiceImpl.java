package com.znsd.circuit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.SystemParamDao;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.service.SystemParamService;

@Service("systemParamService")
public class SystemParamServiceImpl implements SystemParamService{
	@Autowired
    private SystemParamDao systemParamDao;

	@Override
	public List<Systemparam> listSystemparam(Map<String, Object> map) {
		return systemParamDao.listSystemparam(map);
	}

	@Override
	public int systemparamCount(int systemsettingId) {
		return systemParamDao.systemparamCount(systemsettingId);
	}

	@Override
	public int addSystemparam(Systemparam param) {
		return systemParamDao.addSystemparam(param);
	}

	@Override
	public int deleteSystemparam(int id) {
		return systemParamDao.deleteSystemparam(id);
	}

	@Override
	public Systemparam querySystemparam(Map<String,Object> map) {
		return systemParamDao.querySystemparam(map);
	}

	@Override
	public int updateSystemparam(Map<String,Object> map) {
		return systemParamDao.updateSystemparam(map);
	}

	@Override
	public Systemparam getSystemparamById(int paramId) {
		return systemParamDao.getSystemparamById(paramId);
	}
	

}
