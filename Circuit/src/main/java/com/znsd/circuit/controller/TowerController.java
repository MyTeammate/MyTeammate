package com.znsd.circuit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Line;
import com.znsd.circuit.model.Tower;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.LineService;
import com.znsd.circuit.service.TowerService;
import com.znsd.circuit.util.DateTime;

@Controller
public class TowerController {

	@Autowired
	private TowerService towerService;

	@Autowired
	private LineService lineService;

	@RequestMapping("/intoTower")
	public String getData() {

		return "towerManage";
	}

	@RequestMapping("/checkTowerCoding")
	@ResponseBody
	public String checkTowerCoding(@RequestParam("coding") String coding) {
		Tower tower = towerService.checkCoding(coding);

		return null == tower ? "true" : "false";
	}

	@RequestMapping("/addTower")
	@ResponseBody
	public String addTower(Tower tower, HttpSession session) {
		try {
			String datetime = new DateTime().getDateTime();
			User user = (User) session.getAttribute("user");
			tower.setCreateDate(datetime);
			tower.setUpdateDate(datetime);
			tower.setCreateById(user.getId());
			tower.setDeleteFlag("否");
			tower = setStateTower(tower);
			towerService.insertTower(tower);
			return "true";
			} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}
	
	@RequestMapping("/intoUpdateTower")
	public String intoUpdateTower(Tower tower,Model model) {
		model.addAttribute("tower", tower);
		return "towerManage";
	}
	
	@RequestMapping("/updateTower")
	@ResponseBody
	public String updateTower(Tower tower) {
		try {
			String datetime = new DateTime().getDateTime();
			tower.setCreateDate(datetime);
			tower.setUpdateDate(datetime);
			tower = setStateTower(tower);
			towerService.updateTower(tower);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}
	
	@RequestMapping("/isLineId")
	@ResponseBody
	public String isLineId(@RequestParam("id")int id) {
		Tower tower = towerService.getTowerById(id);
		//System.out.println("towerId:"+id+",result:"+tower.getLineId());
		return tower.getLineId()==null?"true":"false";
	}

	public Tower setStateTower(Tower tower) {
		String regex = "\\d";
		String regex1 = "[a-zA-Z]";
		String zimu = tower.getCoding().replaceAll(regex, "");
		List<Tower> towers = towerService.getTowerByLikeCoding("%"+zimu+"%");

		if (towers.size() != 0) {

			Tower tower2 = towers.get(0);
			String zimu2 = tower2.getCoding().replaceAll(regex, "");

			if (zimu.equals(zimu2) && (tower.getCoding().length() == tower2.getCoding().length())) {
				if (tower2.getLineId() != null) {
					Line line = lineService.getLineById(tower2.getLineId());
					String startTower = line.getStartTower();
					String endTower = line.getEndTower();
					String shuziStr = startTower.replaceAll(regex1, "");
					String shuziStr2 = endTower.replaceAll(regex1, "");
					String shuziTowerStr = tower.getCoding().replaceAll(regex1, "");
					int shuzi = Integer.parseInt(shuziStr);
					int shuzi2 =Integer.parseInt(shuziTowerStr);
					int shuzi3 =Integer.parseInt(shuziStr2);
					if (shuzi < shuzi2&&shuzi2<shuzi3 ) {
						tower.setLineId(tower2.getLineId());
					}
				}

			}
		}
		return tower;
	}
	
	@RequestMapping("/isStartOrEndTower")
	@ResponseBody
	public String isStartOrEndTower(Tower tower) {
		Line line = lineService.getLineById(tower.getLineId());
		if(line.getStartTower().equals(tower.getCoding())||line.getEndTower().equals(tower.getCoding())) {
			return "false";
		}
		return "true";
	}
	
	@RequestMapping("/adTower")
	@ResponseBody
	public String adTower(Tower tower) {
		try {
			if(tower.getState()<0) {
				towerService.setDeleteFlag(tower.getId());
			}else {
				towerService.setTowerState(tower);
			}
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}
	
	@RequestMapping("/getLines")
	@ResponseBody
	public List<Line> getLines() {
		List<Line> lines = lineService.selectListLine();
		for (Line line : lines) {
			line.setName(line.getName()+"("+line.getCoding()+")");
		}
		return lineService.selectListLine();
	}

}
