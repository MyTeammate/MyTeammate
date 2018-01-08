package com.znsd.circuit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.SystemUserDao;
import com.znsd.circuit.model.Systemlog;
import com.znsd.circuit.model.Systemrole;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.SystemUserService;

@Service("systemUserService")
public class SystemUserServiceImpl implements SystemUserService{
    @Autowired
	private SystemUserDao systemUserDao;

	@Override
	public int systemUserCount(Map<String, Object> map) {
		return systemUserDao.systemUserCount(map);
	}

	@Override
	public List<User> listSystemUser(Map<String, Object> map) {
		return systemUserDao.listSystemUser(map);
	}

	@Override
	public List<Systemrole> selectSysteUser() {
		return systemUserDao.selectSysteUser();
	}

	@Override
	public User queryUserNameSysteUser(String userName) {
		return systemUserDao.queryUserNameSysteUser(userName);
	}

	@Override
	public User queryNameSysteUser(String name) {
		return systemUserDao.queryNameSysteUser(name);
	}

	@Override
	public int add(User user) {
		return systemUserDao.add(user);
	}

	@Override
	public int addRoleId(Map<String,Object> map) {
		return systemUserDao.addRoleId(map);
	}

	@Override
	public User queryUserName(String userName) {
		return systemUserDao.queryUserName(userName);
	}

	@Override
	public int freezeSysteUser(Map<String,Object> map) {
		return systemUserDao.freezeSysteUser(map);
	}

	@Override
	public User IdSysteUser(int id) {
		return systemUserDao.IdSysteUser(id);
	}

	@Override
	public User queryUserNameSysteUser2(Map<String,Object> map) {
		return systemUserDao.queryUserNameSysteUser2(map);
	}

	@Override
	public User queryNameSysteUser2(Map<String, Object> map) {
		return systemUserDao.queryNameSysteUser2(map);
	}

	@Override
	public int update(User user) {
		return systemUserDao.update(user);
	}

	@Override
	public int addRoleId2(Map<String, Object> map) {
		return systemUserDao.addRoleId2(map);
	}

	@Override
	public int delete(int id) {
		return systemUserDao.delete(id);
	}

	@Override
	public List<Systemlog> listSystemLog(Map<String, Object> map) {
		return systemUserDao.listSystemLog(map);
	}

	@Override
	public int systemLogCount(Map<String,Object> map) {
		return systemUserDao.systemLogCount(map);
	}

	@Override
	public int addLog(Systemlog log) {
		return systemUserDao.addLog(log);
	}

	@Override
	public int loginLog(Systemlog log) {
		return systemUserDao.loginLog(log);
	}

	@Override
	public int freezeSysteUser2(Map<String, Object> map) {
		return systemUserDao.freezeSysteUser2(map);
	}
    
}
