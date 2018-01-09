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

	public void flawadd(Flaw flaw);
	
	public boolean updateflawstate(Flaw flaw);

	public Flaw fupdate(int id);

	public boolean deleteflawstate(Map<String, Object> map);


	
}
