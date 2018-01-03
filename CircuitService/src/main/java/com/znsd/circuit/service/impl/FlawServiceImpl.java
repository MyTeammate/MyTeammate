package com.znsd.circuit.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.FlawDao;
import com.znsd.circuit.model.Flaw;
import com.znsd.circuit.model.Pager;
import com.znsd.circuit.service.FlawService;

@Service
public class FlawServiceImpl implements FlawService{
	
	@Autowired
	private FlawDao flawDao;
	
	//数据显示
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

	//分页 
	@Override 
	public Pager<Flaw> getFlawPage(int pageIndex, int pageSize) {
		Pager<Flaw> page = new Pager<>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		Map<String,Object> map = new HashMap<>();
		map.put("pageIndex", (page.getPageIndex()-1)*page.getPageSize());
		map.put("pageSize", page.getPageSize());
		page.setSumSize(getFlawPageCount());
		List<Flaw> list = flawDao.getFlawPage(map);
		page.setData(list);
		return page;
	}

	@Override
	public int getFlawPageCount() {
		return flawDao.getFlawPageCount();
	}

	@Override
	public boolean flawadd(Flaw flaw) {
		return flawDao.flawadd(flaw);
	}


}
