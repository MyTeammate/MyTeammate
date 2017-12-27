package com.znsd.circuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonalController {

	//个人资料管理页面显示
	@RequestMapping("/personalFile")
	public String getData(){
		return "personalFile";
	} 
	
	//待办列表页面显示
	@RequestMapping("/personalWork")
	public String getPersonalWork(){
		return "personalWork";
	}
}
