package com.znsd.circuit.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Tower;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.TowerService;
import com.znsd.circuit.util.DateTime;


@Controller
public class TowerController {

	@Autowired
	private TowerService towerService;
	
	@RequestMapping("/intoTower")
	public String getData(){
				
		return "towerManage";		
	}
	
	/**
	 * 校验杆塔编号是否存在
	 * @param coding
	 * @return
	 */
	@RequestMapping("/checkTowerCoding")
	@ResponseBody
	public String checkTowerCoding(@RequestParam("coding")String coding){
		Tower tower = towerService.checkCoding(coding);
		
		return null==tower?"true":"false";
	}
	
	
	/**
	 * 插入新的杆塔记录
	 * @param tower
	 * @return
	 */
	@RequestMapping("/addTower")
	@ResponseBody
	public String addTower(Tower tower,HttpSession session){
		String datetime = new DateTime().getDateTime();
		User user = (User) session.getAttribute("user");
		tower.setCreateDate(datetime);
		tower.setUpdateDate(datetime);
		tower.setCreateById(1);
		tower.setDeleteFlag("否");
		towerService.insertTower(tower);
		return null;
	}
	
	
}
