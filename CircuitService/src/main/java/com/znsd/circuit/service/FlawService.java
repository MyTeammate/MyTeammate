package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import com.znsd.circuit.model.Flaw;
import com.znsd.circuit.model.Pager;

public interface FlawService {

	public List<Flaw> getFlawAll(int id,String flawname, int state);

	public List<Flaw> selectFlaw(int id);
	
	public int getFlawPageCount();

	public Pager<Flaw> getFlawPage(int pageIndex, int pageSize);

	public void flawadd(Flaw flaw);

	public boolean updateflawstate(Flaw flaw);
	
	public void deleteflawstate(Map<String, Object> map);
	
	public Flaw fupdate(int id);

	
}
