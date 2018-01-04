package com.znsd.circuit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Line;
import com.znsd.circuit.model.Tower;

@MapperScan
public interface TowerDao {
	
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
	public List<Tower> getAllTowerData(@Param("line")Line line);
	
	
	/**
	 * 更新杆塔的所属路线
	 * @param tower
	 */
	public void updateTowerLineId(Tower tower);
	
	
	
	/**
	 * 根据路线的ID获取该路线的所有的杆塔
	 * @param id
	 * @return
	 */
	public List<Tower> getLineTowersById(int id);
	
	
	/**
	 * 根据杆塔编号模糊查询类似的杆塔数据
	 * @param coding
	 * @return
	 */
	public List<Tower> getTowerByLikeCoding(@Param("coding")String coding);
	
	
	/**
	 * 修改杆塔状态（启用，禁用）
	 * @param tower
	 */
	public void setTowerState(@Param("tower")Tower tower);
	
	/**
	 * 根据id获取杆塔对象
	 * @param id
	 * @return
	 */
	public Tower getTowerById(@Param("id")int id);
	
	/**
	 * 更新杆塔信息
	 * @param tower
	 */
	public void updateTower(@Param("tower")Tower tower);
	
	
	/**
	 * 修改该杆塔的状态为删除
	 * @param id
	 */
	public void setDeleteFlag(@Param("id")int id);

}
