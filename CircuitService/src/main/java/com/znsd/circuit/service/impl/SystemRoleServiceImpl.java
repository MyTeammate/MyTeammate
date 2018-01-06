package com.znsd.circuit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.SystemRoleDao;
import com.znsd.circuit.model.Systemrole;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.SystemRoleService;

@Service("systemRoleService")
public class SystemRoleServiceImpl implements SystemRoleService{
    @Autowired
	private SystemRoleDao systemRoleDao;

	@Override
	public int systemRoleCount() {
		return systemRoleDao.systemRoleCount();
	}

	@Override
	public List<Systemrole> listSystemRole(Map<String, Object> map) {
		return systemRoleDao.listSystemRole(map);
	}

	@Override
	public Systemrole verifyCoding(String coding) {
		return systemRoleDao.verifyCoding(coding);
	}

	@Override
	public Systemrole verifyName(String name) {
		return systemRoleDao.verifyName(name);
	}
}
