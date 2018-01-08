package com.znsd.circuit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.FlawCont;

@MapperScan
public interface FlawConfirmDao {
	public List<FlawCont> getFlawConfirmAll(FlawCont f);

	public List<FlawCont> getFlawConfirmPager(Map<String, Object> map);

	public int getFlawConfirmCount(Map<String, Object> map);
	
	public FlawCont flawconfid(int id);
	
	public boolean getFlawConfirm(Map<String, Object> map);

	public boolean updateflawgrade(FlawCont flawCont);
}
