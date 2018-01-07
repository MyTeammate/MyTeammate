package com.znsd.circuit.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.FlawConfirmDao;
import com.znsd.circuit.model.FlawCont;
import com.znsd.circuit.model.Pager;
import com.znsd.circuit.service.FlawConfirmService;

@Service
public class FlawConfirmServiceImpl implements FlawConfirmService{
	
	@Autowired
	private FlawConfirmDao flawConfirmDao;

	@Override
	public List<FlawCont> getFlawConfirmAll(String taskcoding, String threadcoding, String towercoding, String flawname,
			String serviceAbility, String flawDesc, String discoverDate, int userId, int flawGrade, int confirmstate,
			int updatedBy) {
		FlawCont f = new FlawCont();
		f.setTaskcoding(taskcoding);
		f.setThreadcoding(threadcoding);
		f.setTowercoding(towercoding);
		f.setFlawname(flawname);
		f.setServiceAbility(serviceAbility);
		f.setFlawDesc(flawDesc);
		f.setDiscoverDate(discoverDate);
		f.setUserId(userId);
		f.setFlawGrade(flawGrade);
		f.setConfirmstate(confirmstate);
		f.setUpdatedBy(updatedBy);
		f.setConfirmstate(confirmstate);
		List<FlawCont> list=flawConfirmDao.getFlawConfirmAll(f);
		return list;
	}

	//分页
	@Override
	public Pager<FlawCont> getFlawConfirmPager(int pageIndex, int pageSize) {
		Pager<FlawCont> page = new Pager<>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		Map<String,Object> map = new HashMap<>();
		map.put("pageIndex",(page.getPageIndex()-1)*page.getPageSize());
		map.put("pageSize",page.getPageSize());
		page.setSumSize(getFlawConfirmCount(map));
		List<FlawCont> list = flawConfirmDao.getFlawConfirmPager(map);
		page.setData(list);
		return page;
	}
	
	@Override
	public int getFlawConfirmCount(Map<String, Object> map){
		return flawConfirmDao.getFlawConfirmCount(map);
	}

	@Override
	public FlawCont flawconfid(int id) {
		return flawConfirmDao.flawconfid(id);
	}

	@Override
	public boolean updateflawgrade(FlawCont flawCont) {
		return flawConfirmDao.updateflawgrade(flawCont);
	}

	
	
}
