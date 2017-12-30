package com.znsd.circuit.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Flaw;
import com.znsd.circuit.model.Flawnot;
import com.znsd.circuit.model.Pager;
import com.znsd.circuit.service.FlawFYService;
import com.znsd.circuit.service.FlawNotService;
import com.znsd.circuit.service.FlawService;


@Controller
@RequestMapping
public class FlawController {
	
	@Autowired
	private FlawService flawService;
	
	@Autowired
	private FlawNotService flawNotService;
	
	
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
	
	//缺陷类型设置表查询
	@ResponseBody
	@RequestMapping("/selectFlawAll")
	public List<Flaw> getFlawAll(HttpServletRequest   request){
		Flaw fl = new Flaw();
		List<Flaw> listfl =flawService.getFlawAll(fl.getId(),fl.getFlawname(),fl.getState());
		request.setAttribute("listfl", listfl);
		System.out.println("listfl:"+listfl);
		return listfl;
	}
	
	@ResponseBody
	@RequestMapping("/getFlawNotarizeAll")
	public List<Flawnot> getFlawNotAll(HttpServletRequest   request){
		Flawnot fn = new Flawnot();
		List<Flawnot> listfn = flawNotService.getFlawNotAll(fn.getId(),fn.getTasknumber(),fn.getThreadcoding(),fn.getTowercoding(),fn.getFlawname(),fn.getFlawConfirmserviceAbility(),fn.getFlawConfirmflawDesc(),fn.getFlawConfirmdiscoverDate(),fn.getInspectionstaffuserId(),fn.getFlawConfirmflowGrade());
		request.setAttribute("listfn", listfn);
		System.out.println("listfn:"+listfn);
		return listfn;
		
	}

	@ResponseBody
	@RequestMapping("/getflawpage")
	public Map<String,Object> getflawpage(@RequestParam("page") int pageIndex,@RequestParam("rows")int pageSize,Flaw flaw){
		Map<String,Object> map = new HashMap<>();
		Pager<Flaw> pager = flawService.getFlawPage(pageIndex, pageSize);
    	map.put("rows", pager.getData());
		map.put("total",pager.getSumSize());
		System.out.println("pageIndex"+pageIndex);
		System.out.println("pageSize"+pageSize);
		return map;
	}
}
