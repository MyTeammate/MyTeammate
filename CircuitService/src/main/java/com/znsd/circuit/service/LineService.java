package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import com.znsd.circuit.model.Line;
import com.znsd.circuit.model.Tower;

public interface LineService {

	/**
	 * 分页显示路线数据
	 * @return
	 */
	public Map<String,Object> pageSelectLine(int page,int rows,Line line);
	
	
	/**
	 * 校验路线编码
	 * @return
	 */
	public Line checkCoding(String coding);
	
	/**
	 * 插入路线数据
	 * @param line
	 */
	public int insertLine(Line line);
	
	
	/**
	 * 获取一条路线的起始杆号和结束杆号
	 * @param line
	 * @return
	 */
	public List<Tower> getLineAllTowers(Line line);
}
