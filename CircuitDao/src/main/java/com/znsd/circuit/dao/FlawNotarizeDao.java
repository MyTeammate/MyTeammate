package com.znsd.circuit.dao;

import java.util.List;

import com.znsd.circuit.model.Flawnot;

public interface FlawNotarizeDao {

	public List<Flawnot> selectFlawNotarize(int id);

	public List<Flawnot> getFlawNotAll(Flawnot fln);

	
}
