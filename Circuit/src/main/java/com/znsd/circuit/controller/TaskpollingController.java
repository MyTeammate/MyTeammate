package com.znsd.circuit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.znsd.circuit.model.Taskpolling;
import com.znsd.circuit.service.TaskpollingService;

@Controller
public class TaskpollingController {

	@Autowired
	private TaskpollingService taskpollingService;

	@RequestMapping("/taskPollingPost")
	@ResponseBody
	public Map<String, Object> taskPollingPost(@RequestParam("page") int page, @RequestParam("rows") int rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = taskpollingService.getTsakCount();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		Map<String, Object> maps = new HashMap<String, Object>();
		List<Taskpolling> list = taskpollingService.selelectTaskPoll(map);
		System.out.println(list);
		for (Taskpolling eliminate : list) {
			eliminate.setDescription("<a href='#'>查看</a>");
		}
		maps.put("rows", list);
		maps.put("total", count);
		return maps;
	}
}
