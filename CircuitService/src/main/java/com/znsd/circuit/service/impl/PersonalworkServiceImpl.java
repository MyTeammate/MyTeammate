package com.znsd.circuit.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.PersonalworkDao;
import com.znsd.circuit.model.Flawconfirm;
import com.znsd.circuit.model.Personalwork;
import com.znsd.circuit.model.Threads;
import com.znsd.circuit.service.PersonalworkService;
@Service
public class PersonalworkServiceImpl implements PersonalworkService {

	@Autowired
	private PersonalworkDao personalworkDao;
	
	
	@Override
	public void arriveWork(Personalwork personalwork) {
		personalworkDao.arriveWork(personalwork);
	}

	@Override
	public Map<String,Object> selectMyWork(int page,int rows,Personalwork personalwork) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", (page-1)*rows);
		params.put("rows", rows);
		params.put("isAccomplish", personalwork.getIsAccomplish());
		params.put("userId", personalwork.getUserId());
		List<Personalwork> rowss =  personalworkDao.selectMyWork(params);
		List<Personalwork> rs = new ArrayList<Personalwork>();
		for (Personalwork personalwork2 : rowss) {
		    if(personalwork2.getType().equals("缺陷确认任务")) {
		    	Flawconfirm flawconfirm = personalworkDao.getFlawconfirmById(personalwork2.getTaskId());
		    	if(flawconfirm.getConfirmstate()==1) {
		    		personalwork2.setOperation("<a href='javascript:onclick=queryWorkFlaw()'>查看</a>");
		    		rs.add(personalwork2);
		    	}else {
		    		personalwork2.setIsAccomplish(1);
		    		personalworkDao.setAccomplish(personalwork2);
		    	}
		    }else{
		    	Threads thread = personalworkDao.getThreadBytaskId(personalwork2.getTaskId());
		    	
		    	if(personalwork2.getType().equals("消缺任务")) {
		    		personalwork2.setOperation("<a href='javascript:onclick=queryWorkEliminating()'>查看</a>");
		    	}else if(personalwork2.getType().equals("巡检任务")) {
		    		personalwork2.setOperation("<a href='javascript:onclick=queryWorkInspection()'>查看</a>");
		    	}
		    	if(thread.getState()==5) {
		    		rs.add(personalwork2);
		    	}else {
		    		personalwork2.setIsAccomplish(1);
		    		personalworkDao.setAccomplish(personalwork2);
		    	}
		    }
		    
		}
		int total = personalworkDao.getWorkTotal(params);
		params.put("rows", rs);
		params.put("total", total);
		return params;
	}

	@Override
	public List<Flawconfirm> getTaskTowerFlawInfo(int taskId) {
		return personalworkDao.getTaskTowerFlawInfo(taskId);
	}

	@Override
	public Threads getThreadBytaskId(int taskId) {
		return personalworkDao.getThreadBytaskId(taskId);
	}

			

}
