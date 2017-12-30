package com.znsd.circuit.service;

import java.util.List;

import com.znsd.circuit.model.Flaw;
import com.znsd.circuit.model.Pager;

public interface FlawService {

	List<Flaw> getFlawAll(int id,String flawname, int state);

	List<Flaw> selectFlaw(int id);

	Pager<Flaw> servicePage(int pageIndex, int pageSize, Flaw flaw);

}
