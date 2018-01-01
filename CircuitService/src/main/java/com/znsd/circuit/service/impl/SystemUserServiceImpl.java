package com.znsd.circuit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.SystemUserDao;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.SystemUserService;

@Service("systemUserService")
public class SystemUserServiceImpl implements SystemUserService{
    @Autowired
	private SystemUserDao systemUserDao;

	@Override
	public int systemUserCount() {
		return systemUserDao.systemUserCount();
	}

	@Override
	public List<User> listSystemUser(Map<String, Object> map) {
		return systemUserDao.listSystemUser(map);
	}
    
}
