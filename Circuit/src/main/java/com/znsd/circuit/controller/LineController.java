package com.znsd.circuit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class LineController {

	@Autowired
	private LineService lineService;
	@Autowired
	private TowerService towerService;
	
	@RequestMapping("/intoLine")
	public String intoLine() {
		
		return "lineManage";
	}
	
	@RequestMapping("/getLineData")
	@ResponseBody
	public Map<String,Object> getLineData(@RequestParam("page")int page,@RequestParam("rows")int rows,@RequestParam(value="coding",required=false)String coding,@RequestParam(value="runState",required=false,defaultValue="0")int runState) {
		Line line = new Line();
		line.setCoding(coding);
		return lineService.pageSelectLine(page, rows, line);
	}
	
	@RequestMapping("/checkLineCoding")
	@ResponseBody
	public String checkLineCoding(@RequestParam("coding")String coding) {
		Line line = lineService.checkCoding(coding);
		return line==null?"true":"false";
	}
	
	
	@RequestMapping("/auLine")
	public String auLine() {
		return "auLine";
	}
	
	@RequestMapping("/getAllTowerData")
	@ResponseBody
	public List<Tower> getTowerDate(){
		return towerService.getAllTowerData(null);
	}
	
	
	@RequestMapping("/getTowerDataByCoding")
	@ResponseBody
	public List<Tower> getTowerDate(@RequestParam(value="coding")String coding){
		List<Tower> towers = null;
		if(coding!=null&&!coding.equals("")) {
			towers = towerService.getAllTowerData(coding);
		}
		return towers;
	}
	
	@RequestMapping("/lineCheckTowerCoding")
	@ResponseBody
	public String lineCheckTowerCoding(@RequestParam("coding")String coding){
		Tower tower = towerService.checkCoding(coding);
		return tower==null?"false":"true";
	}
	
	@RequestMapping("/addLine")
	@ResponseBody
	public String addLine(Line line,HttpSession session){
		String datetime = new DateTime().getDateTime();
		User user = (User) session.getAttribute("user");
		line.setCreateDate(datetime);
		line.setUpdateDate(datetime);
		line.setCreateById(1);
		line.setDeleteFlag("否");
		int lineId = lineService.insertLine(line);
		if(lineId>0) {
			List<Tower> towers =  lineService.getLineAllTowers(line);
			for (Tower tower2 : towers) {
				tower2.setLineId(lineId);
				towerService.updateTowerLineId(tower2);
			}
			return "true";
		}
		return "false";
	}
}
