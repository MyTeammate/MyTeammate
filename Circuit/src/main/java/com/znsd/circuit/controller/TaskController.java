package com.znsd.circuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskController {

	//消缺记录统计页面显示
	@RequestMapping("/taskEliminate")
	public String getTaskEliminate(){
		return "taskEliminate";
	}  
	
	//巡检记录统计页面显示
	@RequestMapping("/taskPolling")
	public String getTaskPolling(){
		return "taskPolling";
	}
}
