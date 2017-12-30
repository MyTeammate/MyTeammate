package com.znsd.circuit.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.FlawDao;
import com.znsd.circuit.model.Flaw;
import com.znsd.circuit.model.Pager;
import com.znsd.circuit.service.FlawFYService;

@Service
public class FlawFYServiceImpl implements FlawFYService{
	
	@Autowired
	private FlawDao flawDao;

	//
	@Override
	public Pager<Flaw> servicePage(int pageIndex, int pageSize, Flaw flaw) {
		/*Pager<Flaw> pa = new Pager<>();
		pa.setPageIndex(pageIndex);
		pa.setPageSize(pageSize);
		pa.setSumSize(getPactTableCount(flaw));
		Map<String,Object> map = new HashMap<>();*/
		return null;
	}

	
}
