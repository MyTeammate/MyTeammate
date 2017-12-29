package com.znsd.circuit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Threads;

@MapperScan
public interface ThreadDao {

	/**
	 * 分页列出指定路线下所以线路数据
	 * @param params
	 * @return
	 */
	public List<Threads> pageSelectThread(Map<String,Object> params);
	
	/**
	 * 获取该路线有多少条线路
	 * @param params
	 * @return
	 */
	public int pageThreadTotal(Map<String,Object> params);
}
