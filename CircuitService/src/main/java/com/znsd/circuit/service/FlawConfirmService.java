package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import com.znsd.circuit.model.Flaw;
import com.znsd.circuit.model.FlawCont;
import com.znsd.circuit.model.Pager;

public interface FlawConfirmService {

	public Pager<FlawCont> getFlawConfirmPager(int pageIndex, int pageSize);

	public int getFlawConfirmCount(Map<String, Object> map);


	List<FlawCont> getFlawConfirmAll(String taskcoding, String threadcoding, String towercoding, String flawname,
			String serviceAbility, String flawDesc, String discoverDate, int userId, int flawGrade, int confirmstate,
			int updatedBy);

	public FlawCont flawconfid(int id);

	public boolean updateflawgrade(FlawCont flawCont);
}
