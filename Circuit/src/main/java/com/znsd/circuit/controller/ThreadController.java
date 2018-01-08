package com.znsd.circuit.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
@RequestMapping("thread")
public class ThreadController {

	@Autowired
	private ThreadService threadService;
	@Autowired
	private LineService lineService;


	@Autowired
	private SystemDataService systemDataService;

	@RequestMapping("/getThreadData")
	@ResponseBody
	public Map<String, Object> getThreadData(@RequestParam("page") int page, @RequestParam("rows") int rows,
			@RequestParam(value = "coding", required = false) String coding,
			@RequestParam(value = "runState", required = false) String runState,
			@RequestParam(value = "lineId") int lineId) {
		Threads thread = new Threads();
		thread.setCoding(coding);
		if(runState!=null&&!runState.equals("")) {
			thread.setRunningState(runState.equals("正常")?0:1);
			thread.setRunningStateString(runState);
		}
		thread.setLineId(lineId);
		return threadService.pageSelectThread(page, rows, thread);
	}

	@RequestMapping("/intoThread")
	public String intoThread() {
		return "threadManage";
	}

	@RequestMapping("/auThread")
	public String auLine(Threads threads, Model model) {

		String name = "";
		try {
			name = new String(threads.getLineName().getBytes("iso8859-1"), "UTF-8");
			threads.setLineName(name);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		model.addAttribute("threads", null);
		model.addAttribute("thread", threads);
		return "auThread";
	}

	@RequestMapping("/checkThreadCoding")
	@ResponseBody
	public String checkThreadCoding(Threads thread) {
		Threads threads = threadService.checkCoding(thread);

		return threads == null ? "true" : "false";
	}

	@RequestMapping("/getAllTowerData")
	@ResponseBody
	public List<Tower> getThreadAllTowers(Threads thread) {
		Line line = lineService.getLineById(thread.getLineId());
		List<Tower> towers = lineService.getLineAllTowers(line);
		String coding = thread.getCoding();
		if (coding != null && coding != "") {
			List<Tower> towerss = new ArrayList<Tower>();

			String regex1 = "[a-zA-Z]";
			String shuziStr = coding.replaceAll(regex1, "");
			if (!shuziStr.equals("")) {
				int shuzi = Integer.parseInt(shuziStr);
				for (Tower tower : towers) {
					int shuzi2 = Integer.parseInt(tower.getCoding().replaceAll(regex1, ""));
					if (shuzi < shuzi2) {
						towerss.add(tower);
					}
				}
			}
			return towerss;

		}

		return towers;

	}
	
	@RequestMapping("/getSystemData")
	@ResponseBody
	public List<Systemparam> getSystemData (){
		return systemDataService.getSystemParamDh("VOLTAGE_GRADE");
	}
	
	@RequestMapping("/addThread")
	@ResponseBody
	public String addThread(Threads threads,HttpSession session) {
		String datetime = new DateTime().getDateTime();
		User user = (User) session.getAttribute("user");
		threads.setRunningState(0);
		threads.setCreateDate(datetime);
		threads.setUpdateDate(datetime);
		threads.setCreateById(user.getId());
		threads.setDeleteFlag("否");
		int id = threadService.insertThread(threads);
		if(id>0) {
			return "true";
		}else {
			return "false";
		}
	}
	
	
	@RequestMapping("/updateThread")
	@ResponseBody
	public String addThread(Threads threads) {
		String datetime = new DateTime().getDateTime();
		threads.setUpdateDate(datetime);
		try {
			threadService.updateThread(threads);
			return "true";
		} catch (Exception e) {
			return "false";
		}
	}
	
	@RequestMapping("/intoUpdateThread")
	public String intoUpdateThread(@RequestParam("id")int id,Model model) {
		Threads thread = threadService.getThreadById(id);
		model.addAttribute("threads", thread);
		return "auThread";
	}
	
	
	@RequestMapping("/isInspectionTask")
	@ResponseBody
	public String isInspectionTask(@RequestParam("id")int id) {
		List<Threads> ts = threadService.findThreadTask(id);
		return ts.size()>0?"true":"false";
	}
	
	
	@RequestMapping("/daThread")
	@ResponseBody
	public String daThread(Threads thread) {
		try {
			if(thread.getState()<0) {
				threadService.setDeleteFlag(thread.getId());
			}else {
				thread.setState(thread.getState()==0?1:0);
				threadService.setStateFlag(thread);
			}
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}

	}

}
