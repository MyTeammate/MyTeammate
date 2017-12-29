package com.znsd.circuit.service;

import java.util.List;

import com.znsd.circuit.model.Power;

public interface HomeService {
	public List<Power> selectAllPower(Integer nid);
}
