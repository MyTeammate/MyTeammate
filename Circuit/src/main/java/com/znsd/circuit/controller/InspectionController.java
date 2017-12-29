package com.znsd.circuit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.circuit.model.Inspection;
import com.znsd.circuit.model.Pager;
import com.znsd.circuit.model.Systemparam;
import com.znsd.circuit.service.InspectionService;

@Controller
public class InspectionController {
	
	@Autowired
	private InspectionService inspectionService;
	
	/*
	 * 进入 巡检任务 制定与分配页面
	 */
	@RequestMapping(value="inspectionMakeAllot")
	public String intoMakeAllot(){
		return "inspectionMakeAllot";
	}
	
	/*
	 * 进入   制定巡检任务页面
	 */
	@RequestMapping(value="makeInspection")
	public String intoMakeInspection(){
		return "makeInspection";
	}
	
	/*
	 * 所有  巡检任务状态
	 */
	@ResponseBody
	@RequestMapping(value="getInspectionParam")
	public List<Systemparam> getInspectionParam(){
		return inspectionService.getInspectionParam();
	}
	
	/*
	 * 所有线路
	 */
	//public List<>
	
	/*
	 * 分页查询所有巡检数据
	 */
	@ResponseBody
	@RequestMapping(value="getInspectionPage")
	public Map<String, Object> getInspectionPage(@RequestParam("page") int pageIndex,@RequestParam("rows")int pageSize){
		Pager<Inspection> pager = inspectionService.getInspectionPage(pageIndex, pageSize);
		Map<String, Object> map = new HashMap<>();
		map.put("total", pager.getSumSize());
		map.put("rows", pager.getData());
		return map;
	}
}
