package com.znsd.circuit.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.InspectionDao;
import com.znsd.circuit.model.Inspection;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.model.Threads;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.InspectionService;
import com.znsd.circuit.util.Pager;

@Service
public class InspectionServiceImpl implements InspectionService{
	
	@Autowired
	private InspectionDao inspectionDao;
	
	@Override
	public List<Systemparam> getSystemParam(String coding){
		return inspectionDao.getSystemParam(coding);
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

	@Override
	public List<Threads> getAllThread() {
		return inspectionDao.getAllThread();
	}

	@Override
	public Threads getThreadTower(int id) {
		return inspectionDao.getThreadTower(id);
	}

	@Override
	public List<User> getInspectionStaff(String coding) {
		return inspectionDao.getInspectionStaff(coding);
	}

	@Override
	public boolean makeInspection(Inspection ins) {
		inspectionDao.addTask(ins);
		inspectionDao.addInspection(ins);
		return true;
	}

	@Override
	public boolean allotInspection(int taskId,int[] userId, int creater) {
		int inspectionId = getInspectionId(taskId);
		Map<String, Object> map = new HashMap<>();
		map.put("inspectionId", inspectionId);
		map.put("creater", creater);
		for (int i = 0; i < userId.length; i++) {
			if(i==0){
				map.put("isReceipter", "是");
			}else{
				map.put("isReceipter", "否");
			}
			map.put("userId", userId[i]);		
			inspectionDao.addInspectionStaff(map);
		}
		map.put("coding", "INSPECTION_STATE");
		map.put("taskId", taskId);
		map.put("settingName", "已分配");
		inspectionDao.updateInspectionState(map);// coding taskId settingName
		inspectionDao.updateInspectionDate(map);// creater/updatedBy taskId
		return true;
	}

	@Override
	public int getInspectionId(int taskId) {
		return inspectionDao.getInspectionId(taskId);
	}

	@Override
	public void updateInspectionState(Map<String, Object> map) {
		inspectionDao.updateInspectionState(map);// coding taskId settingName
	}

	@Override
	public void updateInspectionDate(Map<String, Object> map) {
		inspectionDao.updateInspectionDate(map);// creater/updatedBy taskId
	}


}
