package com.znsd.circuit.service;

import java.util.List;

import com.znsd.circuit.model.Tower;

public interface TowerService {

	/**
	 * 校验杆塔编码
	 * @param coding
	 * @return
	 */
	public Tower checkCoding(String coding);
	
	
	/**
	 * 插入一条杆塔记录
	 */
	public void insertTower(Tower tower);
	
	
	/**
	 * 查询所有杆塔数据
	 */
	public List<Tower>  getAllTowerData(String coding);
	
	
	/**
	 * 更新杆塔的所属路线
	 * @param tower
	 */
	public void updateTowerLineId(Tower tower);
}
