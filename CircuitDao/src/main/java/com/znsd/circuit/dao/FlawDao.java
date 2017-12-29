package com.znsd.circuit.dao;

import java.util.List;

import com.znsd.circuit.model.Flaw;

public interface FlawDao {

	public List<Flaw> getFlawAll(Flaw f);

	public List<Flaw> selectFlaw(int id);

}
