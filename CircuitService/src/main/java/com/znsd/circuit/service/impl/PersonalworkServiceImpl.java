package com.znsd.circuit.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.PersonalworkDao;
import com.znsd.circuit.model.Flawconfirm;
import com.znsd.circuit.model.Personalwork;
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
		for (Personalwork personalwork2 : rowss) {
			personalwork2.setOperation("<a href='javascript:onclick=queryWork()'>查看</a>  &nbsp;&nbsp;|&nbsp;&nbsp;  <a href='javascript:onclick=dealWork()'>处理</a>");
		}
		int total = personalworkDao.getWorkTotal(params);
		params.put("rows", rowss);
		params.put("total", total);
		return params;
	}

	@Override
	public List<Flawconfirm> getTaskTowerFlawInfo(int taskId) {
		return personalworkDao.getTaskTowerFlawInfo(taskId);
	}

	

}
