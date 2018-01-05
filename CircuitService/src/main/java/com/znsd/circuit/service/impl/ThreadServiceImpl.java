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
		if(thread.getCoding()!=null&&!thread.getCoding().equals("")) {
			thread.setCoding("%"+thread.getCoding()+"%");
		}
		
		params.put("thread", thread);
		
		List<Threads> threads = threadDao.pageSelectThread(params);
		int total = threadDao.pageThreadTotal(params);
		for (Threads ts : threads) {
			ts.setStateString(ts.getState()==0?"启用":"禁用");
			ts.setRunningStateString(ts.getRunningState()==0?"正常":"维修中");
			ts.setOperation(operation.getOperation(ts.getState(),"Thread"));
		}
		params.put("rows", threads);
		params.put("total", total);
		
		return params;
	}

	@Override
	public Threads checkCoding(Threads threads) {
		return threadDao.checkCoding(threads);
	}

	@Override
	public int insertThread(Threads threads) {
		threadDao.insertThread(threads);
		
		return threads.getId();
	}

	@Override
	public Threads getThreadById(int id) {
		return threadDao.getThreadById(id);
	}

	@Override
	public void updateThread(Threads threads) {
		 threadDao.updateThread(threads);   		
	}

	@Override
	public List<Threads> findThreadTask(int id) {
		return threadDao.findThreadTask(id);
	}

	@Override
	public void setDeleteFlag(int id) {
		threadDao.setDeleteFlag(id);
	}

	@Override
	public void setStateFlag(Threads threads) {
		threadDao.setStateFlag(threads);
	}

	@Override
	public List<Threads> findThreadsByLineId(int lineId) {
		return threadDao.findThreadsByLineId(lineId);
	}
}
