package com.znsd.circuit.service;

import java.util.List;

import com.znsd.circuit.model.Flaw;
import com.znsd.circuit.model.Pager;

public interface FlawFYService {

	Pager<Flaw> servicePage(int pageIndex, int pageSize, Flaw flaw);
	
}
