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
import com.znsd.circuit.model.FlawCont;
import com.znsd.circuit.model.Pager;
import com.znsd.circuit.model.User;
import com.znsd.circuit.service.FlawConfirmService;
import com.znsd.circuit.service.FlawService;
import com.znsd.circuit.util.DateTime;


@Controller
@RequestMapping
public class FlawController {
	
	@Autowired
	private FlawService flawService;
	
	@Autowired
	private FlawConfirmService flawConfirmService;
	
	
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
	
	//修改缺陷类型
	@RequestMapping("/updateFlaw")
	public String getupdateFlaw(){
		return "updateFlaw";
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
		flaw.setDelete_flag("否");
		flaw.setRemark("萝卜抱");
		flawService.flawadd(flaw);
	}
	
	//修改缺陷类型
	@ResponseBody
	@RequestMapping("/updatefla")
	public boolean updateflawstate(HttpSession  session,Flaw flaw){
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return false;
		} 
		flaw.setUpdatedBy(user.getId());
		flawService.updateflawstate(flaw);
		return true;
	}
	
	//修改缺陷等级
	@ResponseBody
	@RequestMapping("/updateflawconfirmgrade")
	public boolean updateflawgrade(HttpSession session,FlawCont flawCont/*,int flawGrade*/){
		System.out.println("--------------"+flawCont);
		System.out.println("--------"+flawCont.getFlawGrade());
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return false;
		}
		flawCont.setUpdatedBy(user.getId());
		flawConfirmService.updateflawgrade(flawCont);
		return true;
	}
	
	//删除缺陷类型
	@ResponseBody
	@RequestMapping("/deleteFlawState")
	public boolean deleteFlawState(int id,HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user==null){
			return false;
		}
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		map.put("delete_flag","是");
		map.put("updatedBy", user.getId());
		System.out.println("============="+id);
		flawService.deleteflawstate(map);
		return true;
	}
	
	
	@ResponseBody
	@RequestMapping("/lookupdate")
	public Flaw lookFlaw(int id){
		Flaw f = flawService.fupdate(id);	//查询到要修改的id
		return f;
	}
	
	
	//查找到要保存的id
	@ResponseBody
	@RequestMapping("/lookflawconfirm")
	public FlawCont lookflawconfirmiid(int id){
		FlawCont f = flawConfirmService.flawconfid(id);
		return f;
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
	
	@ResponseBody
	@RequestMapping("/getFlawConfirmPager")
	public Map<String,Object> getFlawConfirmPager(@RequestParam("page") int pageIndex,@RequestParam("rows")int pageSize,FlawCont flawCont){
		Map<String,Object> map = new HashMap<>();
		Pager<FlawCont> pager = flawConfirmService.getFlawConfirmPager(pageIndex, pageSize);
		map.put("rows",pager.getData());
		map.put("total",pager.getSumSize());
		System.out.println("pageIndex"+pageIndex);
		System.out.println("pageSize"+pageSize);
		return map;
	}
	
	//缺陷等级确认表的查询
	@ResponseBody
	@RequestMapping("/seleteFlawConfirm")
	public List<FlawCont> getFlawConfirm(HttpServletRequest request){
		FlawCont fl = new FlawCont();
		List<FlawCont> listfc = flawConfirmService.getFlawConfirmAll(fl.getTaskcoding(), fl.getThreadcoding(), fl.getTowercoding(), fl.getFlawname(), fl.getServiceAbility(), fl.getFlawDesc(), fl.getDiscoverDate(), fl.getUserId(), fl.getFlawGrade(), fl.getConfirmstate(),fl.getUpdatedBy());
		request.setAttribute("listfc", listfc);
		return listfc;
	}
	
	
}
