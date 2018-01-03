package com.znsd.circuit.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Flaw;
import com.znsd.circuit.model.Flawnot;
import com.znsd.circuit.model.Pager;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.FlawFYService;
import com.znsd.circuit.service.FlawNotService;
import com.znsd.circuit.service.FlawService;
import com.znsd.circuit.util.DateTime;


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
	
	//增加缺陷类型
	@RequestMapping("/fstateadd")
	public String getflawstateadd(){
		return "fstateadd";
	}

	
	@ResponseBody
	@RequestMapping("/flawadd")
	public void flawadd(HttpSession  session,Flaw flaw){
		String datetime = new DateTime().getDateTime();
		User user = (User) session.getAttribute("user");
		flaw.setCreatedDate(datetime);
		flaw.setupdatedDate(datetime);
		flaw.setCreatedBy(1);
		flaw.setUpdatedBy(1);
		flaw.setDelete_flag("是");
		flaw.setRemark("萝卜抱");
		flawService.flawadd(flaw);
	}
	
	//缺陷类型设置表查询
	@ResponseBody
	@RequestMapping("/selectFlawAll")
	public List<Flaw> getFlawAll(HttpServletRequest   request){
		Flaw fl = new Flaw();
		List<Flaw> listfl =flawService.getFlawAll(fl.getId(),fl.getname(),fl.getState());
		request.setAttribute("listfl", listfl);
		System.out.println("listfl:"+listfl);
		return listfl;
	}
	
	//添加缺陷类型
	/*@ResponseBody
	@RequestMapping("/fladd")
	public void flawstateadd(HttpSession session,Flaw flaw){
		String datetime = new DateTime().getDateTime();
		User user = (User) session.getAttribute("user");
		flaw.setCreatedDate(datetime);
		flaw.setUpdateDate(datetime);
		flaw.setCreatedBy(1);
		flaw.setUpdatedBy(1);
		flaw.setDelete_flag("是");
		flaw.setRemark("萝卜抱");
		flawService.getFladd(flaw);
	}*/
	
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
