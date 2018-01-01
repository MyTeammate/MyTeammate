package com.znsd.circuit.service;

import java.util.List;

import com.znsd.circuit.model.Flaw;
import com.znsd.circuit.model.Flawnot;

public interface FlawNotService {
	
	List<Flawnot> selectFlawNotarize(int id);

	List<Flawnot> getFlawNotAll(int id, int tasknumber, int threadcoding, int towercoding, int flawname,
			String flawConfirmserviceAbility, String flawConfirmflawDesc, String flawConfirmdiscoverDate,
			int inspectionstaffuserId, int flawConfirmflowGrade);

}
