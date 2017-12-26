package com.znsd.circuit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.HomeDao;
import com.znsd.circuit.model.Power;
import com.znsd.circuit.service.HomeService;

@Service("HomeService")
public class HomeServiceImpl implements HomeService{
    @Autowired
	private HomeDao homeDao;

	@Override
	public List<Power> selectAllPower(Integer nid) {
		return homeDao.selectAllPower(nid);
	}
    
    
}
