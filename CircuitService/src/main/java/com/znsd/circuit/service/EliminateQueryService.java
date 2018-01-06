package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import com.znsd.circuit.model.EliminateQuery;
import com.znsd.circuit.model.Flaw;

public interface EliminateQueryService {
	/**
	 * 查询所有消缺任务
	 * @return
	 */
	public List<EliminateQuery> selectEliminayeQuery(Map<String, Object> map);
	
	/**
	 * 查询消缺任务总数
	 * @return
	 */
	public int getEQueryCount();
	
	public List<Flaw> selectFlawName();
}
