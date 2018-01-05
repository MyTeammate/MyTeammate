package com.znsd.circuit.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.InspectionDao;
import com.znsd.circuit.model.Flaw;
import com.znsd.circuit.model.Flawconfirm;
import com.znsd.circuit.model.Inspection;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.model.Threads;
import com.znsd.circuit.model.Tower;
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
	public int getInspectionPageCount(Map<String,Object> map) {
		return inspectionDao.getInspectionPageCount(map);
	}
	
	@Override
	public Pager<Inspection> getInspectionPage(int pageIndex,int pageSize,int userId,String operate,Inspection inspection,String startDate,String endDate) {
		Pager<Inspection> page = new Pager<>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);	
		Map<String,Object> map = new HashMap<>();
		map.put("pageIndex", (page.getPageIndex()-1)*page.getPageSize());
		map.put("pageSize", page.getPageSize());
		map.put("userId", userId);
		map.put("operate", operate);
		
		map.put("coding", inspection.getCoding());
		map.put("thread", inspection.getThread());
		map.put("state", inspection.getState());
		map.put("taskMan", inspection.getCreater());
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		
		page.setSumSize(getInspectionPageCount(map));
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
	public int makeInspection(Inspection ins) {
		inspectionDao.addTask(ins);
		int taskId = ins.getId();
		inspectionDao.addInspection(ins);
		return taskId;
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
		map.put("coding", "TASK_STATE");
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

	@Override
	public Threads getThreaddByTask(int taskId) {
		return inspectionDao.getThreaddByTask(taskId);
	}

	@Override
	public List<Tower> getTowerByThread(int threadId) {
		return inspectionDao.getTowerByThread(threadId);
	}

	@Override
	public List<Flaw> getAllFlaw() {
		return inspectionDao.getAllFlaw();
	}

	@Override
	public Inspection getInspectionTaskById(int id) {
		return inspectionDao.getInspectionTaskById(id);
	}

	@Override
	public Flawconfirm getFlawInfoByTowerId(int towerId,int taskId) {
		return inspectionDao.getFlawInfoByTowerId(towerId,taskId);
	}

	@Override
	public List<User> getInspectionTackStaff(int taskId) {
		return inspectionDao.getInspectionTackStaff(taskId);
	}
	public int checkFlawRecord(Flawconfirm fconfirm) {
		return inspectionDao.checkFlawRecord(fconfirm);
	}

	
	@Override
	public boolean updateFlawConfirm(Flawconfirm fconfirm) {
		inspectionDao.updateFlawConfirm(fconfirm);
		return true;
	}

	@Override
	public Flawconfirm getTowerFlaw(Flawconfirm fconfirm) {
		return inspectionDao.getTowerFlaw(fconfirm);
	}

	@Override
	public boolean saveInspectionFlaw(Flawconfirm fconfirm) {
		inspectionDao.saveFlawConfirm(fconfirm);
		inspectionDao.saveFlawRecord(fconfirm);
		return true;
	}

	@Override
	public void updateFlawRecord(int taskId) {
		inspectionDao.updateFlawRecord(taskId);
	}

	@Override
	public int checkInspectionReceipter(Map<String, Object> map) {
		return inspectionDao.checkInspectionReceipter(map);
	}
	
	@Override
	public String getTaskState(int taskId) {
		return inspectionDao.getTaskState(taskId);
	}

	@Override
	public void deleteInspectionStaff(int taskId) {
		inspectionDao.deleteInspectionStaff(taskId);
	}

	


}
