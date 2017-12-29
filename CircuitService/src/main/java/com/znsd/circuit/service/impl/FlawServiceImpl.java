package com.znsd.circuit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.FlawDao;
import com.znsd.circuit.model.Flaw;
import com.znsd.circuit.service.FlawService;

@Service
public class FlawServiceImpl implements FlawService{
	
	@Autowired
	private FlawDao flawDao;
	
	@Override
	public List<Flaw> getFlawAll(int id,String flawname,int state){
		Flaw f = new Flaw();
		f.setFlawname(flawname);
		f.setState(state);
		List<Flaw> list=flawDao.getFlawAll(f);
		return list;
	}
	
	@Override
	public List<Flaw> selectFlaw(int id){
		return flawDao.selectFlaw(id);
	}
	
	
}
