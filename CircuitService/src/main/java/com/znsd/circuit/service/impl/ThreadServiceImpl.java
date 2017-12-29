package com.znsd.circuit.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.ThreadDao;
import com.znsd.circuit.model.Line;
import com.znsd.circuit.model.Threads;
import com.znsd.circuit.service.ThreadService;
import com.znsd.circuit.util.Operation;


@Service
public class ThreadServiceImpl implements ThreadService {

	@Autowired
	private ThreadDao threadDao;

	@Override
	public Map<String,Object> pageSelectThread(int page,int rows,Threads thread) {
		Map<String,Object> params = new HashMap<String,Object>();
		Operation operation = new Operation();
		
		
		params.put("page", (page-1)*rows);
		params.put("row", rows);
		params.put("thread", thread);
		List<Threads> threads = threadDao.pageSelectThread(params);
		int total = threadDao.pageThreadTotal(params);
		for (Threads ts : threads) {
			ts.setStateString(ts.getState()==0?"启用":"禁用");
			ts.setRunningStateString(ts.getRunningState()==0?"正常":"维修中");
			ts.setOperation(operation.getOperation(ts.getState()));
		}
		params.put("rows", threads);
		params.put("total", total);
		
		return params;
	}
}
