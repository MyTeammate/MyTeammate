package com.znsd.circuit.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.excel.toEP;
import com.znsd.circuit.model.TaskEliminate;
import com.znsd.circuit.model.Taskpolling;
import com.znsd.circuit.service.TaskpollingService;

@Controller
public class TaskpollingController {

	@Autowired
	private TaskpollingService taskpollingService;

	@RequestMapping("/taskPonew")
	public String taskPonew() {
		return "taskPonew";
	}

	@RequestMapping("/taskPollingPost")
	@ResponseBody
	public Map<String, Object> taskPollingPost(@RequestParam("page") int page, @RequestParam("rows") int rows,
			@RequestParam(value = "conteTitle", required = false) String conteTitle,
			@RequestParam(value = "renTitle", required = false) String renTitle) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = taskpollingService.getTsakCount();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		Map<String, Object> maps = new HashMap<String, Object>();
		if (conteTitle != "" && conteTitle != null) {
			map.put("title", "%" + conteTitle + "%");
			List<Taskpolling> list1 = taskpollingService.selelectTaskPoll(map);
			System.out.println(list1);
			for (Taskpolling polling : list1) {
				polling.setDescription("<a href='javascript:onclick=selId()'>查看</a>");
			}
			maps.put("rows", list1);
			maps.put("total", list1.size());
		} else if (renTitle != "" && renTitle != null) {
			map.put("make", "%" + renTitle + "%");
			List<Taskpolling> list2 = taskpollingService.selelectTaskPoll(map);
			System.out.println(list2);
			for (Taskpolling polling : list2) {
				polling.setDescription("<a href='javascript:onclick=selId()'>查看</a>");
			}
			maps.put("rows", list2);
			maps.put("total", list2.size());
		} else {
			List<Taskpolling> list = taskpollingService.selelectTaskPoll(map);
			System.out.println(list);
			for (Taskpolling polling : list) {
				polling.setDescription("<a href='javascript:onclick=selId()'>查看</a>");
			}
			maps.put("rows", list);
			maps.put("total", count);
		}

		return maps;
	}

	@RequestMapping("/taskTowerPost")
	public String taskTowerPost(HttpSession session, @RequestParam("coding") String coding) {
		Taskpolling task = taskpollingService.selectTaskTower(coding);
		session.setAttribute("task", task);
		return "taskPonew";
	}

	@RequestMapping("/towerTask")
	@ResponseBody
	public Map<String, Object> towerTask(@RequestParam("page") int page, @RequestParam("rows") int rows,
			@RequestParam("coding") String coding, @RequestParam(value = "ganTitle", required = false) String ganTitle,
			@RequestParam(value = "queTitle", required = false) String queTitle,
			@RequestParam(value = "sTitle", required = false) String sTitle,
			@RequestParam(value = "eTitle", required = false) String eTitle) {
		Map<String, Object> map = new HashMap<String, Object>();

		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		Map<String, Object> maps = new HashMap<String, Object>();
		if (ganTitle != "" && ganTitle != null || queTitle != "" && queTitle != null || sTitle != "" && sTitle != null
				|| eTitle != "" && eTitle != null) {
			if (ganTitle != "" && ganTitle != null) {
				map.put("gan", "%" + ganTitle + "%");
			}
			if (queTitle != "" && queTitle != null) {
				map.put("que", "%" + queTitle + "%");
			}

			map.put("start", sTitle);
			map.put("end", eTitle);
			System.out.println(map);
		}
		//int count = taskpollingService.getselTaskCount(coding);
		List<Taskpolling> list = taskpollingService.selectTower(map, coding);
		System.out.println(list);
		maps.put("rows", list);
		maps.put("total", list.size());
		return maps;
	}
	
	@ResponseBody
	@RequestMapping("/toPExcel")
	public String toPExcel(HttpSession session,String path,String name) {
		System.out.println(path+","+name);
		List<Taskpolling> taskList = taskpollingService.eSelelectTaskPoll();
		toEP t=new toEP();
		String mark=t.outputExcel(taskList,"巡检",path,name);
		return mark;
	}

}
