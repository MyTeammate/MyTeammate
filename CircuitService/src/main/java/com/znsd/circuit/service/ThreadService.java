package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import com.znsd.circuit.model.Threads;

public interface ThreadService {

	
	/**
	 * 分页列出指定路线下所以线路数据
	 * @param params
	 * @return
	 */
	public Map<String,Object> pageSelectThread(int page,int rows,Threads threads);
}
