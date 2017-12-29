package com.znsd.circuit.service;

import java.util.List;

import com.znsd.circuit.model.Flaw;

public interface FlawService {

	List<Flaw> getFlawAll(int id,String flawname, int state);

	List<Flaw> selectFlaw(int id);

}
