package com.znsd.circuit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.FlawNotarizeDao;
import com.znsd.circuit.model.Flaw;
import com.znsd.circuit.model.Flawnot;
import com.znsd.circuit.service.FlawNotService;

@Service
public class FlawNotServiceImpl implements FlawNotService{
	
	@Autowired
	private FlawNotarizeDao flawNotarizeDao;

	@Override
	public List<Flawnot> getFlawNotAll(int id,int tasknumber, int threadcoding, int towercoding, int flawname,
			String flawConfirmserviceAbility, String flawConfirmflawDesc, String flawConfirmdiscoverDate,
			int inspectionstaffuserId, int flawConfirmflowGrade) {
		Flawnot fln = new Flawnot();
		fln.setTasknumber(tasknumber);
		fln.setThreadcoding(threadcoding);
		fln.setTowercoding(towercoding);
		fln.setFlawname(flawname);
		fln.setFlawConfirmserviceAbility(flawConfirmserviceAbility);
		fln.setFlawConfirmflawDesc(flawConfirmflawDesc);
		fln.setFlawConfirmdiscoverDate(flawConfirmdiscoverDate);
		fln.setInspectionstaffuserId(inspectionstaffuserId);
		fln.setFlawConfirmflowGrade(flawConfirmflowGrade);
		List<Flawnot> listfln = flawNotarizeDao.getFlawNotAll(fln);
		return listfln;
	}
	
	@Override
	public List<Flawnot> selectFlawNotarize(int id){
		return flawNotarizeDao.selectFlawNotarize(id);
	}
	
}
