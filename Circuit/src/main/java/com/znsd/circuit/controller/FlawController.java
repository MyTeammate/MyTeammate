package com.znsd.circuit.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class FlawController {
	
	//等级确认
	@RequestMapping("/flawNotarize")
	public String getflawnotarize(){
		return "flawNotarize"; 
	}
	
	//缺陷等级确认
	@RequestMapping("/flawConfirm")
	public String getflawConfirm(){
		return "flawConfirm";
	}
	
	//缺陷类型设置
	@RequestMapping("/flaw")
	public String getflaw(){
		return "flaw";
	}
	
	/*@ResponseBody
	@RequestMapping("/getflawpage")
	public Map<String,Object> getpactpage(@RequestParam("page") int pageIndex,@RequestParam("rows")int pageSize,Pact pact){
		Map<String,Object> map = new HashMap<>();
		Pager<Pact> pager = pactService.servicePage(pageIndex, pageSize, pact);
		map.put("rows", pager.getData());
		map.put("total",pager.getSumSize());
		System.out.println("pageIndex"+pageIndex);
		System.out.println("pageSize"+pageSize);
		return map;
		
	}*/
}
