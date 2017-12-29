package com.znsd.circuit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Line;
import com.znsd.circuit.model.Tower;

@MapperScan
public interface LineDao {

	/**
	 * 分页显示路线数据
	 * @return
	 */
	public List<Line> pageSelectLine(Map<String,Object> params);
	
	
	/**
	 * 获取路线数据总条数
	 * @param params
	 * @return
	 */
	public int getLineTotal(Map<String,Object> params);
	
	/**
	 * 校验路线编码
	 * @return
	 */
	public Line checkCoding(String coding);
	
	/**
	 * 插入路线数据
	 * @param line
	 */
	public void insertLine(Line line);
	
	
	/**
	 * 获取一条路线的起始杆号和结束杆号
	 * @param line
	 * @return
	 */
	public List<Tower> getLineAllTowers(Line line);
}
