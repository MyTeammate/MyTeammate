package com.znsd.circuit.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.znsd.circuit.model.Power;
import com.znsd.circuit.model.RolePower;
import com.znsd.circuit.model.Systemrole;
@MapperScan
public interface RoleConfigDao {

	/**
	 * 获取所有启用的角色
	 * @return
	 */
	public List<Systemrole> getRoles();
	
	/**树形菜单查询
	 * @param nid
	 * @return
	 */
	public List<Power> selectAllPower(Integer nid);
	
	/**
	 * 添加功能菜单
	 * @param power
	 */
	public void addPowerMenu(Power power);
	
	/**
	 * 获得某个角色的功能菜单
	 * @param roleId
	 * @return
	 */
	public List<Power> getRolePowersById(int roleId);
	
	
	/**
	 * 判断同一个父节点下的子节点文本不能重复
	 * @param power
	 * @return
	 */
	public Power checkPowerText(Power power);
	
	
	/**
	 * 修改一个功能菜单的状态
	 * @param power
	 */
	public void setPowerState(Power power);
	
	/**
	 * 根据功能菜单ID获取功能菜单
	 * @param power
	 */
	public Power getPowerMenuById(int id);
	
	
	/**
	 * 修改功能菜单信息
	 * @param power
	 */
	public void updatePowerMenu(Power power);
	
	/**
	 * 修改该功能菜单的状态为删除
	 * @param id
	 */
	public void deletePowerMenu(int id);
	
	/**
	 * 批量插入权限数据
	 * @param list
	 */
	public void addPowerByRole(List<RolePower> list);
}
