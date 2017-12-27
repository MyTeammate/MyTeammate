package com.znsd.circuit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.HomeDao;
import com.znsd.circuit.model.Power;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.HomeService;

@Service("HomeService")
public class HomeServiceImpl implements HomeService{
    @Autowired
	private HomeDao homeDao;

	@Override
	public List<Power> selectAllPower(Integer nid) {
		return homeDao.selectAllPower(nid);
	}

	@Override
	public User login(Map<String,Object> map) {
		return homeDao.login(map);
	}

	@Override
	public int loginDate(Map<String,Object> map2) {
		return homeDao.loginDate(map2);
	}
    
    
}
