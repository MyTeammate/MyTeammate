package com.znsd.circuit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Line;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.model.Threads;
import com.znsd.circuit.model.Tower;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.LineService;
import com.znsd.circuit.service.SystemDataService;
import com.znsd.circuit.service.ThreadService;
import com.znsd.circuit.service.TowerService;
import com.znsd.circuit.util.DateTime;

@Controller
public class LineController {

	@Autowired
	private LineService lineService;
	@Autowired
	private TowerService towerService;
	
	@Autowired
	private ThreadService threadService;
	
	@Autowired
	private SystemDataService systemDataService;
	
	@RequestMapping("/intoLine")
	public String intoLine() {
		
		return "lineManage";
	}
	
	@RequestMapping("/getLineData")
	@ResponseBody
	public Map<String,Object> getLineData(@RequestParam("page")int page,@RequestParam("rows")int rows,@RequestParam(value="name",required=false)String coding,@RequestParam(value="status",required=false)String status) {
		Line line = new Line();
		if(status!=null) {
			line.setState(status.equals("启用")?0:1);
			line.setStateString(status);
		}
		line.setName(coding);
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
	public List<Tower> getTowerDate(Line line,@RequestParam(value="flag",required=false)String flag){

		return towerService.getAllTowerData(line,flag);
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
		line.setCreateById(user.getId());
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
	
	@RequestMapping("/intoUpdateLine")
	public String intoUpdateLine(@RequestParam("id")int id,Model model) {
		Line line = lineService.getLineById(id);
		model.addAttribute("line", line);
		return "auLine";
	}
	
	@RequestMapping("/updateLine")
	@ResponseBody
	public String updateLine(Line line) {
		String datetime = new DateTime().getDateTime();
		line.setUpdateDate(datetime);
		Line le = lineService.getLineById(line.getId());
    	String regex = "\\d";
		String zimu = line.getStartTower().replaceAll(regex, "");
		String zimu2 = le.getStartTower().replaceAll(regex, "");
		List<Tower> towers =  lineService.getLineAllTowers(line);
    	if(zimu.equals(zimu2)&&(line.getStartTower().length()==le.getStartTower().length())) {
    		
			for (Tower tower2 : towers) {
				tower2.setLineId(line.getId());
				if(tower2.getLineId()!=null) {
					towerService.updateTowerLineId(tower2);
				}
			}
    	}/*else {
    		List<Tower> towerss =  lineService.getLineAllTowers(le);
    		for (Tower tower2 : towerss) {
				tower2.setLineId(null);
				towerService.updateTowerLineId(tower2);
			}
    		for (Tower tower2 : towers) {
				tower2.setLineId(line.getId());
				towerService.updateTowerLineId(tower2);
			}
    	}*/
		try {
			lineService.updateLine(line);
			return "true";
		} catch (Exception e) {
			return "false";
		}
		 
	}
	

	@RequestMapping("/getSystemDataState")
	@ResponseBody
	public List<Systemparam> getSystemData (@RequestParam("key")String key){
		return systemDataService.getSystemParamDh(key);
	}
	
	
	
	@RequestMapping("/adLine")
	@ResponseBody
	public String abLine(Line line) {
		try {
			List<Tower> towers = towerService.getLineTowersById(line.getId());
			if(line.getState()<0) {
				for (Tower tower : towers) {
					tower.setLineId(null);
					towerService.updateTowerLineId(tower);
				}
				lineService.setDeleteFlag(line.getId());
			}else {
				line.setState(line.getState()==0?1:0);
				
				for (Tower tower : towers) {
					if(tower.getState()!=line.getState()) {
						tower.setState(line.getState());
						towerService.setTowerState(tower);
					}
				}
				lineService.setStateFlag(line);
			}
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}
	
	
	@RequestMapping("/isThread")
	@ResponseBody
	public String  isThreads(@RequestParam("lineId")int lineId) {
		List<Threads> ts = threadService.findThreadsByLineId(lineId);
		return ts.size()>0?"true":"false";
	}

}

