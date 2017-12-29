package com.znsd.circuit.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.InspectionDao;
import com.znsd.circuit.model.Inspection;
import com.znsd.circuit.model.Pager;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.service.InspectionService;

@Service
public class InspectionServiceImpl implements InspectionService{
	
	@Autowired
	private InspectionDao inspectionDao;
	
	@Override
	public List<Systemparam> getInspectionParam() {
		return inspectionDao.getInspectionParam();
	}
	
	@Override
	public int getInspectionPageCount() {
		return inspectionDao.getInspectionPageCount();
	}
	
	@Override
	public Pager<Inspection> getInspectionPage(int pageIndex,int pageSize) {
		Pager<Inspection> page = new Pager<>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);	
		Map<String,Object> map = new HashMap<>();
		map.put("pageIndex", (page.getPageIndex()-1)*page.getPageSize());
		map.put("pageSize", page.getPageSize());
		page.setSumSize(getInspectionPageCount());
		List<Inspection> list = inspectionDao.getInspectionPage(map);
		page.setData(list);
		return page;
	}

	

}
