package com.znsd.circuit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.EliminateQueryDao;
import com.znsd.circuit.model.EliminateQuery;
import com.znsd.circuit.model.Flaw;
import com.znsd.circuit.service.EliminateQueryService;

@Service
public class EliminateQueryServiceImpl implements EliminateQueryService{

	@Autowired
	private EliminateQueryDao eliminateQueryDao;
	
	@Override
	public List<EliminateQuery> selectEliminayeQuery(Map<String, Object> map) {
		return eliminateQueryDao.selectEliminayeQuery(map) ;
	}

	@Override
	public int getEQueryCount() {
		return eliminateQueryDao.getEQueryCount();
	}

	@Override
	public List<Flaw> selectFlawName() {
		return eliminateQueryDao.selectFlawName();
	}


}
