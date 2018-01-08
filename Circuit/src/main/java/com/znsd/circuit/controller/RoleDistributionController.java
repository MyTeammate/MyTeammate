package com.znsd.circuit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Power;
import com.znsd.circuit.model.RolePower;
import com.znsd.circuit.model.Systemrole;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.RoleConfigService;
import com.znsd.circuit.util.DateTime;

@Controller
@RequestMapping("power")
public class RoleDistributionController {

	@Autowired
	private RoleConfigService roleConfigService;
	
	@RequestMapping("/intoRoleDistribution")
	public String roleDistribution() {
		return "roleDistribution";
	}
	
	@RequestMapping("/getRoles")
	@ResponseBody
	public List<Systemrole> getRoles(){
		return roleConfigService.getRoles();
	}
	
   //树形菜单查询
	@ResponseBody
	@RequestMapping("/getNavs")
    public List<Power> homeNav(Integer id){
		Integer nid = id == null ? 0 : id;
		List<Power> listPower=roleConfigService.selectAllPower(nid);
    	return listPower;
    }
	
	
	@RequestMapping("/checkMenuText")
	@ResponseBody
	public String checkMenuText(Power power) {
	  	power = roleConfigService.checkPowerText(power);
		return power==null?"true":"false";
	}
	
	@RequestMapping("/addMenuNode")
	@ResponseBody
	public String addMenuNode(Power power,HttpSession session) {
		DateTime op = new DateTime();
		User user = (User) session.getAttribute("user");
		power.setCreateDate(op.getDateTime());
		power.setUpdatedDate(op.getDateTime());
		power.setCreateBy(user.getId());
		power.setDeleteFlag("否");
		power.setRemark(power.getText());
		Power parentNode = roleConfigService.getPowerMenuById(power.getNid()); 
		if(parentNode!=null&&parentNode.getState().equals("open")) {
			parentNode.setState("closed");
			roleConfigService.setPowerState(parentNode);
		}
		int id = roleConfigService.addPowerMenu(power);
		return id>0?"true":"false";
	}
	
	@RequestMapping("/updateMenuNode")
	@ResponseBody
	public String addMenuNode(Power power) {
		DateTime op = new DateTime();
		power.setUpdatedDate(op.getDateTime());
		power.setRemark(power.getText());
		try {
			roleConfigService.updatePowerMenu(power);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
		
	}
	@RequestMapping("/getPowerMenuById")
	@ResponseBody
	public Power getPowerMenuById(@RequestParam("id")int id) {
		Power parentNode = roleConfigService.getPowerMenuById(id); 
		return parentNode;
	}
	
	
	@RequestMapping("/deletePowerManu")
	@ResponseBody
	public String deletePowerManu(@RequestParam("id")int id) {
		try {
			roleConfigService.deletePowerMenu(id);
			return "true";
		} catch (Exception e) {
			return "false";
		}
	}
	@RequestMapping("/authorization")
	@ResponseBody
	public String authorization(@RequestParam("roleId")int roleId,@RequestParam("ids")String ids) {
		String[] powerIds = ids.split(",");
		List<RolePower> rolePowers = new ArrayList<RolePower>();
		DateTime op = new DateTime();
		for (int i = 0; i < powerIds.length; i++) {
			RolePower rp = new RolePower();
			rp.setPowerId(Integer.parseInt(powerIds[i]));
			rp.setRoleId(roleId);
			rp.setCreateDate(op.getDateTime());
			rp.setUpdatedDate(op.getDateTime());
			rp.setDeleteFlag("否");
			rolePowers.add(rp);
		}
		try {
			roleConfigService.deletePowerByRoleId(roleId);
			roleConfigService.addPowerByRole(rolePowers);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
		
	}
	
	@RequestMapping("/getRolePowers")
	@ResponseBody
	public List<Power> getRolePowers(@RequestParam("roleId")int roleId){
		return  roleConfigService.getRolePowersById(roleId);
	}
}
