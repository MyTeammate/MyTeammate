package com.znsd.circuit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.circuit.dao.RoleConfigDao;
import com.znsd.circuit.model.Power;
import com.znsd.circuit.model.RolePower;
import com.znsd.circuit.model.Systemrole;
import com.znsd.circuit.service.RoleConfigService;

@Service
public class RoleConfigServiceImpl implements RoleConfigService {

	@Autowired
	private RoleConfigDao roleConfigDao;
	@Override
	public List<Systemrole> getRoles() {
		return roleConfigDao.getRoles();
	}
	
	@Override
	public List<Power> selectAllPower(Integer nid) {
		return roleConfigDao.selectAllPower(nid);
	}

	@Override
	public int addPowerMenu(Power power) {
		roleConfigDao.addPowerMenu(power);
		return power.getId();
	}

	@Override
	public List<Power> getRolePowersById(int roleId) {
		return roleConfigDao.getRolePowersById(roleId);
	}

	@Override
	public Power checkPowerText(Power power) {
		return roleConfigDao.checkPowerText(power);
	}

	@Override
	public void setPowerState(Power power) {
		roleConfigDao.setPowerState(power);
	}

	@Override
	public Power getPowerMenuById(int id) {
		return roleConfigDao.getPowerMenuById(id);
	}

	@Override
	public void updatePowerMenu(Power power) {
		roleConfigDao.updatePowerMenu(power);
	}

	@Override
	public void deletePowerMenu(int id) {
		roleConfigDao.deletePowerMenu(id);
	}

	@Override
	public void addPowerByRole(List<RolePower> list) {
		roleConfigDao.addPowerByRole(list);
	}

	@Override
	public void deletePowerByRoleId(int roleId) {
		roleConfigDao.deletePowerByRoleId(roleId);
	}

}
