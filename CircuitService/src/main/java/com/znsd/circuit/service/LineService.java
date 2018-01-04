package com.znsd.circuit.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
	
	
	/**
	 * 根据路线ID获取该条路线的信息
	 * @param id
	 * @return
	 */
	public Line getLineById(int id);
	
	
	/**
	 * 修改路线信息
	 * @param line
	 */
	public void updateLine(Line line);
	
	
	/**
	 * 修改该条路线的状态为删除
	 * @param id
	 */
	public void setDeleteFlag(int id);
	
	
	/**
	 * 修改该条路线的状态为禁用状态
	 * @param id
	 */
	public void setStateFlag(Line line);
	
	
	/**
	 * 获取所以启用的路线
	 * @return
	 */
	public List<Line> selectListLine();
}
