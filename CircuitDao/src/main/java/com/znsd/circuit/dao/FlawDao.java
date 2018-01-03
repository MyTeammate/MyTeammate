package com.znsd.circuit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Flaw;

@MapperScan
public interface FlawDao {

	public List<Flaw> getFlawAll(Flaw f);

	public List<Flaw> selectFlaw(int id);
	
	public int getFlawPageCount();

	public List<Flaw> getFlawPage(Map<String, Object> map);

	public boolean flawadd(Flaw flaw);

}
